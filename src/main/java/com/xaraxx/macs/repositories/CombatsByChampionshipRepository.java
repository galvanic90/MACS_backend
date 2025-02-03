package com.xaraxx.macs.repositories;

import com.xaraxx.macs.models.CombatsByChampionship;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CombatsByChampionshipRepository extends CrudRepository<CombatsByChampionship, Integer> {
    List<CombatsByChampionship> findByCategoriesByChampionship_idAndRoundOrderByIdAsc(Integer id, Integer round);
    @Query("SELECT MAX(c.round) FROM CombatsByChampionship c where c.categoriesByChampionship.id = ?1")
    Optional<Integer> numberOfRounds(Integer category);
}
