package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgnx extends zzgoa {
    private final int zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgnx(byte[] bArr, int i4, int i5) {
        super(bArr);
        zzgoe.zzq(i4, i4 + i5, bArr.length);
        this.zzc = i4;
        this.zzd = i5;
    }

    @Override // com.google.android.gms.internal.ads.zzgoa, com.google.android.gms.internal.ads.zzgoe
    public final byte zza(int i4) {
        zzgoe.zzy(i4, this.zzd);
        return this.zza[this.zzc + i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgoa, com.google.android.gms.internal.ads.zzgoe
    public final byte zzb(int i4) {
        return this.zza[this.zzc + i4];
    }

    @Override // com.google.android.gms.internal.ads.zzgoa
    protected final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgoa, com.google.android.gms.internal.ads.zzgoe
    public final int zzd() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgoa, com.google.android.gms.internal.ads.zzgoe
    public final void zze(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zza, this.zzc + i4, bArr, i5, i6);
    }
}
