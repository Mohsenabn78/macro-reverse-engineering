package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzgm;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzgm f22877a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaa f22878b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzaa zzaaVar, zzgm zzgmVar) {
        this.f22878b = zzaaVar;
        this.f22877a = zzgmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22878b.f22866b.onPeerDisconnected(this.f22877a);
    }
}
