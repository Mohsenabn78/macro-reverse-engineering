package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public final class r extends com.google.android.play.integrity.internal.l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f25301a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Long f25302b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f25303c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ IntegrityTokenRequest f25304d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ t f25305e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(t tVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l4, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f25305e = tVar;
        this.f25301a = bArr;
        this.f25302b = l4;
        this.f25303c = taskCompletionSource2;
        this.f25304d = integrityTokenRequest;
    }

    @Override // com.google.android.play.integrity.internal.l
    public final void a(Exception exc) {
        if (exc instanceof com.google.android.play.integrity.internal.w) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.integrity.internal.h] */
    @Override // com.google.android.play.integrity.internal.l
    protected final void b() {
        com.google.android.play.integrity.internal.k kVar;
        try {
            this.f25305e.f25309a.e().c(t.a(this.f25305e, this.f25301a, this.f25302b), new s(this.f25305e, this.f25303c));
        } catch (RemoteException e4) {
            kVar = this.f25305e.f25310b;
            kVar.c(e4, "requestIntegrityToken(%s)", this.f25304d);
            this.f25303c.trySetException(new IntegrityServiceException(-100, e4));
        }
    }
}
