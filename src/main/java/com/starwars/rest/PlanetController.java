package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.model.Planet;
import com.starwars.usecase.film.FindAllFilm;
import com.starwars.usecase.planet.DeletePlanet;
import com.starwars.usecase.planet.FindAllPlanets;
import com.starwars.usecase.planet.FindPlanet;
import com.starwars.usecase.planet.SavePlanet;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jaro on 7/07/17.
 */
@RequestMapping(path = "/planets")
@Controller
@AllArgsConstructor
public class PlanetController {

    private FindAllPlanets findAllPlanets;
    private SavePlanet savePlanet;
    private FindPlanet findPlanet;
    private DeletePlanet deletePlanet;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Planet>> findAll() {
        List<Planet> planets = findAllPlanets.execute();

        return new ResponseEntity<>(planets, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Planet> findById(@PathVariable Long id) {
        Planet planet = findPlanet.execute(id);

        return new ResponseEntity<>(planet, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Planet> save (@RequestBody Planet planet){
        Planet savedPlanet = savePlanet.execute(planet);
        return new ResponseEntity<>(savedPlanet, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Planet> update(@PathVariable Long id, @RequestBody Planet planet){
        Planet foundPlanet = findPlanet.execute(id);
        if (foundPlanet == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Planet updatedPlanet = savePlanet.execute(planet);
        return new ResponseEntity<>(updatedPlanet, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Planet> delete(@PathVariable Long id){
        deletePlanet.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
