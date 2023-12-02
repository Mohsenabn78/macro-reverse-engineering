package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzert implements zzeqy {
    private final Executor zza;
    private final String zzb;
    @Nullable
    private final PackageInfo zzc;
    private final zzbyr zzd;

    public zzert(zzbyr zzbyrVar, Executor executor, String str, @Nullable PackageInfo packageInfo, int i4) {
        this.zzd = zzbyrVar;
        this.zza = executor;
        this.zzb = str;
        this.zzc = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 41;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return zzfwc.zzf(zzfwc.zzl(zzfwc.zzh(this.zzb), new zzfov() { // from class: com.google.android.gms.internal.ads.zzerr
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                return new zzeru((String) obj);
            }
        }, this.zza), Throwable.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzers
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzert.this.zzc((Throwable) obj);
            }
        }, this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(Throwable th) throws Exception {
        return zzfwc.zzh(new zzeru(this.zzb));
    }
}
