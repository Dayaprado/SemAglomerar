package semAglomerar.Model;

import org.mindrot.jbcrypt.BCrypt;

public class Login {

    private Integer id;
    private String usuario;
    private String hashSenha;
    private String tipo;

    public Login() {
        usuario = null;
        hashSenha = null;
        tipo = null;
    }

    public Login(String usuario, String senha, String tipo) {
        this.usuario = usuario;
        setSenha(senha);
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String senha) {
        this.hashSenha = senha;
    }

    public final void setSenha(String senha) {
        this.hashSenha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    public boolean validarSenha(String senha) {
        return BCrypt.checkpw(senha, hashSenha);
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public boolean Admin(){
        return this.tipo != null && this.tipo.equals("Administrador");
    }
}
