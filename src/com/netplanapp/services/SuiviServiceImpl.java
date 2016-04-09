package com.netplanapp.services;

import java.sql.SQLException;

import com.netplanapp.dao.SuiviDaoImpl;

public class SuiviServiceImpl implements SuiviService {

	@Override
	public void saveSuiviService(String desc) throws SQLException {
		
		SuiviDaoImpl daosuivi = new SuiviDaoImpl();
		daosuivi.saveSuiviDao(desc);
		
	}

}
