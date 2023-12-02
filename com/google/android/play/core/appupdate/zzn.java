package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzn extends com.google.android.play.core.appupdate.internal.zzn {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f25243b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f25244c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzr f25245d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzn(zzr zzrVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, String str) {
        super(taskCompletionSource);
        this.f25245d = zzrVar;
        this.f25243b = taskCompletionSource2;
        this.f25244c = str;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.play.core.appupdate.internal.zzf, android.os.IInterface] */
    @Override // com.google.android.play.core.appupdate.internal.zzn
    protected final void a() {
        com.google.android.play.core.appupdate.internal.zzm zzmVar;
        String str;
        Bundle i4;
        try {
            ?? zze = this.f25245d.f25253a.zze();
            str = this.f25245d.f25254b;
            i4 = zzr.i();
            zze.zzc(str, i4, new zzp(this.f25245d, this.f25243b));
        } catch (RemoteException e4) {
            zzmVar = zzr.f25251e;
            zzmVar.zzc(e4, "completeUpdate(%s)", this.f25244c);
            this.f25243b.trySetException(new RuntimeException(e4));
        }
    }
}
