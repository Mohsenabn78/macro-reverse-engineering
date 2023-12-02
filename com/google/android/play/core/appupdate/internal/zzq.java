package com.google.android.play.core.appupdate.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzq extends zzn {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzn f25188b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzx f25189c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzq(zzx zzxVar, TaskCompletionSource taskCompletionSource, zzn zznVar) {
        super(taskCompletionSource);
        this.f25189c = zzxVar;
        this.f25188b = zznVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        zzx.j(this.f25189c, this.f25188b);
    }
}
