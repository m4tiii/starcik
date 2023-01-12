package com.example.powtorka.api;

import com.example.powtorka.model.Person;
import com.example.powtorka.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.validation.Valid;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public int insertPerson(@Valid @NonNull @RequestBody  Person person){
        return personService.insertPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person findPersonById(@PathVariable("id") UUID id){
        return personService.findPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePersonById(id);
    }

    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person){
        return personService.updatePersonById(id, person);
    }
}
