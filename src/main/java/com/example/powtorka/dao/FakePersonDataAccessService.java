package com.example.powtorka.dao;

import com.example.powtorka.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> findPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personMaybe = findPersonById(id);
        if(!personMaybe.isPresent()){
            return 0;
        }
        DB.remove(personMaybe);
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person personToUpdate) {
        return findPersonById(id)
                .map(person -> {
                    int index = DB.indexOf(person);
                    if(index >= 0){
                        DB.set(index, new Person(id, personToUpdate.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
