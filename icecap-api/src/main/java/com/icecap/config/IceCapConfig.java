package com.icecap.config;

import java.util.Map;

//@ApplicationScoped
public class IceCapConfig {
	private final MySqlConfig mySqlConfig;

	public IceCapConfig(Map<String, String> env) {
		this.mySqlConfig = new MySqlConfig(env);
	}

	public MySqlConfig getMySqlConfig() {
		return mySqlConfig;
	}

}
