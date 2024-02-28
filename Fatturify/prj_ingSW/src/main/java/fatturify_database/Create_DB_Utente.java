package fatturify_database;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Create_DB_Utente {

	public static String DB_REL_FILE = "../database/User.db3";
	public static String DB_URL = "jdbc:sqlite:" + DB_REL_FILE;

	public void createUserDB() throws SQLException {
		Connection conn = DriverManager.getConnection(DB_URL);
		DatabaseMetaData meta = conn.getMetaData();
		if (new File(DB_REL_FILE).exists())
			System.out.println("db utente gia esistente");
		else
			System.out.println("db utente creato con successo");
	}

}
