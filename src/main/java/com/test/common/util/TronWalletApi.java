package com.test.common.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.bitcoinj.core.Sha256Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TronWalletApi {
    public final static Logger logger = LoggerFactory.getLogger(TronWalletApi.class);

    private static byte addressPreFixByte = TronParameter.CommonConstant.ADD_PRE_FIX_BYTE_MAINNET;

    public static byte[] decodeFromBase58Check(String addressBase58) {
        if (StringUtils.isEmpty(addressBase58)) {
            logger.warn("Warning: Address is empty !!");
            return null;
        }
        byte[] address = decode58Check(addressBase58);
        if (!addressValid(address)) {
            return null;
        }
        return address;
    }

    private static byte[] decode58Check(String input) {
        byte[] decodeCheck = TronBase58.decode(input);
        if (decodeCheck.length <= 4) {
            return null;
        }
        byte[] decodeData = new byte[decodeCheck.length - 4];
        System.arraycopy(decodeCheck, 0, decodeData, 0, decodeData.length);
        byte[] hash0 = TronSha256Hash.hash(decodeData);
        byte[] hash1 = TronSha256Hash.hash(hash0);
        if (hash1[0] == decodeCheck[decodeData.length] &&
                hash1[1] == decodeCheck[decodeData.length + 1] &&
                hash1[2] == decodeCheck[decodeData.length + 2] &&
                hash1[3] == decodeCheck[decodeData.length + 3]) {
            return decodeData;
        }
        return null;
    }

    public static boolean addressValid(byte[] address) {
        if (ArrayUtils.isEmpty(address)) {
            logger.warn("Warning: Address is empty !!");
            return false;
        }
        if (address.length != TronParameter.CommonConstant.ADDRESS_SIZE) {
            logger.warn(
                    "Warning: Address length need " + TronParameter.CommonConstant.ADDRESS_SIZE + " but " + address.length
                            + " !!");
            return false;
        }
        byte preFixbyte = address[0];
        if (preFixbyte != TronWalletApi.getAddressPreFixByte()) {
            logger
                    .warn("Warning: Address need prefix with " + TronWalletApi.getAddressPreFixByte() + " but "
                            + preFixbyte + " !!");
            return false;
        }
        //Other rule;
        return true;
    }

    public static String encode58Check(byte[] input) {
        byte[] hash0 = Sha256Hash.hash(input);
        byte[] hash1 = Sha256Hash.hash(hash0);
        byte[] inputCheck = new byte[input.length + 4];
        System.arraycopy(input, 0, inputCheck, 0, input.length);
        System.arraycopy(hash1, 0, inputCheck, input.length, 4);
        return TronBase58.encode(inputCheck);
    }

    public static byte getAddressPreFixByte() {
        return addressPreFixByte;
    }
}
