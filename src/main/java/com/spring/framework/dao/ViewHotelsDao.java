package com.spring.framework.dao;

import java.util.List;

import com.spring.framework.model.City;
import com.spring.framework.model.Hotels;

public interface ViewHotelsDao {
	
	public List<City> listCities();
	public List<Hotels> listHotels(int id);
	public List<Hotels> listHotel(int id);

}
