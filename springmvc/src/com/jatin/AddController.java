package com.jatin;

import org.hibernate.Criteria;
import org.hibernate.Query;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Synchronization;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jatinhibernate.Alien;

@Controller
public class AddController {

	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse reponse)
	{
		int n=Integer.parseInt(request.getParameter("t"));
		String page = request.getParameter("t1");
		
		String page1 = request.getParameter("t2");
		Alien jatin=new Alien();
		jatin.setAemp(n);
		jatin.setAname(page);
		jatin.setAlast(page1);
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		s.save(jatin);
		tx.commit();
		//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("display.jsp");
//		mv.addObject("result", );
		return "index.jsp";
	}
	
	@RequestMapping("/get")
	public ModelAndView get(HttpServletRequest request,HttpServletResponse response)
	{
		int n=Integer.parseInt(request.getParameter("x"));
		Alien jatin=new Alien();
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		//jatin=(Alien)s.createQuery("select * from Alien");
		jatin=(Alien)s.get(Alien.class, n);
		tx.commit();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",jatin);
		return mv;
	}
	
	@RequestMapping("/update")
	public String update(HttpServletRequest request,HttpServletResponse reponse)
	{
		int n=Integer.parseInt(request.getParameter("x"));
		String n1=request.getParameter("x1");
		String n2=request.getParameter("x2");
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
	public String delete(HttpServletRequest request,HttpServletResponse response)
	{
		int n=Integer.parseInt(request.getParameter("x"));
		Alien jatin=new Alien();
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		jatin=(Alien)s.get(Alien.class, n);
		s.delete(jatin);
		tx.commit();
		return "index.jsp";
	}

	@RequestMapping("/getalldata")
	public ModelAndView getall(HttpServletRequest request,HttpServletResponse response)
	{
		Alien jatin=new Alien();
		ModelAndView mv=new ModelAndView();
		Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf=con.buildSessionFactory(reg);
		Session s=sf.openSession();
		Transaction tx=s.beginTransaction();
		Query q=s.createQuery("from Alien");
		//Criteria c=s.createCriteria(Alien.class);
		List list=q.list();
		//jatin=(Alien)s.createQuery("select * from Alien");
		Iterator itr=list.iterator();
//		while(itr.hasNext())
//		{
//			jatin=(Alien)itr.next();
//			mv.addObject("result",jatin.getAemp());
//			mv.addObject("result1",jatin.getAname());
//			mv.addObject("result2",jatin.getAlast());
//			mv.setViewName("display.jsp");
//		}
//		for(int i=0;i<=list.size();i++)
//		{
//			mv.addObject("result",list.get(i));
//			mv.setViewName("display.jsp");
//		}
		while(itr.hasNext())
		{
			jatin=(Alien)itr.next();
			mv.addObject("result",jatin.getAemp());
			mv.addObject("result1",jatin.getAname());
			mv.addObject("result2",jatin.getAlast());
			mv.setViewName("display.jsp");
		}
		tx.commit();
		
		return mv;
		
	}
}
