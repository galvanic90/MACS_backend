package com.xaraxx.macs.integration;

import com.xaraxx.macs.models.Athlete;
import com.xaraxx.macs.repositories.AthleteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SaveAthleteTest {
    @Autowired
    AthleteRepository athleteRepository;

    @Test
    void saveAthleteMustFailIfDataIncomplete() {
        Athlete athlete = new Athlete();
        athlete.setName("XD");
        Exception exception = assertThrows(RuntimeException.class, () -> {
            athleteRepository.save(athlete);
        });
        assertNotNull(exception.getMessage());
    }

}