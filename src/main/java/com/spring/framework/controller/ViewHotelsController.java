package com.spring.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.framework.model.City;
import com.spring.framework.model.Hotels;
import com.spring.framework.service.ViewHotelsService;

@Controller
public class ViewHotelsController {
	
	private ViewHotelsService viewHotelsService;
	
	@RequestMapping(value="/showHotels", method = RequestMethod.GET)
	public String listCities(Model model) {
		City city =new City();
		model.addAttribute("city", city);
		model.addAttribute("listCities", this.viewHotelsService.listCities());
		return "showhotels";
		
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST )
	public String listHotels(@ModelAttribute("selectCity") City selectCity ,Model model) {
		City city =new City();
		model.addAttribute("city", city);
		model.addAttribute("listCities", this.viewHotelsService.listCities());
		Hotels hotel = new Hotels();
		model.addAttribute("hotel", hotel);
		model.addAttribute("listHotels", this.viewHotelsService.listHotels(selectCity.getId()));
		return "showhotels";
		
	}
	
	@Autowired(required=true)
	@Qualifier(value="viewHotelsService")
	public void setViewHotelsService(ViewHotelsService viewHotelsService) {
		this.viewHotelsService = viewHotelsService;
	}

}
