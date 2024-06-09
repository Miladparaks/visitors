package controller;

import model.bl.TimingBl;
import model.entity.Person;
import model.entity.Timing;

import java.time.LocalDateTime;

public class TimingController {
    public static String save(LocalDateTime startTime, LocalDateTime endTime, Person person, String location, int roomNumber) {
        try {
            Timing timing = new Timing();
            timing.setStartTime(startTime);
            timing.setEndTime(endTime);
            timing.setDoctor(person);
            timing.setLocation(location);
            timing.setRoomNumber(roomNumber);
            TimingBl.getTimingBl().save(timing);
            return "Timing has been saved successfully";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
