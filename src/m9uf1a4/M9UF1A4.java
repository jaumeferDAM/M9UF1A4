/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a4;

import java.util.Arrays;

/**
 *
 * @author ALUMNEDAM
 */
public class M9UF1A4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XifratRSAEmissor aEmissor = new XifratRSAEmissor();
        XfratRSAReceptor aReceptor = new XfratRSAReceptor();
        aReceptor.generaClaus();
        
        aEmissor.xifrarDadesEmissor("Hola", aReceptor.getClauPublica());
        aReceptor.desxifraDadesReceptor(aEmissor.getMissatge());
        System.out.println(Arrays.toString(aReceptor.getTextDesxifrat()));
    }
    
}
