package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzfjb;
import com.google.android.gms.internal.ads.zzfke;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzh implements zzfke {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzi f19379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(zzi zziVar) {
        this.f19379a = zziVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfke
    public final void zza(int i4, long j4) {
        zzfjb zzfjbVar;
        zzfjbVar = this.f19379a.f19387h;
        zzfjbVar.zzd(i4, System.currentTimeMillis() - j4);
    }

    @Override // com.google.android.gms.internal.ads.zzfke
    public final void zzb(int i4, long j4, String str) {
        zzfjb zzfjbVar;
        zzfjbVar = this.f19379a.f19387h;
        zzfjbVar.zze(i4, System.currentTimeMillis() - j4, str);
    }
}
