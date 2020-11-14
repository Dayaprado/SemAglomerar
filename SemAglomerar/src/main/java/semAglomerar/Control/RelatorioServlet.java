/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semAglomerar.Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author crisdut
 */
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/relatorio"})
public class RelatorioServlet extends HttpServlet {

    ArrayList<String> horarios = new ArrayList<>();
    ArrayList<Integer> quantidade = new ArrayList<>();    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Jogue linha abaixo fora (só para testes).
        // Só olhe o padrão dos dados dentro do método
        inicializaInfoFake();
        
        request.setAttribute("loja", "Renner");
        request.setAttribute("horarios", Arrays.toString(horarios.toArray()));
        request.setAttribute("quantidade", Arrays.toString(quantidade.toArray()));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/report.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String qtd = request.getParameter("quantidade");
        
        // Jogue linha abaixo fora (só para testes).
        processaInfoFake(qtd);
        
        request.setAttribute("loja", "Renner");
        request.setAttribute("horarios", Arrays.toString(horarios.toArray()));
        request.setAttribute("quantidade", Arrays.toString(quantidade.toArray()));        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/report.jsp");
        dispatcher.forward(request, response);
    }
    
    private void inicializaInfoFake(){
        horarios.clear();
        quantidade.clear();
        
        horarios.add("'12pm'");
        horarios.add("'13pm'");

        quantidade.add(12);
        quantidade.add(10);
    }
    
    private void processaInfoFake(String qtd){
        LocalDateTime data = LocalDateTime.now();
        String doc = "am";
        if(data.getHour() >= 12){
            doc = "pm";
        }
        
        String chave = "'"+ data.getHour() + doc + "'";
        
        if(horarios.contains(chave)){
            int index = horarios.indexOf(chave);
            quantidade.set(index, Integer.parseInt(qtd));
        }else{
            horarios.add("'"+ data.getHour() + doc + "'");
            quantidade.add(Integer.parseInt(qtd));
        }
    }
}
