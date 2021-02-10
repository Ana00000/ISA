package com.example.demo.model;

import java.sql.Timestamp;

public class TimeInterval {
    Timestamp start;
    Timestamp end;

    public TimeInterval() {
    }

    public TimeInterval(Timestamp start, Timestamp end) {
        setStart(start);
        setEnd(end);
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
