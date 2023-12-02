package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzckk implements zzezg {
    private final zzciq zza;
    private Context zzb;
    private String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzckk(zzciq zzciqVar, zzckj zzckjVar) {
        this.zza = zzciqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezg
    public final /* synthetic */ zzezg zza(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzezg
    public final /* synthetic */ zzezg zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzezg
    public final zzezh zzc() {
        zzgwm.zzc(this.zzb, Context.class);
        return new zzckm(this.zza, this.zzb, this.zzc, null);
    }
}
