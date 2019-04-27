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
import com.sun.org.apache.xpath.internal.operations.Mod;

@Controller
public class AddController {

	@RequestMapping(value="/add" ,method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("result1") Alien jatin,BindingResult errors)
	{
		if(errors.hasErrors())
		{
			ModelAndView mv1=new ModelAndView("index.jsp");
			mv1.addObject("result2","*EMP_ID SHOULD NOT BE EMPTY*");
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
		mv.addObject("re","DATA IS INSERTED");
		return mv;
		}
		catch(Exception e)
		{
			ModelAndView mv3=new ModelAndView("index.jsp");
			mv3.addObject("result3","*already exist*");
			return mv3;
		}
		}
	
	@RequestMapping(value="/FIND",method=RequestMethod.POST)
	public ModelAndView get(@ModelAttribute("resul") Alien jatin,BindingResult errors)
	{
		if(errors.hasErrors())
		{
			ModelAndView mv1=new ModelAndView("index.jsp");
			mv1.addObject("find1","*EMP_ID SHOULD NOT BE EMPTY*");
			return mv1;
		}
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		tx.commit();
		jatin=(Alien)s.get(Alien.class, jatin.getAemp());
		ModelAndView mv=new ModelAndView("index.jsp");
		mv.addObject("result1",jatin);
		
		
		return mv;
	}
	
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("result1") Alien jatin,BindingResult errors,@RequestParam("aname") String name,@RequestParam("alast") String last)
	{
		if(errors.hasErrors())
		{
			ModelAndView mm2=new ModelAndView("index.jsp");
			mm2.addObject("up","*EMP_ID SHOULD NOT BE EMPTY*");
			return mm2;
		}
		try
		{
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		jatin=(Alien)s.get(Alien.class, jatin.getAemp());
		jatin.setAname(name);
		jatin.setAlast(last);
		s.update(jatin);
		tx.commit();
		}
	
		catch(NullPointerException e)
		{
			ModelAndView mm1=new ModelAndView("index.jsp");
			mm1.addObject("updated1","*INVALID EMP_ID*");
			return mm1;
		}
		ModelAndView mm=new ModelAndView("index.jsp");
		mm.addObject("insert","EMP_ID IS UPDATED");
		return mm;
	}	

	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("jatin") Alien jatin,BindingResult errors)
	{
		
		if(errors.hasErrors())
		{
			ModelAndView mv=new ModelAndView("index.jsp");
			mv.addObject("delete","*EMP_ID SHOULD NOT BE EMPTY*");
			return mv;
		}
		try{
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		jatin=(Alien)s.get(Alien.class, jatin.getAemp());
		s.delete(jatin);
		tx.commit();
		ModelAndView mv1=new ModelAndView("index.jsp");
		mv1.addObject("delete2","*EMPLOYE DATA IS DELETE SUCCESSFULLY*");
		return mv1;
		}
		catch(IllegalArgumentException e)
		{
			ModelAndView mv2=new ModelAndView("index.jsp");
			mv2.addObject("delete1","*INVALID EMP_ID*");
			return mv2 ;
		}
		
	}

	@RequestMapping(value="/getalldata",method=RequestMethod.POST )
	public ModelAndView getall()
	{
		Alien jatin=new Alien();
		ModelAndView mv=new ModelAndView("display.jsp");
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		List<Alien> list=new ArrayList<Alien>();
		Query q=s.createQuery("from Alien");
		list=q.list();
		mv.addObject("result",list);
		
		tx.commit();
		return mv;
		
	}
}
