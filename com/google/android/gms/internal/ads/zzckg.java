package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzckg implements zzexs {
    private final zzciq zza;
    private Context zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzq zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzckg(zzciq zzciqVar, zzckf zzckfVar) {
        this.zza = zzciqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexs
    public final /* synthetic */ zzexs zza(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        zzqVar.getClass();
        this.zzd = zzqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzexs
    public final /* synthetic */ zzexs zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzexs
    public final /* synthetic */ zzexs zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzexs
    public final zzext zzd() {
        zzgwm.zzc(this.zzb, Context.class);
        zzgwm.zzc(this.zzc, String.class);
        zzgwm.zzc(this.zzd, com.google.android.gms.ads.internal.client.zzq.class);
        return new zzcki(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
