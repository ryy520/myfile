package com.zb.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zb.entity.Person;
import com.zb.mapper.PersonMapper;
import com.zb.service.RpcPersonService;
import com.zb.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class RpcPersonServiceImpl implements RpcPersonService {

    @Autowired(required = false)
    private PersonMapper personMapper;

    @Override
    public Page<Person> findPersonAll(String name, Integer dept, Integer index, Integer size) {
        Page<Person> page = new Page<Person>();
        int count =  personMapper.findPersonCount(name, dept);
        List<Person> list = personMapper.findPersonByPage((index-1)*size,size,name,dept);
        page.setCount(count);
        page.setIndex(index);
        page.setSize(size);
        page.setData(list);
        return page;
    }

    @Override
    public void addPerson(Person p) {
        personMapper.addPerson(p);
    }

    @Override
    @Transactional
    public void updatePerson(Person p) {
        personMapper.updatePerson(p);
    }

    @Override
    public void deletePerson(Integer id) {
        personMapper.deletePerson(id);
    }

    @Override
    public Person getPersonById(Integer id) {
        return personMapper.getPersonById(id);
    }
}
