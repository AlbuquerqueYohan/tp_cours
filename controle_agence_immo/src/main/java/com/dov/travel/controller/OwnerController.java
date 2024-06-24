package com.dov.travel.controller;

import com.dov.travel.model.Owner;
import com.dov.travel.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("owners", ownerService.getAll());
        return "owner/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Owner owner) {
        return "owner/add";
    }

    @PostMapping("/add")
    public String add(Owner owner) {
        ownerService.add(owner);
        return "redirect:/owner/add";
    }

    @GetMapping("/update")
    public String displayUpdateForm(Long id, Model model) {
        Owner owner = ownerService.findById(id);
        model.addAttribute("owner", owner);
        return "owner/update";
    }

    @PostMapping("/update")
    public String processUpdate(Owner owner) {
        ownerService.update(owner);
        return "redirect:/owner/update";
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        ownerService.delete(id);
        return "redirect:/owner/delete";
    }
}
