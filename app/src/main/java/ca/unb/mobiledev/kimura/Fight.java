package ca.unb.mobiledev.kimura;

import android.os.Parcel;
import android.os.Parcelable;

public class Fight implements Parcelable {

    private String fighterOne;

    private String fighterTwo;

    private String weightClass;

    public Fight(String fighterOne, String fighterTwo, String weightClass) {
        this.fighterOne = fighterOne;
        this.fighterTwo = fighterTwo;
        this.weightClass = weightClass;
    }

    protected Fight(Parcel in) {
        fighterOne = in.readString();
        fighterTwo = in.readString();
        weightClass = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fighterOne);
        dest.writeString(fighterTwo);
        dest.writeString(weightClass);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Fight> CREATOR = new Creator<Fight>() {
        @Override
        public Fight createFromParcel(Parcel in) {
            return new Fight(in);
        }

        @Override
        public Fight[] newArray(int size) {
            return new Fight[size];
        }
    };

    public String getFighterOne() {
        return fighterOne;
    }

    public String getFighterTwo() {
        return fighterTwo;
    }

    public String getWeightClass() {
        return weightClass;
    }
}
