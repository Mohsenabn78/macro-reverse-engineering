package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
abstract class zzjr {
    abstract int zza(int i4, byte[] bArr, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb(byte[] bArr, int i4, int i5) {
        if (zza(0, bArr, i4, i5) != 0) {
            return false;
        }
        return true;
    }
}
