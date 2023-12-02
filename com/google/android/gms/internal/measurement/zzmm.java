package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
final class zzmm implements zzmt {
    private final zzmi zza;
    private final zznk zzb;
    private final boolean zzc;
    private final zzko zzd;

    private zzmm(zznk zznkVar, zzko zzkoVar, zzmi zzmiVar) {
        this.zzb = zznkVar;
        this.zzc = zzkoVar.zzc(zzmiVar);
        this.zzd = zzkoVar;
        this.zza = zzmiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzmm zzc(zznk zznkVar, zzko zzkoVar, zzmi zzmiVar) {
        return new zzmm(zznkVar, zzkoVar, zzmiVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final int zza(Object obj) {
        zznk zznkVar = this.zzb;
        int zzb = zznkVar.zzb(zznkVar.zzd(obj));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final Object zze() {
        zzmi zzmiVar = this.zza;
        if (zzmiVar instanceof zzlb) {
            return ((zzlb) zzmiVar).zzbD();
        }
        return zzmiVar.zzbJ().zzaF();
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final void zzg(Object obj, Object obj2) {
        zzmv.zzB(this.zzb, obj, obj2);
        if (!this.zzc) {
            return;
        }
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final void zzh(Object obj, byte[] bArr, int i4, int i5, zzjn zzjnVar) throws IOException {
        zzlb zzlbVar = (zzlb) obj;
        if (zzlbVar.zzc == zznl.zzc()) {
            zzlbVar.zzc = zznl.zzf();
        }
        zzky zzkyVar = (zzky) obj;
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final void zzi(Object obj, zzoc zzocVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzmt
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
