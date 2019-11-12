package com.hooli.railways.controller;

import com.hooli.railways.entity.*;
import com.hooli.railways.repository.StationsRoutesRepository;
import com.hooli.railways.repository.TicketRepository;
import com.hooli.railways.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String showGuestList(Model model, @ModelAttribute("user") TicketSearch ticketSearch) {

        List<RouteFront> routeFronts = new ArrayList<>();
        List<TrainFront> trainFronts = new ArrayList<>();
        List<StationsRoutes> starts = stationsRoutesRepository.findAllByStationName(ticketSearch.getStart());
        List<StationsRoutes> ends = stationsRoutesRepository.findAllByStationName(ticketSearch.getEnd());

        for (StationsRoutes startStationsRoutes : starts) {
            for (StationsRoutes endStationsRoutes : ends) {
                if (startStationsRoutes.getRouteId().equals(endStationsRoutes.getRouteId()) && startStationsRoutes.getStationNumber() < endStationsRoutes.getStationNumber()) {
                    routeFronts.add(new RouteFront(
                            startStationsRoutes.getRouteId(),
                            startStationsRoutes.getArrival() + startStationsRoutes.getTime(),
                            endStationsRoutes.getArrival(),
                            endStationsRoutes.getPrice() - startStationsRoutes.getPrice(),
                            startStationsRoutes.getStationNumber(),
                            endStationsRoutes.getStationNumber()
                    ));
                }
            }
        }
        for (RouteFront routeFront : routeFronts) {
            for (Train train : trainRepository.findAllByRouteId(routeFront.getId())) {
                //TODO("we really need to do this from repository: ")
                if (train.getDeparture() >= ticketSearch.getDate() - routeFront.getDeparture() && train.getDeparture() <= ticketSearch.getDate() - routeFront.getDeparture() + 24 * 60 * 60 * 60) {
                    trainFronts.add(new TrainFront(
                            train.getId(),
                            routeFront.getId(),
                            train.getDeparture() + routeFront.getDeparture(),
                            train.getDeparture() + routeFront.getArrival(),
                            routeFront.getPrice(),
                            routeFront.getStart(),
                            routeFront.getEnd(),
                            train.getSeats()
                    ));
                }
            }
        }

        for (TrainFront trainFront : trainFronts) {
            for (Ticket ticket : ticketRepository.findAllByTrainId(trainFront.getId())) {
                if (ticket.getEnd() > trainFront.getStart() && ticket.getStart() < trainFront.getEnd()) {
                    trainFront.setSeatFalse(ticket.getSeat());
                }
            }
        }

        model.addAttribute("trains", trainFronts);
        return "";
    }
}
