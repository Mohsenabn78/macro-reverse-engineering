package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzeeh implements zzdew {
    private final zzezn zza;
    private final zzbpt zzb;
    private final AdFormat zzc;
    @Nullable
    private zzcvy zzd = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeeh(zzezn zzeznVar, zzbpt zzbptVar, AdFormat adFormat) {
        this.zza = zzeznVar;
        this.zzb = zzbptVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdew
    public final void zza(boolean z3, Context context, zzcvt zzcvtVar) throws zzdev {
        boolean zzs;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int ordinal = this.zzc.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 6) {
                        zzs = this.zzb.zzr(ObjectWrapper.wrap(context));
                    }
                    throw new zzdev("Adapter failed to show.");
                }
                zzs = this.zzb.zzt(ObjectWrapper.wrap(context));
            } else {
                zzs = this.zzb.zzs(ObjectWrapper.wrap(context));
            }
            if (zzs) {
                if (this.zzd == null) {
                    return;
                }
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbs)).booleanValue() && this.zza.zzZ == 2) {
                    this.zzd.zza();
                    return;
                }
                return;
            }
            throw new zzdev("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdev(th);
        }
    }

    public final void zzb(zzcvy zzcvyVar) {
        this.zzd = zzcvyVar;
    }
}
