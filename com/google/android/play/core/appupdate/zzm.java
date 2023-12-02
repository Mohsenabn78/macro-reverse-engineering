package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzm extends com.google.android.play.core.appupdate.internal.zzn {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f25240b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f25241c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzr f25242d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(zzr zzrVar, TaskCompletionSource taskCompletionSource, String str, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.f25242d = zzrVar;
        this.f25240b = str;
        this.f25241c = taskCompletionSource2;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.play.core.appupdate.internal.zzf, android.os.IInterface] */
    @Override // com.google.android.play.core.appupdate.internal.zzn
    protected final void a() {
        com.google.android.play.core.appupdate.internal.zzm zzmVar;
        String str;
        try {
            ?? zze = this.f25242d.f25253a.zze();
            zzr zzrVar = this.f25242d;
            str = zzrVar.f25254b;
            zze.zzd(str, zzr.b(zzrVar, this.f25240b), new zzq(this.f25242d, this.f25241c, this.f25240b));
        } catch (RemoteException e4) {
            zzmVar = zzr.f25251e;
            zzmVar.zzc(e4, "requestUpdateInfo(%s)", this.f25240b);
            this.f25241c.trySetException(new RuntimeException(e4));
        }
    }
}
