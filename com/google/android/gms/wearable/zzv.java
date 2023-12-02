package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzao;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzao f22881a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaa f22882b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzaa zzaaVar, zzao zzaoVar) {
        this.f22882b = zzaaVar;
        this.f22881a = zzaoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22882b.f22866b.onCapabilityChanged(this.f22881a);
    }
}
