package com.zb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zb.entity.Dept;
import com.zb.entity.Person;
import com.zb.service.RpcPersonService;
import com.zb.util.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {
    @Reference
    private RpcPersonService rpcPersonService;

    @RequestMapping(value = "/showPerson")
    @ResponseBody
    public Page<Person> getPersonList(@RequestParam(value = "index",defaultValue = "1") Integer index, String name, Integer dept){
        Page<Person> page= rpcPersonService.findPersonAll(name,dept,index,2);
        return page;
    }

    @RequestMapping(value = "/addPerson")
    @ResponseBody
    public String addPerson(Person p,Integer deptId){
        Dept d=new Dept();
        d.setId(deptId);
        p.setDept(d);
        rpcPersonService.addPerson(p);
        return "ok";
    }

    @RequestMapping(value = "/updatePerson")
    @ResponseBody
    public String updatePerson(Person p,Integer deptId){
        Dept d=new Dept();
        d.setId(deptId);
        p.setDept(d);
        rpcPersonService.updatePerson(p);
        return "ok";
    }

    @RequestMapping(value = "/deletePerson")
    @ResponseBody
    public String deletePerson(Integer id){
        rpcPersonService.deletePerson(id);
        return "ok";
    }

    @RequestMapping(value = "/getPersonInfo")
    @ResponseBody
    public Person getPersonInfo(Integer id){
        return rpcPersonService.getPersonById(id);
    }

}
