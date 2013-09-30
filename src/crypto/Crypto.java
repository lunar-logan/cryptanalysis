/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import crypto.util.ByteCipher;

/**
 *
 * @author ANURAG
 */
public class Crypto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Integer.parseInt("1100", 2));
        System.out.println(ByteCipher.encode(45698712325662259L));
        System.out.println(ByteCipher.encode(1));
    }
}
