package com.netplanapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DBAccess {
	
    /* Connexion � la base de donn�es */
    private String url = "jdbc:mysql://localhost:3306/netplanapp";
    private String utilisateur = "root";
    private String motDePasse = "";
    private Connection connexion = null;
    private Statement statement = null;
    private ResultSet resultat = null;

    
	public DBAccess() {
	
	    
		/* Chargement du driver JDBC pour MySQL */
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            /* G�rer les �ventuelles erreurs ici. */
        	System.out.println(e);
        }
        
        /* Connexion � la BDD */
        try {
			connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        
        /* Cr�ation de l'objet g�rant les requ�tes */
        try {
			statement = (Statement) connexion.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* Fonction d'insertation dans la BDD */
	public void insertSuivi (String desc) throws SQLException {
        try {
        	//System.out.println("INSERT INTO description (remarques, date_heure) VALUES (\""+desc+"\", NOW());");
    		/* Ex�cution d'une requ�te d'�criture */
            int statut = statement.executeUpdate( "INSERT INTO description (remarques, date_heure) VALUES (\""+desc+"\", NOW());");
            if (statut == 1)
            	System.out.println("Ins�rtion effectu�e avec succ�s");
            else
            	System.out.println("Echec de votre requ�te, donn�es non ins�r�es");
    		
		} finally {
            if ( statement != null ) {
                try {
                    /* Puis on ferme le Statement */
                    statement.close();
                } catch ( SQLException ignore ) {
                }
            }
            if ( connexion != null ) {
                try {
                    /* Et enfin on ferme la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
                }
            }
		}
	}
	
	/* Fonction de v�rification des identifiants dans la BDD */
	public int authSuivi (String name, String pass) throws SQLException {
        try {            
            /* Ex�cution d'une requ�te de lecture */
            resultat = statement.executeQuery( "SELECT COUNT(*) AS NUMBUSERS FROM user WHERE user_name=name AND pass=pass;" );
            /* R�cup�ration des donn�es du r�sultat de la requ�te de lecture */
            int nmbr = 0;
            while ( resultat.next() ) {
            	nmbr = resultat.getInt("NUMBUSERS");
            }
            
            return nmbr;
                        
        } catch ( SQLException e ) {
            /* G�rer les �ventuelles erreurs ici */
        	System.out.println(e);
        } finally {
            if ( resultat != null ) {
                try {
                    /* On commence par fermer le ResultSet */
                    resultat.close();
                } catch ( SQLException ignore ) {
                }
            }
            if ( statement != null ) {
                try {
                    /* Puis on ferme le Statement */
                    statement.close();
                } catch ( SQLException ignore ) {
                }
            }
            if ( connexion != null ) {
                try {
                    /* Et enfin on ferme la connexion */
                    connexion.close();
                } catch ( SQLException ignore ) {
                }
            }
        }
		return 0;		
	}
	
	
}
