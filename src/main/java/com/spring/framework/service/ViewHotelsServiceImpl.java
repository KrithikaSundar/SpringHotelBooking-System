package com.spring.framework.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.framework.dao.BookARoomDao;
import com.spring.framework.dao.ViewHotelsDao;
import com.spring.framework.model.BookedHotels;
import com.spring.framework.model.City;
import com.spring.framework.model.Hotels;

@Service
public class ViewHotelsServiceImpl implements ViewHotelsService {

	private ViewHotelsDao viewHotelsDao;
	
	private BookARoomDao bookARoomDao;

	public void setViewHotelsDao(ViewHotelsDao viewHotelsDao) {
		this.viewHotelsDao = viewHotelsDao;
	}

	public void setBookARoomDao(BookARoomDao bookARoomDao) {
		this.bookARoomDao = bookARoomDao;
	}

	@Transactional
	public List<City> listCities() {
		return this.viewHotelsDao.listCities();
	}
	
	@Transactional
	public List<Hotels> listHotels(int id) {
		return this.viewHotelsDao.listHotels(id);
	}
	
	@Transactional
	public List<Hotels> listHotel(int id) {
		return this.viewHotelsDao.listHotel(id);
	}
	
	@Transactional
	public List<Hotels> listHotels() {
		return this.bookARoomDao.listHotels();
	}
	
	@Transactional
	public BookedHotels addbookedHotelsDetails(BookedHotels bookedHotels) {
		return this.bookARoomDao.addbookedHotelsDetails(bookedHotels);
	}
	
	@Transactional
	public double updatebookedHotelsDetails(BookedHotels bookedHotels) {
		return this.bookARoomDao.updatebookedHotelsDetails(bookedHotels);
	}
	
	@Transactional
	public double getTotalAmount(BookedHotels bookedHotels) {
		return this.bookARoomDao.getTotalAmount(bookedHotels);
	}
	
	@Transactional
	public Date getCheckOutDate(BookedHotels bookedHotels) {
		return this.bookARoomDao.getCheckOutDate(bookedHotels);
	}
	
	@Transactional
	public int getAvailableNumberOfRooms(BookedHotels bookedHotels) {
		return this.bookARoomDao.getAvailableNumberOfRooms(bookedHotels);
	}
	
	@Transactional
	public Date getCurrentDate() {
		return this.bookARoomDao.getCurrentDate();
	}

	@Transactional
	public String getCityName(int id) {
		return this.bookARoomDao.getCityName(id);
	}

	@Transactional
	public int getCityId(BookedHotels bookedHotels) {
		return this.bookARoomDao.getCityId(bookedHotels);
	}
}
