package com.jatin;

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

}
