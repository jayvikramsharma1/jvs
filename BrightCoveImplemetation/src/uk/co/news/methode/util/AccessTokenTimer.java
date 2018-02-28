package uk.co.news.methode.util;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import uk.co.news.methode.listener.BrightcoveContextListener;

public class AccessTokenTimer implements Runnable {
	Logger logger = Logger.getLogger(AccessTokenTimer.class);
	private ServletContext context;

	public AccessTokenTimer(ServletContext servletContext) {
		context = servletContext;
	}

	@Override
	public void run() {
		context.setAttribute("_tokenExpired", true);
		context.setAttribute("credentials", null);
	}
}
