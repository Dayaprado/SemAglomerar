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
        
        // 2) Abrir a conexão
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/sem_aglomerar?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC",
                "root", // Usuário de conexão no BD
                "zero1827!TSU"); // Senha
        return conn ;
    }
}
