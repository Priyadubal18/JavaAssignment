package org.jawaiw.serviceMain;
import java.util.Scanner;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GlobalWeather src = new GlobalWeather();
		GlobalWeatherSoap soap =src.getGlobalWeatherSoap();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the country");
		String country= scan.nextLine();
		String cities = soap.getCitiesByCountry(country);
		System.out.println(cities);
		System.out.println("Enter the city name who's weather needs to be checked");
		String city= scan.nextLine();
		String weather= soap.getWeather(city, country);
		System.out.println(weather);
		
		
		

	}

}
