package fr.pizzeria.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class webAppInitializer implements WebApplicationInitializer {





	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
	AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
	
	webContext.register(PizzeriaSpringConfig.class);
		
	ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
	dispatcher.setLoadOnStartup(1);
	
	dispatcher.addMapping("/api/*");
	
	servletContext.addListener(new ContextLoaderListener(webContext));
	
	
	
	}

}
