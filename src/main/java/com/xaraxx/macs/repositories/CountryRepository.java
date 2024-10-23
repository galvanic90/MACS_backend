package com.xaraxx.macs.repositories;

import com.xaraxx.macs.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
