package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
abstract class zzes {
    abstract int zza(int i4, byte[] bArr, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb(byte[] bArr, int i4, int i5) {
        if (zza(0, bArr, i4, i5) != 0) {
            return false;
        }
        return true;
    }
}
