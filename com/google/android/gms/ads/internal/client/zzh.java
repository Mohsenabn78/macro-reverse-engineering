package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzh extends zzbj {

    /* renamed from: a  reason: collision with root package name */
    private final AdLoadCallback f19200a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f19201b;

    public zzh(AdLoadCallback adLoadCallback, Object obj) {
        this.f19200a = adLoadCallback;
        this.f19201b = obj;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzb(zze zzeVar) {
        AdLoadCallback adLoadCallback = this.f19200a;
        if (adLoadCallback != null) {
            adLoadCallback.onAdFailedToLoad(zzeVar.zzb());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzc() {
        Object obj;
        AdLoadCallback adLoadCallback = this.f19200a;
        if (adLoadCallback != null && (obj = this.f19201b) != null) {
            adLoadCallback.onAdLoaded(obj);
        }
    }
}
