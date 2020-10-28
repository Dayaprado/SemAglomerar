/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semAglomerar.Control;

import java.sql.SQLException;
import semAglomerar.DAO.ResponsavelDAO;
import semAglomerar.Model.Responsavel;

/**
 *
 * @author Morfyd
 */
public class ResponsavelControl {
    
    public void addResp(String nome, String cpf, String email, String tel) throws SQLException {
        ResponsavelDAO resp = new ResponsavelDAO();
        Responsavel Resposavel= new Responsavel(nome,cpf,email,tel);
        
        resp.inserirResponsavel(Resposavel);
    }
}
