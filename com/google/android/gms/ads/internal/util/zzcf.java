package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcf extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcg f19320a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcf(zzcg zzcgVar) {
        this.f19320a = zzcgVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f19320a.b(context, intent);
    }
}
