package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzesy implements zzeqy {
    final zzfwn zza;
    final Context zzb;
    final zzawo zzc;

    public zzesy(zzawo zzawoVar, zzfwn zzfwnVar, Context context) {
        this.zzc = zzawoVar;
        this.zza = zzfwnVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 45;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzesz(new JSONObject());
            }
        });
    }
}
