package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzpm implements zzpl {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;
    public static final zzib zzd;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.client.global_params", true);
        zzb = zza2.zzf("measurement.service.global_params_in_payload", true);
        zzc = zza2.zzf("measurement.service.clear_global_params_on_uninstall", true);
        zzd = zza2.zzf("measurement.service.global_params", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpl
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpl
    public final boolean zzb() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
