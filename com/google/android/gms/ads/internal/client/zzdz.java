package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdz extends zzaz {

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzea f19151c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdz(zzea zzeaVar) {
        this.f19151c = zzeaVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzaz, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        VideoController videoController;
        zzea zzeaVar = this.f19151c;
        videoController = zzeaVar.f19155d;
        videoController.zzb(zzeaVar.zzi());
        super.onAdFailedToLoad(loadAdError);
    }

    @Override // com.google.android.gms.ads.internal.client.zzaz, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        VideoController videoController;
        zzea zzeaVar = this.f19151c;
        videoController = zzeaVar.f19155d;
        videoController.zzb(zzeaVar.zzi());
        super.onAdLoaded();
    }
}
