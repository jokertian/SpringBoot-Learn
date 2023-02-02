package com.example.jpa.repository;

import com.example.jpa.model.Person;
import com.example.jpa.model.PersonInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author 田朋朋
 * @since 2023/1/28
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByNameAndAge(@Param("name") String name,
                            @Param("age") Integer age);

    @Query(name = "select Person from Person where name = :name and age = :age")
    Person findPersonByNameAndAge(@Param("name") String name,
                                  @Param("age") Integer age);

    @Query(name = "select * from person where name = :name and age = :age", nativeQuery = true)
    Person findPerson1ByNameAndAge(@Param("name") String name,
                                   @Param("age") Integer age);

    @Query("select p from Person p where p.name = ?1 and p.age = ?2")
    Optional<Person> test(String name, Integer age);

    Page<PersonInfo> findByName(String name, Pageable pageable);


}