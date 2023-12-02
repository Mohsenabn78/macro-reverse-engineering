package com.google.android.play.core.appupdate.internal;

import android.os.IBinder;
import java.util.List;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
final class zzt extends zzn {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ IBinder f25191b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzw f25192c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzw zzwVar, IBinder iBinder) {
        this.f25192c = zzwVar;
        this.f25191b = iBinder;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void a() {
        List<Runnable> list;
        List list2;
        this.f25192c.f25194a.f25208m = zze.zzb(this.f25191b);
        zzx.k(this.f25192c.f25194a);
        this.f25192c.f25194a.f25202g = false;
        list = this.f25192c.f25194a.f25199d;
        for (Runnable runnable : list) {
            runnable.run();
        }
        list2 = this.f25192c.f25194a.f25199d;
        list2.clear();
    }
}
