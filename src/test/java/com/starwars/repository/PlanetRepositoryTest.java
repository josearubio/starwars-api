package com.starwars.repository;

import com.starwars.model.Planet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by jaro on 30/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository planetRepository;

    @Test
    public void shouldFindByName() throws Exception {
        Planet planet = planetRepository.findByName("Alderaan");
        Assert.assertThat(planet.getName(),is("Alderaan"));
    }

    @Test
    public void findAllPageable() throws Exception {
        PageRequest page = new PageRequest(0,2);
        Page<Planet> all = planetRepository.findAll(page);

        Sort sort = new Sort(Sort.Direction.ASC, "climate")
                .and(new Sort(Sort.Direction.DESC, "gravity"));

        List<Planet> planetList = planetRepository.findAll(sort);

    }
}
