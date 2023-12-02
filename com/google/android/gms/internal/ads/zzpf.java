package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(29)
/* loaded from: classes4.dex */
final class zzpf {
    @DoNotInline
    public static zzoh zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z3) {
        boolean isOffloadedPlaybackSupported;
        isOffloadedPlaybackSupported = AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes);
        if (!isOffloadedPlaybackSupported) {
            return zzoh.zza;
        }
        zzof zzofVar = new zzof();
        boolean z4 = true;
        zzofVar.zza(true);
        zzofVar.zzc(z3);
        zzofVar.zzb((zzfj.zza == 30 && zzfj.zzd.startsWith("Pixel")) ? false : false);
        return zzofVar.zzd();
    }
}
