package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
@WorkerThread
/* loaded from: classes4.dex */
final class zzex implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final zzev f21549a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21550b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f21551c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f21552d;

    /* renamed from: e  reason: collision with root package name */
    private final String f21553e;

    /* renamed from: f  reason: collision with root package name */
    private final Map f21554f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzex(String str, zzev zzevVar, int i4, Throwable th, byte[] bArr, Map map, zzew zzewVar) {
        Preconditions.checkNotNull(zzevVar);
        this.f21549a = zzevVar;
        this.f21550b = i4;
        this.f21551c = th;
        this.f21552d = bArr;
        this.f21553e = str;
        this.f21554f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f21549a.a(this.f21553e, this.f21550b, this.f21551c, this.f21552d, this.f21554f);
    }
}
