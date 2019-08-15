package com.example.demo;

 import java.util.List;

import org.apache.ibatis.annotations.Mapper;

 
@Mapper
public interface dao_personmessage {
	public List<entity_person> query();

}
