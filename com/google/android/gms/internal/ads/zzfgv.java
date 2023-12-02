package com.google.android.gms.internal.ads;

import android.app.Application;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfgv {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Context context) {
        zzfid.zzb(context, "Application Context cannot be null");
        if (!this.zza) {
            this.zza = true;
            zzfhr.zzb().zzc(context);
            zzfhm zza = zzfhm.zza();
            if (context instanceof Application) {
                ((Application) context).registerActivityLifecycleCallbacks(zza);
            }
            zzfib.zzd(context);
            zzfho.zzb().zzc(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zza;
    }
}
