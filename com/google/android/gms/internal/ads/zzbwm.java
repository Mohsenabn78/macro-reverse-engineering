package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzbwm implements zzfvy {
    final /* synthetic */ zzfwm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbwm(zzbwn zzbwnVar, zzfwm zzfwmVar) {
        this.zza = zzfwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        List list;
        list = zzbwn.zzc;
        list.remove(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List list;
        Void r22 = (Void) obj;
        list = zzbwn.zzc;
        list.remove(this.zza);
    }
}
