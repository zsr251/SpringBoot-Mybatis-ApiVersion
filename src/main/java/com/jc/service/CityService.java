package com.jc.service;

import com.github.pagehelper.PageHelper;
import com.jc.mapper.CityMapper;
import com.jc.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jasonzhu on 2016/11/23.
 */
@Service
public class CityService {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CityMapper cityMapper;

    public List<City> getAll(City city) {
        if (city.getPage() != null && city.getRows() != null) {
            PageHelper.startPage(city.getPage(), city.getRows(), "id desc");
        }
        return cityMapper.selectAll();
    }
    public City getById(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        cityMapper.deleteByPrimaryKey(id);
    }

    public void save(City country) {
        if (country.getId() != null) {
            cityMapper.updateByPrimaryKey(country);
        } else {
            cityMapper.insert(country);
        }
    }

    public City getTest(){
        logger.error("123456789");
        return cityMapper.selectTest();
    }
}
