package com.starwars.repository;

import com.starwars.model.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by jaro on 30/06/17.
 */
@Repository
public interface PeopleRepository extends JpaRepository<People,Long> {
    People findByNameIgnoreCase(String name);
    Page<People> findAll(Pageable pageable);
    List<People> findByHeightGreaterThanEqual(Integer height);
    List<People> findByEyeColorIn(Collection<String> eyeColors);
    List<People> findFirst20ByOrderByMassDesc();
    List<People> findByEyeColorInOrderByNameAsc(Collection<String> eyeColors);

    @Query(value = "select p from People p where p.name like 'S%'", nativeQuery = true)
    List<People> findByNameStartingWith();
}
