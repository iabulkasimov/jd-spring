package com.cybertek.bootstrap;

import com.cybertek.entity.Address;
import com.cybertek.entity.Person;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {

        Person p1 = new Person("Mike","Smith");
        Person p2 = new Person("Ozzy","Kmith");
        Person p3 = new Person("Tedd","Bith");

        Address address1 = new Address("King st","20111");
        Address address2 = new Address("Qween st","20140");
        Address address3 = new Address("Main st","25511");


//        p1.setAddress(Arrays.asList(address1,address2)); //Case-1
        personRepository.save(p1);

        address1.setPerson(p1);
        address2.setPerson(p1);
        address3.setPerson(p1);

        addressRepository.saveAll(Arrays.asList(address1,address2,address3));

    }
}
