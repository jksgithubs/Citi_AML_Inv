package org.citi.gfx.apputils;

import java.io.IOException;
import org.citi.gfx.utils.GetController;

public class BusinessDate {
	public static void Select(String getCountry) throws IOException {
		String getBusDate = GetController.GetPropertyValue(getCountry);
		System.out.println("Day: "+getBusDate.split(",")[1].split("-")[0]);
		System.out.println("Month: "+getBusDate.split(",")[1].split("-")[1]);
		System.out.println("Year: "+getBusDate.split(",")[1].split("-")[2]);	
	}
}