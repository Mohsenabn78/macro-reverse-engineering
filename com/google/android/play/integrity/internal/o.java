package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
public final class o extends l {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ l f25342f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ v f25343g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(v vVar, TaskCompletionSource taskCompletionSource, l lVar) {
        super(taskCompletionSource);
        this.f25343g = vVar;
        this.f25342f = lVar;
    }

    @Override // com.google.android.play.integrity.internal.l
    public final void b() {
        v.m(this.f25343g, this.f25342f);
    }
}
