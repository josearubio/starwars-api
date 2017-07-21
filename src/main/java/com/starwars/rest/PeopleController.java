package com.starwars.rest;

import com.starwars.model.People;
import com.starwars.usecase.people.DeletePeople;
import com.starwars.usecase.people.FindAllPeople;
import com.starwars.usecase.people.FindPeople;
import com.starwars.usecase.people. SavePeople;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jaro on 7/07/17.
 */
@RequestMapping(path = "/people")
@Controller
@AllArgsConstructor
public class PeopleController {

    private FindAllPeople findAllPeople;
    private SavePeople savePeople;
    private FindPeople findPeople;
    private DeletePeople delete;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<People>> findAll() {
        List<People> people = findAllPeople.execute();

        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<People> save (@RequestBody People people){
        People savedPeople = savePeople.execute(people);
        return new ResponseEntity<>(savedPeople, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<People> update(@PathVariable Long id, @RequestBody People people){
        People foundPeople = findPeople.execute(id);
        if (foundPeople == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        People updatedPeople = savePeople.execute(people);
        return new ResponseEntity<>(updatedPeople, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<People> delete(@PathVariable Long id){
        delete.execute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
