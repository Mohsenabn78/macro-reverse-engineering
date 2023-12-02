package com.google.android.gms.internal.ads;

import android.view.Surface;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzyk extends zzrq {
    public zzyk(Throwable th, @Nullable zzrs zzrsVar, @Nullable Surface surface) {
        super(th, zzrsVar);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
    }
}
