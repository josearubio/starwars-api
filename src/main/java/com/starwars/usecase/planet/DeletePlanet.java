package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jaro on 7/07/17.
 */
@Service
public class DeletePlanet {
    private PlanetRepository planetRepository;

    public DeletePlanet(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public void execute(Long planetId) {
        if(planetId == null) throw new NullPointerException();

        planetRepository.delete(planetId);
    }
}
