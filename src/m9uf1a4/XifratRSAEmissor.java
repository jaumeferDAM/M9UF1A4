/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a4;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author ALUMNEDAM
 */
public class XifratRSAEmissor {
    
    byte[] bites;
    
    /*
    * Metodod que recibe un mensaje a cifrar y una clave publica, utilizamos el 
    cipher en modo cifrador con la clave publica y obtenemos el resultado en el 
    * array de bites.
    */
    public void xifrarDadesEmissor(String missatge_rebut, PublicKey pky){
    byte[] missatge;
    missatge = missatge_rebut.getBytes();
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
            cipher.init(Cipher.ENCRYPT_MODE, pky);
            bites = cipher.doFinal(missatge);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            Logger.getLogger(XifratRSAEmissor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public byte[] getMissatge() {
        return bites;
    }
}
