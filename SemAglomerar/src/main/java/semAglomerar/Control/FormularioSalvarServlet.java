
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
import semAglomerar.DAO.LojaDAO;
import semAglomerar.DAO.ResponsavelDAO;
import semAglomerar.Model.Loja;
import semAglomerar.Model.Responsavel;
import semAglomerar.Model.Login;
import semAglomerar.Model.Shopping;


@WebServlet(name = "FormularioSalvarServlet", urlPatterns = {"/formulario-salvar"})
public class FormularioSalvarServlet extends HttpServlet {

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
        String social = request.getParameter("social");
        String CNPJ = request.getParameter("cnpj");
        String Piso = request.getParameter("piso");
        String categoria = request.getParameter("categoria");
        String responsavel = request.getParameter("loja");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String nomeLogin = request.getParameter("nomeLogin");
        String senha = request.getParameter("senha");

        Responsavel responsavels = new Responsavel(responsavel,cpf,email,telefone);
        Login logins = new Login(nomeLogin,senha,"Loja");
        Loja lojas = new Loja(nome,CNPJ,social,Piso,categoria);
        Shopping shoppings = new Shopping();
        
        request.setAttribute("responsavels", responsavels); 
        request.setAttribute("logins", logins);
        request.setAttribute("lojas", lojas);
        
        LojaDAO lojaDAO = new LojaDAO();
        LoginDAO loginDAO = new LoginDAO();
        ResponsavelDAO respDAO = new ResponsavelDAO();
        
        try {
            shoppings = (Shopping) request.getSession().getAttribute("shopping");
            //request.getSession().getAttribute("usuario");
            
            respDAO.inserirResponsavel(responsavels);
            loginDAO.inserirLogin(logins);            
            lojaDAO.inserirLoja(lojas,logins,responsavels,shoppings);
        } catch (SQLException ex) {
            Logger.getLogger(FormularioSalvarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultado.jsp");
        dispatcher.forward(request, response);
    }
}
