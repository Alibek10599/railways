package com.hooli.railways.entity;

public class TicketSearch {
    private String start;
    private String end;
    private Integer date;

    public TicketSearch() {
    }

    public TicketSearch(String start, String end, Integer date) {
        this.start = start;
        this.end = end;
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }
}
