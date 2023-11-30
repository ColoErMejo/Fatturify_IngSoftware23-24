package main;

import GUI.jFrame_Cantiere;
import GUI.jFrame_Login;
import controller.Controller_Login;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jFrame_Login jframe_login = new jFrame_Login();
        jframe_login.setVisible(true);
		Controller_Login controller_login = new Controller_Login(jframe_login);
	}

}
