package com.icecap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.icecap.config.MySqlConfig;

public class ConnectionToSQL {
	/**
	 * 
	 * @return The return of this method generates a successful connection to the
	 *         database. This is subject to change.
	 * @throws SQLException This gets thrown when there is a problem when the user
	 *                      tries to connect to the database
	 */
	private final MySqlConfig config;

	public ConnectionToSQL(MySqlConfig config) {
		super();
		this.config = config;
	}

	public Connection connect() throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(
					"jdbc:mysql://" + config.getUser() + ":" + config.getPort() + "/" + config.getDbName(),
					config.getHost(), config.getPassword());
		} catch (ClassNotFoundException e) {
			// the driver is shipped with the application
			throw new IllegalStateException(e);
		}
		// This is the source of all of the errors.
	}
}

// TODO: Find a way to connect the liberty project to the MySQL database using the config classes
//TODO: Experiment with the sportsradar API
//TODO: Create a gitaction that automatically verifies the tests before merging a PR/pushing
