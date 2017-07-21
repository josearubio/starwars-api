package com.starwars.usecase.film;

import com.starwars.repository.FilmRepository;
import org.springframework.stereotype.Service;

/**
 * Created by jaro on 7/07/17.
 */
@Service
public class DeleteFilm {
    private FilmRepository filmRepository;

    public DeleteFilm(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void execute(Long filmId) {
        if(filmId == null) throw new NullPointerException("Film ID is null");

        filmRepository.delete(filmId);
    }
}
