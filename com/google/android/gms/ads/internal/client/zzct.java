package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.MuteThisAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzct extends zzcr {

    /* renamed from: a  reason: collision with root package name */
    private final MuteThisAdListener f19115a;

    public zzct(MuteThisAdListener muteThisAdListener) {
        this.f19115a = muteThisAdListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcs
    public final void zze() {
        this.f19115a.onAdMuted();
    }
}
