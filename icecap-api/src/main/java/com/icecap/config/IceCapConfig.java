package com.icecap.config;

import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.logging.Logger;

//@ApplicationScoped
public class IceCapConfig {
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	private final MySqlConfig mySqlConfig;

	public IceCapConfig(Map<String, String> env) {
		logger.info("surely this isn't the problem?");
		this.mySqlConfig = new MySqlConfig(env);
	}

	public MySqlConfig getMySqlConfig() {
		return mySqlConfig;
	}

}
