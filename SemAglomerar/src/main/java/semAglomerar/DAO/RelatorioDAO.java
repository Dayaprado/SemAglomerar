/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semAglomerar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import semAglomerar.ConnectionBD.ConnectionMySql;
import semAglomerar.Model.ResumoRelatorio;

/**
 *
 * @author dayprado
 */
public class RelatorioDAO {

    public List<ResumoRelatorio> findByLoja(int loja, LocalDate data) {
        List<ResumoRelatorio> resumos = new ArrayList<>();

        String q
                = "select relat_hora as hora, "
                + "       sum(relat_quant_cliente) as quantidade "
                + "from Relatorio "
                + "where relat_data = ? "
                + "and relat_loja_id = ? "
                + "group by relat_hora";

        try (Connection conn = ConnectionMySql.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(q)) {

            stmt.setString(2, Integer.toString(loja));
            stmt.setString(1, data.toString());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ResumoRelatorio resumo;
                resumo = new ResumoRelatorio(loja, rs.getInt("quantidade"), rs.getTime("hora").toLocalTime());
                resumos.add(resumo);
            }

        } catch (SQLException esql) {
            System.out.print("Erro ao pesquisar a Loja: " + esql.getMessage());
        }

        return resumos;
    }
}
