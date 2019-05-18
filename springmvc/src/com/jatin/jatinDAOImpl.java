package com.jatin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jatinhibernate.Alien;

@Repository(value = "jatinDAO")
public class jatinDAOImpl extends jatinDAO{

	@Override
	public void add(Alien jatin) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(jatin);
		tx.commit();
		
	}

	@Override
	public void update(Alien jatin, String name, String last) {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		jatin = (Alien) s.get(Alien.class, jatin.getAemp());
		jatin.setAname(name);
		jatin.setAlast(last);
		s.update(jatin);
		tx.commit();		
	}

	@Override
	public List<Alien> getAllData(Alien jatin) {

		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
				
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
				.buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		tx.commit();
		List<Alien> list = new ArrayList<Alien>();
		Query q = s.createQuery("from Alien");
		list = q.list();
		return list;
		
	}

}
