package com.mycompany.tvstreamingapplication;

public class SeriesModel {
    public String SeriesId;
    public String SeriesName;
    public int SeriesAge;
    public String SeriesNumberOfEpisodes;

    //Constructor
    public SeriesModel(String SeriesId, String SeriesName, int SeriesAge, String SeriesNumberOfEpisodes){
        this.SeriesId = SeriesId;
        this.SeriesName = SeriesName;
        this.SeriesAge = SeriesAge;
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }
    
    @Override
    public String toString(){
        return "Series ID: " + SeriesId +
                ", Name: " + SeriesName +
                ", Age: " + SeriesAge +
                ", Episodes: " + SeriesNumberOfEpisodes;
    }
    
    //getters
    public String getId(){
        return SeriesId;
    }
    
    public String getSeriesName(){
        return SeriesName;
    }
    
    public int getAge(){
        return SeriesAge;
    }
    
    public String getNumberofEpisodes(){
        return SeriesNumberOfEpisodes;
    }
    
    //setters
    public void setId(String SeriesId){
        this.SeriesId = SeriesId;
    }
    
    public void setSeriesName(String SeriesName){
        this.SeriesName = SeriesName;
    }
    
    public void setAge(int SeriesAge){
        this.SeriesAge = SeriesAge;
    }
    
    public void setNumberofEpisodes(String SeriesNumberOfEpisodes){
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }
}
