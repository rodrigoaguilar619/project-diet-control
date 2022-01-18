package project.diet.control.config.starter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.request.RequestContextListener;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	/*@Override public void onStartup( ServletContext servletContext ) throws ServletException {
        super.onStartup( servletContext );
        servletContext.addListener( new RequestContextListener() );
    }*/

}
