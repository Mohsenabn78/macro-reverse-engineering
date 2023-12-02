package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzbzr;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbh implements zzalo {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f19295a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzbl f19296b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbh(zzbo zzboVar, String str, zzbl zzblVar) {
        this.f19295a = str;
        this.f19296b = zzblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzalo
    public final void zza(zzalt zzaltVar) {
        String str = this.f19295a;
        String obj = zzaltVar.toString();
        zzbzr.zzj("Failed to load URL: " + str + "\n" + obj);
        this.f19296b.zza((Object) null);
    }
}
