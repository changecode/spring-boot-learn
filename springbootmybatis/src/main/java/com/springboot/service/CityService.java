package com.springboot.service;

import com.springboot.domain.City;

/**
 * service层
 * @author Tim
 *
 */
public interface CityService {

	/**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findCityByName(String cityName);
}
