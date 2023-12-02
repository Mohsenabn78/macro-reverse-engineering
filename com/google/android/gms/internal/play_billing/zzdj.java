package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
final class zzdj implements zzdp {
    private final zzdf zza;
    private final zzeg zzb;
    private final boolean zzc;
    private final zzbo zzd;

    private zzdj(zzeg zzegVar, zzbo zzboVar, zzdf zzdfVar) {
        this.zzb = zzegVar;
        this.zzc = zzboVar.zzc(zzdfVar);
        this.zzd = zzboVar;
        this.zza = zzdfVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdj zzc(zzeg zzegVar, zzbo zzboVar, zzdf zzdfVar) {
        return new zzdj(zzegVar, zzboVar, zzdfVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final int zza(Object obj) {
        zzeg zzegVar = this.zzb;
        int zzb = zzegVar.zzb(zzegVar.zzd(obj));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final Object zze() {
        zzdf zzdfVar = this.zza;
        if (zzdfVar instanceof zzcb) {
            return ((zzcb) zzdfVar).zzh();
        }
        return zzdfVar.zzj().zze();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzg(Object obj, Object obj2) {
        zzdr.zzC(this.zzb, obj, obj2);
        if (!this.zzc) {
            return;
        }
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzh(Object obj, byte[] bArr, int i4, int i5, zzan zzanVar) throws IOException {
        zzcb zzcbVar = (zzcb) obj;
        if (zzcbVar.zzc == zzeh.zzc()) {
            zzcbVar.zzc = zzeh.zzf();
        }
        zzby zzbyVar = (zzby) obj;
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzi(Object obj, zzey zzeyVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
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

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
