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


        if (time.getCurrentTime >= 600 || time.getCurrentTime <= 1200) {

            time.setTimeOfDay(TimesOfDay.Morning);

        }else if (time.getCurrentTime >= 1215 || time.getCurrentTime <= 1600) {

            time.setTimeOfDay(TimesOfDay.Afternoon);    

        }else if (time.getCurrentTime >= 1615 || time.getCurrentTime <= 2200) {

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
