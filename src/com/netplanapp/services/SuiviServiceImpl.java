package com.netplanapp.services;

import java.sql.SQLException;

import com.netplanapp.dao.SuiviDaoImpl;

public class SuiviServiceImpl implements SuiviService {

	@Override
	public void saveSuiviService(String desc) throws SQLException {
		SuiviDaoImpl daosuivi = new SuiviDaoImpl();
		daosuivi.saveSuiviDao(desc);
	}

	@Override
	public int authSuiviService(String nom, String pass) throws SQLException {
		SuiviDaoImpl daoauth = new SuiviDaoImpl();
		daoauth.authSuiviDao(nom, pass);
		return 1;
	}
}
