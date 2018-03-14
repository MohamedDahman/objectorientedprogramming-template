package oop.pset4.controller;

import oop.pset4.controller.travelstage.*;
import oop.pset4.model.Luggage;
import oop.pset4.view.Host;
import oop.pset4.view.SummaryReporter;
import java.util.List;
import java.util.stream.Collectors;

public class Airport {

    private SecurityControl securityControl = new SecurityControl();
    private TravelStage dropOff = new DropOffStand();
    private TravelStage storageArea = new StorageArea();
    private TravelStage transportCart = new TransportCart();
    private TravelStage flight = new Flight();
    private TravelStage luggageClaim = new LuggageClaim();

    private SummaryReporter summaryReporter = new SummaryReporter();

    public List<Luggage> travel(List<Luggage> departureLuggage) {
        // TODO apply airport travel stages per the following order
        // show a welcome message

        Host.welcome();
        List<Luggage> rejected = departureLuggage.stream()
                .filter(e -> securityControl.isAllowedToTravel(e)==true)
                .collect(Collectors.toList());

        List<Luggage> newluggageList = departureLuggage.stream()
                .filter(e -> securityControl.isAllowedToTravel(e)==false)
                .collect(Collectors.toList());

        newluggageList.forEach(e-> dropOff.process(e));
        newluggageList.forEach(e->storageArea.process(e));
        newluggageList.forEach(e->transportCart.process(e));
        newluggageList.forEach(e->flight.process(e));
        newluggageList.forEach(e->transportCart.process(e));
        newluggageList.forEach(e->luggageClaim.process(e));

        summaryReporter.reportRejected(rejected);
        summaryReporter.reportAccepted(newluggageList);

        Host.goodBy();
        return newluggageList;
    }


}
