package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzjs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f21954a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21955b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21956c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzq f21957d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ boolean f21958e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzjz f21959f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjs(zzjz zzjzVar, AtomicReference atomicReference, String str, String str2, String str3, zzq zzqVar, boolean z3) {
        this.f21959f = zzjzVar;
        this.f21954a = atomicReference;
        this.f21955b = str2;
        this.f21956c = str3;
        this.f21957d = zzqVar;
        this.f21958e = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzjz zzjzVar;
        zzej zzejVar;
        synchronized (this.f21954a) {
            try {
                zzjzVar = this.f21959f;
                zzejVar = zzjzVar.f21972d;
            } catch (RemoteException e4) {
                this.f21959f.f21734a.zzaA().zzd().zzd("(legacy) Failed to get user properties; remote exception", null, this.f21955b, e4);
                this.f21954a.set(Collections.emptyList());
                atomicReference = this.f21954a;
            }
            if (zzejVar == null) {
                zzjzVar.f21734a.zzaA().zzd().zzd("(legacy) Failed to get user properties; not connected to service", null, this.f21955b, this.f21956c);
                this.f21954a.set(Collections.emptyList());
                this.f21954a.notify();
                return;
            }
            if (TextUtils.isEmpty(null)) {
                Preconditions.checkNotNull(this.f21957d);
                this.f21954a.set(zzejVar.zzh(this.f21955b, this.f21956c, this.f21958e, this.f21957d));
            } else {
                this.f21954a.set(zzejVar.zzi(null, this.f21955b, this.f21956c, this.f21958e));
            }
            this.f21959f.q();
            atomicReference = this.f21954a;
            atomicReference.notify();
        }
    }
}
