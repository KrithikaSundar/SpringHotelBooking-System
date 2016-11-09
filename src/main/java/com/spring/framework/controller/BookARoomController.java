package com.spring.framework.controller;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.framework.model.BookedHotels;
import com.spring.framework.model.City;
import com.spring.framework.model.Hotels;
import com.spring.framework.service.ViewHotelsService;

@Controller
@RequestMapping("")
public class BookARoomController {

	@Autowired
	private MessageSource messageSource;
	
	private ViewHotelsService viewHotelsService;

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String listHotels(Model model) {
		Hotels hotel = new Hotels();
		model.addAttribute("hotel", hotel);
		model.addAttribute("listHotels", this.viewHotelsService.listHotels());
		City city = new City();
		model.addAttribute("city", city);
		model.addAttribute("listCities", this.viewHotelsService.listCities());
		return "book";

	}

	@RequestMapping(value="/go", method = RequestMethod.POST )
	public String listHotels(@ModelAttribute("selectCity") City selectCity ,Model model) {
		City city =new City();
		model.addAttribute("city", city);
		model.addAttribute("listCities", this.viewHotelsService.listCities());
		Hotels hotel = new Hotels();
		model.addAttribute("hotel", hotel);
		model.addAttribute("listHotels", this.viewHotelsService.listHotel(selectCity.getId()));
		return "book";
		
	}
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String addEmployees(@ModelAttribute("bookedhotels") BookedHotels bookedHotels, Model model,BindingResult errors) {
		String page = "confirmationform";
		Date checkoutdate = this.viewHotelsService.getCheckOutDate(bookedHotels);
		int availablerooms = this.viewHotelsService.getAvailableNumberOfRooms(bookedHotels);
		Date curdate = this.viewHotelsService.getCurrentDate();
		if(bookedHotels.getCheckindate().compareTo(curdate)<0 || bookedHotels.getCheckoutdate().compareTo(checkoutdate) >0 || bookedHotels.getNumberofrooms()>availablerooms) {
			Object error = "Requested Number of Rooms are not available on the given dates,Please try again...";
			model.addAttribute("errorMessage", error);
		}
		else {
		double priceamount = this.viewHotelsService.updatebookedHotelsDetails(bookedHotels);
		model.addAttribute("priceamount", this.viewHotelsService.updatebookedHotelsDetails(bookedHotels));
		long difference = (bookedHotels.getCheckoutdate().getTime() - bookedHotels.getCheckindate().getTime())
				/ 86400000;
		double totalamount = priceamount * bookedHotels.getNumberofrooms() * difference;
		model.addAttribute("totalamount", totalamount);
		bookedHotels.setPrice(totalamount);
		int cityid=this.viewHotelsService.getCityId(bookedHotels);
		String cityname=this.viewHotelsService.getCityName(cityid);
		bookedHotels.setCity(cityname);
		model.addAttribute("bookedinfo", this.viewHotelsService.addbookedHotelsDetails(bookedHotels));
		}
		return page;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "viewHotelsService")
	public void setViewHotelsService(ViewHotelsService viewHotelsService) {
		this.viewHotelsService = viewHotelsService;
	}
}
