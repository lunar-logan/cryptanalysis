/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import crypto.util.ByteCipher;
import crypto.util.Generator;

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
//        String hex = ByteCipher.decode("hqrtkrnhongpnipn");
//        System.out.println(hex);
//        System.out.println(ByteCipher.encode(Long.decode(hex)));
//        System.out.println(ByteCipher.decodeFancy("hqrtkrnhongpnipn"));
//        System.out.println(ByteCipher.encode(" 0x  2b ce 5c 82 98 1a   83 a8 "));
        Generator.generatePairs(128, 6458);
    }
}
