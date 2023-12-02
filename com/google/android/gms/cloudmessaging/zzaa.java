package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.0.0 */
/* loaded from: classes4.dex */
public final class zzaa extends com.google.android.gms.internal.cloudmessaging.zzf {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rpc f19907a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaa(Rpc rpc, Looper looper) {
        super(looper);
        this.f19907a = rpc;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Rpc.b(this.f19907a, message);
    }
}
