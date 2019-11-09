package com.hooli.railways.controller;

import com.hooli.railways.entity.StationsRoutes;
import com.hooli.railways.entity.TicketSearch;
import com.hooli.railways.entity.Train;
import com.hooli.railways.repository.StationsRoutesRepository;
import com.hooli.railways.repository.TicketRepository;
import com.hooli.railways.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TrainRepository trainRepository;
    @Autowired
    StationsRoutesRepository stationsRoutesRepository;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String showGuestList(Model model, @RequestParam TicketSearch ticketSearch) {

        List<Integer> routes = new ArrayList<>();
        List<Train> trains = new ArrayList<>();
        List<StationsRoutes> starts = stationsRoutesRepository.findAllByStationName(ticketSearch.getStart());
        List<StationsRoutes> ends = stationsRoutesRepository.findAllByStationName(ticketSearch.getEnd());

        for (StationsRoutes startStationsRoutes : starts) {
            for (StationsRoutes endStationsRoutes : ends) {
                if (startStationsRoutes.getRouteId().equals(endStationsRoutes.getRouteId()) && startStationsRoutes.getStationNumber() < endStationsRoutes.getStationNumber()) {
                    routes.add(startStationsRoutes.getId());
//                    break;
                }
            }
        }
        for (Integer routeId : routes) {
            for (Train train : trainRepository.findAllByRouteId(routeId)) {
                if (train.getDeparture() > ticketSearch.getDate() && train.getDeparture() < ticketSearch.getDate() + 24 * 60 * 60 * 60) {
                    trains.add(train);
                }
            }
        }

        // TODO("create TicketFront, calculate the price, departure and arrival time");


        model.addAttribute("trains", trains);
        return "results :: resultsList";
    }
}
