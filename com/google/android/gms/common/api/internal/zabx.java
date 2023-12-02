package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zabx extends BroadcastReceiver {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    Context f20264a;

    /* renamed from: b  reason: collision with root package name */
    private final zabw f20265b;

    public zabx(zabw zabwVar) {
        this.f20265b = zabwVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str;
        Uri data = intent.getData();
        if (data != null) {
            str = data.getSchemeSpecificPart();
        } else {
            str = null;
        }
        if ("com.google.android.gms".equals(str)) {
            this.f20265b.zaa();
            zab();
        }
    }

    public final void zaa(Context context) {
        this.f20264a = context;
    }

    public final synchronized void zab() {
        Context context = this.f20264a;
        if (context != null) {
            context.unregisterReceiver(this);
        }
        this.f20264a = null;
    }
}
