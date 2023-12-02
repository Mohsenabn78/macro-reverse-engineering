package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(23)
/* loaded from: classes4.dex */
final class zzpj {
    @DoNotInline
    public static void zza(AudioTrack audioTrack, @Nullable zzpl zzplVar) {
        AudioDeviceInfo audioDeviceInfo;
        if (zzplVar == null) {
            audioDeviceInfo = null;
        } else {
            audioDeviceInfo = zzplVar.zza;
        }
        audioTrack.setPreferredDevice(audioDeviceInfo);
    }
}
