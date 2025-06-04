package com.icecap.config;

import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.logging.Logger;

public class MySqlConfig {
	private final String dbName;
	private final String host;
	private final int port;
	private final String user;
	private final String password;
	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

	public MySqlConfig(Map<String, String> env) {
		dbName = env.get("mysql_dbname");
		host = env.get("mysql_host");
		port = Integer.parseInt(env.get("mysql_port"));
		user = env.get("mysql_user");
		password = env.get("mysql_password");

	}

	public String getDbName() {
		return dbName;
	}

	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "MySqlConfig [dbName=" + dbName + ", host=" + host + ", port=" + port + ", user=" + user + ", password="
				+ password + "]";
	}

}
