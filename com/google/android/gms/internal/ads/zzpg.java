package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(31)
/* loaded from: classes4.dex */
final class zzpg {
    @DoNotInline
    public static zzoh zza(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z3) {
        int playbackOffloadSupport;
        playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        if (playbackOffloadSupport == 0) {
            return zzoh.zza;
        }
        zzof zzofVar = new zzof();
        boolean z4 = true;
        zzofVar.zza(true);
        if (playbackOffloadSupport != 2) {
            z4 = false;
        }
        zzofVar.zzb(z4);
        zzofVar.zzc(z3);
        return zzofVar.zzd();
    }
}
