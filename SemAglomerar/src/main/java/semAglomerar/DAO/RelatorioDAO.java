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
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import semAglomerar.ConnectionBD.ConnectionMySql;
import semAglomerar.Model.Loja;
import semAglomerar.Model.Relatorio;
import semAglomerar.Model.ResumoRelatorio;
import semAglomerar.Model.Shopping;

/**
 *
 * @author dayprado
 */
public class RelatorioDAO {

    public Relatorio findByLoja(int lojaId, LocalDate data, LocalTime hora) {
        Relatorio relatorio = null;
        String q    = "select relat_id, relat_quant_cliente, relat_hora, relat_data, relat_loja_id, relat_shop_id "
                    + " from Relatorio "
                    + " where relat_data = ? "
                    + " and relat_hora = ? "
                    + " and relat_loja_id = ? ";
        
        try (Connection conn = ConnectionMySql.obterConexao();
                PreparedStatement stmt = conn.prepareStatement(q)) {
            stmt.setDate(1, java.sql.Date.valueOf(data));
            stmt.setTime(2, java.sql.Time.valueOf(hora));
            stmt.setString(3, Integer.toString(lojaId));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Shopping shop = new Shopping();
                shop.setId(rs.getInt("relat_shop_id"));

                Loja loja = new Loja();
                loja.setId(rs.getInt("relat_loja_id"));

                relatorio = new Relatorio();
                relatorio.setLoja(loja);
                relatorio.setShop(shop);
                relatorio.setId(rs.getInt("relat_id"));
                relatorio.setData(rs.getDate("relat_data"));
                relatorio.setHora(rs.getTime("relat_hora"));
                relatorio.setQuantCliente(rs.getInt("relat_quant_cliente"));
            }

        } catch (SQLException esql) {
            System.out.print("Erro ao pesquisar a Loja: " + esql.getMessage());
        }

        return relatorio;
    }

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
            while (rs.next()) {
                ResumoRelatorio resumo;
                resumo = new ResumoRelatorio(loja, rs.getInt("quantidade"), rs.getTime("hora").toLocalTime());
                resumos.add(resumo);
            }

        } catch (SQLException esql) {
            System.out.print("Erro ao pesquisar a Loja: " + esql.getMessage());
        }

        return resumos;
    }

    public void atualizar(Relatorio rel) throws SQLException {
        String sql = 
                  " UPDATE Relatorio " +
                  " SET relat_quant_cliente = ? " +
                  " WHERE relat_id = ? ";
        
        Connection conn = null;
        
        try {
            conn = ConnectionMySql.obterConexao();
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.SUCCESS_NO_INFO);
            stmt.setInt(1, rel.getQuantCliente());
            stmt.setInt(2, rel.getId());
            
            int resul = stmt.executeUpdate();

            conn.commit();

        } catch (SQLException e) {
            conn.rollback();
        }
    }

    public void inserir(Relatorio rel) throws SQLException {
        String sql = 
                  " INSERT INTO Relatorio(relat_quant_cliente, relat_hora, relat_data, relat_loja_id, relat_shop_id) "
                + " VALUES (?, ?, ?, ?, ?) ";
        
        Connection conn = null;
        
        try {
            conn = ConnectionMySql.obterConexao();
            conn.setAutoCommit(false);

            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, rel.getQuantCliente());
            stmt.setTime(2, rel.getHora());
            stmt.setDate(3, rel.getData());
            stmt.setInt(4, rel.getLoja().getId());
            stmt.setInt(5, rel.getShop().getId());

            boolean resul = stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys(); // RECUPERA O ID GERADO PARA O INFO NOVO
            while (rs.next()) {
                Integer idGerado = rs.getInt(1);
                rel.setId(idGerado);
            }

            conn.commit();

        } catch (SQLException e) {
            conn.rollback();
        }
    }
}
