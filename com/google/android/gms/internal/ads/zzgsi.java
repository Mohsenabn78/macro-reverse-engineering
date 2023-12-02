package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgsi extends zzgsg {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* synthetic */ int zza(Object obj) {
        return ((zzgsh) obj).zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzgsh) obj).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzgpm zzgpmVar = (zzgpm) obj;
        zzgsh zzgshVar = zzgpmVar.zzc;
        if (zzgshVar == zzgsh.zzc()) {
            zzgsh zzf = zzgsh.zzf();
            zzgpmVar.zzc = zzf;
            return zzf;
        }
        return zzgshVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzgpm) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (!zzgsh.zzc().equals(obj2)) {
            if (zzgsh.zzc().equals(obj)) {
                return zzgsh.zze((zzgsh) obj, (zzgsh) obj2);
            }
            ((zzgsh) obj).zzd((zzgsh) obj2);
            return obj;
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgsg
    final /* synthetic */ Object zzf() {
        return zzgsh.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzgsg
    final /* synthetic */ Object zzg(Object obj) {
        ((zzgsh) obj).zzh();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgsg
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i4, int i5) {
        ((zzgsh) obj).zzj((i4 << 3) | 5, Integer.valueOf(i5));
    }

    @Override // com.google.android.gms.internal.ads.zzgsg
    final /* bridge */ /* synthetic */ void zzi(Object obj, int i4, long j4) {
        ((zzgsh) obj).zzj((i4 << 3) | 1, Long.valueOf(j4));
    }

    @Override // com.google.android.gms.internal.ads.zzgsg
    final /* bridge */ /* synthetic */ void zzj(Object obj, int i4, Object obj2) {
        ((zzgsh) obj).zzj((i4 << 3) | 3, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* bridge */ /* synthetic */ void zzk(Object obj, int i4, zzgoe zzgoeVar) {
        ((zzgsh) obj).zzj((i4 << 3) | 2, zzgoeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* bridge */ /* synthetic */ void zzl(Object obj, int i4, long j4) {
        ((zzgsh) obj).zzj(i4 << 3, Long.valueOf(j4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final void zzm(Object obj) {
        ((zzgpm) obj).zzc.zzh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzgpm) obj).zzc = (zzgsh) obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzgpm) obj).zzc = (zzgsh) obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final boolean zzq(zzgrh zzgrhVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgsg
    public final /* synthetic */ void zzr(Object obj, zzgou zzgouVar) throws IOException {
        ((zzgsh) obj).zzk(zzgouVar);
    }
}
