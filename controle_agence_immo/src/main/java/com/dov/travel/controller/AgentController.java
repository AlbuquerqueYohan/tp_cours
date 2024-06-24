package com.dov.travel.controller;

import com.dov.travel.model.Agent;
import com.dov.travel.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("agents", agentService.getAll());
        return "agent/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Agent agent) {
        return "agent/add";
    }

    @PostMapping("/add")
    public String add(Agent agent) {
        agentService.add(agent);
        return "redirect:/agent/add";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
        Agent agent = agentService.findById(id);
        model.addAttribute("agent", agent);
        return "agent/update";
    }

    @PostMapping("/update")
    public String processUpdate(Agent agent) {
        agentService.update(agent);
        return "redirect:agent/update";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        agentService.delete(id);
        return "redirect:agent/delete";
    }

}
