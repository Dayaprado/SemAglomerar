/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semAglomerar.Model;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author dayprado
 */
public class ResumoRelatorio {
    
    public int lojaId;
    public int quantidade;
    public LocalTime hora;
    
    public ResumoRelatorio(int lojaId, int quantidade, LocalTime hora){
        this.lojaId = lojaId;
        this.hora = hora;        
        this.quantidade = quantidade;
    }
}
