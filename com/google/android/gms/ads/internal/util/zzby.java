package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbzw;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzby extends zzb {

    /* renamed from: a  reason: collision with root package name */
    private final zzbzw f19311a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19312b;

    public zzby(Context context, String str, String str2) {
        this.f19311a = new zzbzw(com.google.android.gms.ads.internal.zzt.zzp().zzc(context, str));
        this.f19312b = str2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        this.f19311a.zza(this.f19312b);
    }
}
