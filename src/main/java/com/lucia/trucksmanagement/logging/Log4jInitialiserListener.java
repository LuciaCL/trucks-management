package com.lucia.trucksmanagement.logging;




import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The log4j initialiser prepares the system for the use of log4j 2.0.  Specifically this involves
 * setting a system property to force Hibernate to use the appropriate logging mechanism which will
 * be piped through to log4j.
 * 
 *
 */
public class Log4jInitialiserListener implements ServletContextListener {

	protected static final Logger LOG = LoggerFactory.getLogger(Log4jInitialiserListener.class);

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		LOG.info("Configuring jboss logging (used by Hibernate) to use sl4j which is bridged to log4j 2.0");
		System.setProperty("org.jboss.logging.provider", "slf4j");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// Nothing to do.
	}

}
