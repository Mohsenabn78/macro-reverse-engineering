package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(29)
/* loaded from: classes4.dex */
public final class zzod {
    private static final AudioAttributes zza = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    @DoNotInline
    public static int zza(int i4, int i5) {
        boolean isDirectPlaybackSupported;
        for (int i6 = 10; i6 > 0; i6--) {
            isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i4).setSampleRate(i5).setChannelMask(zzfj.zzf(i6)).build(), zza);
            if (isDirectPlaybackSupported) {
                return i6;
            }
        }
        return 0;
    }

    @DoNotInline
    public static zzfsc<Integer> zzb() {
        zzfsf zzfsfVar;
        boolean isDirectPlaybackSupported;
        zzfrz zzfrzVar = new zzfrz();
        zzfsfVar = zzoe.zzc;
        zzfuc it = zzfsfVar.keySet().iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (zzfj.zza >= 34 || intValue != 30) {
                isDirectPlaybackSupported = AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), zza);
                if (isDirectPlaybackSupported) {
                    zzfrzVar.zzf(Integer.valueOf(intValue));
                }
            }
        }
        zzfrzVar.zzf((Object) 2);
        return zzfrzVar.zzi();
    }
}
