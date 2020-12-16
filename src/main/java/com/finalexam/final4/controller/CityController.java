package com.finalexam.final4.controller;


import com.finalexam.final4.model.City;
import com.finalexam.final4.model.Nation;
import com.finalexam.final4.service.city.ICityService;
import com.finalexam.final4.service.nation.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    INationService nationService;
    @Autowired
    ICityService cityService;

    @ModelAttribute("cityList")
    private Iterable<City> getCities() {
        return cityService.findAll();
    }
    @ModelAttribute("nations")
    private Iterable<Nation> getNations(){
        return nationService.findAll();
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("editForm");
        modelAndView.addObject("city", cityService.findById(id).get());
        modelAndView.addObject("messenger", "...");
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute("city") City newCity) {
        cityService.save(newCity);
        ModelAndView modelAndView = new ModelAndView("editForm");
        modelAndView.addObject("messenger", "Success!!");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("createForm");
        modelAndView.addObject("messenger", "...");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("city") City newCity) {
        cityService.save(newCity);
        ModelAndView modelAndView = new ModelAndView("createForm");
        modelAndView.addObject("messenger", "Success!!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id, HttpServletResponse response) {
        cityService.delete(id);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailCity(@PathVariable Long id) {
        return new ModelAndView("detail", "city", cityService.findById(id).get());
    }
}
