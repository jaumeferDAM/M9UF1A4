/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf1a4;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ALUMNEDAM
 */
public class XfratRSAReceptor {

    private static KeyPair keyPair;
    private byte[] datosDesencriptados;

    /*
    * Metodo para gener dos claves de 2048 bites, y instanciar 
    * la clave publica y privada.
    */
    public void generaClaus() {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            keyPair = keyGen.genKeyPair();
        } catch (Exception e) {
            System.err.println("Generador no disponible.");
        }

    }

    /*
    * Recibe el array de bytes y utilizamos el cipher en modo desfricador con la
    * clave privada y  lo almacenamos en array de bites.
    */
    public void desxifraDadesReceptor(byte[] mensaje) {
        Cipher ciph;
        try {
            ciph = Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
            ciph.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
            datosDesencriptados = ciph.doFinal(mensaje);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(XfratRSAReceptor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public PublicKey getClauPublica() {
        return keyPair.getPublic();
    }

    public byte[] getTextDesxifrat() {
        return datosDesencriptados;
    }

}
