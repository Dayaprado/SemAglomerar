package semAglomerar.Model;

public class Loja {
    private Integer id;
    private String nome;
    private String cnpj;
    private Login login;
    private Responsavel resp;
    private Shopping shop;

    public Loja(Integer id, String nome, String cnpj, Login login, Responsavel resp, Shopping shop) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.login = login;
        this.resp = resp;
        this.shop = shop;
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

    public Shopping getShop() {
        return shop;
    }

    public void setShop(Shopping shop) {
        this.shop = shop;
    }    
}
