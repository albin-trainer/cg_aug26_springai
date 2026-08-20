package com.example.tools;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
@Service
public class WeatherAppTool {
    @Tool ( description = "Getweather details of city")
    public String getWeather(String city){
        if(city.equals("Bangalore")){
            return "25 deg, light rain";
        }
        else if (city.equals("Chennai")){
            return "35 deg, Sunny Day!!";
        }
        else if(city.equals("Mumbai")){
            return "30 deg, Heavy Rain";
        }
        else {
            return "City not found !!!";
        }
    }
}
