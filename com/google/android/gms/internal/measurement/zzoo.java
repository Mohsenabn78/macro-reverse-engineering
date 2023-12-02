package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzoo implements zzon {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;
    public static final zzib zzd;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.client.consent_state_v1", true);
        zzb = zza2.zzf("measurement.client.3p_consent_state_v1", true);
        zzc = zza2.zzf("measurement.service.consent_state_v1_W36", true);
        zzd = zza2.zzd("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final long zza() {
        return ((Long) zzd.zzb()).longValue();
    }
}
