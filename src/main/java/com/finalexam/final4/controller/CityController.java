package com.finalexam.final4.controller;


import com.finalexam.final4.model.City;
import com.finalexam.final4.service.city.ICityService;
import com.finalexam.final4.service.nation.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    INationService nationService;
    @Autowired
    ICityService cityService;

    @ModelAttribute
    private Iterable<City> getCities() {
        return cityService.findAll();
    }

    @GetMapping("/edit")
    public ModelAndView edit() {
        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("index");
        cityService.delete(id);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailCity(@PathVariable Long id){
        return new ModelAndView("detail","city",cityService.findById(id).get());
    }
}
