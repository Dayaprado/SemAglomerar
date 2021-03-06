package semAglomerar.Model;

import java.sql.SQLException;
import semAglomerar.DAO.LojaDAO;
import semAglomerar.DAO.ShoppingDAO;


public class Shopping {
    private Integer id;
    private String nome;
    private String cnpj;
    private String status;
    private String endereco;
    private Login login;
    private Responsavel resp;

    public Shopping(String nome, String cnpj, String status, Login login, Responsavel resp) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.status = status;
        this.login = login;
        this.resp = resp;
    }
    
    public Shopping(){
        nome = null;
        cnpj = null;
        status = null;
        login = null;
        resp = null;
    }
    
    
    public Shopping LoadUsuarioShop(Shopping shop, String usuario) throws SQLException{
        ShoppingDAO shopDAO = new ShoppingDAO();
        shop = shopDAO.findByUser(shop, usuario);
        return shop;
    }

    public Loja LoadUsuarioLoja(String usuario) throws SQLException{
        LojaDAO lojaDAO = new LojaDAO();
        Loja loja = lojaDAO.findByUser(usuario);
        return loja;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Responsavel getResp() {
        return resp;
    }

    public void setResp(Responsavel resp) {
        this.resp = resp;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }   
}
