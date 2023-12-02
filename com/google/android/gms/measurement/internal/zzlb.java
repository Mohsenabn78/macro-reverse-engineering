package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzlb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f22029a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f22030b = "_err";

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Bundle f22031c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzlc f22032d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlb(zzlc zzlcVar, String str, String str2, Bundle bundle) {
        this.f22032d = zzlcVar;
        this.f22029a = str;
        this.f22031c = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22032d.f22033a.f((zzau) Preconditions.checkNotNull(this.f22032d.f22033a.zzv().V(this.f22029a, this.f22030b, this.f22031c, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, this.f22032d.f22033a.zzax().currentTimeMillis(), false, true)), this.f22029a);
    }
}
