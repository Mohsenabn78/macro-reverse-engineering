package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzflm implements Closeable {
    public static zzfly zza() {
        return new zzfly();
    }

    public static zzfly zzb(final int i4, zzflx zzflxVar) {
        return new zzfly(new zzfpx() { // from class: com.google.android.gms.internal.ads.zzflk
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf(i4);
                return valueOf;
            }
        }, new zzfpx() { // from class: com.google.android.gms.internal.ads.zzfll
            @Override // com.google.android.gms.internal.ads.zzfpx
            public final Object zza() {
                return zzflm.zze();
            }
        }, zzflxVar);
    }

    public static zzfly zzc(zzfpx<Integer> zzfpxVar, zzfpx<Integer> zzfpxVar2, zzflx zzflxVar) {
        return new zzfly(zzfpxVar, zzfpxVar2, zzflxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Integer zze() {
        return -1;
    }
}
