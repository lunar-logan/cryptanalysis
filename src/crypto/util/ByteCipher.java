/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.util;

/**
 *
 * @author ANURAG
 */
public class ByteCipher {

    private static final int BLOCK_SIZE = 64; // 64 bit block

    public static String encode(long num) {
        String binary = Long.toBinaryString(num);
        binary = addBinaryPadding(binary, BLOCK_SIZE);
        assert (binary.length() == 64); // binary must be of size 64
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int j = i * 4;
            String fourBitBlock = binary.substring(j, j + 4);
            int index = Integer.parseInt(fourBitBlock, 2);
            assert (index < 16);
            char c = (char) ('f' + index);
            output.append(c);
        }
        return output.toString();
    }

    private static String addBinaryPadding(String binaryData, int finalLength) {
        if (binaryData.length() < finalLength) {
            int dx = finalLength - binaryData.length();
            binaryData = repeatString("0", dx) + binaryData;
        }
        return binaryData;
    }

    private static String repeatString(String str, int times) {
        assert (times >= 0);
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sbr.append(str);
        }
        return sbr.toString();
    }
}
