package semAglomerar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import semAglomerar.ConnectionBD.ConnectionMySql;
import semAglomerar.Model.Responsavel;

public class ResponsavelDAO {

    private Responsavel resp;

    public List<Responsavel> findAll() throws SQLException {
        String sql = "SELECT * FROM Responsavel";
        List<Responsavel> resul = new ArrayList<>();

        try (Connection conn = ConnectionMySql.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                resp.setId(rs.getInt("resp_id"));
                resp.setNome(rs.getString("resp_nome"));
                resp.setCpf(rs.getString("resp_cpf"));
                resp.setEmail(rs.getString("resp_email"));
                resp.setTelefone(rs.getString("resp_telefone"));
                resul.add(resp);
            }
        }
        return resul;
    }

    public Responsavel findByCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM Responsavel WHERE resp_cpf=?";
        try (Connection conn = ConnectionMySql.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    resp.setId(rs.getInt("resp_id"));
                    resp.setNome(rs.getString("resp_nome"));
                    resp.setCpf(rs.getString("resp_cpf"));
                    resp.setEmail(rs.getString("resp_email"));
                    resp.setTelefone(rs.getString("resp_telefone"));
                    return resp;
                }
            } catch (Exception e) {
                System.out.print("Erro ao pesquisar o CPF: " + cpf);
            }
        }
        return null;
    }

    public void inserirResponsavel(Responsavel resp) throws SQLException{
        String sql = "INSERT INTO Responsavel (resp_nome, resp_cpf, resp_email,resp_telefone) VALUES (?,?,?,?)";
        Connection conn = null;
        try  {
            conn = ConnectionMySql.obterConexao();
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);

            // ADICIONAR O Statement.RETURN_GENERATED_KEYS PARA RECUPERAR O ID GERADO NO BD
            PreparedStatement stmt =   conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, resp.getNome());
            stmt.setString(2, resp.getCpf());
            stmt.setString(3, resp.getEmail());
            stmt.setString(4, resp.getTelefone());
            boolean resul = stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys(); // RECUPERA O ID GERADO PARA O INFO NOVO
            while (rs.next()) {
                Integer idGerado = rs.getInt(1);
                resp.setId(idGerado);
            }

            conn.commit();

        } catch (SQLException e) {
            conn.rollback();
            
        }
    }

    
    public void atualizarResponsavel(Responsavel resp) throws SQLException {
        String sql = "UPDATE Responsavel set resp_nome=?, resp_cpf=?, resp_email=?,resp_telefone=? WHERE resp_id=?";
        try (Connection conn = ConnectionMySql.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);
            // ADICIONAR O Statement.RETURN_GENERATED_KEYS PARA RECUPERAR O ID GERADO NO BD
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, resp.getNome());
                stmt.setString(2, resp.getCpf());
                stmt.setString(3, resp.getEmail());
                stmt.setString(4, resp.getTelefone());
                stmt.setString(5, String.valueOf(resp.getId()));
                int resul = stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    // RECUPERA O ID GERADO PARA O INFO NOVO
                    while (rs.next()) {
                        Integer idGerado = rs.getInt(5);
                        resp.setId(idGerado);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    public void deletarResponsavel(Responsavel resp) throws SQLException {
        String sql = "DELETE * FROM Responsavel WHERE resp_id=?";
        try (Connection conn = ConnectionMySql.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);
            // ADICIONAR O Statement.RETURN_GENERATED_KEYS PARA RECUPERAR O ID GERADO NO BD
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, String.valueOf(resp.getId()));
                int resul = stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    // RECUPERA O ID GERADO PARA O INFO NOVO
                    while (rs.next()) {
                        Integer idGerado = rs.getInt(1);
                        resp.setId(idGerado);
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
