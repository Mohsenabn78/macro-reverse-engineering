package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import androidx.annotation.RequiresApi;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(21)
/* loaded from: classes4.dex */
public final class zzi {
    public final AudioAttributes zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzi(zzk zzkVar, zzh zzhVar) {
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        int i4 = zzfj.zza;
        if (i4 >= 29) {
            zzf.zza(usage, 1);
        }
        if (i4 >= 32) {
            zzg.zza(usage, 0);
        }
        this.zza = usage.build();
    }
}
