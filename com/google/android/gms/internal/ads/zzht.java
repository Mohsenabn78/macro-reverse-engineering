package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzht {
    private final Context zza;
    private final zzhr zzb;

    public zzht(Context context, Handler handler, zzhs zzhsVar) {
        this.zza = context.getApplicationContext();
        this.zzb = new zzhr(this, handler, zzhsVar);
    }
}
