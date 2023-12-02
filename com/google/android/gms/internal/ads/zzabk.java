package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzabk implements zzaax {
    private final zzaax zza;

    public zzabk(zzaax zzaaxVar) {
        this.zza = zzaaxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaax, com.google.android.gms.internal.ads.zzt
    public final int zza(byte[] bArr, int i4, int i5) throws IOException {
        return this.zza.zza(bArr, i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final int zzb(byte[] bArr, int i4, int i5) throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final int zzc(int i4) throws IOException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public long zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public long zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public long zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzg(int i4) throws IOException {
        ((zzaam) this.zza).zzl(i4, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzh(byte[] bArr, int i4, int i5) throws IOException {
        ((zzaam) this.zza).zzm(bArr, i4, i5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzi(byte[] bArr, int i4, int i5) throws IOException {
        ((zzaam) this.zza).zzn(bArr, i4, i5, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzj() {
        this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzk(int i4) throws IOException {
        ((zzaam) this.zza).zzo(i4, false);
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final boolean zzm(byte[] bArr, int i4, int i5, boolean z3) throws IOException {
        return this.zza.zzm(bArr, 0, 8, true);
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final boolean zzn(byte[] bArr, int i4, int i5, boolean z3) throws IOException {
        return this.zza.zzn(bArr, 0, 8, true);
    }
}
