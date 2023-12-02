package com.google.android.play.integrity.internal;

import android.os.IBinder;
import java.util.List;

/* compiled from: com.google.android.play:integrity@@1.1.0 */
/* loaded from: classes5.dex */
final class r extends l {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ IBinder f25345f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ u f25346g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(u uVar, IBinder iBinder) {
        this.f25346g = uVar;
        this.f25345f = iBinder;
    }

    @Override // com.google.android.play.integrity.internal.l
    public final void b() {
        List<Runnable> list;
        List list2;
        this.f25346g.f25348a.f25362m = g.b(this.f25345f);
        v.n(this.f25346g.f25348a);
        this.f25346g.f25348a.f25356g = false;
        list = this.f25346g.f25348a.f25353d;
        for (Runnable runnable : list) {
            runnable.run();
        }
        list2 = this.f25346g.f25348a.f25353d;
        list2.clear();
    }
}
