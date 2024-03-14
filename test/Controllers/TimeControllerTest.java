package Controllers;

import Models.Time;
import Utils.TimesOfDay;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeControllerTest {

    private TestableTime time;
    private TimeController timeController;

    @Before
    public void setUp() {
        time = new TestableTime();
        timeController = new TimeController(time);
    }

    @Test
    public void testAdvanceTime() {
        time.setCurrentTime(2350); // Set to 11:50 PM
        timeController.advanceTime(20); // Advance by 20 minutes
        assertEquals("Time should wrap to next day", 10, time.getCurrentTime());
        assertEquals("Should be night", TimesOfDay.Night, time.getTimeOfDay());
    }

    @Test
    public void testResetTime() {
        time.setCurrentTime(1230); // Set to 12:30 PM
        timeController.resetTime();
        assertEquals("Time should reset to 0", 0, time.getCurrentTime());
        assertEquals("Should be night", TimesOfDay.Night, time.getTimeOfDay());
    }

    // An inner class to extend Time or act as a concrete implementation for testing
    private static class TestableTime extends Time {
        private int currentTime;
        private TimesOfDay timeOfDay;

        @Override
        public int getCurrentTime() {
            return currentTime;
        }

        @Override
        public void setCurrentTime(int currentTime) {
            this.currentTime = currentTime;
        }

        @Override
        public void setTimeOfDay(TimesOfDay timeOfDay) {
            this.timeOfDay = timeOfDay;
        }

        @Override
        public TimesOfDay getTimeOfDay() {
            return timeOfDay;
        }
    }
}
