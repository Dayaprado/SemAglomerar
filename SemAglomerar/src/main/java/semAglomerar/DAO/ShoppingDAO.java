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
        String sql = "SELECT shop_id, shop_nome,shop_cnpj,shop_status, resp_id, resp_nome, resp_cpf,resp_email,resp_telefone,login_id, login_usuario, login_usuario " +
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
                shop.setStatus(rs.getString("shop_status"));   
                resp.setId(rs.getInt("resp_id"));                
                resp.setNome(rs.getString("resp_nome"));
                resp.setCpf(rs.getString("resp_cpf"));
                resp.setEmail(rs.getString("resp_email"));
                resp.setTelefone(rs.getString("resp_telefone"));   
                login.setId(rs.getInt("login_id"));      
                login.setUsuario(rs.getString("login_usuario"));    
                login.setHashSenha(rs.getString("login_senha"));             
                resul.add(shop);
            }
        }        
        return resul;
    }
    
    public Shopping findById(Integer id) throws SQLException{
        String sql = "SELECT shop_id, shop_nome,shop_cnpj,resp_nome, resp_cpf,resp_email,resp_telefone " +
            "FROM shopping, responsavel,login " +
            "WHERE shop_id=?" +
            "AND shop_resp_id=resp_id AND shop_login_id = login_id;" ;
        
        Connection conn = null;
        
        try {
            conn = ConnectionMySql.obterConexao();
            conn.setAutoCommit(false);  
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);    
            
            ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    shop.setId(rs.getInt("shop_id"));
                    shop.setNome(rs.getString("shop_nome"));
                    shop.setCnpj(rs.getString("shop_cnpj"));                
                    resp.setNome(rs.getString("resp_nome"));
                    resp.setCpf(rs.getString("resp_cpf"));
                    resp.setEmail(rs.getString("resp_email"));
                    resp.setTelefone(rs.getString("resp_telefone"));               
                    return shop;
                }
            }catch (Exception e){
                System.out.println("Erro ao pesquisar o ID: " + id);
            }
        return null;
    }
    
    public Shopping findByUser(Shopping shop, String usuario) throws SQLException{
        String sql = "SELECT shop_id, shop_nome, shop_cnpj, shop_status, resp_id, resp_nome, resp_cpf,resp_email,resp_telefone " +
            "FROM shopping, responsavel,login " +
            "WHERE login_usuario=? " +
            "AND shop_resp_id=resp_id AND shop_login_id = login_id;" ;
        
        Connection conn = null;
        
        try {
            conn = ConnectionMySql.obterConexao();
            conn.setAutoCommit(false);  
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);    
            
            ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    shop.setId(rs.getInt("shop_id"));
                    shop.setNome(rs.getString("shop_nome"));
                    shop.setCnpj(rs.getString("shop_cnpj"));
                    shop.setStatus(rs.getString("shop_status"));
                    
                    resp.setId(rs.getInt("resp_id"));
                    resp.setNome(rs.getString("resp_nome"));
                    resp.setCpf(rs.getString("resp_cpf"));
                    resp.setEmail(rs.getString("resp_email"));
                    resp.setTelefone(rs.getString("resp_telefone"));
                    
                    return shop;
                }
            }catch (Exception e){
                System.out.println("Erro ao pesquisar o CNPJ: " + usuario);
            }
        return shop;
    }
    
    public Shopping  findUserShop(Shopping shop, String user) throws SQLException{
        String sql = "select shop_id, shop_nome, shop_cnpj, shop_status" + 
                "from login, loja, shopping " +
                "where login_usuario =? " +
                "and loja_login_id= login_id and loja_shop_id = shop_id; ";
        
        Connection conn = null;
        
        try {
            conn = ConnectionMySql.obterConexao();
            conn.setAutoCommit(false);      
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                    shop.setId(rs.getInt("shop_id"));
                    shop.setNome(rs.getString("shop_nome"));
                    shop.setCnpj(rs.getString("shop_cnpj"));
                    shop.setStatus(rs.getString("shop_status"));
                    return shop;
            }
            
        }catch (SQLException e) {
                conn.rollback();
            }
        return shop;
    }
    
    public Shopping Pesquisa(String pesq) throws SQLException{
        String sql = "SELECT shop_id, shop_nome, shop_cnpj, shop_status" +
            "FROM shopping " +
            "WHERE shop_nome like ? ;";
        
        Connection conn = null;
        
        try {
            conn = ConnectionMySql.obterConexao();
            conn.setAutoCommit(false);  
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%"+pesq+"%");    
            
            ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    shop.setId(rs.getInt("shop_id"));
                    shop.setNome(rs.getString("shop_nome"));
                    shop.setCnpj(rs.getString("shop_cnpj"));
                    shop.setStatus(rs.getString("shop_status"));
                    return shop;
                }
        }catch (SQLException e) {
                conn.rollback();
            }
        return shop;
    }
    
    public void inserirShopping(Shopping shop, Responsavel resp, Login login) throws SQLException{
        String sql = "INSERT INTO shopping (shop_nome, shop_cnpj, shop_status, shop_login_id, shop_resp_id) " +
        "VALUES (?,?,?,?,?);";
        
        Connection conn = null;
        try  {
            conn = ConnectionMySql.obterConexao();
            // DESLIGAR AUTO-COMMIT -> POSSIBILITAR DESFAZER OPERACOES EM CASOS DE ERROS
            conn.setAutoCommit(false);

            // ADICIONAR O Statement.RETURN_GENERATED_KEYS PARA RECUPERAR O ID GERADO NO BD
            PreparedStatement stmt =   conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, shop.getNome());
            stmt.setString(2, shop.getCnpj());
            stmt.setString(3, shop.getStatus());
            stmt.setInt(4, login.getId());
            stmt.setInt(5, resp.getId());
            boolean resul = stmt.execute();
                
            ResultSet rs = stmt.getGeneratedKeys(); // RECUPERA O ID GERADO PARA O INFO NOVO
            while (rs.next()) {
                Integer idGerado = rs.getInt(1);
                shop.setId(idGerado);
            }

            conn.commit();

        } catch (SQLException e) {
            conn.rollback();
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
