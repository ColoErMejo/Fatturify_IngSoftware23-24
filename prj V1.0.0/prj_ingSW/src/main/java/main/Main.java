package main;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import GUI.jFrame_Cantiere;
import GUI.jFrame_Login;
import controller.Controller_Login;
import database.DB_Login;

public class Main {

		
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DB_Login db = new DB_Login();
		db.createDB();
		db.SelectUtentePassword();
		
		jFrame_Login jframe_login = new jFrame_Login();
        jframe_login.setVisible(true);
		Controller_Login controller_login = new Controller_Login(jframe_login, db);
	}

}
