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
        
        try {
            Login usuario = new Login(email,senha);
            Login usuarioTeste = new Login();
            usuarioTeste = loginDAO.findByUser(usuarioTeste, email);  
            
            if(email.equals(usuarioTeste.getUsuario()) && senha.equals(usuarioTeste.getSenha())){
                RequestDispatcher dispatcher = request.getRequestDispatcher("/inicioAdmin.jsp");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("/validacao.jsp");                
                dispatcher.forward(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}