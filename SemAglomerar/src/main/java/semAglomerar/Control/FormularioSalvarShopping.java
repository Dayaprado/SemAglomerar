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
import semAglomerar.DAO.ShoppingDAO;
import semAglomerar.DAO.LoginDAO;
import semAglomerar.DAO.ResponsavelDAO;
import semAglomerar.Model.Responsavel;
import semAglomerar.Model.Login;
import semAglomerar.Model.Shopping;


@WebServlet(name = "FormularioSalvarShopping", urlPatterns = {"/formulario-salvarShop"})
public class FormularioSalvarShopping extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //recuperar dados inseridos no formulario.
        String nome = request.getParameter("nome");
        String CNPJ = request.getParameter("cnpj");
        String responsavel = request.getParameter("loja");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String nomeLogin = request.getParameter("nomeLogin");
        String senha = request.getParameter("senha");
        
        Responsavel responsavels = new Responsavel(responsavel,cpf,email,telefone);
        Login logins = new Login(nomeLogin,senha,"Shopping");
        Shopping shoppings = new Shopping(nome,CNPJ,"Novo",logins,responsavels);
      
        request.setAttribute("responsavels", responsavels); 
        request.setAttribute("logins", logins);
        request.setAttribute("shoppings", shoppings);
        
        ShoppingDAO shopDAO = new ShoppingDAO();
        LoginDAO loginDAO = new LoginDAO();
        ResponsavelDAO respDAO = new ResponsavelDAO();
        
        try {
            respDAO.inserirResponsavel(responsavels);
            loginDAO.inserirLogin(logins);
            
            shopDAO.inserirShopping(shoppings,responsavels,logins);
            
        } catch (SQLException ex) {
            Logger.getLogger(FormularioSalvarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultadoShop.jsp");
        dispatcher.forward(request, response);
    }
}
