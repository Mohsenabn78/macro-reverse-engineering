package com.android.dex;

/* loaded from: classes2.dex */
public final class DexFormat {
    public static final int API_CURRENT = 24;
    public static final int API_NO_EXTENDED_OPCODES = 13;
    public static final String DEX_IN_JAR_NAME = "classes.dex";
    public static final int ENDIAN_TAG = 305419896;
    public static final String MAGIC_PREFIX = "dex\n";
    public static final String MAGIC_SUFFIX = "\u0000";
    public static final int MAX_MEMBER_IDX = 65535;
    public static final int MAX_TYPE_IDX = 65535;
    public static final String VERSION_CURRENT = "037";
    public static final String VERSION_FOR_API_13 = "035";

    private DexFormat() {
    }

    public static String apiToMagic(int i4) {
        String str;
        if (i4 >= 24) {
            str = VERSION_CURRENT;
        } else {
            str = VERSION_FOR_API_13;
        }
        return MAGIC_PREFIX + str + MAGIC_SUFFIX;
    }

    public static boolean isSupportedDexMagic(byte[] bArr) {
        int magicToApi = magicToApi(bArr);
        if (magicToApi != 13 && magicToApi != 24) {
            return false;
        }
        return true;
    }

    public static int magicToApi(byte[] bArr) {
        if (bArr.length == 8 && bArr[0] == 100 && bArr[1] == 101 && bArr[2] == 120 && bArr[3] == 10 && bArr[7] == 0) {
            String str = "" + ((char) bArr[4]) + ((char) bArr[5]) + ((char) bArr[6]);
            if (str.equals(VERSION_CURRENT)) {
                return 24;
            }
            if (str.equals(VERSION_FOR_API_13)) {
                return 13;
            }
        }
        return -1;
    }
}
