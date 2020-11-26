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
import semAglomerar.Model.Shopping;

@WebServlet(name = "PesquisaShopServlet", urlPatterns = {"/pesquisar-shopping"})
public class PesquisaShopServlet extends HttpServlet {

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
        
        Shopping shop = new Shopping();
        ShoppingDAO shopDAO = new ShoppingDAO();
        
        request.setAttribute("shopping", shop);
        
        try{
            shopDAO.Pesquisa(pesquisa);
        }catch (SQLException ex) {
            Logger.getLogger(FormularioSalvarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pesquisaShop.jsp");
        dispatcher.forward(request, response);
    }
}