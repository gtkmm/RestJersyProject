package com.netplanapp.controllers;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.netplanapp.services.SuiviServiceImpl;

@Path("/SuiviController")
public class SuiviController {

		
		@GET
		@Path("/saveSuivi/{desc: .*}")
		public void saveSuiviConroller(@PathParam("desc") String desc) throws SQLException{
			
			SuiviServiceImpl suivisave = new SuiviServiceImpl();
			suivisave.saveSuiviService(desc);
		}
		
		@GET
		@Path("/authent/{desc: .*}")
		public int authentConroller(@PathParam("nom") String nom, @PathParam("pass") String pass) throws SQLException{
			
			SuiviServiceImpl suiviauth = new SuiviServiceImpl();
			suiviauth.authSuiviService(nom, pass);
			return 1;
		}

}
