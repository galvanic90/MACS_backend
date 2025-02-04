package com.xaraxx.macs.integration;

import com.xaraxx.macs.DTOs.combat.CombatByCategoryDTO;
import com.xaraxx.macs.controllers.CombatsByChampionshipController;
import com.xaraxx.macs.models.Athlete;
import com.xaraxx.macs.repositories.AthleteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CombatsByChampionshipTest {
    @Autowired
    CombatsByChampionshipController combatsByChampionshipController;

    @Test
    void createCombats() {
        CombatByCategoryDTO combatByCategoryDTO = new CombatByCategoryDTO();
        combatByCategoryDTO.setCategory(2);
        combatsByChampionshipController.createCombatsByCategory(combatByCategoryDTO);
    }

}