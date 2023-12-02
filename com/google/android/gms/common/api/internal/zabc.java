package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zabc extends com.google.android.gms.internal.base.zau {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zabe f20190a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zabc(zabe zabeVar, Looper looper) {
        super(looper);
        this.f20190a = zabeVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i4 = message.what;
        if (i4 != 1) {
            if (i4 != 2) {
                Log.w("GoogleApiClientImpl", "Unknown message id: " + i4);
                return;
            }
            zabe.f(this.f20190a);
            return;
        }
        zabe.g(this.f20190a);
    }
}
