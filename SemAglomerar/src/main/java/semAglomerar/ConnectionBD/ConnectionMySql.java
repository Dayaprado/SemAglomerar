package semAglomerar.ConnectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionMySql {
    public static Connection obterConexao() throws SQLException {
        // 1) Declarar o driver JDBC de acordo com o Banco de dados usado
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
        
        String url ="jdbc:mysql://sem-aglomerar-pi3.mysql.database.azure.com:3306/semAglomerar?useSSL=true&requireSSL=false"; 
        
        Connection conn = DriverManager.getConnection(url, "adminadmin@sem-aglomerar-pi3", "12345678A!");
        
        // 2) Abrir a conexão
        /*
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://192.168.64.2:3306/semAglomerar?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC",
                "sysadmin", // Usuário de conexão no BD
                "sysadmin"); // Senha
        */
        return conn ;
    }
}
