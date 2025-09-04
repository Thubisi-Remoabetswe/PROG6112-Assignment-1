package com.mycompany.tvstreamingapplication;

import java.util.Scanner;
import java.util.ArrayList;

public class Series {
    
    public static ArrayList<SeriesModel> seriesList = new ArrayList<>();
    
    public static void main(String[] args) {
         System.out.println("LATEST SERIES - 2025");
         showMenu();
         
    }
    
    // show main menu for series application
    public static void showMenu(){
        
        Scanner input = new Scanner(System.in);
        int menuOption;
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        menuOption = input.nextInt();
        
        if(menuOption == 1){
            mainMenu(); 
        } else{
            System.out.println("Exiting Application");
            return;
        }  
    }
   
    //main menu with switch for different user input
    public static void mainMenu(){
        
        String mainMenuOption;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("""
            Please select one of the following menu items:
            (1) Capture a new series.
            (2) Search for a series.
            (3) Update series age restriction.
            (4) Delete a series.
            (5) Print series report - 2025
            (6) Exit Application.
            """);
        mainMenuOption = input.nextLine();
        
        switch(mainMenuOption){
            case "1":
                captureSeries();
                return;
                
            case "2":
                searchSeries();
                return;
                
            case "3":
                updateSeries();
                return;
                
            case "4":
                deleteSeries();
                return;
                
            case "5":
                seriesReport();
                return;
                
            case "6":
            System.out.println("Exiting Application");
                return;
            
            default: 
                System.out.println("Invalid choice.");        
        }       
    }
    
    //capture series method
    public static void captureSeries(){
        
        String id;
        String name;
        int age = 0;
        String episodes;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("Enter the series id: ");
        id = input.nextLine();
        System.out.println("Enter the series name: ");
        name = input.nextLine();
        
        boolean validAge = false;
        
        while(!validAge){
            
            System.out.println("Enter the series age restriction: ");
            age = input.nextInt();
            input.nextLine();
            
            if(age < 2 || age > 18){
                System.out.println("You have entered a incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            } else{
               validAge = true;    }    
        }
        
        System.out.println("Enter the number of episodes for " + name + ": ");
        episodes = input.nextLine();
        
        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesList.add(newSeries);
        System.out.println("Series processed successfully!!!");
        showMenu(); 
    }

    //series search method
    public static void searchSeries(){
        
        String search;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the series id to search: ");
        search = input.nextLine();
        System.out.println("------------------------------------");

        boolean found = false;
        
        for(SeriesModel series : seriesList) {
            if(series.getId().equalsIgnoreCase(search) || series.getSeriesName().equalsIgnoreCase(search)) {
                System.out.println("SERIES ID: " + series.getId());
                System.out.println("SERIES NAME: " + series.getSeriesName());
                System.out.println("SERIES AGE Restriction: " + series.getAge());
                System.out.println("SERIES NUMBER OF EPISODES: " + series.getNumberofEpisodes());
                System.out.println("------------------------------------");
                found = true;
                break;
            }
        }
        
        if(!found){
            System.out.println("Series with Series Id: " + search + " was not found!");
            System.out.println("------------------------------------");
        }
        showMenu();
    }
    
    //method to update the inforation of the series already entered
    public static void updateSeries(){
        
        String updateId;
        String updateName;
        int updateAge;
        String updateEpisodes;
        
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the series id to update: ");
        updateId = input.nextLine();
        
        for (SeriesModel series : seriesList) {
            if (series.getId().equalsIgnoreCase(updateId)) {
                System.out.println("Enter the new series name: ");
                updateName = input.nextLine();
                series.setSeriesName(updateName);

                System.out.println("Enter the new age restriction: ");
                updateAge = input.nextInt();
                input.nextLine();
                series.setAge(updateAge);

                System.out.println("Enter the new number of episodes: ");
                updateEpisodes = input.nextLine();
                series.setNumberofEpisodes(updateEpisodes);

                System.out.println("Series updated successfully!");
                showMenu();
            }
        }
        System.out.println("Series with Series Id: " + updateId + " was not found!");
        showMenu();
        
    }
    
    //delete the series
    public static void deleteSeries(){
        
        String deleteId;
        String confirmation;
        
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the series id to delete: ");
        deleteId = input.nextLine();
        
        boolean search = false;
        
        for(int i = 0; i < seriesList.size(); i++){
            SeriesModel series = seriesList.get(i);
            
            if(series.getId().equalsIgnoreCase(deleteId)){
                System.out.println("Are you sure you want to delete series " + deleteId + " from the system? Yes (y) to delete. ");
                confirmation = input.nextLine();
                System.out.println("------------------------------------");
                
                if(confirmation.equalsIgnoreCase("y")){
                    seriesList.remove(series);
                    System.out.println("Series with Series Id: " + deleteId + " WAS deleted!");
                }else{
                    System.out.println("Delete cancelled.");
                }
                
                search = true;
                break;
            }
        }
        
        if(!search){
            
           System.out.println("Series with Series Id: " + deleteId + " was not found!"); 
        }           
            showMenu();   
    }
    
    //full report of the series saved on array
    public static void seriesReport(){
        
        if(seriesList.isEmpty()){
            System.out.println("No series found.");
            showMenu();
            
        } else{
            int count = 1;
            for(SeriesModel series : seriesList){
                System.out.println("SERIES " + count++);
                System.out.println("SERIES ID: " + series.getId());
                System.out.println("SERIES NAME: " + series.getSeriesName());
                System.out.println("SERIES AGE Restriction: " + series.getAge());
                System.out.println("SERIES NUMBER OF EPISODES: " + series.getNumberofEpisodes());
                System.out.println("------------------------------------");
            }
        }
        showMenu();
    }
}
