package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class controller_HelloController {
    @Autowired
    private dao_personmessage pm;
    
    @RequestMapping("/pson")
    @ResponseBody
    public List<entity_person> posn()
    {
     	 
    	return pm.query();
    }
}
