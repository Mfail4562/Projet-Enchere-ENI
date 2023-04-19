package fr.eni.mahm.projetencheres.dal;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Thoumire Mathieu
 * @description Classe effectuant la connection via le META-INF/context.xml
 * @date 20-03-2023
 * @version POO - V1.0
 */
public class ConnectBDD {
	public static Connection getConnection() {
		
		Connection cnx=null;
		InitialContext ctx;
		DataSource ds;
		

		try {
			ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/jdbc/pool_cnx");
			cnx=ds.getConnection();
			
			//Context context = new InitialContext();
			//DataSource datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");

			//cnx = datasource.getConnection();

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return cnx;
	}

}
