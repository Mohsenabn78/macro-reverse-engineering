package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzju implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ComponentName f21962a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzjy f21963b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzju(zzjy zzjyVar, ComponentName componentName) {
        this.f21963b = zzjyVar;
        this.f21962a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjz.y(this.f21963b.f21970c, this.f21962a);
    }
}
