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
import javax.servlet.http.HttpSession;
import semAglomerar.DAO.LoginDAO;
import semAglomerar.Model.Login;
import semAglomerar.Model.Loja;
import semAglomerar.Model.Shopping;

/**
 *
 * @author crisdut
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp")
                .forward(request, response);
    }

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

            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", usuario);

            if (email.equals(usuario.getUsuario()) && usuario.validarSenha(senha)) {
                if (usuario_tipo.equals("Loja")) {
                    Loja loja = shop.LoadUsuarioLoja(email);
                    sessao.setAttribute("shopping", loja);
                    response.sendRedirect(request.getContextPath() + "/relatorio?loja_id=" + loja.getId());

                } else if (usuario_tipo.equals("Shopping")) {
                    shop = shop.LoadUsuarioShop(shop, email);
                    sessao.setAttribute("shopping", shop);
                    response.sendRedirect(request.getContextPath() + "/admin-loja?shop_id=" + shop.getId());
                } else {
                    Loja loja = shop.LoadUsuarioLoja(email);
                    sessao.setAttribute("shopping", loja);
                    response.sendRedirect(request.getContextPath() + "/admin-shopping");
                }

            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/validacao.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
