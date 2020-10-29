package semAglomerar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import semAglomerar.ConnectionBD.ConnectionMySql;
import semAglomerar.Model.Shopping;
import semAglomerar.Model.Login;
import semAglomerar.Model.Responsavel;


public class ShoppingDAO {
    private Shopping shop;
    private Login login;
    private Responsavel resp;
    
    public List<Shopping> findall() throws SQLException{
        String sql = "SELECT shop_id, shop_nome,shop_cnpj,resp_nome, resp_cpf,resp_email,resp_telefone,login_usuario " +
            "FROM shopping, responsavel,login " +
            "WHERE shop_resp_id=resp_id AND shop_login_id = login_id;" ;
        
        List<Shopping> resul = new ArrayList<>();
        
        try(Connection conn = ConnectionMySql.obterConexao();
                PreparedStatement stmt=conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                shop.setId(rs.getInt("shop_id"));
                shop.setNome(rs.getString("shop_nome"));
                shop.setCnpj(rs.getString("shop_cnpj"));                
                resp.setNome(rs.getString("resp_nome"));
                resp.setCpf(rs.getString("resp_cpf"));
                resp.setEmail(rs.getString("resp_email"));
                resp.setTelefone(rs.getString("resp_telefone"));                
                login.setUsuario(rs.getString("login_usuario"));                
                resul.add(shop);
            }
        }        
        return resul;
    }
    
    public Shopping findByCnpj(String cnpj) throws SQLException{
        String sql = "SELECT shop_id, shop_nome,shop_cnpj,resp_nome, resp_cpf,resp_email,resp_telefone,login_usuario " +
            "FROM shopping, responsavel,login " +
            "WHERE shop_cnpj=?" +
            "AND shop_resp_id=resp_id AND shop_login_id = login_id;" ;
        
        try (Connection conn = ConnectionMySql.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cnpj);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    shop.setId(rs.getInt("shop_id"));
                    shop.setNome(rs.getString("shop_nome"));
                    shop.setCnpj(rs.getString("shop_cnpj"));                
                    resp.setNome(rs.getString("resp_nome"));
                    resp.setCpf(rs.getString("resp_cpf"));
                    resp.setEmail(rs.getString("resp_email"));
                    resp.setTelefone(rs.getString("resp_telefone"));                
                    login.setUsuario(rs.getString("login_usuario"));                
                    return shop;
                }
            }catch (Exception e){
                System.out.println("Erro ao pesquisar o CNPJ: " + cnpj);
            }
        }
        return null;
    }
    
    public void inserirShopping(Shopping shop) throws SQLException{
        String sql = "INSERT INTO shopping (shop_nome, shop_cnpj, shop_login_id, shop_resp_id) " +
        "VALUES (?,?,?,?);";
        
        try(Connection conn = ConnectionMySql.obterConexao()){
            conn.setAutoCommit(false);
            
            try(PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                stmt.setString(1, shop.getNome());
                stmt.setString(2, shop.getCnpj());
                stmt.setInt(3, login.getId());
                stmt.setInt(4, resp.getId());
                int resul = stmt.executeUpdate();
                
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    while (rs.next()){
                        Integer idGerado = rs.getInt(1);
                        shop.setId(idGerado);
                    }
                }
                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                throw e;
            }
        }        
    }
    
    public void atualizarShopping(Shopping shop) throws SQLException {
        String sql = "UPDATE Shopping set shop_nome=?, shop_cnpj=? WHERE shop_id=?";
        try (Connection conn = ConnectionMySql.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);
            // ADICIONAR O Statement.RETURN_GENERATED_KEYS PARA RECUPERAR O ID GERADO NO BD
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, shop.getNome());
                stmt.setString(2, shop.getCnpj());
                stmt.setInt(3, shop.getId());
                int resul = stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    // RECUPERA O ID GERADO PARA O INFO NOVO
                    while (rs.next()) {
                        Integer idGerado = rs.getInt(3);
                        shop.setId(idGerado);
                    }
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }
    
     public void deletarShopping(Shopping shop) throws SQLException {
        String sql = "DELETE * FROM Shopping WHERE shop_id=?";
        try (Connection conn = ConnectionMySql.obterConexao()) {
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);
            // ADICIONAR O Statement.RETURN_GENERATED_KEYS PARA RECUPERAR O ID GERADO NO BD
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, shop.getId());
                int resul = stmt.executeUpdate();
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    // RECUPERA O ID GERADO PARA O INFO NOVO
                    while (rs.next()) {
                        Integer idGerado = rs.getInt(1);
                        shop.setId(idGerado);
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