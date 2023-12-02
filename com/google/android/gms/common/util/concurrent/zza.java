package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
final class zza implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f20754a;

    public zza(Runnable runnable, int i4) {
        this.f20754a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.f20754a.run();
    }
}
