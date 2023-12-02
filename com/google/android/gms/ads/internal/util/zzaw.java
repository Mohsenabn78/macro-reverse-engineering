package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzdsw;
import com.google.android.gms.internal.ads.zzdsx;
import com.google.android.gms.internal.ads.zzfwm;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaw {

    /* renamed from: a  reason: collision with root package name */
    private final Object f19279a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private String f19280b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f19281c = "";

    /* renamed from: d  reason: collision with root package name */
    private boolean f19282d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19283e = false;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    protected String f19284f = "";

    /* renamed from: g  reason: collision with root package name */
    private zzdsx f19285g;

    @Nullable
    @VisibleForTesting
    protected static final String c(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzt.zzp().zzc(context, str2));
        zzfwm zzb = new zzbo(context).zzb(0, str, hashMap, null);
        try {
            return (String) zzb.get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzey)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e4) {
            zzbzr.zzh("Interrupted while retrieving a response from: ".concat(String.valueOf(str)), e4);
            zzb.cancel(true);
            return null;
        } catch (TimeoutException e5) {
            zzbzr.zzh("Timeout while retrieving a response from: ".concat(String.valueOf(str)), e5);
            zzb.cancel(true);
            return null;
        } catch (Exception e6) {
            zzbzr.zzh("Error retrieving a response from: ".concat(String.valueOf(str)), e6);
            return null;
        }
    }

    private final Uri d(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        synchronized (this.f19279a) {
            if (TextUtils.isEmpty(this.f19280b)) {
                com.google.android.gms.ads.internal.zzt.zzp();
                try {
                    str5 = new String(IOUtils.readInputStreamFully(context.openFileInput("debug_signals_id.txt"), true), "UTF-8");
                } catch (IOException unused) {
                    zzbzr.zze("Error reading from internal storage.");
                    str5 = "";
                }
                this.f19280b = str5;
                if (TextUtils.isEmpty(str5)) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    this.f19280b = UUID.randomUUID().toString();
                    com.google.android.gms.ads.internal.zzt.zzp();
                    String str6 = this.f19280b;
                    try {
                        FileOutputStream openFileOutput = context.openFileOutput("debug_signals_id.txt", 0);
                        openFileOutput.write(str6.getBytes("UTF-8"));
                        openFileOutput.close();
                    } catch (Exception e4) {
                        zzbzr.zzh("Error writing to file in internal storage.", e4);
                    }
                }
            }
            str4 = this.f19280b;
        }
        buildUpon.appendQueryParameter("linkedDeviceId", str4);
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final void a(Context context, String str, boolean z3, boolean z4) {
        if (!(context instanceof Activity)) {
            zzbzr.zzi("Can not create dialog without Activity Context");
        } else {
            zzs.zza.post(new zzav(this, context, str, z3, z4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    @androidx.annotation.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbbe r0 = com.google.android.gms.internal.ads.zzbbm.zzev
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.String r0 = (java.lang.String) r0
            android.net.Uri r0 = r3.d(r4, r0, r5, r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = c(r4, r0, r6)
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            r0 = 0
            if (r6 == 0) goto L25
            java.lang.String r4 = "Not linked for in app preview."
            com.google.android.gms.internal.ads.zzbzr.zze(r4)
            return r0
        L25:
            java.lang.String r4 = r4.trim()
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L83
            r6.<init>(r4)     // Catch: org.json.JSONException -> L83
            java.lang.String r4 = "gct"
            java.lang.String r4 = r6.optString(r4)     // Catch: org.json.JSONException -> L83
            java.lang.String r1 = "status"
            java.lang.String r6 = r6.optString(r1)     // Catch: org.json.JSONException -> L83
            r3.f19284f = r6     // Catch: org.json.JSONException -> L83
            com.google.android.gms.internal.ads.zzbbe r6 = com.google.android.gms.internal.ads.zzbbm.zziJ     // Catch: org.json.JSONException -> L83
            com.google.android.gms.internal.ads.zzbbk r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: org.json.JSONException -> L83
            java.lang.Object r6 = r1.zzb(r6)     // Catch: org.json.JSONException -> L83
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch: org.json.JSONException -> L83
            boolean r6 = r6.booleanValue()     // Catch: org.json.JSONException -> L83
            r1 = 1
            if (r6 == 0) goto L79
            java.lang.String r6 = "0"
            java.lang.String r2 = r3.f19284f     // Catch: org.json.JSONException -> L83
            boolean r6 = r6.equals(r2)     // Catch: org.json.JSONException -> L83
            if (r6 != 0) goto L66
            java.lang.String r6 = "2"
            java.lang.String r2 = r3.f19284f     // Catch: org.json.JSONException -> L83
            boolean r6 = r6.equals(r2)     // Catch: org.json.JSONException -> L83
            if (r6 == 0) goto L64
            goto L66
        L64:
            r6 = 0
            goto L67
        L66:
            r6 = 1
        L67:
            r3.zzf(r6)     // Catch: org.json.JSONException -> L83
            com.google.android.gms.internal.ads.zzbza r2 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch: org.json.JSONException -> L83
            com.google.android.gms.ads.internal.util.zzg r2 = r2.zzh()     // Catch: org.json.JSONException -> L83
            if (r6 != 0) goto L76
            java.lang.String r5 = ""
        L76:
            r2.zzA(r5)     // Catch: org.json.JSONException -> L83
        L79:
            java.lang.Object r5 = r3.f19279a
            monitor-enter(r5)
            r3.f19281c = r4     // Catch: java.lang.Throwable -> L80
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L80
            return r1
        L80:
            r4 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L80
            throw r4
        L83:
            r4 = move-exception
            java.lang.String r5 = "Fail to get in app preview response json."
            com.google.android.gms.internal.ads.zzbzr.zzk(r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzaw.b(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public final zzdsx zza() {
        return this.f19285g;
    }

    public final String zzb() {
        String str;
        synchronized (this.f19279a) {
            str = this.f19281c;
        }
        return str;
    }

    public final void zzc(Context context) {
        zzdsx zzdsxVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziJ)).booleanValue() && (zzdsxVar = this.f19285g) != null) {
            zzdsxVar.zzh(new zzat(this, context), zzdsw.DEBUG_MENU);
        }
    }

    public final void zzd(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzt.zzp();
        zzs.zzQ(context, d(context, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeu), str, str2));
    }

    public final void zze(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = d(context, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzex), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzt.zzp();
        zzs.zzH(context, str, buildUpon.build().toString());
    }

    public final void zzf(boolean z3) {
        synchronized (this.f19279a) {
            this.f19283e = z3;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzo().zzh().zzB(z3);
                zzdsx zzdsxVar = this.f19285g;
                if (zzdsxVar != null) {
                    zzdsxVar.zzj(z3);
                }
            }
        }
    }

    public final void zzg(zzdsx zzdsxVar) {
        this.f19285g = zzdsxVar;
    }

    public final void zzh(boolean z3) {
        synchronized (this.f19279a) {
            this.f19282d = z3;
        }
    }

    public final boolean zzj(Context context, String str, String str2) {
        String c4 = c(context, d(context, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzew), str, str2).toString(), str2);
        if (TextUtils.isEmpty(c4)) {
            zzbzr.zze("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(c4.trim()).optString("debug_mode"));
            zzf(equals);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziJ)).booleanValue()) {
                zzg zzh = com.google.android.gms.ads.internal.zzt.zzo().zzh();
                if (true != equals) {
                    str = "";
                }
                zzh.zzA(str);
            }
            return equals;
        } catch (JSONException e4) {
            zzbzr.zzk("Fail to get debug mode response json.", e4);
            return false;
        }
    }

    public final boolean zzl() {
        boolean z3;
        synchronized (this.f19279a) {
            z3 = this.f19283e;
        }
        return z3;
    }

    public final boolean zzm() {
        boolean z3;
        synchronized (this.f19279a) {
            z3 = this.f19282d;
        }
        return z3;
    }

    public final boolean zzn(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) && zzm()) {
            zzbzr.zze("Sending troubleshooting signals to the server.");
            zze(context, str, str2, str3);
            return true;
        }
        return false;
    }
}
