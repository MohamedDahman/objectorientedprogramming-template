package oop.pset4.controller.travelstage;

import oop.pset4.model.Luggage;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Flight implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add travel duration to the processing time
        // Update arrival time

        Duration lastwaitingDuration = luggage.getWaitingDuration();
        Duration flightDuration = luggage.getFlightDuration();
        Duration duration = lastwaitingDuration.plus(flightDuration);
        luggage.setWaitingDuration(duration);
        LocalDateTime departureTime = luggage.getDepartureTime();
        LocalDateTime plus = departureTime.plus(luggage.getFlightDuration());
        luggage.setArrivalTime(plus);
        return luggage;

    }
}
