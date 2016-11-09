package com.spring.framework.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.framework.model.BookedHotels;
import com.spring.framework.model.Hotels;

@Repository
public class BookARoomDaoImpl implements BookARoomDao{

	private static final Logger logger = LoggerFactory.getLogger(BookARoomDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	public List<Hotels> listHotels() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Hotels");
		List<Hotels> hotelsList = query.list();
		for(Hotels hotels : hotelsList){
			logger.info("Hotel List::"+hotels);
		}
		return hotelsList;
	}
	
	public BookedHotels addbookedHotelsDetails(BookedHotels bookedHotels) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bookedHotels);
		return bookedHotels;
	}
	public double updatebookedHotelsDetails(BookedHotels bookedHotels) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("select h.price from Hotels h where h.hotelname= :hotelname");
		query.setParameter("hotelname", bookedHotels.getHotel());
		double price = (Double) query.uniqueResult();
		return price;
	}

	public Date getCheckOutDate(BookedHotels bookedHotels) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("select h.checkout from Hotels h where h.hotelname= :hotelname");
		query.setParameter("hotelname", bookedHotels.getHotel());
		Date date = (Date) query.uniqueResult();
		return date;
	}
	
	
	public int getCityId(BookedHotels bookedHotels) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("select h.id from Hotels h where h.hotelname= :hotelname");
		query.setParameter("hotelname", bookedHotels.getHotel());
		int id =  (Integer) query.uniqueResult();
		return id;
	}
	
	public String getCityName(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("select c.cityname from City c where c.id= :id");
		query.setParameter("id", id);
		String cityname =  (String) query.uniqueResult();
		return cityname;
	}
	
	public int getAvailableNumberOfRooms(BookedHotels bookedHotels) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("select h.availablerooms from Hotels h where h.hotelname= :hotelname");
		query.setParameter("hotelname", bookedHotels.getHotel());
		int availablerooms =  (Integer) query.uniqueResult();
		return availablerooms;
	}
	
	public double getTotalAmount(BookedHotels bookedHotels) {
        long difference = (bookedHotels.getCheckindate().getTime()-bookedHotels.getCheckoutdate().getTime())/86400000; 
        double totalamount = bookedHotels.getPrice() * bookedHotels.getNumberofrooms() * difference;
        return totalamount;
	}
	
	public Date getCurrentDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
		Calendar cal = Calendar.getInstance();
		String currentDate = simpleDateFormat.format(cal.getTime());
		Date currDate = null;
		try {
			currDate = simpleDateFormat.parse(currentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return currDate;
	}
}
