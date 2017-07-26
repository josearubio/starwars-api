package com.starwars.rest;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by jaro on 7/07/17.
 */
@Controller
@RequestMapping(path = "/links")
public class LinkController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResourceSupport> allLinks() {
        Link swapiLink = new Link ("http://swapi.co");
        Link planetsLink = linkTo(PlanetController.class).withRel("planets");
        Link peopleLink = linkTo(PeopleController.class).withRel("people");
        Link filmsLink = linkTo(FilmController.class).withRel("films");

        ResourceSupport result = new ResourceSupport();
        result.add(swapiLink);
        result.add(planetsLink);
        result.add(peopleLink);
        result.add(filmsLink);

        return new ResponseEntity<ResourceSupport>(result, HttpStatus.OK);
    }
}
