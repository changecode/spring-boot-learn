package com.springboot.dao;

import org.apache.ibatis.annotations.Param;

import com.springboot.domain.City;

/**
 * Dao接口
 * @author Tim
 *
 */
public interface CityDao {

	/**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}
