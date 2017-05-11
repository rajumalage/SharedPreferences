package com.example.india.sharedpreferences.model;


public class BoardingPass {
    private String arrival;
    private String boardingIn;
    private String boardingTime;
    private String departure;
    private String destination;
    private String gate;
    private String origin;
    private String seat;
    private String terminal;
    private String plane;

    public BoardingPass() {
    }

    public BoardingPass(String arrival, String boardingIn, String boardingTime, String departure, String destination,
                        String gate, String origin, String seat, String terminal, String plane) {
        this.arrival = arrival;
        this.boardingIn = boardingIn;
        this.boardingTime = boardingTime;
        this.departure = departure;
        this.destination = destination;
        this.gate = gate;
        this.origin = origin;
        this.seat = seat;
        this.terminal = terminal;
        this.plane = plane;
    }

    public String getArrival() {
        return arrival;
    }

    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getBoardingIn() {
        return boardingIn;
    }

    public void setBoardingIn(String boardingIn) {
        this.boardingIn = boardingIn;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }
}
