package com.zb.service;

import com.zb.entity.Person;
import com.zb.util.Page;

public interface RpcPersonService {

    Page<Person> findPersonAll(String name, Integer dept,
                               Integer index, Integer size);

    void addPerson(Person p);

    void updatePerson(Person p);

    void deletePerson(Integer id);

    Person getPersonById(Integer id);
}
