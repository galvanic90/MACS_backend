package com.xaraxx.macs.repositories;
import com.xaraxx.macs.models.CategoriesByChampionship;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriesByChampionshipRepository extends CrudRepository<CategoriesByChampionship, Integer> {
    public List<CategoriesByChampionship> findByChampionship_id(Integer championship);
}
