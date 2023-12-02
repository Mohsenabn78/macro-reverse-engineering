package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzfmz;
import com.google.android.gms.internal.ads.zzfna;
import com.google.android.gms.internal.ads.zzfnb;
import com.google.android.gms.internal.ads.zzfnc;
import com.google.android.gms.internal.ads.zzfnl;
import com.google.android.gms.internal.ads.zzfnn;
import com.google.android.gms.internal.ads.zzfno;
import com.google.android.gms.internal.ads.zzfnp;
import com.google.android.gms.internal.ads.zzfnq;
import com.google.android.gms.internal.ads.zzfok;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzw {

    /* renamed from: f  reason: collision with root package name */
    private zzfno f19251f;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private zzcez f19248c = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19250e = false;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f19246a = null;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private zzfnb f19249d = null;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f19247b = null;

    private final zzfnq f() {
        zzfnp zzc = zzfnq.zzc();
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjQ)).booleanValue() && !TextUtils.isEmpty(this.f19247b)) {
            zzc.zza(this.f19247b);
        } else {
            String str = this.f19246a;
            if (str != null) {
                zzc.zzb(str);
            } else {
                c("Missing session token and/or appId", "onLMDupdate");
            }
        }
        return zzc.zzc();
    }

    private final void g() {
        if (this.f19251f == null) {
            this.f19251f = new zzv(this);
        }
    }

    @VisibleForTesting
    final void a(String str) {
        b(str, new HashMap());
    }

    @VisibleForTesting
    final void b(final String str, final Map map) {
        zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzu
            @Override // java.lang.Runnable
            public final void run() {
                zzw.this.d(str, map);
            }
        });
    }

    @VisibleForTesting
    final void c(String str, String str2) {
        com.google.android.gms.ads.internal.util.zze.zza(str);
        if (this.f19248c != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("message", str);
            hashMap.put("action", str2);
            b("onError", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(String str, Map map) {
        zzcez zzcezVar = this.f19248c;
        if (zzcezVar != null) {
            zzcezVar.zzd(str, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void e(zzfnn zzfnnVar) {
        if (!TextUtils.isEmpty(zzfnnVar.zzb())) {
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjQ)).booleanValue()) {
                this.f19246a = zzfnnVar.zzb();
            }
        }
        switch (zzfnnVar.zza()) {
            case 8152:
                a("onLMDOverlayOpened");
                return;
            case 8153:
                a("onLMDOverlayClicked");
                return;
            case 8154:
            case 8156:
            case 8158:
            case 8159:
            default:
                return;
            case 8155:
                a("onLMDOverlayClose");
                return;
            case 8157:
                this.f19246a = null;
                this.f19247b = null;
                this.f19250e = false;
                return;
            case 8160:
            case 8161:
            case 8162:
                HashMap hashMap = new HashMap();
                hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, String.valueOf(zzfnnVar.zza()));
                b("onLMDOverlayFailedToOpen", hashMap);
                return;
        }
    }

    public final synchronized void zza(@Nullable zzcez zzcezVar, Context context) {
        this.f19248c = zzcezVar;
        if (!zzk(context)) {
            c("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("action", "fetch_completed");
        b("on_play_store_bind", hashMap);
    }

    public final void zzb() {
        zzfnb zzfnbVar;
        if (this.f19250e && (zzfnbVar = this.f19249d) != null) {
            zzfnbVar.zza(f(), this.f19251f);
            a("onLMDOverlayCollapse");
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
    }

    public final void zzc() {
        zzfnb zzfnbVar;
        if (this.f19250e && (zzfnbVar = this.f19249d) != null) {
            zzfmz zzc = zzfna.zzc();
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjQ)).booleanValue() && !TextUtils.isEmpty(this.f19247b)) {
                zzc.zza(this.f19247b);
            } else {
                String str = this.f19246a;
                if (str != null) {
                    zzc.zzb(str);
                } else {
                    c("Missing session token and/or appId", "onLMDupdate");
                }
            }
            zzfnbVar.zzb(zzc.zzc(), this.f19251f);
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
    }

    public final void zzg() {
        zzfnb zzfnbVar;
        if (this.f19250e && (zzfnbVar = this.f19249d) != null) {
            zzfnbVar.zzc(f(), this.f19251f);
            a("onLMDOverlayExpand");
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
    }

    public final void zzj(@Nullable zzcez zzcezVar, @Nullable zzfnl zzfnlVar) {
        if (zzcezVar == null) {
            c("adWebview missing", "onLMDShow");
            return;
        }
        this.f19248c = zzcezVar;
        if (!this.f19250e && !zzk(zzcezVar.getContext())) {
            c("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjQ)).booleanValue()) {
            this.f19247b = zzfnlVar.zzg();
        }
        g();
        zzfnb zzfnbVar = this.f19249d;
        if (zzfnbVar != null) {
            zzfnbVar.zzd(zzfnlVar, this.f19251f);
        }
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfok.zza(context)) {
            return false;
        }
        try {
            this.f19249d = zzfnc.zza(context);
        } catch (NullPointerException e4) {
            com.google.android.gms.ads.internal.util.zze.zza("Error connecting LMD Overlay service");
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.f19249d == null) {
            this.f19250e = false;
            return false;
        }
        g();
        this.f19250e = true;
        return true;
    }
}
