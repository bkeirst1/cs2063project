package ca.unb.mobiledev.kimura;

public class Event {

    private String title; //(__ vs. __)

    private int number; //(-1 if a fight name)

    private String location;

    private String date;

    public Event(String title, int number, String location, String date) {
        this.title = title;
        this.number = number;
        this.location = location;
        this.date = date;
    }

    public String getTitle() {
        return this.title;
    }

    public int getNumber() {
        return this.number;
    }

    public String getLocation() {
        return this.location;
    }

    public String getDate() {
        return this.date;
    }
}
