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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import semAglomerar.DAO.ShoppingDAO;
import semAglomerar.Model.Login;
import semAglomerar.Model.Loja;
import semAglomerar.Model.Relatorio;
import semAglomerar.Model.ResumoRelatorio;
import semAglomerar.Model.Shopping;

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
        
        carregaRelatorio(request, param1, param2);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/report.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int qtd = Integer.parseInt(request.getParameter("quantidade"));
        int lojaId = Integer.parseInt(request.getParameter("loja_id"));        

        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.of(LocalTime.now().getHour(), 0);
        
        try {
            LojaDAO lojas = new LojaDAO();
            ShoppingDAO shops = new ShoppingDAO();
            RelatorioDAO rels = new RelatorioDAO();
            
            Loja loja = lojas.findById(lojaId);
            Shopping shop = shops.findByLoja(lojaId);
            
            Relatorio rel = rels.findByLoja(lojaId, data, hora);
            
            if(rel != null){
                int q = qtd;
                rel.setQuantCliente(q);
                
                rels.atualizar(rel);
            } else { 
                rel = new Relatorio();
                rel.setData(java.sql.Date.valueOf(data));
                rel.setHora(java.sql.Time.valueOf(hora));
                rel.setQuantCliente(qtd);
                rel.setLoja(loja);
                rel.setShop(shop);
                
                rels.inserir(rel);                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(request.getContextPath() + "/relatorio?loja_id=" + lojaId);
    }
    
    private void carregaRelatorio(HttpServletRequest request, String lojaId, LocalDate data){
        try {
            RelatorioDAO rels = new RelatorioDAO();
            LojaDAO lojas = new LojaDAO();

            Loja loja = lojas.findById(Integer.parseInt(lojaId));
            List<ResumoRelatorio> resumos = rels.findByLoja(Integer.parseInt(lojaId), data);

            ArrayList<String> horarios = new ArrayList<>();
            ArrayList<Integer> quantidade = new ArrayList<>();

            for (ResumoRelatorio resumo : resumos) {
                quantidade.add(resumo.quantidade);
                horarios.add(formatarHora(Integer.toString(resumo.hora.getHour())));
            }

            verficaNivelAcesso(request);
            request.setAttribute("loja", loja.getNome());
            request.setAttribute("loja_id", loja.getId());
            request.setAttribute("horarios", Arrays.toString(horarios.toArray()));
            request.setAttribute("quantidade", Arrays.toString(quantidade.toArray()));

        } catch (SQLException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        if (sessao.getAttribute("usuario") == null) {
            request.setAttribute("admin", false);
            return;
        }

        Login usuario = (Login) sessao.getAttribute("usuario");

        if (usuario.Admin()) {
            request.setAttribute("admin", true);
        } else {
            request.setAttribute("admin", false);
        }
    }
}
