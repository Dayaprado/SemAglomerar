package semAglomerar.Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import semAglomerar.DAO.LojaDAO;
import semAglomerar.DAO.ShoppingDAO;
import semAglomerar.Model.Loja;
import semAglomerar.Model.Shopping;

@WebServlet(name = "AdminPesquisaShopServlet", urlPatterns = {"/admin-shopping"})
public class AdminPesquisaShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        request.setAttribute("shops", new ArrayList<Shopping>());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPesquisaShop.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String param1 = request.getParameter("shop_id");
        
        try {
            ShoppingDAO shopDAO = new ShoppingDAO();
            Shopping shop = new Shopping();
            shop.setId(Integer.parseInt(param1));
                    
            shopDAO.deletarShopping(shop);
            
            response.sendRedirect(request.getContextPath() + "/admin-shopping");
        } catch (SQLException ex) {
            Logger.getLogger(AdminPesquisaLojaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        if ("delete".equals(request.getParameter("action"))) {
            doDelete(request, response);
            return;
        }
        
        
        String pesquisa = request.getParameter("txtPesquisa");

        ShoppingDAO shopDAO = new ShoppingDAO();
        try {
            List<Shopping> shops = shopDAO.Pesquisa(pesquisa);
            request.setAttribute("shops", shops);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPesquisaShopServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPesquisaShop.jsp");
        dispatcher.forward(request, response);
    }
}
