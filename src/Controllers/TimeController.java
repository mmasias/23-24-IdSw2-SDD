package controllers;

import Models.Time;

public class TimeController {
    private Time time;

    public TimeController(Time time) {
        this.time = time;
    }

    public void advanceTime() {

     int currentTime = time.getCurrentTime();
        int minutes = currentTime % 100; 
        int hours = currentTime / 100; 

        
        minutes += 15;
        if (minutes >= 60) {
         
            hours++;
            minutes = 0;
        }
        
       
        if (hours > 23) {
            hours = 0;
        }

      
        time.setCurrentTime(hours * 100 + minutes);
    }
        
    }

    private void updateTimeOfDay() {

        int currentTime = time.getCurrentTime();

        if (currentTime >= 600 || currentTime <= 1200) {

            time.setTimeOfDay(TimesOfDay.Morning);

        }else if (currentTime >= 1215 || currentTime <= 1600) {

            time.setTimeOfDay(TimesOfDay.Afternoon);    

        }else if (currentTime >= 1615 || currentTime <= 2200) {

          time.setTimeOfDay(TimesOfDay.Evening);    

        }else {time.setTimeOfDay(TimesOfDay.Night);}


    }
    

    public void resetTime() {

        int currentTime = time.getCurrentTime();

        if  (time.getCurrentTime >2345) {

            time.setCurrentTime(0)


        }

        
    }
}
