package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzqn implements zzqm {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;
    public static final zzib zzd;
    public static final zzib zze;
    public static final zzib zzf;
    public static final zzib zzg;
    public static final zzib zzh;
    public static final zzib zzi;
    public static final zzib zzj;
    public static final zzib zzk;
    public static final zzib zzl;
    public static final zzib zzm;
    public static final zzib zzn;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.redaction.app_instance_id", true);
        zzb = zza2.zzf("measurement.redaction.client_ephemeral_aiid_generation", true);
        zzc = zza2.zzf("measurement.redaction.config_redacted_fields", true);
        zzd = zza2.zzf("measurement.redaction.device_info", true);
        zze = zza2.zzf("measurement.redaction.e_tag", true);
        zzf = zza2.zzf("measurement.redaction.enhanced_uid", true);
        zzg = zza2.zzf("measurement.redaction.populate_ephemeral_app_instance_id", true);
        zzh = zza2.zzf("measurement.redaction.google_signals", true);
        zzi = zza2.zzf("measurement.redaction.no_aiid_in_config_request", true);
        zzj = zza2.zzf("measurement.redaction.retain_major_os_version", true);
        zzk = zza2.zzf("measurement.redaction.scion_payload_generator", true);
        zzl = zza2.zzf("measurement.redaction.upload_redacted_fields", true);
        zzm = zza2.zzf("measurement.redaction.upload_subdomain_override", true);
        zzn = zza2.zzf("measurement.redaction.user_id", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final boolean zza() {
        return ((Boolean) zzj.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzb() {
        return ((Boolean) zzk.zzb()).booleanValue();
    }
}
