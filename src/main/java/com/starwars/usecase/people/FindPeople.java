package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

/**
 * Created by jaro on 7/07/17.
 */
@Service
public class FindPeople {
    private PeopleRepository peopleRepository;

    public FindPeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People execute(Long peopleId) {
        if(peopleId == null) throw new NullPointerException("People ID is null");

        return peopleRepository.findOne(peopleId);
    }
}
