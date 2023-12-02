package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcbz {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final boolean zzm;
    public final long zzn;
    public final long zzo;

    public zzcbz(String str) {
        String string;
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzbbm.zzJ);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzbbm.zzl);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzbbm.zzw);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzbbm.zzh);
        zzbbe zzbbeVar = zzbbm.zzg;
        if (jSONObject != null) {
            try {
                string = jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
            this.zze = string;
            this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbbm.zzi);
            this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbbm.zzj);
            this.zzh = zzb(jSONObject, "player_precache_limit", zzbbm.zzk);
            this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbbm.zzm);
            this.zzj = zza(jSONObject, "use_cache_data_source", zzbbm.zzdX);
            zzb(jSONObject, "min_retry_count", zzbbm.zzn);
            this.zzk = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbbm.zzq);
            this.zzl = zza(jSONObject, "enable_multiple_video_playback", zzbbm.zzbK);
            this.zzm = zza(jSONObject, "use_range_http_data_source", zzbbm.zzbM);
            this.zzn = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbbm.zzbN);
            this.zzo = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbbm.zzbO);
        }
        string = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbeVar);
        this.zze = string;
        this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbbm.zzi);
        this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbbm.zzj);
        this.zzh = zzb(jSONObject, "player_precache_limit", zzbbm.zzk);
        this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbbm.zzm);
        this.zzj = zza(jSONObject, "use_cache_data_source", zzbbm.zzdX);
        zzb(jSONObject, "min_retry_count", zzbbm.zzn);
        this.zzk = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbbm.zzq);
        this.zzl = zza(jSONObject, "enable_multiple_video_playback", zzbbm.zzbK);
        this.zzm = zza(jSONObject, "use_range_http_data_source", zzbbm.zzbM);
        this.zzn = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbbm.zzbN);
        this.zzo = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbbm.zzbO);
    }

    private static final boolean zza(JSONObject jSONObject, String str, zzbbe zzbbeVar) {
        boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbeVar)).booleanValue();
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
                return booleanValue;
            }
        }
        return booleanValue;
    }

    private static final int zzb(JSONObject jSONObject, String str, zzbbe zzbbeVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbeVar)).intValue();
    }

    private static final long zzc(JSONObject jSONObject, String str, zzbbe zzbbeVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException unused) {
            }
        }
        return ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbeVar)).longValue();
    }
}
