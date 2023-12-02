package com.google.android.gms.internal.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzaq extends zzat {
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaq(byte[] bArr, int i4, int i5) {
        super(bArr);
        zzaw.zzk(0, i5, bArr.length);
        this.zzc = i5;
    }

    @Override // com.google.android.gms.internal.wearable.zzat, com.google.android.gms.internal.wearable.zzaw
    public final byte zza(int i4) {
        int i5 = this.zzc;
        if (((i5 - (i4 + 1)) | i4) < 0) {
            if (i4 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + i5);
        }
        return this.zza[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.wearable.zzat, com.google.android.gms.internal.wearable.zzaw
    public final byte zzb(int i4) {
        return this.zza[i4];
    }

    @Override // com.google.android.gms.internal.wearable.zzat
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.wearable.zzat, com.google.android.gms.internal.wearable.zzaw
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.wearable.zzat, com.google.android.gms.internal.wearable.zzaw
    protected final void zze(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zza, 0, bArr, 0, i6);
    }
}
