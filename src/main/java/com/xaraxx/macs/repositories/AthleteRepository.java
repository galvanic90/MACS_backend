package com.xaraxx.macs.repositories;

import com.xaraxx.macs.models.Athlete;
import org.springframework.data.repository.CrudRepository;

public interface AthleteRepository extends CrudRepository<Athlete, Integer> {
}
