package com.netplanapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {
	
    /* Connexion à la base de données */
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
            /* Gérer les éventuelles erreurs ici. */
        	System.out.println(e);
        }
        
        try {
			connexion = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        /* Création de l'objet gérant les requêtes */
        try {
			statement = (Statement) connexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	
	public void insertSuivi (String desc) throws SQLException {
        try {
        	System.out.println("INSERT INTO test_table (toto, Date) VALUES (\""+desc+"\", 2016-04-10);");
    		/* Exécution d'une requête d'écriture */
            int statut = statement.executeUpdate( "INSERT INTO test_table (toto, Date) VALUES (\""+desc+"\", NOW());");
            if (statut == 1)
            	System.out.println("Insértion effectuée avec succès");
            else
            	System.out.println("Echec de votre requête, données non insérées");
    		
		} finally {
//            if ( resultat != null ) {
//                try {
//                    /* On commence par fermer le ResultSet */
//                    resultat.close();
//                } catch ( SQLException ignore ) {
//                }
//            }
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
}
