package com.wboard.common.sql; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.wboard.common.xml.XMLParseException;
import com.wboard.common.xml.XMLParser;

public class ConnectionFactory {

	/**
	 * reads xml file and returns new db connection
	 * @param filepath example: config/db.xml
	 * @return
	 * @throws SQLException
	 * @throws XMLParseException
	 */
	public static Connection getConnection(String filepath) throws SQLException, XMLParseException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new SQLException("Failed to load oracle driver.");
		}
		XMLParser xmlp;
		xmlp = new XMLParser(filepath);
		
		//get attributes from Server tag
		Element root = xmlp.getRootElement();
		
		int port = Integer.parseInt(root.getAttribute("port"));
		String host = root.getAttribute("host");
		String username = "";
		String password = "";
		String sid = "";
		// fetch other variables
		NodeList nList = root.getChildNodes();
		for(int i=0; i<nList.getLength(); i++){
			Node n = nList.item(i);
			if(n.getNodeName().equals("username"))
				username = n.getTextContent();
			else if(n.getNodeName().equals("password"))
				password = n.getTextContent();
			else if(n.getNodeName().equals("sid"))
				sid = n.getTextContent();
		}
		String url = "jdbc:oracle:thin:@" + host + ":" + port + ":" + sid;
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new SQLException("Failed to load oracle driver.");
		}
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		return DriverManager.getConnection(url, "skccc1", "salad");
	}
}
