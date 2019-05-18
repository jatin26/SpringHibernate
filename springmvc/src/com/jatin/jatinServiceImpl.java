package com.jatin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatinhibernate.Alien;

@Service(value = "jatinService")
public class jatinServiceImpl  implements jatinService {

	@Autowired
	private jatinDAO jatindao;
	
	@Override
	public void addData(Alien jatin) {
		
		 jatindao.add(jatin);
	}

	@Override
	public void updateData(Alien jatin, String name, String last) {
		jatindao.update(jatin, name, last);
		
	}

	@Override
	public List<Alien> getAllData(Alien jatin) {
		
		return this.jatindao.getAllData(jatin);
	}

	

}
