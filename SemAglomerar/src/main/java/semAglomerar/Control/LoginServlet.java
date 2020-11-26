/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semAglomerar.Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import semAglomerar.DAO.LoginDAO;
import semAglomerar.Model.Login;
import semAglomerar.Model.Shopping;

/**
 *
 * @author crisdut
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String email = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        LoginDAO loginDAO = new LoginDAO(); 
        Shopping shop = new Shopping();
        
        try {
            Login usuario = new Login();
            usuario = loginDAO.findByUser(usuario, email);  
            String usuario_tipo = usuario.getTipo();
            
            if(email.equals(usuario.getUsuario()) && usuario.validarSenha(senha)){
                
                //LoadUsuarioShop(usuarioTeste, email);
                if(usuario_tipo.equals("Loja")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/report.jsp");
                    dispatcher.forward(request, response);  
                    shop.LoadUsuarioLoja(shop, email);
                    
                }else  if(usuario_tipo.equals("Shopping")){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/inicioAdmin.jsp");
                    dispatcher.forward(request, response);  
                    shop.LoadUsuarioShop(shop, email);
                }else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/admSistema.jsp");
                    dispatcher.forward(request, response);  
                    shop.LoadUsuarioShop(shop, email);
                }
                
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("/validacao.jsp");                
                dispatcher.forward(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}