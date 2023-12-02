package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfon {
    public static String zza(String str) {
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            if (zze(str.charAt(i4))) {
                char[] charArray = str.toCharArray();
                while (i4 < length) {
                    char c4 = charArray[i4];
                    if (zze(c4)) {
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

    public static String zzb(String str) {
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            if (zzd(str.charAt(i4))) {
                char[] charArray = str.toCharArray();
                while (i4 < length) {
                    char c4 = charArray[i4];
                    if (zzd(c4)) {
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

    public static boolean zzc(CharSequence charSequence, CharSequence charSequence2) {
        int zzf;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = charSequence.charAt(i4);
            char charAt2 = charSequence2.charAt(i4);
            if (charAt != charAt2 && ((zzf = zzf(charAt)) >= 26 || zzf != zzf(charAt2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean zzd(char c4) {
        if (c4 >= 'a' && c4 <= 'z') {
            return true;
        }
        return false;
    }

    public static boolean zze(char c4) {
        if (c4 >= 'A' && c4 <= 'Z') {
            return true;
        }
        return false;
    }

    private static int zzf(char c4) {
        return (char) ((c4 | ' ') - 97);
    }
}
