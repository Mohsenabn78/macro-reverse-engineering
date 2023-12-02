package com.google.android.gms.internal.common;

import android.os.Build;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzd {
    public static final int zza;

    static {
        int i4;
        if (Build.VERSION.SDK_INT >= 23) {
            i4 = 67108864;
        } else {
            i4 = 0;
        }
        zza = i4;
    }
}
