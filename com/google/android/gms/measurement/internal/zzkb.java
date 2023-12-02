package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzkb extends zzku {

    /* renamed from: d  reason: collision with root package name */
    private final Map f21986d;
    public final zzfe zza;
    public final zzfe zzb;
    public final zzfe zzc;
    public final zzfe zzd;
    public final zzfe zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkb(zzlh zzlhVar) {
        super(zzlhVar);
        this.f21986d = new HashMap();
        zzfi zzm = this.f21734a.zzm();
        zzm.getClass();
        this.zza = new zzfe(zzm, "last_delete_stale", 0L);
        zzfi zzm2 = this.f21734a.zzm();
        zzm2.getClass();
        this.zzb = new zzfe(zzm2, "backoff", 0L);
        zzfi zzm3 = this.f21734a.zzm();
        zzm3.getClass();
        this.zzc = new zzfe(zzm3, "last_upload", 0L);
        zzfi zzm4 = this.f21734a.zzm();
        zzm4.getClass();
        this.zzd = new zzfe(zzm4, "last_upload_attempt", 0L);
        zzfi zzm5 = this.f21734a.zzm();
        zzm5.getClass();
        this.zze = new zzfe(zzm5, "midnight_offset", 0L);
    }

    @Override // com.google.android.gms.measurement.internal.zzku
    protected final boolean c() {
        return false;
    }

    @WorkerThread
    @Deprecated
    final Pair d(String str) {
        zzka zzkaVar;
        AdvertisingIdClient.Info info;
        zzg();
        long elapsedRealtime = this.f21734a.zzax().elapsedRealtime();
        zzka zzkaVar2 = (zzka) this.f21986d.get(str);
        if (zzkaVar2 != null && elapsedRealtime < zzkaVar2.f21985c) {
            return new Pair(zzkaVar2.f21983a, Boolean.valueOf(zzkaVar2.f21984b));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzi = this.f21734a.zzf().zzi(str, zzeg.zza) + elapsedRealtime;
        try {
            long zzi2 = this.f21734a.zzf().zzi(str, zzeg.zzb);
            if (zzi2 > 0) {
                try {
                    info = AdvertisingIdClient.getAdvertisingIdInfo(this.f21734a.zzaw());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (zzkaVar2 != null && elapsedRealtime < zzkaVar2.f21985c + zzi2) {
                        return new Pair(zzkaVar2.f21983a, Boolean.valueOf(zzkaVar2.f21984b));
                    }
                    info = null;
                }
            } else {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.f21734a.zzaw());
            }
        } catch (Exception e4) {
            this.f21734a.zzaA().zzc().zzb("Unable to get advertising id", e4);
            zzkaVar = new zzka("", false, zzi);
        }
        if (info == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String id = info.getId();
        if (id != null) {
            zzkaVar = new zzka(id, info.isLimitAdTrackingEnabled(), zzi);
        } else {
            zzkaVar = new zzka("", info.isLimitAdTrackingEnabled(), zzi);
        }
        this.f21986d.put(str, zzkaVar);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(zzkaVar.f21983a, Boolean.valueOf(zzkaVar.f21984b));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final Pair e(String str, zzhb zzhbVar) {
        if (zzhbVar.zzj(zzha.AD_STORAGE)) {
            return d(str);
        }
        return new Pair("", Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    @Deprecated
    public final String f(String str, boolean z3) {
        String str2;
        zzg();
        if (z3) {
            str2 = (String) d(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest g4 = zzlp.g();
        if (g4 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, g4.digest(str2.getBytes())));
    }
}
