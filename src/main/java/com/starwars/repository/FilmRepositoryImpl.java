package com.starwars.repository;

import com.starwars.model.Film;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaro on 30/06/17.
 */
@Slf4j
public class FilmRepositoryImpl implements CustomFilmRepository {
    @Override
    public void logFilm(Film film){
        log.info(film.toString());
    }
}
