package ca.unb.mobiledev.kimura;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebScraper extends AsyncTask {

    Context context;

    public WebScraper(Context context) {
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        String protocol = "http";
        String domainName = "ufcstats.com";
        String portNumber = "80";
        String documentPath = "statistics/events/upcoming";
        String url = protocol + "://" + domainName + ":" + portNumber + "/" + documentPath;  // CREATE A STRING OF THE URL
        BufferedReader eventReader = scrape(url);
        getEvents(eventReader);

        getFighters();
        return null;
    }

    private BufferedReader scrape(String url) {
        URL homeSite = null;
        try {
            homeSite = new URL(url);     // CONSTRUCT URL OBJECT
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BufferedReader reader = null; // OPEN CONNECTION USING URL OBJECT
        try {
            reader = new BufferedReader(new InputStreamReader(homeSite.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }

    private void getEvents(BufferedReader reader) {
        String inputLine;
        int entry = 0;
        try {
            while((inputLine = reader.readLine()) != null) { // TRAVERSE FILE LINE BY LINE
                inputLine = inputLine.replaceAll("\\s+","");
                if(inputLine.contains("b-statistics__table-row") && !inputLine.contains("$0")) {
                    if(entry > 1) {
                        String title;
                        int number = 0;
                        String location;
                        String date;
                        for(int i = 0; i < 4; i++) {
                            reader.readLine();
                        }
                        inputLine = reader.readLine();
                        if(inputLine.contains("Fight Night")) {
                            number = -1;
                        } else {
                            number = Integer.parseInt(inputLine.split("C |:")[1]);
                        }
                        title = inputLine.split(": ")[1];
                        for(int i = 0; i < 2; i++) {
                            reader.readLine();
                        }
                        inputLine = reader.readLine();
                        date = inputLine.replaceAll("\\s+","");
                        for(int i = 0; i < 4; i++) {
                            reader.readLine();
                        }
                        inputLine = reader.readLine();
                        location = inputLine.replaceAll("\\s+","");
                        Event event = new Event(title, number, location, date);
                        Data.getInstance().getEvents().add(event);
                    }
                    entry++;
                }
            }
            reader.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void getFighters() {
        String protocol = "http";
        String domainName = "ufcstats.com";
        String portNumber = "80";

        String firstName;
        String lastName;
        String nickName;
        String height;
        double weight;
        double reach;
        String stance;
        int[] record;
        int w, l, d;

        for(char letter = 'a'; letter <= 'z'; letter++) {
            String documentPath = "statistics/fighters?char=" + letter + "&page=all";
            String url = protocol + "://" + domainName + ":" + portNumber + "/" + documentPath;  // CREATE A STRING OF THE URL
            BufferedReader fighterReader = scrape(url);
            String inputLine;
            int entry = 0;
            try {
                while((inputLine = fighterReader.readLine()) != null) {
                    inputLine = inputLine.replaceAll("\\s+","");
                    if(inputLine.contains("b-statistics__table-row")) {
                        if(entry > 1) {
                            fighterReader.readLine();
                            inputLine = fighterReader.readLine();
                            firstName = inputLine.split(">|</a>")[1];
                            fighterReader.readLine();
                            fighterReader.readLine();
                            inputLine = fighterReader.readLine();
                            lastName = inputLine.split(">|</a>")[1];
                            fighterReader.readLine();
                            fighterReader.readLine();
                            inputLine = fighterReader.readLine();
                            try {
                                nickName = inputLine.split(">|</a>")[1];
                            } catch(Exception e) {
                                nickName = "";
                            }
                            fighterReader.readLine();
                            fighterReader.readLine();
                            inputLine = fighterReader.readLine();
                            height = inputLine.replaceAll("\\s+","");
                            fighterReader.readLine();
                            fighterReader.readLine();
                            inputLine = fighterReader.readLine().replaceAll("\\s+","");
                            if(inputLine.equals("--")) {
                                weight = -1;
                            } else {
                                weight = Double.parseDouble(inputLine.replaceAll("lbs",""));
                            }
                            fighterReader.readLine();
                            fighterReader.readLine();
                            inputLine = fighterReader.readLine().replaceAll("\\s+","");
                            if(inputLine.equals("--")) {
                                reach = -1;
                            } else {
                                reach = Double.parseDouble(inputLine.replaceAll("\"",""));
                            }
                            fighterReader.readLine();
                            fighterReader.readLine();
                            inputLine = fighterReader.readLine().replaceAll("\\s+","");
                            stance = inputLine;
                            fighterReader.readLine();
                            fighterReader.readLine();
                            inputLine = fighterReader.readLine().replaceAll("\\s+","");
                            w = Integer.parseInt(inputLine);
                            fighterReader.readLine();
                            fighterReader.readLine();
                            inputLine = fighterReader.readLine().replaceAll("\\s+","");
                            l = Integer.parseInt(inputLine);
                            fighterReader.readLine();
                            fighterReader.readLine();
                            inputLine = fighterReader.readLine().replaceAll("\\s+","");
                            d = Integer.parseInt(inputLine);
                            record = new int[]{w,l,d};
                            Fighter fighter = new Fighter(firstName,lastName, nickName, height, weight, reach, stance, record);
                            Data.getInstance().getFighters().add(fighter);
                        }
                        entry++;
                    }
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
