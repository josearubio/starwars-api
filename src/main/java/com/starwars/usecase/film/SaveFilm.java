package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.model.People;
import com.starwars.model.Planet;
import com.starwars.repository.FilmRepository;
import com.starwars.repository.PeopleRepository;
import com.starwars.repository.PlanetRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by jaro on 7/07/17.
 */
@Service
public class SaveFilm {
    private FilmRepository filmRepository;
    private PlanetRepository planetRepository;
    private PeopleRepository peopleRepository;

    public SaveFilm(FilmRepository filmRepository, PlanetRepository planetRepository, PeopleRepository peopleRepository) {
        this.filmRepository = filmRepository;
        this.planetRepository = planetRepository;
        this.peopleRepository = peopleRepository;
    }

    public Film execute(@NonNull Film film) {
        createPlanetsWhenNotExist(film);
        createPeopleWhenNotExist(film);

        return filmRepository.save(film);
    }

    private void createPlanetsWhenNotExist(Film film){
        film.getPlanets().forEach((Planet planet) -> {
            if(!planetRepository.exists(planet.getPlanetId())) {
                planetRepository.save(planet);
            }
        });
    }

    private void createPeopleWhenNotExist(Film film){
        film.getPeople().forEach((People people) -> {
            if(!peopleRepository.exists(people.getPeopleId())){
                peopleRepository.save(people);
            }
        });
    }
}
