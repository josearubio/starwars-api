package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.model.People;
import com.starwars.repository.FilmRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jaro on 7/07/17.
 */
@Service
public class FindFilm {
    private FilmRepository filmRepository;

    public FindFilm(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    //TODO annotation @NOnNull att
    public Film execute(Long filmId) {
        if(filmId == null) throw new NullPointerException("People ID is null");

        return filmRepository.findOne(filmId);
    }
}
