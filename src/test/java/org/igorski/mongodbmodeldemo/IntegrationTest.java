package org.igorski.mongodbmodeldemo;

import org.igorski.mongodbmodeldemo.model.Entry;
import org.igorski.mongodbmodeldemo.model.Participant;
import org.igorski.mongodbmodeldemo.model.Race;
import org.igorski.mongodbmodeldemo.model.Result;
import org.igorski.mongodbmodeldemo.repositories.RaceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    private List<Participant> participants = new ArrayList<>();

    @Autowired
    RaceRepository raceRepository;

    @Test
    public void shouldCreateEntriesInDatabase() {
        createParticipants();

        LocalDateTime start = LocalDateTime.now();

        Race race = createRace(start);

        Random random = new Random();

        for(Entry entry : race.getEntries()) {
            int length = random.nextInt(30);
            entry.getResult().setEndTime(LocalDateTime.now().plusSeconds(length));
        }

        raceRepository.save(race);
    }

    private Race createRace(LocalDateTime start) {
        List<Entry> entries = new ArrayList<>();
        for(Participant participant : participants) {
            Entry entry = new Entry();
            entry.setParticipant(participant);

            Result result = new Result();
            result.setStartTime(start);
            entry.setResult(result);

            entries.add(entry);
        }
        Race race = new Race();
        race.setEntries(entries);
        return race;
    }

    private void createParticipants() {
        Participant one = new Participant();
        one.setName("Billy");
        one.setSurname("Batson");
        one.setCountry("USA");

        Participant two = new Participant();
        two.setName("Beatriz");
        two.setSurname("DaCosta");
        two.setCountry("Brazil");

        Participant three = new Participant();
        three.setName("Helena");
        three.setSurname("Kosmatos");
        three.setCountry("Greece");

        participants.add(one);
        participants.add(two);
        participants.add(three);
    }


}
