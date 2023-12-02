package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcxu implements Runnable {
    private final WeakReference zza;

    @Override // java.lang.Runnable
    public final void run() {
        zzcxv zzcxvVar = (zzcxv) this.zza.get();
        if (zzcxvVar != null) {
            zzcxvVar.zzp(new zzdap() { // from class: com.google.android.gms.internal.ads.zzcxs
                @Override // com.google.android.gms.internal.ads.zzdap
                public final void zza(Object obj) {
                    ((zzcxw) obj).zza();
                }
            });
        }
    }
}
