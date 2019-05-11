package com.jatin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
//import org.exolab.castor.dsml.Exporter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jatinhibernate.Alien;
import com.jatinhibernate.App;

import com.jatinhibernate.Table_1;
import com.jatinhibernate.Table_2;
import com.jatinhibernate.Table_3;
import com.jatinhibernate.Table_4;
import com.jatinhibernate.Table_5;
import com.jatinhibernate.app;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.view.JasperViewer;

@Controller
public class AddController {

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("result1") Table_5 jatin, BindingResult errors) {
		if (errors.hasErrors()) {
			ModelAndView mv1 = new ModelAndView("index.jsp");
			mv1.addObject("result2", "*EMP_ID SHOULD NOT BE EMPTY*");
			return mv1;
		}
		try {
			Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Table_5.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
					.buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			s.save(jatin);
			tx.commit();
			ModelAndView mv = new ModelAndView("index.jsp");
			mv.addObject("re", "DATA IS INSERTED");
			return mv;
		} catch (ConstraintViolationException e) {
			ModelAndView mv3 = new ModelAndView("index.jsp");
			mv3.addObject("result3", "*already exist*");
			return mv3;
		} catch (HibernateException he) {
			ModelAndView mv3 = new ModelAndView("index.jsp");
			mv3.addObject("delete3", "*INTERNATE_IS_NOT_WORKING*");
			mv3.addObject("delete4", "*KINDLY CHECK YOUR INTERNET CONNECTION*");
			return mv3;

		}

	}

	@RequestMapping(value = "/FIND", method = RequestMethod.POST)
	public ModelAndView get(@ModelAttribute("resul") Alien jatin, BindingResult errors) {
		if (errors.hasErrors()) {
			ModelAndView mv1 = new ModelAndView("index.jsp");
			mv1.addObject("find1", "*EMP_ID SHOULD NOT BE EMPTY*");
			return mv1;
		}
		try {
			Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
					.buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			jatin = (Alien) s.get(Alien.class, jatin.getAemp());

			tx.commit();
			ModelAndView mv = new ModelAndView("index.jsp");
			mv.addObject("result1", jatin);

			return mv;
		} catch (HibernateException he) {
			ModelAndView mv3 = new ModelAndView("index.jsp");
			mv3.addObject("delete3", "*INTERNATE_IS_NOT_WORKING*");
			mv3.addObject("delete4", "*KINDLY CHECK YOUR INTERNET CONNECTION*");
			return mv3;
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("result1") Alien jatin, BindingResult errors,
			@RequestParam("aname") String name, @RequestParam("alast") String last) {
		if (errors.hasErrors()) {
			ModelAndView mm2 = new ModelAndView("index.jsp");
			mm2.addObject("up", "*EMP_ID SHOULD NOT BE EMPTY*");
			return mm2;
		}
		try {
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

		catch (NullPointerException e) {
			ModelAndView mm1 = new ModelAndView("index.jsp");
			mm1.addObject("updated1", "*INVALID EMP_ID*");
			return mm1;
		} catch (HibernateException he) {
			ModelAndView mv3 = new ModelAndView("index.jsp");
			mv3.addObject("delete3", "*INTERNATE_IS_NOT_WORKING*");
			mv3.addObject("delete4", "*KINDLY CHECK YOUR INTERNET CONNECTION*");
			return mv3;
		}

		ModelAndView mm = new ModelAndView("index.jsp");
		mm.addObject("insert", "EMP_ID IS UPDATED");
		return mm;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("jatin") App jatin, BindingResult errors) {
		if (errors.hasErrors()) {
			ModelAndView mv = new ModelAndView("index.jsp");
			mv.addObject("delete", "*EMP_ID SHOULD NOT BE EMPTY*");
			return mv;
		}
		try {
			Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(App.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
					.buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			jatin = (App) s.get(App.class, jatin.getAemp());
			s.delete(jatin);
			tx.commit();
			ModelAndView mv1 = new ModelAndView("index.jsp");
			mv1.addObject("delete2", "*EMPLOYE DATA IS DELETE SUCCESSFULLY*");
			return mv1;
		} catch (IllegalArgumentException e) {
			ModelAndView mv2 = new ModelAndView("index.jsp");
			mv2.addObject("delete1", "*INVALID EMP_ID*");
			return mv2;
		} catch (HibernateException he) {
			ModelAndView mv3 = new ModelAndView("index.jsp");
			mv3.addObject("delete3", "*INTERNATE_IS_NOT_WORKING*");
			mv3.addObject("delete4", "*KINDLY CHECK YOUR INTERNET CONNECTION*");
			return mv3;
		}

	}

	@RequestMapping(value = "/getalldata", method = RequestMethod.POST)
	public ModelAndView getall() {
		try {
			Alien jatin = new Alien();
			App a = new App();
			ModelAndView mv = new ModelAndView("display.jsp");
			Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class)
					.addAnnotatedClass(App.class);
			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties())
					.buildServiceRegistry();
			SessionFactory sf = con.buildSessionFactory(reg);
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			List<App> list2 = new ArrayList<App>();
			Query q1 = s.createQuery("from App");
			list2 = q1.list();
			List<Alien> list = new ArrayList<Alien>();
			Query q = s.createQuery("from Alien");
			list = q.list();
			mv.addObject("result", list);
			mv.addObject("query", list2);
			tx.commit();
			return mv;
		} catch (HibernateException he) {
			ModelAndView mv3 = new ModelAndView("index.jsp");
			mv3.addObject("delete3", "*INTERNATE_IS_NOT_WORKING*");
			mv3.addObject("delete4", "*KINDLY CHECK YOUR INTERNET CONNECTION*");
			return mv3;
		}

	}

	/*
	 * @RequestMapping(value = "/getalldataPDF", method = RequestMethod.POST)
	 * public ModelAndView main() throws JRException, IOException {
	 * Configuration con = new
	 * Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.
	 * class); ServiceRegistry reg = new
	 * ServiceRegistryBuilder().applySettings(con.getProperties()).
	 * buildServiceRegistry(); SessionFactory sf = con.buildSessionFactory(reg);
	 * Session s = sf.openSession(); Transaction tx = s.beginTransaction();
	 * List<Alien> list = new ArrayList<Alien>(); Query q =
	 * s.createQuery("from Alien"); list = q.list(); tx.commit(); JasperReport
	 * jsr = JasperCompileManager.compileReport(
	 * "//home//jatin//Documents//06 march springhibernate//SpringHibernate//springmvc//src//jasper.jrxml"
	 * ); Map<String, Object> param = new HashMap<String, Object>();
	 * JRBeanCollectionDataSource ds; JasperPrint jsp =
	 * JasperFillManager.fillReport(jsr, param, new
	 * JRBeanCollectionDataSource(list));
	 * JasperExportManager.exportReportToPdfFile(jsp,
	 * "//home//jatin//Documents//06 march springhibernate//SpringHibernate//springmvc//src//jatin.pdf"
	 * ); ModelAndView mv = new ModelAndView("index.jsp");
	 * mv.addObject("jasper", "PDF IS DOWNLOAD KINDLY CHECK YOUR DIRECTORY");
	 * return mv; }
	 */
	@RequestMapping(value = "/getalldataPDF", method = RequestMethod.POST)
	public ModelAndView main() throws JRException {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class)
				.addAnnotatedClass(app.class).addAnnotatedClass(App.class).addAnnotatedClass(Table_1.class)
				.addAnnotatedClass(Table_3.class).addAnnotatedClass(Table_2.class).addAnnotatedClass(Table_4.class).addAnnotatedClass(Table_5.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		List<Alien> list = new ArrayList<Alien>();
		Query q = s.createQuery("from Alien");
		list = q.list();
		List<app> list2 = new ArrayList<app>();
		Query q1 = s.createQuery("from app");
		list2 = q1.list();
		List<App> list3 = new ArrayList<App>();
		Query q2 = s.createQuery("from App");
		list3 = q2.list();
		List<Table_1> list4 = new ArrayList<Table_1>();
		Query q3 = s.createQuery("from Table_1");
		list4 = q3.list();
		List<Table_2> list5 = new ArrayList<Table_2>();
		Query q4 = s.createQuery("from Table_2");
		list5 = q4.list();
		List<Table_3> list6 = new ArrayList<Table_3>();
		Query q5 = s.createQuery("from Table_3");
		list6 = q5.list();
		List<Table_4> list7 = new ArrayList<Table_4>();
		Query q6 = s.createQuery("from Table_4");
		list7 = q6.list();
		List<Table_5> list8 = new ArrayList<Table_5>();
		Query q7 = s.createQuery("from Table_5");
		list8 = q7.list();
		tx.commit();
		
		JasperReport jsr = JasperCompileManager.compileReport(
				"//home//jatin//Documents//06 march springhibernate//SpringHibernate//springmvc//src//jasper.jrxml");
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(list);
		JRBeanCollectionDataSource ds2 = new JRBeanCollectionDataSource(list2);
		JRBeanCollectionDataSource ds3 = new JRBeanCollectionDataSource(list3);
		JRBeanCollectionDataSource ds4 = new JRBeanCollectionDataSource(list4);
		JRBeanCollectionDataSource ds5 = new JRBeanCollectionDataSource(list5);
		JRBeanCollectionDataSource ds6 = new JRBeanCollectionDataSource(list6);
		JRBeanCollectionDataSource ds7 = new JRBeanCollectionDataSource(list7);
		JRBeanCollectionDataSource ds8 = new JRBeanCollectionDataSource(list8);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("itemDataSource", ds);
		param.put("itemDataSource2", ds2);
		param.put("itemDataSource3", ds3);
		param.put("itemDataSource4", ds4);
		param.put("itemDataSource5", ds5);
		param.put("itemDataSource6", ds6);
		param.put("itemDataSource7", ds7);
		param.put("itemDataSource8", ds8);
		JasperPrint jsp = JasperFillManager.fillReport(jsr, param, ds8);

		JasperExportManager.exportReportToPdfFile(jsp,
				"//home//jatin//Documents//06 march springhibernate//SpringHibernate//springmvc//src//jatin.pdf");
		  JasperViewer jasperViewer = new JasperViewer(jsp);
          jasperViewer.viewReport(jsp,false);
		/*
		  JRXlsxExporter xlsx=new JRXlsxExporter();
		  xlsx.setParameter(JRXlsExporterParameter.JASPER_PRINT, jsp);
		  xlsx.setParameter(JRXlsExporterParameter.
		  OUTPUT_FILE_NAME,"//home//jatin//Documents//06 march springhibernate//SpringHibernate//springmvc//src//jatin.xlsx"
		  ); xlsx.exportReport();
		*/ 
		ModelAndView mv = new ModelAndView("index.jsp");
		mv.addObject("jasper", "PDF IS DOWNLOAD KINDLY CHECK YOUR DIRECTORY");
		return mv;
	}

	/*
	 * @RequestMapping(value = "/getalldataPDF", method = RequestMethod.POST)
	 * public ModelAndView main() throws java.io.IOException{
	 * 
	 * try { Alien a=new Alien(); a.setAemp(101); a.setAname("jatin");
	 * a.setAlast("mehta"); Alien a2=new Alien(); a2.setAemp(102);
	 * a2.setAname("richa"); a2.setAlast("dutta"); List<Alien> listItems=new
	 * ArrayList<Alien>(); listItems.add(a); listItems.add(a2);
	 * JRBeanCollectionDataSource itemsJRBean=new
	 * JRBeanCollectionDataSource(listItems); Map<String,Object> param=new
	 * HashMap<String,Object>(); param.put("itemDataSource", itemsJRBean);
	 * JasperPrint jasperPrint=JasperFillManager.
	 * fillReport("//home//jatin//Documents//06 march springhibernate//SpringHibernate//springmvc//src//com//jasper//jaspertablejrxml.jasper"
	 * , param,itemsJRBean);
	 * JasperExportManager.exportReportToPdfFile(jasperPrint,
	 * "//home//jatin//Documents//06 march springhibernate//SpringHibernate//springmvc//src//jatin.pdf"
	 * );
	 * 
	 * 
	 * }
	 * 
	 * catch(JRException ex) { ex.printStackTrace(); } ModelAndView mv = new
	 * ModelAndView("index.jsp"); mv.addObject("jasper",
	 * "PDF IS DOWNLOAD KINDLY CHECK YOUR DIRECTORY"); return mv; }
	 */
}
