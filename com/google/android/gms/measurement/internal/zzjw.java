package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
final class zzjw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzjy f21966a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjw(zzjy zzjyVar) {
        this.f21966a = zzjyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjz zzjzVar = this.f21966a.f21970c;
        Context zzaw = zzjzVar.f21734a.zzaw();
        this.f21966a.f21970c.f21734a.zzay();
        zzjz.y(zzjzVar, new ComponentName(zzaw, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
