package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * Created by jaro on 7/07/17.
 */
@Service
public class FindPlanet {
    private PlanetRepository planetRepository;

    public FindPlanet(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet execute(Long planetId) {
        Planet planet = planetRepository.findOne(planetId);

        if(planet == null) throw new EntityNotFoundException();

        return planet;
    }

}
