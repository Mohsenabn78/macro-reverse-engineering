package com.google.android.gms.internal.measurement;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.webkit.ProxyConfig;
import com.google.firebase.firestore.util.ExponentialBackoff;
import org.altbeacon.beacon.service.scanner.CycledLeScanner;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzol implements zzok {
    public static final zzib zzA;
    public static final zzib zzB;
    public static final zzib zzC;
    public static final zzib zzD;
    public static final zzib zzE;
    public static final zzib zzF;
    public static final zzib zzG;
    public static final zzib zzH;
    public static final zzib zzI;
    public static final zzib zzJ;
    public static final zzib zzK;
    public static final zzib zzL;
    public static final zzib zzM;
    public static final zzib zzN;
    public static final zzib zzO;
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
    public static final zzib zzo;
    public static final zzib zzp;
    public static final zzib zzq;
    public static final zzib zzr;
    public static final zzib zzs;
    public static final zzib zzt;
    public static final zzib zzu;
    public static final zzib zzv;
    public static final zzib zzw;
    public static final zzib zzx;
    public static final zzib zzy;
    public static final zzib zzz;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzd("measurement.ad_id_cache_time", 10000L);
        zzb = zza2.zzd("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L);
        zzc = zza2.zzd("measurement.max_bundles_per_iteration", 100L);
        zzd = zza2.zzd("measurement.config.cache_time", 86400000L);
        zze = zza2.zze("measurement.log_tag", "FA");
        zzf = zza2.zze("measurement.config.url_authority", "app-measurement.com");
        zzg = zza2.zze("measurement.config.url_scheme", ProxyConfig.MATCH_HTTPS);
        zzh = zza2.zzd("measurement.upload.debug_upload_interval", 1000L);
        zzi = zza2.zzd("measurement.lifetimevalue.max_currency_tracked", 4L);
        zzj = zza2.zzd("measurement.store.max_stored_events_per_app", 100000L);
        zzk = zza2.zzd("measurement.experiment.max_ids", 50L);
        zzl = zza2.zzd("measurement.audience.filter_result_max_count", 200L);
        zzm = zza2.zzd("measurement.upload.max_item_scoped_custom_parameters", 27L);
        zzn = zza2.zzd("measurement.alarm_manager.minimum_interval", ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
        zzo = zza2.zzd("measurement.upload.minimum_delay", 500L);
        zzp = zza2.zzd("measurement.monitoring.sample_period_millis", 86400000L);
        zzq = zza2.zzd("measurement.upload.realtime_upload_interval", 10000L);
        zzr = zza2.zzd("measurement.upload.refresh_blacklisted_config_interval", 604800000L);
        zzs = zza2.zzd("measurement.config.cache_time.service", 3600000L);
        zzt = zza2.zzd("measurement.service_client.idle_disconnect_millis", 5000L);
        zzu = zza2.zze("measurement.log_tag.service", "FA-SVC");
        zzv = zza2.zzd("measurement.upload.stale_data_deletion_interval", 86400000L);
        zzw = zza2.zzd("measurement.sdk.attribution.cache.ttl", 604800000L);
        zzx = zza2.zzd("measurement.redaction.app_instance_id.ttl", 7200000L);
        zzy = zza2.zzd("measurement.upload.backoff_period", 43200000L);
        zzz = zza2.zzd("measurement.upload.initial_upload_delay_time", 15000L);
        zzA = zza2.zzd("measurement.upload.interval", 3600000L);
        zzB = zza2.zzd("measurement.upload.max_bundle_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzC = zza2.zzd("measurement.upload.max_bundles", 100L);
        zzD = zza2.zzd("measurement.upload.max_conversions_per_day", 500L);
        zzE = zza2.zzd("measurement.upload.max_error_events_per_day", 1000L);
        zzF = zza2.zzd("measurement.upload.max_events_per_bundle", 1000L);
        zzG = zza2.zzd("measurement.upload.max_events_per_day", 100000L);
        zzH = zza2.zzd("measurement.upload.max_public_events_per_day", 50000L);
        zzI = zza2.zzd("measurement.upload.max_queue_time", 2419200000L);
        zzJ = zza2.zzd("measurement.upload.max_realtime_events_per_day", 10L);
        zzK = zza2.zzd("measurement.upload.max_batch_size", PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzL = zza2.zzd("measurement.upload.retry_count", 6L);
        zzM = zza2.zzd("measurement.upload.retry_time", CycledLeScanner.ANDROID_N_MAX_SCAN_DURATION_MILLIS);
        zzN = zza2.zze("measurement.upload.url", "https://app-measurement.com/a");
        zzO = zza2.zzd("measurement.upload.window_interval", 3600000L);
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzA() {
        return ((Long) zzF.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzB() {
        return ((Long) zzG.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzC() {
        return ((Long) zzH.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzD() {
        return ((Long) zzI.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzE() {
        return ((Long) zzJ.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzF() {
        return ((Long) zzK.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzG() {
        return ((Long) zzL.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzH() {
        return ((Long) zzM.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzI() {
        return ((Long) zzO.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final String zzJ() {
        return (String) zzf.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final String zzK() {
        return (String) zzg.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final String zzL() {
        return (String) zzN.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zza() {
        return ((Long) zza.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzb() {
        return ((Long) zzb.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzc() {
        return ((Long) zzc.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzd() {
        return ((Long) zzd.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zze() {
        return ((Long) zzh.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzf() {
        return ((Long) zzi.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzg() {
        return ((Long) zzj.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzh() {
        return ((Long) zzk.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzi() {
        return ((Long) zzl.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzj() {
        return ((Long) zzm.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzk() {
        return ((Long) zzn.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzl() {
        return ((Long) zzo.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzm() {
        return ((Long) zzp.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzn() {
        return ((Long) zzq.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzo() {
        return ((Long) zzr.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzp() {
        return ((Long) zzt.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzq() {
        return ((Long) zzv.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzr() {
        return ((Long) zzw.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzs() {
        return ((Long) zzx.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzt() {
        return ((Long) zzy.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzu() {
        return ((Long) zzz.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzv() {
        return ((Long) zzA.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzw() {
        return ((Long) zzB.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzx() {
        return ((Long) zzC.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzy() {
        return ((Long) zzD.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzok
    public final long zzz() {
        return ((Long) zzE.zzb()).longValue();
    }
}
