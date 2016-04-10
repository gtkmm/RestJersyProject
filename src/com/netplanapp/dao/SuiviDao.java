package com.netplanapp.dao;

import java.sql.SQLException;

public interface SuiviDao {

	public void saveSuiviDao(String desc) throws SQLException;
	public int authSuiviDao(String name, String pass) throws SQLException;
	
}
