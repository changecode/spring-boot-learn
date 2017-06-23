package com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.CityDao;
import com.springboot.domain.City;
import com.springboot.service.CityService;

/**
 * service impl层
 * @author Tim
 *
 */
@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDao cityDao;
	
	@Override
	public City findCityByName(String cityName) {
		return cityDao.findByName(cityName);
	}

	
}
