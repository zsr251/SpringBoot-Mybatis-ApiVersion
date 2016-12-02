package com.jc.controller;

import com.github.pagehelper.PageInfo;
import com.jc.Person;
import com.jc.model.City;
import com.jc.service.CityService;
import com.jc.util.apiVersion.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jasonzhu on 2016/11/18.
 */
@Controller
public class IndexController {
    @Autowired
    private CityService cityService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 测试模板
     * @param model
     * @return
     */
    @RequestMapping("/")
    String index(Model model) {
        Person single = new Person("aa",11);

        List<Person> people = new ArrayList<>();
        Person p1 = new Person("xx",11);
        Person p2 = new Person("yy",22);
        Person p3 = new Person("zz",33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";
    }

    /**
     * 测试 mybatis common组件
     * @param city
     * @return
     */
    @RequestMapping("/common")
    @ResponseBody
    public PageInfo<City> getAll(City city) {
        List<City> countryList = cityService.getAll(city);
        return new PageInfo<City>(countryList);
    }

    /**
     * 测试 mybatis自定义方法
     * @return
     */
    @RequestMapping("/mybatis")
    @ResponseBody
    public City getTest() {
        City city = cityService.getTest();
        return city;
    }

    /**
     * 测试 redis
     * @return
     */
    @RequestMapping("/redis")
    @ResponseBody
    public String testRedis(){
        return redisTemplate.opsForValue().get("a");
    }

    /**
     * API版本管理测试
     */
    @ApiVersion(targetClass = TestApiVersionDo.class)
    @RequestMapping("/api/test")
    public void test(){}
    @ApiVersion(targetClass = TestApiVersionDo.class,methodPreName = "test")
    @RequestMapping("/api/testno")
    public void testNo(){}

    @RequestMapping("/test")
    public String testNone(){
        return "没有参数";
    }

    @RequestMapping("/test/{a}")
    public String testOne(@PathVariable("a") String a){
        return a;
    }

    @RequestMapping("/test/{a}/{b}")
    public String testOne(@PathVariable("a") String a,@PathVariable("b") String bv){
        return a+" "+bv;
    }
}
