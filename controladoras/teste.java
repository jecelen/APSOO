package controladoras;

import java.sql.Connection;

import dbVenda.DB;
import interfaceFront.*;


public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Connection conn = DB.getConnection();
		DB.cloeConnection();*/
		
		
		ViewRealizarVenda now = new ViewRealizarVenda(); 
		DB.cloeConnection();
		

	}

}
