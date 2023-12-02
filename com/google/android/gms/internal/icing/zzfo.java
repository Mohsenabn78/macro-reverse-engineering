package com.google.android.gms.internal.icing;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
abstract class zzfo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(byte[] bArr, int i4, int i5) {
        if (zzb(0, bArr, 0, i5) != 0) {
            return false;
        }
        return true;
    }

    abstract int zzb(int i4, byte[] bArr, int i5, int i6);
}
