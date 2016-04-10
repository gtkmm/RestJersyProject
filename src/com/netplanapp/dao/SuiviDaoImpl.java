package com.netplanapp.dao;

import java.sql.SQLException;

import com.netplanapp.utils.DBAccess;

public class SuiviDaoImpl implements SuiviDao {

	@Override
	public void saveSuiviDao(String desc) throws SQLException {
		DBAccess db = new DBAccess();
		db.insertSuivi(desc);	
	}
	
	@Override
	public int authSuiviDao(String name, String pass) throws SQLException {
		DBAccess db = new DBAccess();
		db.authSuivi(name, pass);	
		return 1;
	}
	

}
