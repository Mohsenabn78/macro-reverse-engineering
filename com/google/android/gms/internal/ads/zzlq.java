package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzlq {
    @Nullable
    private final PowerManager zza;

    public zzlq(Context context) {
        this.zza = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
