package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzqz implements zzqy {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;
    public static final zzib zzd;
    public static final zzib zze;
    public static final zzib zzf;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.client.sessions.background_sessions_enabled", true);
        zzb = zza2.zzf("measurement.client.sessions.enable_fix_background_engagement", false);
        zzc = zza2.zzf("measurement.client.sessions.immediate_start_enabled_foreground", true);
        zzd = zza2.zzf("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        zze = zza2.zzf("measurement.client.sessions.session_id_enabled", true);
        zzf = zza2.zzd("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzqy
    public final boolean zza() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }
}
