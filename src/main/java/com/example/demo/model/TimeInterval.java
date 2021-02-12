package com.example.demo.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeInterval {
    Timestamp start;
    Timestamp end;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public TimeInterval() {
    }

    public TimeInterval(Timestamp start, Timestamp end) {
        setStart(start);
        setEnd(end);
        this.startTime = this.start.toLocalDateTime();
        this.endTime = this.end.toLocalDateTime();
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        if(this.end != null){
            if(start.after(this.end)) {
                this.start = end;
                this.end = start;
            }else{
                this.start = start;
            }
        }
        else{
            this.start = start;
        }
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        if(this.start != null){
            if(end.before(this.start)){
                this.end = start;
                this.start = end;
            }else{
                this.end = end;
            }
        }else{
            this.end = end;
        }
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean same(TimeInterval timeInterval){
        return this.start.equals(timeInterval.getStart()) && this.end.equals(timeInterval.getEnd());
    }

    public boolean containsOther(TimeInterval timeInterval){
        return this.start.before(timeInterval.getStart()) && this.end.after(timeInterval.getEnd());
    }

    public boolean isContained(TimeInterval timeInterval){
        return timeInterval.getStart().before(this.start) && timeInterval.getEnd().after(this.end);
    }

    public boolean overlaps(TimeInterval timeInterval){
        return this.end.equals(timeInterval.getStart()) ||
                (this.end.after(timeInterval.getStart()) && this.start.before(timeInterval.getStart())) ||
                (this.start.before(timeInterval.getEnd()) && this.end.after(timeInterval.getEnd())) ||
                this.start.equals(timeInterval.getEnd()) ||
                same(timeInterval) ||
                containsOther(timeInterval) ||
                isContained(timeInterval);
    }
}
