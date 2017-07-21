package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jaro on 7/07/17.
 */
@Service
public class FindAllPlanets {
    private PlanetRepository planetRepository;

    public FindAllPlanets(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public List<Planet> execute() {
        return planetRepository.findAll();
    }
}
