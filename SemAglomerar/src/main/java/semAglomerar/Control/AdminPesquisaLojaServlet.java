package semAglomerar.Control;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet(name = "AdminPesquisaLojaServlet", urlPatterns = {"/admin-loja"})
public class AdminPesquisaLojaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String param1 = request.getParameter("shop_id");
        
        try {
            LojaDAO lojaDAO = new LojaDAO();
            List<Loja> lojas = lojaDAO.findByShopId(Integer.parseInt(param1));
            request.setAttribute("shop_id", param1);
            request.setAttribute("lojas", lojas);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPesquisaLojaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPesquisaLoja.jsp");
        dispatcher.forward(request, response);
        
    }
    
        @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String param1 = request.getParameter("loja_id");
        String param2 = request.getParameter("shop_id");
        
        try {
            LojaDAO lojaDAO = new LojaDAO();
            Loja loja = new Loja();
            loja.setId(Integer.parseInt(param1));
                    
            lojaDAO.deletarLoja(loja);
            
            response.sendRedirect(request.getContextPath() + "/admin-loja?shop_id="+param2);
        } catch (SQLException ex) {
            Logger.getLogger(AdminPesquisaLojaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //recuperar dados inseridos no formulario.
        String param1 = request.getParameter("shop_id");
        String param2 = request.getParameter("txtPesquisa");
        
        if ("delete".equals(request.getParameter("action"))) {
            doDelete(request, response);
            return;
        }        
        
        try {
            LojaDAO lojaDAO = new LojaDAO();
            List<Loja> lojas = lojaDAO.findByShopId(Integer.parseInt(param1));
            request.setAttribute("shop_id", param1);
            request.setAttribute("lojas", lojas);

        } catch (SQLException ex) {
            Logger.getLogger(AdminPesquisaLojaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/adminPesquisaLoja.jsp");
        dispatcher.forward(request, response);
    }
}