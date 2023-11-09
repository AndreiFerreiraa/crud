
package Utils;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    private static Connection conexao;
    
    public static Connection getConexao(){
        if(conexao == null){
            try{
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/crud","postgres", "docker");
                System.out.println("conexão estabelecida com sucesso!");
            }catch (SQLException e){
                System.out.println("Erro ao estabelecer a conexão com o banco de dados.");
                e.printStackTrace();
            }catch (ClassNotFoundException ex) {
                System.out.println("Erro ao estabelecer a conexão com o banco de dados.");
                ex.printStackTrace();
            }
        }
        return conexao;
    }
}
