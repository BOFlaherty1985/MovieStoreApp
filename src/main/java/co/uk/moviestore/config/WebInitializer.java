package co.uk.moviestore.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Web Initialiser Configuration
 *
 * @author Benjamin O'Flaherty
 * @date Created on: 23/01/2015
 * @project MovieStore
 */
public class WebInitializer implements WebApplicationInitializer {

    /**
     *  Dispatcher servlet/ContextLoaderListener configuration for Spring application
     *
     * @param servletContext
     * @throws javax.servlet.ServletException
     */
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.setConfigLocations(new String[]{"co.uk.moviestore"});

        servletContext.addListener(new ContextLoaderListener(ctx));

        ServletRegistration.Dynamic servlet = servletContext.addServlet("MovieStore", new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(0);

    }

}
