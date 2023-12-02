package com.google.android.gms.nearby.messages.internal;

import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class zzc {

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f22464b = "0123456789abcdef".toCharArray();

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f22465a;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzc(byte[] bArr) {
        this.f22465a = bArr;
    }

    public static String zzb(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b4 : bArr) {
            char[] cArr = f22464b;
            sb.append(cArr[(b4 >> 4) & 15]);
            sb.append(cArr[b4 & Ascii.SI]);
        }
        return sb.toString();
    }

    public static byte[] zzd(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 + i4;
            bArr[i4] = (byte) ((Character.digit(str.charAt(i5), 16) << 4) + Character.digit(str.charAt(i5 + 1), 16));
        }
        return bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!obj.getClass().isAssignableFrom(getClass())) {
            return false;
        }
        return Arrays.equals(this.f22465a, ((zzc) obj).f22465a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f22465a);
    }

    public String toString() {
        return zzb(this.f22465a);
    }

    public final String zza() {
        return zzb(this.f22465a);
    }

    public final byte[] zzc() {
        return this.f22465a;
    }
}
