import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 Tomcat t = new Tomcat();

	        t.setPort(8082);
	        
	        Context ctx1 = t.addContext("/home", new File(".").getAbsolutePath());
	        Context ctx2 = t.addContext("/log", new File(".").getAbsolutePath());
	        
	        Servletconn servletconn= new Servletconn();
	        ServletForm servletForm = new ServletForm();

	        Tomcat.addServlet(ctx1, "home",servletconn);
	        Tomcat.addServlet(ctx2, "log",  servletForm);
	        
	        ctx1.addServletMapping("/*", "home");
	        ctx2.addServletMapping("/*", "log");

	        try {
				t.start();
			} catch (LifecycleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        t.getServer().await();
		}

	        

	}


