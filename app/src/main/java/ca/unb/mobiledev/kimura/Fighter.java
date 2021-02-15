package ca.unb.mobiledev.kimura;

public class Fighter {

    private String firstName;

    private String lastName;

    private String nickName;

    private String height; //(#'#")

    private double weight; //(lbs)

    private double reach; //(inches)

    private String stance; //(Orthodox, Switch, Southpaw)

    private int[] record; //([wins, losses, nc])

    private String belt; //(weight class belt won in, NULL if no belt held)

    public Fighter(String firstName, String lastName, String nickName, String height, double weight,
                   double reach, String stance, int[] record, String belt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.height = height;
        this.weight = weight;
        this.reach = reach;
        this.stance = stance;
        this.record = record;
        this.belt = belt;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getReach() {
        return this.reach;
    }

    public String getStance() {
        return this.stance;
    }

    public int[] getRecord() {
        return this.record;
    }

    public String getBelt() {
        return this.belt;
    }
}
