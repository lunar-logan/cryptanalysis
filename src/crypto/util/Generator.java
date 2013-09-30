/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ANURAG
 */
public class Generator {

    private static File getReadyFile(String fileName, String ext, boolean adjust) {
        String path = System.getProperty("user.dir") + System.getProperty("file.separator");
        File outfile = new File(path + fileName + ext);
        if (outfile.exists()) {
            outfile = null;
            if (adjust) {
                fileName = fileName + "_" + System.currentTimeMillis();
                outfile = new File(path + fileName + ext);
            }
        }
        return outfile;
    }

    public static void generatePairs(int count, long differential) {
        assert (count > 0);
        File outfile = getReadyFile("pairs", ".txt", true);
        if (outfile != null) {
            try (PrintWriter pw = new PrintWriter(outfile)) {
                SecureRandom rand = new SecureRandom();
                for (int i = 0; i < count; i++) {
                    BigInteger bi = new BigInteger(63, rand);
                    long p1 = bi.longValue();
                    long p2 = p1 ^ differential;
                    pw.printf("%-22x%-22x%-22s%-22s\n", p1, p2, ByteCipher.encode(p1), ByteCipher.encode(p2));
                }
            } catch (IOException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
