package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jaro on 7/07/17.
 */
@Service
public class SavePeople {
    private PeopleRepository peopleRepository;

    public SavePeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People execute(People people) {
        if(people == null ) throw new NullPointerException("People is null");

        return peopleRepository.save(people);
    }
}
