package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgmz {
    public static String zza(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b4 : bArr) {
            int i4 = b4 & 255;
            sb.append("0123456789abcdef".charAt(i4 >> 4));
            sb.append("0123456789abcdef".charAt(i4 & 15));
        }
        return sb.toString();
    }
}
