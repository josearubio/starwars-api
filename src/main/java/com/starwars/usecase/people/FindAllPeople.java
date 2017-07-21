package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jaro on 7/07/17.
 */
@Service

public class FindAllPeople {
    private PeopleRepository peopleRepository;

    public FindAllPeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> execute() {
        return peopleRepository.findAll();
    }
}
