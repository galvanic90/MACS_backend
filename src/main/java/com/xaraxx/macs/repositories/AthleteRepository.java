package com.xaraxx.macs.repositories;

import com.xaraxx.macs.models.Athlete;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AthleteRepository extends CrudRepository<Athlete, Integer> {
    public List<Athlete> findByClub_id(Integer club);
}
