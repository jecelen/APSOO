package dbVenda;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
     
	private static Connection conexao = null; //Cria-se um objeto do tipo connection
	
	public static Connection getConnection() {
		
		if(conexao == null) {
			try{
				
				Properties props = loadpropriedades(); //Recebe o props de loadpropriedades()
				String url = props.getProperty("dburl"); //É pego o conteúdo do campo dburl e salvo em String url
				conexao = DriverManager.getConnection(url, props); //Usando o DriverManager é feita a ligação com o BD que fica armazenada na "conexao"
				
			} catch (SQLException e ) {
				throw new DbException(e.getMessage());
			}
			
		}
		return conexao;
	}
	
	
	public static void cloeConnection() {
		if ( conexao != null) {
			
			try {
				conexao.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			
		}
	}
	
	
	
	
	private static Properties loadpropriedades() { //Retorna as Propriedades do arquivo db.propriedades
		
		try(FileInputStream fs = new FileInputStream("db.propriedades")){ //Aponta para o conteúdo do arquivo passado para o FileInputStream
			Properties props = new Properties(); //Cria-se um objeto do tipo Properties
			props.load(fs); //Passamos para o objeto props o "ponteiro" para o arquivo de propriedades, realiza e leitura e gurada no objeto o conteúdo
			//System.out.println(props);
			return props; //Retorna para quem o invocou 
		
		}
		catch (IOException e) {
			
			throw new DbException(e.getMessage());//Lançamos para exception personalizada o erro (caso o arquivo não consiga ser aberto)
			
		}
		
	}
}
