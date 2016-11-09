package com.spring.framework.service;

import java.util.Date;
import java.util.List;

import com.spring.framework.model.BookedHotels;
import com.spring.framework.model.City;
import com.spring.framework.model.Hotels;

public interface ViewHotelsService {
	public List<City> listCities();
	public List<Hotels> listHotels(int id);
	public List<Hotels> listHotel(int id);
	public List<Hotels> listHotels();
	public BookedHotels addbookedHotelsDetails(BookedHotels bookedHotels);
	public double updatebookedHotelsDetails(BookedHotels bookedHotels);
	public double getTotalAmount(BookedHotels bookedHotels);
	public Date getCheckOutDate(BookedHotels bookedHotels);
	public int getAvailableNumberOfRooms(BookedHotels bookedHotels);
	public Date getCurrentDate();
	public String getCityName(int id);
	public int getCityId(BookedHotels bookedHotels);
}
