package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zacz extends com.google.android.gms.internal.base.zau {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zada f20294a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zacz(zada zadaVar, Looper looper) {
        super(looper);
        this.f20294a = zadaVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        zada zadaVar;
        int i4 = message.what;
        if (i4 != 0) {
            if (i4 != 1) {
                Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + i4);
                return;
            }
            RuntimeException runtimeException = (RuntimeException) message.obj;
            Log.e("TransformedResultImpl", "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage())));
            throw runtimeException;
        }
        PendingResult pendingResult = (PendingResult) message.obj;
        obj = this.f20294a.f20300e;
        synchronized (obj) {
            zadaVar = this.f20294a.f20297b;
            zada zadaVar2 = (zada) Preconditions.checkNotNull(zadaVar);
            if (pendingResult == null) {
                zadaVar2.i(new Status(13, "Transform returned null"));
            } else if (pendingResult instanceof zacp) {
                zadaVar2.i(((zacp) pendingResult).a());
            } else {
                zadaVar2.zai(pendingResult);
            }
        }
    }
}
