package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
final class zznm extends zznk {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznk
    public final /* synthetic */ int zza(Object obj) {
        return ((zznl) obj).zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznk
    public final /* synthetic */ int zzb(Object obj) {
        return ((zznl) obj).zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznk
    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzlb zzlbVar = (zzlb) obj;
        zznl zznlVar = zzlbVar.zzc;
        if (zznlVar == zznl.zzc()) {
            zznl zzf = zznl.zzf();
            zzlbVar.zzc = zzf;
            return zzf;
        }
        return zznlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznk
    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzlb) obj).zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznk
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (!zznl.zzc().equals(obj2)) {
            if (zznl.zzc().equals(obj)) {
                return zznl.zze((zznl) obj, (zznl) obj2);
            }
            ((zznl) obj).zzd((zznl) obj2);
            return obj;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznk
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i4, long j4) {
        ((zznl) obj).zzj(i4 << 3, Long.valueOf(j4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznk
    public final void zzg(Object obj) {
        ((zzlb) obj).zzc.zzh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznk
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzlb) obj).zzc = (zznl) obj2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zznk
    public final /* synthetic */ void zzi(Object obj, zzoc zzocVar) throws IOException {
        ((zznl) obj).zzk(zzocVar);
    }
}
