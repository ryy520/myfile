package com.zb.mapper;

import com.zb.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PersonMapper {
    List<Person> findPersonByPage(@Param("start") Integer start,
                                  @Param("size") Integer size,
                                  @Param("name") String name,
                                  @Param("dept") Integer dept);

    int findPersonCount(@Param("name") String name,
                            @Param("dept") Integer dept);

    void addPerson(Person p);

    void updatePerson(Person p);

    void deletePerson(@Param("id") Integer id);

    Person getPersonById(@Param("id") Integer id);
}
