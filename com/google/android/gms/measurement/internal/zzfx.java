package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfx implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private final String f21635a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzga f21636b;

    public zzfx(zzga zzgaVar, String str) {
        this.f21636b = zzgaVar;
        Preconditions.checkNotNull(str);
        this.f21635a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f21636b.f21734a.zzaA().zzd().zzb(this.f21635a, th);
    }
}
