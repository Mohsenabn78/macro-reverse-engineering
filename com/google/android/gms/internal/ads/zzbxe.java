package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbxe implements zzaua {
    private final Context zza;
    private final Object zzb;
    private final String zzc;
    private boolean zzd;

    public zzbxe(Context context, String str) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = str;
        this.zzd = false;
        this.zzb = new Object();
    }

    public final String zza() {
        return this.zzc;
    }

    public final void zzb(boolean z3) {
        if (!com.google.android.gms.ads.internal.zzt.zzn().zzu(this.zza)) {
            return;
        }
        synchronized (this.zzb) {
            if (this.zzd == z3) {
                return;
            }
            this.zzd = z3;
            if (TextUtils.isEmpty(this.zzc)) {
                return;
            }
            if (this.zzd) {
                com.google.android.gms.ads.internal.zzt.zzn().zzh(this.zza, this.zzc);
            } else {
                com.google.android.gms.ads.internal.zzt.zzn().zzi(this.zza, this.zzc);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzc(zzatz zzatzVar) {
        zzb(zzatzVar.zzj);
    }
}
