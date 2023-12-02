package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(32)
/* loaded from: classes4.dex */
public final class zzwr {
    private final Spatializer zza;
    private final boolean zzb;
    @Nullable
    private Handler zzc;
    @Nullable
    private Spatializer.OnSpatializerStateChangedListener zzd;

    private zzwr(Spatializer spatializer) {
        boolean z3;
        this.zza = spatializer;
        if (spatializer.getImmersiveAudioLevel() != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzb = z3;
    }

    @Nullable
    public static zzwr zza(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return new zzwr(audioManager.getSpatializer());
    }

    public final void zzb(zzwy zzwyVar, Looper looper) {
        if (this.zzd == null && this.zzc == null) {
            this.zzd = new zzwq(this, zzwyVar);
            final Handler handler = new Handler(looper);
            this.zzc = handler;
            this.zza.addOnSpatializerStateChangedListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzwp
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handler.post(runnable);
                }
            }, this.zzd);
        }
    }

    public final void zzc() {
        Spatializer.OnSpatializerStateChangedListener onSpatializerStateChangedListener = this.zzd;
        if (onSpatializerStateChangedListener != null && this.zzc != null) {
            this.zza.removeOnSpatializerStateChangedListener(onSpatializerStateChangedListener);
            Handler handler = this.zzc;
            int i4 = zzfj.zza;
            handler.removeCallbacksAndMessages(null);
            this.zzc = null;
            this.zzd = null;
        }
    }

    public final boolean zzd(zzk zzkVar, zzam zzamVar) {
        int i4;
        if ("audio/eac3-joc".equals(zzamVar.zzm) && zzamVar.zzz == 16) {
            i4 = 12;
        } else {
            i4 = zzamVar.zzz;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(zzfj.zzf(i4));
        int i5 = zzamVar.zzA;
        if (i5 != -1) {
            channelMask.setSampleRate(i5);
        }
        return this.zza.canBeSpatialized(zzkVar.zza().zza, channelMask.build());
    }

    public final boolean zze() {
        return this.zza.isAvailable();
    }

    public final boolean zzf() {
        return this.zza.isEnabled();
    }

    public final boolean zzg() {
        return this.zzb;
    }
}
