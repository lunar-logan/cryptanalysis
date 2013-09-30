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
//        System.out.println(Integer.parseInt("1100", 2));
//        System.out.println(ByteCipher.encode(45698712325662259L));
//        System.out.println(ByteCipher.encode(1));
//        String hex = ByteCipher.decode("hqrtkrnhongpnipn");
//        System.out.println(hex);
//        System.out.println(ByteCipher.encode(Long.decode(hex)));
//        System.out.println(ByteCipher.decodeFancy("hqrtkrnhongpnipn"));
        System.out.println(ByteCipher.encode(" 0x  2b ce 5c 82 98 1a   83 a8 "));
    }
}
