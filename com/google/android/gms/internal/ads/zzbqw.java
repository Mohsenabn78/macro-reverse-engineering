package com.google.android.gms.internal.ads;

import androidx.constraintlayout.motion.widget.Key;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzbqw {
    private final zzcez zza;
    private final String zzb;

    public zzbqw(zzcez zzcezVar, String str) {
        this.zza = zzcezVar;
        this.zzb = str;
    }

    public final void zzf(int i4, int i5, int i6, int i7) {
        try {
            this.zza.zze("onDefaultPositionReceived", new JSONObject().put("x", i4).put("y", i5).put("width", i6).put("height", i7));
        } catch (JSONException e4) {
            zzbzr.zzh("Error occurred while dispatching default position.", e4);
        }
    }

    public final void zzg(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.zzb);
            zzcez zzcezVar = this.zza;
            if (zzcezVar != null) {
                zzcezVar.zze("onError", put);
            }
        } catch (JSONException e4) {
            zzbzr.zzh("Error occurred while dispatching error event.", e4);
        }
    }

    public final void zzh(String str) {
        try {
            this.zza.zze("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e4) {
            zzbzr.zzh("Error occurred while dispatching ready Event.", e4);
        }
    }

    public final void zzi(int i4, int i5, int i6, int i7, float f4, int i8) {
        try {
            this.zza.zze("onScreenInfoChanged", new JSONObject().put("width", i4).put("height", i5).put("maxSizeWidth", i6).put("maxSizeHeight", i7).put("density", f4).put(Key.ROTATION, i8));
        } catch (JSONException e4) {
            zzbzr.zzh("Error occurred while obtaining screen information.", e4);
        }
    }

    public final void zzj(int i4, int i5, int i6, int i7) {
        try {
            this.zza.zze("onSizeChanged", new JSONObject().put("x", i4).put("y", i5).put("width", i6).put("height", i7));
        } catch (JSONException e4) {
            zzbzr.zzh("Error occurred while dispatching size change.", e4);
        }
    }

    public final void zzk(String str) {
        try {
            this.zza.zze("onStateChanged", new JSONObject().put(RemoteConfigConstants.ResponseFieldKey.STATE, str));
        } catch (JSONException e4) {
            zzbzr.zzh("Error occurred while dispatching state change.", e4);
        }
    }
}
