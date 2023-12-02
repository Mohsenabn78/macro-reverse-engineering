package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcnt implements zzbms {
    private final Context zza;
    private final zzatw zzb;
    private final PowerManager zzc;

    public zzcnt(Context context, zzatw zzatwVar) {
        this.zza = context;
        this.zzb = zzatwVar;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    @Override // com.google.android.gms.internal.ads.zzbms
    /* renamed from: zza */
    public final JSONObject zzb(zzcnw zzcnwVar) throws JSONException {
        JSONObject jSONObject;
        Integer valueOf;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzatz zzatzVar = zzcnwVar.zzf;
        if (zzatzVar == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzd() != null) {
            boolean z3 = zzatzVar.zza;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzd()).put("timestamp", zzcnwVar.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzc()).put("isMraid", false).put("isStopped", false).put("isPaused", zzcnwVar.zzb).put("isNative", this.zzb.zze()).put("isScreenOn", this.zzc.isInteractive()).put("appMuted", com.google.android.gms.ads.internal.zzt.zzr().zze()).put("appVolume", com.google.android.gms.ads.internal.zzt.zzr().zza()).put("deviceVolume", com.google.android.gms.ads.internal.util.zzab.zzb(this.zza.getApplicationContext()));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfv)).booleanValue()) {
                AudioManager audioManager = (AudioManager) this.zza.getApplicationContext().getSystemService("audio");
                if (audioManager == null) {
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(audioManager.getMode());
                }
                if (valueOf != null) {
                    jSONObject3.put("audioMode", valueOf);
                }
            }
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzatzVar.zzb).put("isAttachedToWindow", z3).put("viewBox", new JSONObject().put("top", zzatzVar.zzc.top).put("bottom", zzatzVar.zzc.bottom).put("left", zzatzVar.zzc.left).put("right", zzatzVar.zzc.right)).put("adBox", new JSONObject().put("top", zzatzVar.zzd.top).put("bottom", zzatzVar.zzd.bottom).put("left", zzatzVar.zzd.left).put("right", zzatzVar.zzd.right)).put("globalVisibleBox", new JSONObject().put("top", zzatzVar.zze.top).put("bottom", zzatzVar.zze.bottom).put("left", zzatzVar.zze.left).put("right", zzatzVar.zze.right)).put("globalVisibleBoxVisible", zzatzVar.zzf).put("localVisibleBox", new JSONObject().put("top", zzatzVar.zzg.top).put("bottom", zzatzVar.zzg.bottom).put("left", zzatzVar.zzg.left).put("right", zzatzVar.zzg.right)).put("localVisibleBoxVisible", zzatzVar.zzh).put("hitBox", new JSONObject().put("top", zzatzVar.zzi.top).put("bottom", zzatzVar.zzi.bottom).put("left", zzatzVar.zzi.left).put("right", zzatzVar.zzi.right)).put("screenDensity", this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzcnwVar.zza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbl)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzatzVar.zzk;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcnwVar.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
