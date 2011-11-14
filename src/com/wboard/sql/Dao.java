package com.wboard.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wboard.exception.DAOException;
import com.wboard.xml.XMLParseException;

abstract public class Dao {
	protected Connection con;
	
	public Dao() throws DAOException{
		try {
			con = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			throw new DAOException("Failed to connect to DB. " + e.getMessage());
		}
	}
	public Dao(String xml) throws DAOException{
		try {
			con = ConnectionFactory.getConnection(xml);
		} catch (SQLException e) {
			throw new DAOException("Failed to connect to DB. " + e.getMessage());
		} catch (XMLParseException e) {
			throw new DAOException("Failed to parse DB XML file. " + e.getMessage());
		}
	}
	/**
	 * close current connection to this dao
	 */
	public void close(){
		if(con !=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * HELPER METHOD
	 * close statement and result set
	 * @param stmt
	 * @param rs
	 */
	protected void close(Statement stmt, ResultSet rs) {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if( stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
