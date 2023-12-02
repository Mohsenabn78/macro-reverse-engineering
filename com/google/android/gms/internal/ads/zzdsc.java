package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdsc {
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdnv zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdqj zzl;
    private final zzbzx zzm;
    private final zzdbx zzo;
    private final zzfgb zzp;
    private boolean zza = false;
    private boolean zzb = false;
    @GuardedBy("this")
    private boolean zzc = false;
    private final zzcaj zze = new zzcaj();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;
    private final long zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();

    public zzdsc(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdnv zzdnvVar, ScheduledExecutorService scheduledExecutorService, zzdqj zzdqjVar, zzbzx zzbzxVar, zzdbx zzdbxVar, zzfgb zzfgbVar) {
        this.zzh = zzdnvVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdqjVar;
        this.zzm = zzbzxVar;
        this.zzo = zzdbxVar;
        this.zzp = zzfgbVar;
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzj(final zzdsc zzdscVar, String str) {
        int i4 = 5;
        final zzffn zza = zzffm.zza(zzdscVar.zzf, 5);
        zza.zzh();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                final String next = keys.next();
                final zzffn zza2 = zzffm.zza(zzdscVar.zzf, i4);
                zza2.zzh();
                zza2.zzd(next);
                final Object obj = new Object();
                final zzcaj zzcajVar = new zzcaj();
                zzfwm zzn = zzfwc.zzn(zzcajVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbH)).longValue(), TimeUnit.SECONDS, zzdscVar.zzk);
                zzdscVar.zzl.zzc(next);
                zzdscVar.zzo.zzc(next);
                final long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                zzn.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrt
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdsc.this.zzq(obj, zzcajVar, next, elapsedRealtime, zza2);
                    }
                }, zzdscVar.zzi);
                arrayList.add(zzn);
                final zzdsb zzdsbVar = new zzdsb(zzdscVar, obj, next, elapsedRealtime, zza2, zzcajVar);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        int i5 = 0;
                        while (i5 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzbkp(optString, bundle));
                            i5++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdscVar.zzv(next, false, "", 0);
                try {
                    try {
                        final zzfbd zzc = zzdscVar.zzh.zzc(next, new JSONObject());
                        zzdscVar.zzj.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrx
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzdsc.this.zzn(zzc, zzdsbVar, arrayList2, next);
                            }
                        });
                    } catch (zzfan unused2) {
                        zzdsbVar.zze("Failed to create Adapter.");
                    }
                } catch (RemoteException e4) {
                    zzbzr.zzh("", e4);
                }
                i4 = 5;
            }
            zzfwc.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdru
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdsc.this.zzf(zza);
                    return null;
                }
            }, zzdscVar.zzi);
        } catch (JSONException e5) {
            com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e5);
            zzdscVar.zzo.zza("MalformedJson");
            zzdscVar.zzl.zza("MalformedJson");
            zzdscVar.zze.zze(e5);
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e5, "AdapterInitializer.updateAdapterStatus");
            zzfgb zzfgbVar = zzdscVar.zzp;
            zza.zzg(e5);
            zza.zzf(false);
            zzfgbVar.zzb(zza.zzl());
        }
    }

    private final synchronized zzfwm zzu() {
        String zzc = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zzc();
        if (!TextUtils.isEmpty(zzc)) {
            return zzfwc.zzh(zzc);
        }
        final zzcaj zzcajVar = new zzcaj();
        com.google.android.gms.ads.internal.zzt.zzo().zzh().zzq(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdry
            @Override // java.lang.Runnable
            public final void run() {
                zzdsc.this.zzo(zzcajVar);
            }
        });
        return zzcajVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv(String str, boolean z3, String str2, int i4) {
        this.zzn.put(str, new zzbkf(str, z3, i4, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zzf(zzffn zzffnVar) throws Exception {
        this.zze.zzd(Boolean.TRUE);
        zzfgb zzfgbVar = this.zzp;
        zzffnVar.zzf(true);
        zzfgbVar.zzb(zzffnVar.zzl());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzbkf zzbkfVar = (zzbkf) this.zzn.get(str);
            arrayList.add(new zzbkf(str, zzbkfVar.zzb, zzbkfVar.zzc, zzbkfVar.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        synchronized (this) {
            if (this.zzc) {
                return;
            }
            zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzd));
            this.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            this.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            this.zze.zze(new Exception());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(zzfbd zzfbdVar, zzbkj zzbkjVar, List list, String str) {
        try {
            try {
                Context context = (Context) this.zzg.get();
                if (context == null) {
                    context = this.zzf;
                }
                zzfbdVar.zzi(context, zzbkjVar, list);
            } catch (RemoteException e4) {
                zzbzr.zzh("", e4);
            }
        } catch (zzfan unused) {
            zzbkjVar.zze("Failed to initialize adapter. " + str + " does not implement the initialize() method.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(final zzcaj zzcajVar) {
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrr
            @Override // java.lang.Runnable
            public final void run() {
                zzcaj zzcajVar2 = zzcajVar;
                String zzc = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zzc();
                if (!TextUtils.isEmpty(zzc)) {
                    zzcajVar2.zzd(zzc);
                } else {
                    zzcajVar2.zze(new Exception());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Object obj, zzcaj zzcajVar, String str, long j4, zzffn zzffnVar) {
        synchronized (obj) {
            if (!zzcajVar.isDone()) {
                zzv(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - j4));
                this.zzl.zzb(str, "timeout");
                this.zzo.zzb(str, "timeout");
                zzfgb zzfgbVar = this.zzp;
                zzffnVar.zzc("Timeout");
                zzffnVar.zzf(false);
                zzfgbVar.zzb(zzffnVar.zzl());
                zzcajVar.zzd(Boolean.FALSE);
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbdk.zza.zze()).booleanValue()) {
            if (this.zzm.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbG)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    if (this.zza) {
                        return;
                    }
                    this.zzl.zzf();
                    this.zzo.zzf();
                    this.zze.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrs
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdsc.this.zzp();
                        }
                    }, this.zzi);
                    this.zza = true;
                    zzfwm zzu = zzu();
                    this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrv
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdsc.this.zzm();
                        }
                    }, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbI)).longValue(), TimeUnit.SECONDS);
                    zzfwc.zzq(zzu, new zzdsa(this), this.zzi);
                    return;
                }
            }
        }
        if (!this.zza) {
            zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zze.zzd(Boolean.FALSE);
            this.zza = true;
            this.zzb = true;
        }
    }

    public final void zzs(final zzbkm zzbkmVar) {
        this.zze.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdrw
            @Override // java.lang.Runnable
            public final void run() {
                zzdsc zzdscVar = zzdsc.this;
                try {
                    zzbkmVar.zzb(zzdscVar.zzg());
                } catch (RemoteException e4) {
                    zzbzr.zzh("", e4);
                }
            }
        }, this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
