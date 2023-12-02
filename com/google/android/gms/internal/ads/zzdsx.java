package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import com.arlosoft.macrodroid.plugins.comments.PluginCommentsActivity;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdsx implements zzdtv, zzdsi {
    private final zzdtf zza;
    private final zzdtw zzb;
    private final zzdsj zzc;
    private final zzdss zzd;
    private final zzdsh zze;
    private final zzdtr zzf;
    private final String zzg;
    @Nullable
    private final String zzh;
    private JSONObject zzm;
    private boolean zzp;
    private int zzq;
    private boolean zzr;
    private final Map zzi = new HashMap();
    private final Map zzj = new HashMap();
    private final Map zzk = new HashMap();
    private String zzl = "{}";
    private long zzn = Long.MAX_VALUE;
    private zzdst zzo = zzdst.NONE;
    private zzdsw zzs = zzdsw.UNKNOWN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdsx(zzdtf zzdtfVar, zzdtw zzdtwVar, zzdsj zzdsjVar, Context context, zzbzx zzbzxVar, zzdss zzdssVar, zzdtr zzdtrVar, @Nullable String str) {
        this.zza = zzdtfVar;
        this.zzb = zzdtwVar;
        this.zzc = zzdsjVar;
        this.zze = new zzdsh(context);
        this.zzg = zzbzxVar.zza;
        this.zzh = str;
        this.zzd = zzdssVar;
        this.zzf = zzdtrVar;
        com.google.android.gms.ads.internal.zzt.zzs().zzg(this);
    }

    private final synchronized JSONObject zzq() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry entry : this.zzi.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (zzdsl zzdslVar : (List) entry.getValue()) {
                if (zzdslVar.zzg()) {
                    jSONArray.put(zzdslVar.zzd());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put((String) entry.getKey(), jSONArray);
            }
        }
        return jSONObject;
    }

    private final void zzr() {
        this.zzr = true;
        this.zzd.zzc();
        this.zza.zzh(this);
        this.zzb.zzc(this);
        this.zzc.zzc(this);
        this.zzf.zzf(this);
        zzx(com.google.android.gms.ads.internal.zzt.zzo().zzh().zzo());
    }

    private final void zzs() {
        com.google.android.gms.ads.internal.zzt.zzo().zzh().zzG(zzd());
    }

    private final synchronized void zzt(zzdst zzdstVar, boolean z3) {
        if (this.zzo == zzdstVar) {
            return;
        }
        if (zzo()) {
            zzv();
        }
        this.zzo = zzdstVar;
        if (zzo()) {
            zzw();
        }
        if (z3) {
            zzs();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x000b, B:11:0x001d, B:13:0x0027, B:18:0x0036, B:14:0x002b, B:16:0x0031), top: B:26:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized void zzu(boolean r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzp     // Catch: java.lang.Throwable -> L3d
            if (r0 != r2) goto L7
            monitor-exit(r1)
            return
        L7:
            r1.zzp = r2     // Catch: java.lang.Throwable -> L3d
            if (r2 == 0) goto L2b
            com.google.android.gms.internal.ads.zzbbe r2 = com.google.android.gms.internal.ads.zzbbm.zziJ     // Catch: java.lang.Throwable -> L3d
            com.google.android.gms.internal.ads.zzbbk r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r2 = r0.zzb(r2)     // Catch: java.lang.Throwable -> L3d
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L3d
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L3d
            if (r2 == 0) goto L27
            com.google.android.gms.ads.internal.util.zzaw r2 = com.google.android.gms.ads.internal.zzt.zzs()     // Catch: java.lang.Throwable -> L3d
            boolean r2 = r2.zzl()     // Catch: java.lang.Throwable -> L3d
            if (r2 != 0) goto L2b
        L27:
            r1.zzw()     // Catch: java.lang.Throwable -> L3d
            goto L34
        L2b:
            boolean r2 = r1.zzo()     // Catch: java.lang.Throwable -> L3d
            if (r2 != 0) goto L34
            r1.zzv()     // Catch: java.lang.Throwable -> L3d
        L34:
            if (r3 == 0) goto L3b
            r1.zzs()     // Catch: java.lang.Throwable -> L3d
            monitor-exit(r1)
            return
        L3b:
            monitor-exit(r1)
            return
        L3d:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsx.zzu(boolean, boolean):void");
    }

    private final synchronized void zzv() {
        zzdst zzdstVar = zzdst.NONE;
        int ordinal = this.zzo.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                return;
            }
            this.zzc.zza();
            return;
        }
        this.zzb.zza();
    }

    private final synchronized void zzw() {
        zzdst zzdstVar = zzdst.NONE;
        int ordinal = this.zzo.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                return;
            }
            this.zzc.zzb();
            return;
        }
        this.zzb.zzb();
    }

    private final synchronized void zzx(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzu(jSONObject.optBoolean("isTestMode", false), false);
            zzt((zzdst) Enum.valueOf(zzdst.class, jSONObject.optString("gesture", KeyPropertiesCompact.DIGEST_NONE)), false);
            this.zzl = jSONObject.optString("networkExtras", "{}");
            this.zzn = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
        } catch (JSONException unused) {
        }
    }

    public final zzdst zza() {
        return this.zzo;
    }

    public final synchronized zzfwm zzb(String str) {
        zzcaj zzcajVar;
        zzcajVar = new zzcaj();
        if (this.zzj.containsKey(str)) {
            zzcajVar.zzd((zzdsl) this.zzj.get(str));
        } else {
            if (!this.zzk.containsKey(str)) {
                this.zzk.put(str, new ArrayList());
            }
            ((List) this.zzk.get(str)).add(zzcajVar);
        }
        return zzcajVar;
    }

    public final synchronized String zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && zzo()) {
            if (this.zzn < com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() / 1000) {
                this.zzl = "{}";
                this.zzn = Long.MAX_VALUE;
                return "";
            } else if (this.zzl.equals("{}")) {
                return "";
            } else {
                return this.zzl;
            }
        }
        return "";
    }

    public final synchronized String zzd() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("isTestMode", this.zzp);
            jSONObject.put("gesture", this.zzo);
            if (this.zzn > com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() / 1000) {
                jSONObject.put("networkExtras", this.zzl);
                jSONObject.put("networkExtrasExpirationSecs", this.zzn);
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final synchronized JSONObject zze() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "ANDROID");
            if (!TextUtils.isEmpty(this.zzh)) {
                String str = this.zzh;
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "afma-sdk-a-v" + str);
            }
            jSONObject.put("internalSdkVersion", this.zzg);
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("adapters", this.zzd.zza());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziS)).booleanValue()) {
                String zzm = com.google.android.gms.ads.internal.zzt.zzo().zzm();
                if (!TextUtils.isEmpty(zzm)) {
                    jSONObject.put(PluginCommentsActivity.EXTRA_PLUGIN_DETAIL, zzm);
                }
            }
            if (this.zzn < com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() / 1000) {
                this.zzl = "{}";
            }
            jSONObject.put("networkExtras", this.zzl);
            jSONObject.put("adSlots", zzq());
            jSONObject.put("appInfo", this.zze.zza());
            String zzc = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzh().zzc();
            if (!TextUtils.isEmpty(zzc)) {
                jSONObject.put("cld", new JSONObject(zzc));
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziK)).booleanValue() && (jSONObject2 = this.zzm) != null) {
                String obj = jSONObject2.toString();
                zzbzr.zze("Server data: " + obj);
                jSONObject.put("serverData", this.zzm);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
                jSONObject.put("openAction", this.zzs);
                jSONObject.put("gesture", this.zzo);
            }
        } catch (JSONException e4) {
            com.google.android.gms.ads.internal.zzt.zzo().zzt(e4, "Inspector.toJson");
            zzbzr.zzk("Ad inspector encountered an error", e4);
        }
        return jSONObject;
    }

    public final synchronized void zzf(String str, zzdsl zzdslVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && zzo()) {
            if (this.zzq >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziw)).intValue()) {
                zzbzr.zzj("Maximum number of ad requests stored reached. Dropping the current request.");
                return;
            }
            if (!this.zzi.containsKey(str)) {
                this.zzi.put(str, new ArrayList());
            }
            this.zzq++;
            ((List) this.zzi.get(str)).add(zzdslVar);
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziQ)).booleanValue()) {
                return;
            }
            String zzc = zzdslVar.zzc();
            this.zzj.put(zzc, zzdslVar);
            if (this.zzk.containsKey(zzc)) {
                List<zzcaj> list = (List) this.zzk.get(zzc);
                for (zzcaj zzcajVar : list) {
                    zzcajVar.zzd(zzdslVar);
                }
                list.clear();
            }
        }
    }

    public final void zzg() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziJ)).booleanValue() && com.google.android.gms.ads.internal.zzt.zzo().zzh().zzO()) {
            zzr();
            return;
        }
        String zzo = com.google.android.gms.ads.internal.zzt.zzo().zzh().zzo();
        if (TextUtils.isEmpty(zzo)) {
            return;
        }
        try {
            if (new JSONObject(zzo).optBoolean("isTestMode", false)) {
                zzr();
            }
        } catch (JSONException unused) {
        }
    }

    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zzda zzdaVar, zzdsw zzdswVar) {
        if (!zzo()) {
            try {
                zzdaVar.zze(zzfbi.zzd(18, null, null));
                return;
            } catch (RemoteException unused) {
                zzbzr.zzj("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
                return;
            }
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
            try {
                zzdaVar.zze(zzfbi.zzd(1, null, null));
                return;
            } catch (RemoteException unused2) {
                zzbzr.zzj("Ad inspector had an internal error.");
                return;
            }
        }
        this.zzs = zzdswVar;
        this.zza.zzj(zzdaVar, new zzbjb(this), new zzbiu(this.zzf));
        return;
    }

    public final synchronized void zzi(String str, long j4) {
        this.zzl = str;
        this.zzn = j4;
        zzs();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000a, code lost:
        if (r2 != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzj(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.zzr
            if (r0 != 0) goto La
            if (r2 == 0) goto L15
            r1.zzr()
            goto Lc
        La:
            if (r2 == 0) goto L15
        Lc:
            boolean r2 = r1.zzp
            if (r2 == 0) goto L11
            goto L15
        L11:
            r1.zzw()
            return
        L15:
            boolean r2 = r1.zzo()
            if (r2 != 0) goto L1e
            r1.zzv()
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsx.zzj(boolean):void");
    }

    public final void zzk(zzdst zzdstVar) {
        zzt(zzdstVar, true);
    }

    public final synchronized void zzl(JSONObject jSONObject) {
        this.zzm = jSONObject;
    }

    public final void zzm(boolean z3) {
        if (!this.zzr && z3) {
            zzr();
        }
        zzu(z3, true);
    }

    public final boolean zzn() {
        if (this.zzm != null) {
            return true;
        }
        return false;
    }

    public final synchronized boolean zzo() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
            if (!this.zzp && !com.google.android.gms.ads.internal.zzt.zzs().zzl()) {
                return false;
            }
            return true;
        }
        return this.zzp;
    }

    public final synchronized boolean zzp() {
        return this.zzp;
    }
}
