package semAglomerar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import semAglomerar.ConnectionBD.ConnectionMySql;
import semAglomerar.Model.Login;


public class LoginDAO {    
    
    Login login;
    
    public List<Login> findAll() throws SQLException {
        String sql = "SELECT * FROM Login";
        List<Login> resul = new ArrayList<>();

        try (Connection conn = ConnectionMySql.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                login.setId(rs.getInt("login_id"));
                login.setUsuario(rs.getString("login_usuario"));
                login.setSenha(rs.getString("login_senha"));
                resul.add(login);
            }
        }
        return resul;
    }
    
    public Login findByUser(String user) throws SQLException {
        String sql = "SELECT * FROM Login WHERE login_usuario=?";
        try (Connection conn = ConnectionMySql.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    login.setId(rs.getInt("login_id"));
                    login.setUsuario(rs.getString("login_usuario"));
                    login.setSenha(rs.getString("login_senha"));
                    return login;
                }
            }catch (Exception e) {
            System.out.print("Erro ao pesquisar usuário: " + user);
            }
        }
        return null;
    }
    
    public void inserirLogin(Login login) throws SQLException {
        String sql = "INSERT INTO Login (login_usuario, login_senha) VALUES (?,?)";

        try (Connection conn = ConnectionMySql.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);

            // ADICIONAR O Statement.RETURN_GENERATED_KEYS PARA RECUPERAR O ID GERADO NO BD
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, login.getUsuario());
                stmt.setString(2, login.getSenha());
                int resul = stmt.executeUpdate();

                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    // RECUPERA O ID GERADO PARA O INFO NOVO
                    while (rs.next()) {
                        Integer idGerado = rs.getInt(1);
                        login.setId(idGerado);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }
    
    public void atualizarLogin(Login login) throws SQLException {
        String sql = "UPDATE Login set login_usuario=?, login_senha=? WHERE login_id=?";
        try (Connection conn = ConnectionMySql.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);
            // ADICIONAR O Statement.RETURN_GENERATED_KEYS PARA RECUPERAR O ID GERADO NO BD
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, login.getUsuario());
                stmt.setString(2, login.getSenha());
                stmt.setString(3, String.valueOf(login.getId()));
                int resul = stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    // RECUPERA O ID GERADO PARA O INFO NOVO
                    while (rs.next()) {
                        Integer idGerado = rs.getInt(1);
                        login.setId(idGerado);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }
     public void deletarLogin(Login login) throws SQLException {
        String sql = "DELETE * FROM Login WHERE login_id=?";
        try (Connection conn = ConnectionMySql.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);
            // ADICIONAR O Statement.RETURN_GENERATED_KEYS PARA RECUPERAR O ID GERADO NO BD
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, String.valueOf(login.getId()));
                int resul = stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    // RECUPERA O ID GERADO PARA O INFO NOVO
                    while (rs.next()) {
                        Integer idGerado = rs.getInt(1);
                        login.setId(idGerado);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }
}
