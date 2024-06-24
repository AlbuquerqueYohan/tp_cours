package com.dov.travel.service;

import com.dov.travel.model.Agent;

import java.util.List;

public interface AgentService {
    public List<Agent> getAll();
    public void add(Agent agent);
    public void update(Agent agent);
    public void delete(Long id);
    public Agent findById(Long id);
}
