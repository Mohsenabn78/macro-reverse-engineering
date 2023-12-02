package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzqb implements zzqa {
    public static final zzib zza;
    public static final zzib zzb;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.collection.client.log_target_api_version", true);
        zzb = zza2.zzf("measurement.collection.service.log_target_api_version", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqa
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzqa
    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqa
    public final boolean zzc() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }
}
