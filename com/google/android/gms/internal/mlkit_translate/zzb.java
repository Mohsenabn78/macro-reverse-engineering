package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzb {
    public static String zza(String str) {
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            if (zzb(str.charAt(i4))) {
                char[] charArray = str.toCharArray();
                while (i4 < length) {
                    char c4 = charArray[i4];
                    if (zzb(c4)) {
                        charArray[i4] = (char) (c4 ^ ' ');
                    }
                    i4++;
                }
                return String.valueOf(charArray);
            }
            i4++;
        }
        return str;
    }

    public static boolean zzb(char c4) {
        if (c4 >= 'A' && c4 <= 'Z') {
            return true;
        }
        return false;
    }
}
