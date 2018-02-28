package uk.co.news.methode.listener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import uk.co.news.methode.servlets.BrightcoveAPIServlet;
import uk.co.news.methode.util.AccessTokenTimer;

@WebListener
public class BrightcoveContextListener implements ServletContextListener {
	Logger logger = Logger.getLogger(BrightcoveContextListener.class);
	private ScheduledExecutorService scheduler;

	public BrightcoveContextListener() {
		// TODO Auto-generated constructor stub
	}

	public void contextDestroyed(ServletContextEvent arg) {
		scheduler.shutdownNow();

	}

	public void contextInitialized(ServletContextEvent arg) {
		scheduler = Executors.newSingleThreadScheduledExecutor();
		scheduler.scheduleAtFixedRate(new AccessTokenTimer(arg.getServletContext()), 0, 4, TimeUnit.MINUTES);
	}
}
