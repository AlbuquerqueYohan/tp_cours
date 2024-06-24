package com.dov.travel.controller;

import com.dov.travel.model.Property;
import com.dov.travel.service.OwnerService;
import com.dov.travel.service.PropertyService;
import com.dov.travel.service.PropertyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/property")
public class PropertyController {
     @Autowired
    private PropertyService propertyService;

    @Autowired
    private PropertyTypeService propertyTypeService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("properties", propertyService.getAll());
        return "property/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Property property, Model model) {
        model.addAttribute("propertyTypes", propertyTypeService.getAll());
        model.addAttribute("owners", ownerService.getAll());
        return "property/add";
    }

    @PostMapping("/add")
    public String processAdd(Property property) {
        propertyService.add(property);
        return "redirect:/property/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") String id, Model model) {
        Property property = propertyService.findById(id);
        model.addAttribute("propertyTypes", propertyTypeService.getAll());
        model.addAttribute("owners", ownerService.getAll());
        model.addAttribute("property", property);
        return "property/update";
    }

    @PostMapping("/update")
    public String processUpdate(Property property) {
        propertyService.update(property);
        return "redirect:/property/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        propertyService.delete(id);
        return "redirect:/property/list";
    }

}
