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
import semAglomerar.DAO.LojaDAO;
import semAglomerar.Model.Loja;

@WebServlet(name = "PesquisaLojaServlet", urlPatterns = {"/pesquisar-loja"})
public class PesquisaLojaServlet extends HttpServlet {

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
        String pesquisa = request.getParameter("txtPesquisa");
        
        Loja loja = new Loja();
        LojaDAO lojaDAO = new LojaDAO();
        
        request.setAttribute("loja", loja);
        
        try{
            lojaDAO.Pesquisa(pesquisa);
        }catch (SQLException ex) {
            Logger.getLogger(FormularioSalvarLoja.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pesquisaShop.jsp");
        dispatcher.forward(request, response);
    }
}