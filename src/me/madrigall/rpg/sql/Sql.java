package me.madrigall.rpg.sql;

import me.madrigall.rpg.Main;

public class Sql {
	private String serverHost;
	private String serverPort;
	private String dataBase;
	private String username;
	private String password;
	
	public void init()
	{
		loadConf();
		saveConf();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			
			return;
		}
	}
	
	public void loadConf()
	{
		serverHost = Main.instance.getConfig().getString("MySQL.host","localhost");
		serverPort = Main.instance.getConfig().getString("MySQL.port","3306");
		dataBase = Main.instance.getConfig().getString("MySQL.database","ReActions");
		username = Main.instance.getConfig().getString("MySQL.username","root");
		password = Main.instance.getConfig().getString("MySQL.password","password");
	}

	public void saveConf()
	{
		Main.instance.getConfig().set("MySQL.server",serverHost );
		Main.instance.getConfig().set("MySQL.port",serverPort );
		Main.instance.getConfig().set("MySQL.database",dataBase);
		Main.instance.getConfig().set("MySQL.username",username);
		Main.instance.getConfig().set("MySQL.password",password);
		Main.instance.saveConfig();
	}

}
