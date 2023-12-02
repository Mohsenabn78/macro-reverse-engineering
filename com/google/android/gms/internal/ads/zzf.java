package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@RequiresApi(29)
/* loaded from: classes4.dex */
public final class zzf {
    @DoNotInline
    public static void zza(AudioAttributes.Builder builder, int i4) {
        builder.setAllowedCapturePolicy(i4);
    }
}
