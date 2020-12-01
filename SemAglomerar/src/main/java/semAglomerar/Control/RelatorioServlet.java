/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semAglomerar.Control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import semAglomerar.DAO.LojaDAO;
import semAglomerar.DAO.RelatorioDAO;
import semAglomerar.Model.Loja;
import semAglomerar.Model.ResumoRelatorio;

/**
 *
 * @author crisdut
 */
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/relatorio"})
public class RelatorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String param1 = request.getParameter("loja_id");
        LocalDate param2 = LocalDate.now();

        try {
            RelatorioDAO rels = new RelatorioDAO();
            LojaDAO lojas = new LojaDAO();

            Loja loja = lojas.findById(Integer.parseInt(param1));
            List<ResumoRelatorio> resumos = rels.findByLoja(Integer.parseInt(param1), param2);

            ArrayList<String> horarios = new ArrayList<>();
            ArrayList<Integer> quantidade = new ArrayList<>();

            for (ResumoRelatorio resumo : resumos) {
                quantidade.add(resumo.quantidade);
                horarios.add(formatarHora(Integer.toString(resumo.hora.getHour())));
            }

            verficaNivelAcesso(request);
            request.setAttribute("loja", loja.getNome());
            request.setAttribute("horarios", Arrays.toString(horarios.toArray()));
            request.setAttribute("quantidade", Arrays.toString(quantidade.toArray()));

        } catch (SQLException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/report.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String qtd = request.getParameter("quantidade");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/report.jsp");
        dispatcher.forward(request, response);
    }

    private String formatarHora(String hora) {
        if (Integer.parseInt(hora) >= 12) {
            return "'" + hora + " pm'";
        }
        return "'" + hora + " am'";
    }

    private void verficaNivelAcesso(HttpServletRequest request) {
        HttpSession sessao = request.getSession();
        if (sessao == null) {
            request.setAttribute("admin", false);
            return;
        } 
        
        if(sessao.getAttribute("usuario") == null){
            request.setAttribute("admin", false);
            return;        
        }
    }
}
