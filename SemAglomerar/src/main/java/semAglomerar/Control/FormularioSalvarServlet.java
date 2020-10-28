/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semAglomerar.Control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import semAglomerar.Model.Loja;
import semAglomerar.Model.Responsavel;
import semAglomerar.Model.Login;

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
        String CNPJ = request.getParameter("CNPJ");
        String Piso = request.getParameter("Piso");
        String responsavel = request.getParameter("loja");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String nomeLogin = request.getParameter("nomeLogin");
        String senha = request.getParameter("senha");

        Responsavel responsavels = new Responsavel();
        responsavels.setNome(responsavel);
        responsavels.setEmail(email);
        responsavels.setTelefone(telefone);
       

        Login logins = new Login();
        logins.setUsuario(nomeLogin);
        logins.setSenha(senha);
        
        Loja lojas = new Loja();
        lojas.setNome(nome);
        lojas.setRazaoSocial(social);
        lojas.setCnpj(CNPJ);
        lojas.setPiso(Piso);
        lojas.setLogin(logins);
        lojas.setResp(responsavels);
      
        request.setAttribute("responsavels", responsavels); 
        request.setAttribute("logins", logins);
        request.setAttribute("lojas", lojas);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultado.jsp");
        dispatcher.forward(request, response);
    }

}
