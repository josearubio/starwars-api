package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.model.Planet;
import com.starwars.usecase.film.DeleteFilm;
import com.starwars.usecase.film.FindAllFilm;
import com.starwars.usecase.film.FindFilm;
import com.starwars.usecase.film.SaveFilm;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;


/**
 * Created by jaro on 7/07/17.
 */
@RequestMapping(path = "/film")
@Controller
@AllArgsConstructor
public class FilmController {

    private FindAllFilm findAllFilm;
    private SaveFilm saveFilm;
    private FindFilm findFilm;
    private DeleteFilm delete;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Film>> findAll() {
        List<Film> filmList = findAllFilm.execute();

        filmList.forEach((Film film) -> {
            film.getPlanets().forEach((Planet p) -> {
                if(!p.hasLink("self")) {
                    p.add(linkTo(methodOn(PlanetController.class).findById(p.getPlanetId())).withSelfRel());
                }
             });
        });
        return new ResponseEntity<>(filmList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Film> save (@RequestBody Film film){
        Film savedFilm = saveFilm.execute(film);
        return new ResponseEntity<>(savedFilm, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Film> update(@PathVariable Long id, @RequestBody Film film){
        Film foundFilm = findFilm.execute(id);
        if (foundFilm == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Film updatedFilm = saveFilm.execute(film);
        return new ResponseEntity<>(updatedFilm, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Film> delete(@PathVariable Long id){
        delete.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
