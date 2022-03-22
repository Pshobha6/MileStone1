package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Netflix {

    private String sNo;
    private String type;
    private String title;
    private String director;
    private String team;
    private String country;
    private Date date_added;
    private String year;
    private String series;
    private String duration;
    private String listed_in;
    private String description;

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Netflix{" +
                "sNo='" + sNo + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", team='" + team + '\'' +
                ", country='" + country + '\'' +
                ", date_added='" + date_added + '\'' +
                ", year='" + year + '\'' +
                ", series='" + series + '\'' +
                ", duration='" + duration + '\'' +
                ", listed_in='" + listed_in + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getListed_in() {
        return listed_in;
    }

    public void setListed_in(String listed_in) {
        this.listed_in = listed_in;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Netflix(String sNo, String type, String title, String director, String team, String country, String date_added, String year, String series, String duration, String listed_in, String description) {
        this.sNo=sNo;
        this.type=type;
        this.title=title;
        this.director=director;
        this.team=team;
        this.country=country;
        //System.out.println(date_added+"---------------------------date");
        try {
            this.date_added=new SimpleDateFormat("dd/MM/yyyy").parse(date_added);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.year=year;
        this.series=series;
        this.duration=duration;
        this.listed_in=listed_in;
        this.description=description;

    }


}
