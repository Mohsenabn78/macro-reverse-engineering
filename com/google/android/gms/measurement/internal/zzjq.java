package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21944a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21945b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21946c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzq f21947d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzjz f21948e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjq(zzjz zzjzVar, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar) {
        this.f21948e = zzjzVar;
        this.f21944a = atomicReference;
        this.f21945b = str2;
        this.f21946c = str3;
        this.f21947d = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzjz zzjzVar;
        zzej zzejVar;
        synchronized (this.f21944a) {
            try {
                zzjzVar = this.f21948e;
                zzejVar = zzjzVar.f21972d;
            } catch (RemoteException e4) {
                this.f21948e.f21734a.zzaA().zzd().zzd("(legacy) Failed to get conditional properties; remote exception", null, this.f21945b, e4);
                this.f21944a.set(Collections.emptyList());
                atomicReference = this.f21944a;
            }
            if (zzejVar == null) {
                zzjzVar.f21734a.zzaA().zzd().zzd("(legacy) Failed to get conditional properties; not connected to service", null, this.f21945b, this.f21946c);
                this.f21944a.set(Collections.emptyList());
                this.f21944a.notify();
                return;
            }
            if (TextUtils.isEmpty(null)) {
                Preconditions.checkNotNull(this.f21947d);
                this.f21944a.set(zzejVar.zzf(this.f21945b, this.f21946c, this.f21947d));
            } else {
                this.f21944a.set(zzejVar.zzg(null, this.f21945b, this.f21946c));
            }
            this.f21948e.q();
            atomicReference = this.f21944a;
            atomicReference.notify();
        }
    }
}
