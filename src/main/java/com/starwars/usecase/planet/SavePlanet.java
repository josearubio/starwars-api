package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jaro on 7/07/17.
 */
@Service
public class SavePlanet {
    private PlanetRepository planetRepository;

    public SavePlanet(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet execute(Planet planet) {
        if(planet == null ) throw new NullPointerException("Planet is null");

        return planetRepository.save(planet);
    }
}
