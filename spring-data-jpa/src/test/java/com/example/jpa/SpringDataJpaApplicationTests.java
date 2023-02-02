package com.example.jpa;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.example.jpa.model.Person;
import com.example.jpa.model.PersonInfo;
import com.example.jpa.repository.PersonRepository;
import com.fasterxml.uuid.Generators;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringDataJpaApplicationTests {

    @Resource
    private PersonRepository repository;

    @Test
    void save() {
        Person person = new Person();
        person.setName("John");
        person.setAge(18);
        person.setBirthday(LocalDateTime.of(1999, 10, 1, 11, 11, 11));
        person.setWeight(new BigDecimal("100.12"));
        Person save = repository.save(person);
        System.out.println(save);
    }

    @Test
    void find() {
        Person john = repository.findByNameAndAge("John", 18);
        System.out.println(john);

        System.out.println(repository.findById(2L));

        System.out.println(repository.findPersonByNameAndAge("John", 18));

        System.out.println(repository.findPerson1ByNameAndAge("John", 18));

        System.out.println(repository.test("John", 18));
    }

    @Test
    void test() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            UUID uuid = Uuids.timeBased();
            System.out.println(uuid);
            System.out.println(Uuids.unixTimestamp(uuid));
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println(Uuids.unixTimestamp(UUID.fromString("911d8480-96f8-11ed-8535-6b5be1bc52fd")));
    }

    @Test
    void test1() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<PersonInfo> infos = repository.findByName("John", pageRequest);
        for (PersonInfo personInfo : infos) {
            System.out.println(personInfo.getName());
            System.out.println(personInfo.getAge());
        }
    }

    @Test
    void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID());
        }
        System.out.println("+++++++++++++++++++++++++++++");
        for (int i = 0; i < 10; i++) {
            System.out.println(Generators.timeBasedEpochGenerator().generate());
        }
    }

}