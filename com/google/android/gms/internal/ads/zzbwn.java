package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbwn implements zzbws {
    public static final /* synthetic */ int zzb = 0;
    private static final List zzc = Collections.synchronizedList(new ArrayList());
    @VisibleForTesting
    boolean zza;
    private final zzgtl zzd;
    private final LinkedHashMap zze;
    private final Context zzh;
    private final zzbwp zzi;
    private final zzbwo zzn;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzbwn(Context context, zzbzx zzbzxVar, zzbwp zzbwpVar, @Nullable String str, zzbwo zzbwoVar) {
        Preconditions.checkNotNull(zzbwpVar, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzn = zzbwoVar;
        this.zzi = zzbwpVar;
        for (String str2 : zzbwpVar.zze) {
            this.zzk.add(str2.toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzgtl zza = zzgva.zza();
        zza.zzn(9);
        zza.zzj(str);
        zza.zzh(str);
        zzgtm zza2 = zzgtn.zza();
        String str3 = this.zzi.zza;
        if (str3 != null) {
            zza2.zza(str3);
        }
        zza.zzg((zzgtn) zza2.zzal());
        zzguu zza3 = zzguv.zza();
        zza3.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str4 = zzbzxVar.zza;
        if (str4 != null) {
            zza3.zza(str4);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zza3.zzb(apkVersion);
        }
        zza.zzf((zzguv) zza3.zzal());
        this.zzd = zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final zzbwp zza() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(Map map) throws Exception {
        zzgus zzgusVar;
        zzfwm zzl;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.zzj) {
                            int length = optJSONArray.length();
                            synchronized (this.zzj) {
                                zzgusVar = (zzgus) this.zze.get(str);
                            }
                            if (zzgusVar == null) {
                                zzbwr.zza("Cannot find the corresponding resource object for " + str);
                            } else {
                                boolean z3 = false;
                                for (int i4 = 0; i4 < length; i4++) {
                                    zzgusVar.zza(optJSONArray.getJSONObject(i4).getString("threat_type"));
                                }
                                boolean z4 = this.zza;
                                if (length > 0) {
                                    z3 = true;
                                }
                                this.zza = z3 | z4;
                            }
                        }
                    }
                }
            } catch (JSONException e4) {
                if (((Boolean) zzbdm.zzb.zze()).booleanValue()) {
                    zzbzr.zzf("Failed to get SafeBrowsing metadata", e4);
                }
                return zzfwc.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zza) {
            synchronized (this.zzj) {
                this.zzd.zzn(10);
            }
        }
        boolean z5 = this.zza;
        if ((z5 && this.zzi.zzg) || ((this.zzm && this.zzi.zzf) || (!z5 && this.zzi.zzd))) {
            synchronized (this.zzj) {
                for (zzgus zzgusVar2 : this.zze.values()) {
                    this.zzd.zzc((zzgut) zzgusVar2.zzal());
                }
                this.zzd.zza(this.zzf);
                this.zzd.zzb(this.zzg);
                if (zzbwr.zzb()) {
                    String zzl2 = this.zzd.zzl();
                    String zzk = this.zzd.zzk();
                    StringBuilder sb = new StringBuilder("Sending SB report\n  url: " + zzl2 + "\n  clickUrl: " + zzk + "\n  resources: \n");
                    for (zzgut zzgutVar : this.zzd.zzm()) {
                        sb.append("    [");
                        sb.append(zzgutVar.zza());
                        sb.append("] ");
                        sb.append(zzgutVar.zze());
                    }
                    zzbwr.zza(sb.toString());
                }
                byte[] zzax = ((zzgva) this.zzd.zzal()).zzax();
                zzfwm zzb2 = new com.google.android.gms.ads.internal.util.zzbo(this.zzh).zzb(1, this.zzi.zzb, null, zzax);
                if (zzbwr.zzb()) {
                    zzb2.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbwi
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzbwr.zza("Pinged SB successfully.");
                        }
                    }, zzcae.zza);
                }
                zzl = zzfwc.zzl(zzb2, new zzfov() { // from class: com.google.android.gms.internal.ads.zzbwj
                    @Override // com.google.android.gms.internal.ads.zzfov
                    public final Object apply(Object obj) {
                        String str2 = (String) obj;
                        int i5 = zzbwn.zzb;
                        return null;
                    }
                }, zzcae.zzf);
            }
            return zzl;
        }
        return zzfwc.zzh(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzd(String str, Map map, int i4) {
        String str2;
        String str3;
        synchronized (this.zzj) {
            if (i4 == 3) {
                this.zzm = true;
            }
            if (this.zze.containsKey(str)) {
                if (i4 == 3) {
                    ((zzgus) this.zze.get(str)).zze(4);
                }
                return;
            }
            zzgus zzc2 = zzgut.zzc();
            int zza = zzgur.zza(i4);
            if (zza != 0) {
                zzc2.zze(zza);
            }
            zzc2.zzb(this.zze.size());
            zzc2.zzd(str);
            zzgty zza2 = zzgub.zza();
            if (!this.zzk.isEmpty() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (entry.getKey() != null) {
                        str2 = (String) entry.getKey();
                    } else {
                        str2 = "";
                    }
                    if (entry.getValue() != null) {
                        str3 = (String) entry.getValue();
                    } else {
                        str3 = "";
                    }
                    if (this.zzk.contains(str2.toLowerCase(Locale.ENGLISH))) {
                        zzgtw zza3 = zzgtx.zza();
                        zza3.zza(zzgoe.zzw(str2));
                        zza3.zzb(zzgoe.zzw(str3));
                        zza2.zza((zzgtx) zza3.zzal());
                    }
                }
            }
            zzc2.zzc((zzgub) zza2.zzal());
            this.zze.put(str, zzc2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zze() {
        synchronized (this.zzj) {
            this.zze.keySet();
            zzfwm zzh = zzfwc.zzh(Collections.emptyMap());
            zzfvj zzfvjVar = new zzfvj() { // from class: com.google.android.gms.internal.ads.zzbwk
                @Override // com.google.android.gms.internal.ads.zzfvj
                public final zzfwm zza(Object obj) {
                    return zzbwn.this.zzb((Map) obj);
                }
            };
            zzfwn zzfwnVar = zzcae.zzf;
            zzfwm zzm = zzfwc.zzm(zzh, zzfvjVar, zzfwnVar);
            zzfwm zzn = zzfwc.zzn(zzm, 10L, TimeUnit.SECONDS, zzcae.zzd);
            zzfwc.zzq(zzm, new zzbwm(this, zzn), zzfwnVar);
            zzc.add(zzn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Bitmap bitmap) {
        zzgob zzt = zzgoe.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzt);
        synchronized (this.zzj) {
            zzgtl zzgtlVar = this.zzd;
            zzgul zza = zzgun.zza();
            zza.zza(zzt.zzb());
            zza.zzb("image/png");
            zza.zzc(2);
            zzgtlVar.zzi((zzgun) zza.zzal());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzbws
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzg(android.view.View r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbwp r0 = r7.zzi
            boolean r0 = r0.zzc
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r7.zzl
            if (r0 == 0) goto Lc
            return
        Lc:
            com.google.android.gms.ads.internal.zzt.zzp()
            r0 = 1
            r1 = 0
            if (r8 != 0) goto L14
            goto L6d
        L14:
            boolean r2 = r8.isDrawingCacheEnabled()     // Catch: java.lang.RuntimeException -> L2d
            r8.setDrawingCacheEnabled(r0)     // Catch: java.lang.RuntimeException -> L2d
            android.graphics.Bitmap r3 = r8.getDrawingCache()     // Catch: java.lang.RuntimeException -> L2d
            if (r3 == 0) goto L26
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3)     // Catch: java.lang.RuntimeException -> L2d
            goto L27
        L26:
            r3 = r1
        L27:
            r8.setDrawingCacheEnabled(r2)     // Catch: java.lang.RuntimeException -> L2b
            goto L34
        L2b:
            r2 = move-exception
            goto L2f
        L2d:
            r2 = move-exception
            r3 = r1
        L2f:
            java.lang.String r4 = "Fail to capture the web view"
            com.google.android.gms.internal.ads.zzbzr.zzh(r4, r2)
        L34:
            if (r3 != 0) goto L6c
            int r2 = r8.getWidth()     // Catch: java.lang.RuntimeException -> L65
            int r3 = r8.getHeight()     // Catch: java.lang.RuntimeException -> L65
            if (r2 == 0) goto L5f
            if (r3 != 0) goto L43
            goto L5f
        L43:
            int r4 = r8.getWidth()     // Catch: java.lang.RuntimeException -> L65
            int r5 = r8.getHeight()     // Catch: java.lang.RuntimeException -> L65
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch: java.lang.RuntimeException -> L65
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch: java.lang.RuntimeException -> L65
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch: java.lang.RuntimeException -> L65
            r5.<init>(r4)     // Catch: java.lang.RuntimeException -> L65
            r6 = 0
            r8.layout(r6, r6, r2, r3)     // Catch: java.lang.RuntimeException -> L65
            r8.draw(r5)     // Catch: java.lang.RuntimeException -> L65
            r1 = r4
            goto L6d
        L5f:
            java.lang.String r8 = "Width or height of view is zero"
            com.google.android.gms.internal.ads.zzbzr.zzj(r8)     // Catch: java.lang.RuntimeException -> L65
            goto L6d
        L65:
            r8 = move-exception
            java.lang.String r2 = "Fail to capture the webview"
            com.google.android.gms.internal.ads.zzbzr.zzh(r2, r8)
            goto L6d
        L6c:
            r1 = r3
        L6d:
            if (r1 != 0) goto L75
            java.lang.String r8 = "Failed to capture the webview bitmap."
            com.google.android.gms.internal.ads.zzbwr.zza(r8)
            return
        L75:
            r7.zzl = r0
            com.google.android.gms.internal.ads.zzbwl r8 = new com.google.android.gms.internal.ads.zzbwl
            r8.<init>()
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            java.lang.Thread r0 = r0.getThread()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            if (r0 == r1) goto L8e
            r8.run()
            return
        L8e:
            com.google.android.gms.internal.ads.zzfwn r0 = com.google.android.gms.internal.ads.zzcae.zza
            r0.execute(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbwn.zzg(android.view.View):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzh(String str) {
        synchronized (this.zzj) {
            if (str == null) {
                this.zzd.zzd();
            } else {
                this.zzd.zze(str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final boolean zzi() {
        if (PlatformVersion.isAtLeastKitKat() && this.zzi.zzc && !this.zzl) {
            return true;
        }
        return false;
    }
}
