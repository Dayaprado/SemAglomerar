package semAglomerar.Model;

import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class Login {

    private Integer id;
    private String usuario;
    private String hashSenha;

    public Login() {
        usuario = null;
        hashSenha = null;
    }

    public Login(String usuario, String senha) {
        this.usuario = usuario;
        setSenha(senha);
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
    
}
