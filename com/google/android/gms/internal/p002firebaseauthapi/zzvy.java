package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvy  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzvy {
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
