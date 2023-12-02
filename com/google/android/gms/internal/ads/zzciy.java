package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzciy implements zzeun {
    private final zzciq zza;
    private Context zzb;
    private String zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzciy(zzciq zzciqVar, zzcix zzcixVar) {
        this.zza = zzciqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeun
    public final /* synthetic */ zzeun zza(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeun
    public final /* synthetic */ zzeun zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeun
    public final zzeuo zzc() {
        zzgwm.zzc(this.zzb, Context.class);
        zzgwm.zzc(this.zzc, String.class);
        return new zzcja(this.zza, this.zzb, this.zzc, null);
    }
}
