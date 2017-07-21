package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jaro on 7/07/17.
 */
@Service
public class DeletePeople {
    private PeopleRepository peopleRepository;

    public DeletePeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void execute(Long peopleId) {
        if(peopleId == null) throw new NullPointerException("People ID is null");

        peopleRepository.delete(peopleId);
    }
}
