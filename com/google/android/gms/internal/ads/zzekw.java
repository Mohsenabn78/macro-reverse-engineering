package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzekw implements zzeqy {
    private final zzfwn zza;
    private final zzfai zzb;
    private final zzfau zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzekw(zzfwn zzfwnVar, zzfai zzfaiVar, zzfau zzfauVar) {
        this.zza = zzfwnVar;
        this.zzb = zzfaiVar;
        this.zzc = zzfauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 5;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzekv
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzekw.this.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzekx zzc() throws Exception {
        String str = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgW)).booleanValue() && "requester_type_2".equals(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(this.zzb.zzd))) {
            str = zzfau.zza();
        }
        return new zzekx(str);
    }
}
