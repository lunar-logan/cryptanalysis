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

    public static String encode(String num) {
        if (num.contains(" ")) {
            num = num.replaceAll(" +", "");
        }
        return encode(Long.decode(num));
    }

    public static String encode(long num) {
        String binary = Long.toBinaryString(num);
//        System.out.println("Binary: " + binary);
        binary = addBinaryPadding(binary, BLOCK_SIZE);
//        System.out.println("Binary after padding: " + binary);
        assert (binary.length() == BLOCK_SIZE); // binary must be of size 64
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

    /**
     *
     * @param text
     * @return a hex dump
     */
    public static String decode(String text) {
        assert (text.length() % 2 == 0);
        StringBuilder hexDecoded = new StringBuilder();
        int n = text.length() >> 1;
        for (int i = 0; i < n; i++) {
            int j = i * 2; //use i + i for speedup
            int c0 = text.charAt(j) - 'f';
            int c1 = text.charAt(j + 1) - 'f';
            int c2 = (c0 << 4) | c1;
            hexDecoded.append(Integer.toHexString(c2));
        }
        return "0x" + hexDecoded.toString();
    }

    public static String decodeFancy(String text) {
        System.out.println("Input Text: " + text);
        assert (text.length() % 2 == 0);
        StringBuilder hexDecoded = new StringBuilder();
        int n = text.length() >> 1;
        for (int i = 0; i < n; i++) {
            int j = i * 2; //use i + i for speedup
            int c0 = text.charAt(j) - 'f';
            int c1 = text.charAt(j + 1) - 'f';
            int c2 = (c0 << 4) | c1;
            hexDecoded.append(Integer.toHexString(c2)).append(" ");
        }
        return hexDecoded.toString();
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
