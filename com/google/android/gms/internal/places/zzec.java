package com.google.android.gms.internal.places;

/* loaded from: classes4.dex */
abstract class zzec {
    abstract int zzc(int i4, byte[] bArr, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzc(CharSequence charSequence, byte[] bArr, int i4, int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzf(byte[] bArr, int i4, int i5) {
        if (zzc(0, bArr, i4, i5) != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String zzh(byte[] bArr, int i4, int i5) throws zzbk;
}
