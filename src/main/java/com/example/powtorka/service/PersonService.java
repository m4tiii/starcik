package com.example.powtorka.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.powtorka.dao.PersonDao;
import com.example.powtorka.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int insertPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.getAllPeople();
    }

    public Optional<Person> findPersonById(UUID id){
        return personDao.findPersonById(id);
    }

    public int deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePersonById(UUID id, Person person){
        return personDao.updatePersonById(id, person);
    }


}
