package com.xaraxx.macs.repositories;

import com.xaraxx.macs.models.RegistrationsByChampionship;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegistrationsByChampionshipRepository extends CrudRepository<RegistrationsByChampionship, Integer> {
    List<RegistrationsByChampionship> findByCategoriesByChampionship_id(Integer category);
}
