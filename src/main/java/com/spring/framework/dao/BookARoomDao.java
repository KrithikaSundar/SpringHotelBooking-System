package com.spring.framework.dao;

import java.util.Date;
import java.util.List;

import com.spring.framework.model.BookedHotels;
import com.spring.framework.model.Hotels;

public interface BookARoomDao {
	
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
