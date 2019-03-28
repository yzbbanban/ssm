package com.test.common.util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * Created by Lselie on 17/6/02.
 */
public class TextUtil {

    public static boolean endsWith(String source, String... ends) {
        for (String end : ends) {
            if (source.endsWith(end)) {
                return true;
            }
        }
        return false;
    }

    /**
     * hexString和base58check转码
     *
     * @param base58checkAddress
     * @return
     */
    public static String base58checkToHexString(String base58checkAddress) {
        String hexString = null;
        if (StringUtils.isNotEmpty(base58checkAddress)) {
            hexString = TronByteArray.toHexString(TronWalletApi.decodeFromBase58Check(base58checkAddress));
            return hexString;
        } else {
            throw new RuntimeException("Warning: base58checkAddress is empty !!");
        }
    }

    public static String hexStringTobase58check(String hexString) {
        String base58check = null;
        if (StringUtils.isNotEmpty(hexString)) {
            base58check = TronWalletApi.encode58Check(TronByteArray.fromHexString(hexString));
            return base58check;
        } else {
            throw new RuntimeException("Warning: base58checkAddress is empty !!");
        }
    }


    public static BigDecimal hexStringToBigDecimal(String s) {
        if (StringUtils.isNotBlank(s)) {
            return new BigDecimal("" + Long.parseLong(s, 16));
        }
        return null;
    }

    /**
     * 16进制转为字符串文字
     *
     * @param s 16进制数据
     * @return 字符串文字
     */
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    public static String strTo16(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            int ch = (int) s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = str + s4;
        }
        return str;
    }

    /**
     * Connect all into one String.
     */
    public static String x(Object... objects) {
        StringBuilder sb = new StringBuilder();
        for (Object object : objects) {
            sb.append(object);
        }
        return sb.toString();
    }

    /**
     * Connect all into one String.
     */
    public static String x(Separator separator, Object... objects) {
        if (objects == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object object : objects) {
            if (object == null) {
                return null;
            }
            sb.append(String.valueOf(object));
            sb.append(separator.separator);
        }
        if (sb.length() > separator.separator.length()) {
            return sb.toString().substring(0, sb.length() - separator.separator.length());
        } else {
            return sb.toString();
        }
    }


    public static String toCap(String s) {
        return StringUtils.capitalize(s.toLowerCase());
    }

    public enum Separator {

        Vertical("|"), Dot("."), Comma(","), DB_Comma("','"), Dash("-"), SLASH("/"), TAB2("\t\t"), WRAP("\n");

        private String separator;

        Separator(String separator) {
            this.separator = separator;
        }

        public String getSeparator() {
            return separator;
        }
    }

}
