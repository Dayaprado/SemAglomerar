package semAglomerar.Model;

import java.sql.Time;
import java.sql.Date;


public class Relatorio {
    private Integer id;
    private Integer quantCliente;
    private Time hora;
    private Date data;
    private Loja loja;
    private Shopping shop;

    public Relatorio(Integer id, Integer quantCliente, Time hora, Date data, Loja loja, Shopping shop) {
        this.id = id;
        this.quantCliente = quantCliente;
        this.hora = hora;
        this.data = data;
        this.loja = loja;
        this.shop = shop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantCliente() {
        return quantCliente;
    }

    public void setQuantCliente(Integer quantCliente) {
        this.quantCliente = quantCliente;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Shopping getShop() {
        return shop;
    }

    public void setShop(Shopping shop) {
        this.shop = shop;
    }
    
    
    
}
