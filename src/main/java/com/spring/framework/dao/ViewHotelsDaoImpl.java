package com.spring.framework.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.spring.framework.model.City;
import com.spring.framework.model.Hotels;

@Repository
public class ViewHotelsDaoImpl implements ViewHotelsDao{
	
	private static final Logger logger = LoggerFactory.getLogger(ViewHotelsDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	public List<City> listCities() {
		Session session = this.sessionFactory.getCurrentSession();
		List<City> cityList = session.createQuery("from City").list();
		for(City city : cityList){
			logger.info("Cities List::"+city);
		}
		return cityList;
	}
	@SuppressWarnings("unchecked")
	public List<Hotels> listHotels(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Hotels h where h.id= :id order by h.price ASC");
		query.setParameter("id", id);
		query.setFirstResult(0);
		query.setMaxResults(5); 
		List<Hotels> hotelsList = query.list();
		for(Hotels hotels : hotelsList){
			logger.info("Cities List::"+hotels);
		}
		return hotelsList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Hotels> listHotel(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query= session.createQuery("from Hotels h where h.id= :id order by h.price ASC");
		query.setParameter("id", id);
		List<Hotels> hotelsList = query.list();
		for(Hotels hotels : hotelsList){
			logger.info("Cities List::"+hotels);
		}
		return hotelsList;
	}

}
