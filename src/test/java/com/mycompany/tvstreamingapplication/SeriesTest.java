package com.mycompany.tvstreamingapplication;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {
    
    @BeforeEach
    public void setUp() {
        Series.seriesList.clear();
        Series.seriesList.add(new SeriesModel("S01", "Breaking Code", 16, "10"));
        Series.seriesList.add(new SeriesModel("S02", "Java Hunters", 13, "8"));
    }

    @org.junit.jupiter.api.Test
    public void testSearchSeries() {
       // Search by ID
        SeriesModel result = findSeriesById("S01");
        assertNotNull(result);
        assertEquals("Breaking Code", result.getSeriesName());
    
    }
    
    @org.junit.jupiter.api.Test
    public void testSearchSeries_SeriesNotFound() {
        SeriesModel result = findSeriesById("S99");
        assertNull(result);
    }

    @org.junit.jupiter.api.Test
    public void testUpdateSeries() {
        SeriesModel series = findSeriesById("S02");
        assertNotNull(series);

        // Update details
        series.setSeriesName("Java Legends");
        series.setAge(15);
        series.setNumberofEpisodes("12");

        assertEquals("Java Legends", series.getSeriesName());
        assertEquals(15, series.getAge());
        assertEquals("12", series.getNumberofEpisodes());
    }

    @org.junit.jupiter.api.Test
    public void testDeleteSeries() {
        boolean removed = deleteSeriesById("S01");
        assertTrue(removed);

        // Ensure it’s really deleted
        assertNull(findSeriesById("S01"));
        assertEquals(1, Series.seriesList.size());
    }
    
    @org.junit.jupiter.api.Test
    public void testDeleteSeries_SeriesNotFound() {
        boolean removed = deleteSeriesById("S99");
        assertFalse(removed);
        assertEquals(2, Series.seriesList.size()); // no deletion occurred
    }

    @org.junit.jupiter.api.Test
    public void testSeriesAgeRestriction_AgeValid() {
        SeriesModel series = new SeriesModel("S03", "Kids Show", 10, "20");
        assertTrue(series.getAge() >= 2 && series.getAge() <= 18);
    }
    
    @org.junit.jupiter.api.Test
    public void testSeriesAgeRestriction_SeriesAgeInValid() {
        SeriesModel series = new SeriesModel("S04", "Adults Only", 21, "5");
        assertFalse(series.getAge() >= 2 && series.getAge() <= 18);
    }
    
    private SeriesModel findSeriesById(String id) {
        for (SeriesModel s : Series.seriesList) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    private boolean deleteSeriesById(String id) {
        SeriesModel toRemove = null;
        for (SeriesModel s : Series.seriesList) {
            if (s.getId().equalsIgnoreCase(id)) {
                toRemove = s;
                break;
            }
        }
        if (toRemove != null) {
            Series.seriesList.remove(toRemove);
            return true;
        }
        return false;
    }
    
}
