package com.google.android.gms.wearable;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f22879a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaa f22880b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzu(zzaa zzaaVar, List list) {
        this.f22880b = zzaaVar;
        this.f22879a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22880b.f22866b.onConnectedNodes(this.f22879a);
    }
}
