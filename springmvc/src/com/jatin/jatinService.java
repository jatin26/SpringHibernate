package com.jatin;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.jatinhibernate.Alien;

public interface jatinService {

	public void addData(Alien jatin);

	public void updateData(Alien jatin, @RequestParam("aname") String name, @RequestParam("alast") String last);

	public List<Alien> getAllData(Alien jatin);
}
