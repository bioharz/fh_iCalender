package controller;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.property.Summary;
import biweekly.util.Duration;
import biweekly.util.Frequency;
import biweekly.util.Recurrence;

import java.util.Date;

public class ICalenderBuilder {

    public static String buildICal(Date start){

        ICalendar ical = new ICalendar();
        VEvent event = new VEvent();
        Summary summary = event.setSummary("Team Meeting");
        summary.setLanguage("de-de");

        event.setDateStart(start);

        Duration duration = new Duration.Builder().hours(1).build();
        event.setDuration(duration);

        Recurrence recur = new Recurrence.Builder(Frequency.WEEKLY).interval(2).build();
        event.setRecurrenceRule(recur);
        ical.addEvent(event);

        String str = Biweekly.write(ical).go();

        return "";
    }
}
