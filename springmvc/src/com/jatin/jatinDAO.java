package com.jatin;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.jatinhibernate.Alien;

public abstract class jatinDAO {

	public abstract void add(Alien jatin);
	public abstract void update(Alien jatin ,@RequestParam("aname") String name, @RequestParam("alast") String last);
	public abstract List<Alien> getAllData(Alien jatin);
}
