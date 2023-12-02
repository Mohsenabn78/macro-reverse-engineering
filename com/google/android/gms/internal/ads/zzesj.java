package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzesj implements zzeqy {
    private final Context zza;
    private final String zzb;
    private final zzfwn zzc;

    public zzesj(@Nullable zzbug zzbugVar, Context context, String str, zzfwn zzfwnVar) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzfwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 42;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesi
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzesk(new JSONObject());
            }
        });
    }
}
