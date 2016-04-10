package com.netplanapp.services;

import java.sql.SQLException;

public interface SuiviService {
	public void saveSuiviService(String desc) throws SQLException ;
	public int authSuiviService(String nom, String pass) throws SQLException ;	
}