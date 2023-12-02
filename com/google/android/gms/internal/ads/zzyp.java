package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzyp implements zzdj {
    private static final zzfpx zza = zzfqa.zza(new zzfpx() { // from class: com.google.android.gms.internal.ads.zzyn
        @Override // com.google.android.gms.internal.ads.zzfpx
        public final Object zza() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                Object invoke = cls.getMethod("build", new Class[0]).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]);
                invoke.getClass();
                return (zzdj) invoke;
            } catch (Exception e4) {
                throw new IllegalStateException(e4);
            }
        }
    });

    private zzyp() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzyp(zzyo zzyoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdj
    public final zzdl zza(Context context, List list, zzv zzvVar, zzs zzsVar, zzs zzsVar2, boolean z3, Executor executor, zzdk zzdkVar) throws zzdi {
        return ((zzdj) zza.zza()).zza(context, list, zzvVar, zzsVar, zzsVar2, false, executor, zzdkVar);
    }
}
