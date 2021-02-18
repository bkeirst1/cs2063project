package ca.unb.mobiledev.kimura;

import java.util.ArrayList;

public final class Data {

    private static final Data SELF = new Data();

    private ArrayList<Fighter> fighters = new ArrayList<Fighter>();

    private ArrayList<Event> events = new ArrayList<Event>();

    private Data() {}

    public static Data getInstance() {
        return SELF;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public ArrayList<Fighter> getFighters() {
        return fighters;
    }
}