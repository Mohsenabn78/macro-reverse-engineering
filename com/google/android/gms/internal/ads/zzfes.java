package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfes {
    private final Executor zza;
    private final zzbzw zzb;

    public zzfes(Executor executor, zzbzw zzbzwVar) {
        this.zza = executor;
        this.zzb = zzbzwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        this.zzb.zza(str);
    }

    public final void zzb(final String str) {
        this.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfer
            @Override // java.lang.Runnable
            public final void run() {
                zzfes.this.zza(str);
            }
        });
    }
}
