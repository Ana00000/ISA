package com.example.demo.service.impl;

import com.example.demo.model.TimeInterval;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class TimeGenerator {
    private long intervalDuration;

    private long breakDuration;

    private LocalDate localDate;

    public TimeGenerator(int intervalDuration, int breakDuration, LocalDate localDate){
        this.intervalDuration = intervalDuration;
        this.breakDuration = breakDuration;
        this.localDate = localDate;
    }

    public Set<TimeInterval> generateForOneDay(){
        Set<TimeInterval> timeIntervals = new HashSet<>();
        LocalTime localTimeStart = LocalTime.of(0, 0, 0);
        LocalTime localTimeEnd = LocalTime.of(23, 59, 59);
        LocalDateTime start = LocalDateTime.of(localDate, localTimeStart);
        LocalDateTime end = LocalDateTime.of(localDate, localTimeEnd);
        LocalDateTime temp = start.plusMinutes(intervalDuration);
        while(start.isAfter(end)){
            timeIntervals.add(new TimeInterval(Timestamp.valueOf(start), Timestamp.valueOf(end)));
            start = end.plusMinutes(breakDuration);
            end = start.plusMinutes(intervalDuration);
        }
        return timeIntervals;
    }

    public Set<TimeInterval> generateForChosenPeriod( TimeInterval timeInterval ){
        Set<TimeInterval> timeIntervals = this.generateForOneDay();
        Set<TimeInterval> chosenIntervals = new HashSet<>();
        for( TimeInterval ti : timeIntervals ){
            if(ti.isContained(timeInterval)){
                chosenIntervals.add(ti);
            }
        }
        return chosenIntervals;
    }
}
