
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

@WebServlet(name = "FormularioSalvarLoja", urlPatterns = {"/cadastrar-loja"})
public class FormularioSalvarLoja extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String param1 = request.getParameter("shop_id");
        request.setAttribute("shop_id", param1);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroLoja.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //recuperar dados inseridos no formulario.
        String nome = request.getParameter("nome");
        String social = request.getParameter("social");
        String CNPJ = request.getParameter("cnpj");
        String localizacao = request.getParameter("localizacao");
        String categoria = request.getParameter("categoria");
        String responsavel = request.getParameter("loja");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String nomeLogin = request.getParameter("nomeLogin");
        String senha = request.getParameter("senha");
        String repetirSenha = request.getParameter("repetirSenha");
        int shopId = Integer.parseInt(request.getParameter("shop_id"));
        
        //Validação do nome
        boolean nomeValido = (nome != null && nome.trim().length() >= 3);

        //Validação da Razão Social
        boolean socialValido = (social != null && social.trim().length() >= 3);

        //Validação do cnpj
        boolean cnpjValido = (CNPJ != null && (CNPJ.trim().length() >=14 && CNPJ.trim().length() <=18 ));

        //Validação do piso
        boolean localizacaoValido = (localizacao != null && localizacao.trim().length() >=3);

        //Validação da categoria
        boolean categoriaValido = (categoria != null && categoria.trim().length() >= 3);

        //Validação do responsavel
        boolean responsavelValido = (responsavel != null && responsavel.trim().length() >= 3);

        //Validação do cpf
        boolean cpfValido = (cpf !=null && (cpf.trim().length() >= 11 && cpf.trim().length() <=14));

        //Validação do email
        boolean emailValido = (email != null && email.trim().length() > 0);
        if (emailValido) {
            Pattern emailPattern = Pattern.compile("^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+(\\.[a-z]+)?$");
            Matcher emailMatcher = emailPattern.matcher(email);
            emailValido = emailValido && emailMatcher.matches();
        }

        //Validação do telefone
        boolean telefoneValido = (telefone !=null && (telefone.trim().length() >= 8 && telefone.trim().length() <= 14));

        //Validação do Login
        boolean nomeLoginValido = (nomeLogin !=null && nomeLogin.trim().length() >= 3);

        //Validação da senha
        boolean senhaValido = (senha != null && senha.trim().length() >= 6);
        
        //validação do repetir senha
        boolean repetirsenhaValido = (senha.equals(repetirSenha));

        boolean camposValidosGlobal = nomeValido && socialValido && cnpjValido && localizacaoValido && categoriaValido
                && responsavelValido && cpfValido && emailValido && telefoneValido && nomeLoginValido 
                && senhaValido && repetirsenhaValido;
        
        if (!camposValidosGlobal) {            
            if (!nomeValido) {
                request.setAttribute("nomeErro", "Nome deve ser preenchido");
            }
            if (!socialValido) {
                request.setAttribute("socialErro", "Razão social deve ser preenchido");
            }
            if (!cnpjValido) {
                request.setAttribute("cnpjErro", "Cnpj deve ser preenchido");
            }
            if (!localizacaoValido) {
                request.setAttribute("localizacaoErro", "Localizacao deve ser preenchido");
            }
            if (!categoriaValido) {
                request.setAttribute("categoriaErro", "Categoria deve ser preenchido");
            }
            if (!responsavelValido) {
                request.setAttribute("responsavelErro", "Responsavel deve ser preenchido");
            }
            if (!cpfValido) {
                request.setAttribute("cpfErro", "Cpf deve ser preenchido");
            }
            if (!emailValido) {
                request.setAttribute("emailErro", "Email deve ser preenchido");
            }
            if(!telefoneValido){
                request.setAttribute("telefoneErro", "Telefone deve ser preenchido");
            }
            if(!nomeLoginValido){
                request.setAttribute("nomeLoginErro", "Login deve ser preenchido");
            }
            if(!senhaValido){
                request.setAttribute("senhaErro", "Senha deve conter pelo menos 6 caracteres");
            }
            if (!repetirsenhaValido) {
                request.setAttribute("repetirSenhaErro", "Senha deve ser igual a digitada anterior");
            }
            
            request.setAttribute("nome", nome);
            request.setAttribute("social", nome);
            request.setAttribute("cnpj", CNPJ);
            request.setAttribute("localizacao", localizacao);
            request.setAttribute("categoria", categoria);
            request.setAttribute("loja", responsavel);
            request.setAttribute("cpf", cpf);
            request.setAttribute("email", email);
            request.setAttribute("telefone", telefone);
            request.setAttribute("nomeLogin", nomeLogin);
            request.setAttribute("shop_id", shopId);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroLoja.jsp");
            dispatcher.forward(request, response);
            return;
        }


        Responsavel responsavels = new Responsavel(responsavel, cpf, email, telefone);
        Login logins = new Login(nomeLogin, senha, "Loja");
        Loja lojas = new Loja(nome, CNPJ, social, localizacao, categoria);
        Shopping shoppings = new Shopping();
        shoppings.setId(shopId);

        request.setAttribute("responsavels", responsavels);
        request.setAttribute("logins", logins);
        request.setAttribute("lojas", lojas);

        LojaDAO lojaDAO = new LojaDAO();
        LoginDAO loginDAO = new LoginDAO();
        ResponsavelDAO respDAO = new ResponsavelDAO();

        try {
            respDAO.inserirResponsavel(responsavels);
            loginDAO.inserirLogin(logins);
            lojaDAO.inserirLoja(lojas, logins, responsavels, shoppings);
        } catch (SQLException ex) {
            Logger.getLogger(FormularioSalvarLoja.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultado.jsp");
        dispatcher.forward(request, response);
    }
}
