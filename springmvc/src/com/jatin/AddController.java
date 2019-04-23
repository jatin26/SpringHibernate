package com.jatin;

import java.util.ArrayList;
import java.util.List;
import java.lang.NumberFormatException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jatinhibernate.Alien;

@Controller
public class AddController {

	@RequestMapping(value="/add" ,method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("result1") Alien jatin,BindingResult errors)
	{
		if(errors.hasErrors())
		{
			ModelAndView mv1=new ModelAndView("index.jsp");
			mv1.addObject("result2","*EMP_ID can't be empty*");
			return mv1;
		}
		try{
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(jatin);
		tx.commit();
		ModelAndView mv=new ModelAndView("index.jsp");
		mv.addObject("result","DATA IS INSERTED");
		
		return mv;
		}
		catch(Exception e)
		{
			ModelAndView mv3=new ModelAndView("index.jsp");
			mv3.addObject("result3","*already exist*");
			return mv3;
		}
		}
	
	@RequestMapping("/get")
	public ModelAndView get(@RequestParam("x") int n)
	{
		
		Alien jatin=new Alien();
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		tx.commit();
		jatin=(Alien)s.get(Alien.class, n);
		ModelAndView mv=new ModelAndView();
		mv.addObject("result1",jatin);
		mv.setViewName("displatyall.jsp");
		return mv;
		}
	
	@RequestMapping("/update")
	public String update(@RequestParam("x") int n,@RequestParam("x1") String n1,@RequestParam("x2") String n2)
	{
		Alien jatin=new Alien();
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		jatin=(Alien)s.get(Alien.class, n);
		jatin.setAname(n1);
		jatin.setAlast(n2);
		s.update(jatin);
		tx.commit();
		return "index.jsp";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("x") int n)
	{
		Alien jatin=new Alien();
		try{
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		jatin=(Alien)s.get(Alien.class, n);
		s.delete(jatin);
		tx.commit();
		}
		catch(IllegalArgumentException e)
		{
			return "displatyall.jsp";
		}
	
		
		return "index.jsp";
	}

	@RequestMapping("/getalldata")
	public ModelAndView getall()
	{
		Alien jatin=new Alien();
		ModelAndView mv=new ModelAndView();
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		List<Alien> list=new ArrayList<Alien>();
		Query q=s.createQuery("from Alien");
		list=q.list();
		mv.addObject("result",list);
		mv.setViewName("display.jsp");
		tx.commit();
		return mv;
		
	}
}
