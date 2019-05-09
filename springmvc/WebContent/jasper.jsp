<%@ page contentType="application/pdf"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.FileInputStream"%>
<%@ page import="java.io.FileNotFoundException"%>
<%@ page import="java.io.InputStream"%>
<%@ page import= "org.hibernate.cfg.Configuration"%>
<%@ page import= "com.jatinhibernate.Alien"%>
<%@ page import= "org.hibernate.service.ServiceRegistry"%>
<%@ page import= "org.hibernate.service.ServiceRegistryBuilder"%>
<%@ page import= "org.hibernate.SessionFactory"%>
<%@ page import= "org.hibernate.Session"%>
<%@ page import= "java.util.*"%>
<%@ page import= "org.hibernate.Query"%>
<%@ page import= "org.hibernate.Transaction"%>

<%@ page import= "net.sf.jasperreports.engine.data.JRBeanCollectionDataSource"%>
<%
   
    try{
    	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg);
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		List<Alien> list = new ArrayList<Alien>();
		Query q = s.createQuery("from Alien");
		list = q.list();
		tx.commit();
		JasperReport jr = JasperCompileManager
				.compileReport("//home//jatin//Documents//06 march springhibernate//SpringHibernate//springmvc//src//jasper.jrxml"); 

		JRBeanCollectionDataSource ds=new JRBeanCollectionDataSource(list);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("itemDataSource", ds);
		JasperPrint jsp = JasperFillManager.fillReport(jr, param,ds);
		//JasperPrint jp = JasperFillManager.fillReport("//home//jatin//Documents//06 march springhibernate//SpringHibernate//springmvc//src//jasper.jasper",param,ds);
        //JasperPrint jp = JasperFillManager.fillReport(jr, param,ds);
		JasperExportManager.exportReportToPdfStream(jsp,response.getOutputStream());
		
		response.getOutputStream().flush();
        response.getOutputStream().close();
        
    }catch(Exception e){
        e.printStackTrace();
    }

%>