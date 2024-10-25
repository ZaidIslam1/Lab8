package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list; /**
     * create a mocklist for my citylist * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>()); return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount(); 
        list.addCity(new City("Estevan", "SK")); 
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    void testHasCity(){
        CustomList cityList = MockCityList();
        City mockCity = new City("Van", "BC");
        cityList.addCity(mockCity);
        // should return true
        assertTrue(cityList.hasCity(mockCity));
        City city2 = new City("Calgary", "AB");
        assertFalse(cityList.hasCity(city2));
    }
    @Test
    void testDelete(){
        CustomList cityList = MockCityList();
        // Add the city to the list first
        City city = new City("Sherwood Park", "AB");
        cityList.addCity(city);
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }
    @Test
    void testCountCities(){
        CustomList cityList = MockCityList();
        cityList.addCity(new City("Toronto", "ON"));
        assertEquals(1, cityList.countCities());
        cityList.addCity(new City("Hello", "World"));
        assertEquals(2, cityList.countCities());
    }


}
