package com.google.android.gms.measurement.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzga extends zzgx {

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicLong f21645l = new AtomicLong(Long.MIN_VALUE);
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private zzfz f21646c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private zzfz f21647d;

    /* renamed from: e  reason: collision with root package name */
    private final PriorityBlockingQueue f21648e;

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue f21649f;

    /* renamed from: g  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f21650g;

    /* renamed from: h  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f21651h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f21652i;

    /* renamed from: j  reason: collision with root package name */
    private final Semaphore f21653j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f21654k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzga(zzgd zzgdVar) {
        super(zzgdVar);
        this.f21652i = new Object();
        this.f21653j = new Semaphore(2);
        this.f21648e = new PriorityBlockingQueue();
        this.f21649f = new LinkedBlockingQueue();
        this.f21650g = new zzfx(this, "Thread death: Uncaught exception on worker thread");
        this.f21651h = new zzfx(this, "Thread death: Uncaught exception on network thread");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean l(zzga zzgaVar) {
        boolean z3 = zzgaVar.f21654k;
        return false;
    }

    private final void m(zzfy zzfyVar) {
        synchronized (this.f21652i) {
            this.f21648e.add(zzfyVar);
            zzfz zzfzVar = this.f21646c;
            if (zzfzVar == null) {
                zzfz zzfzVar2 = new zzfz(this, "Measurement Worker", this.f21648e);
                this.f21646c = zzfzVar2;
                zzfzVar2.setUncaughtExceptionHandler(this.f21650g);
                this.f21646c.start();
            } else {
                zzfzVar.a();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgx
    protected final boolean b() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Object g(AtomicReference atomicReference, long j4, String str, Runnable runnable) {
        synchronized (atomicReference) {
            this.f21734a.zzaB().zzp(runnable);
            try {
                atomicReference.wait(j4);
            } catch (InterruptedException unused) {
                zzer zzk = this.f21734a.zzaA().zzk();
                zzk.zza("Interrupted waiting for " + str);
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            this.f21734a.zzaA().zzk().zza("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final void zzaz() {
        if (Thread.currentThread() == this.f21647d) {
            return;
        }
        throw new IllegalStateException("Call expected from network thread");
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final void zzg() {
        if (Thread.currentThread() == this.f21646c) {
            return;
        }
        throw new IllegalStateException("Call expected from worker thread");
    }

    public final Future zzh(Callable callable) throws IllegalStateException {
        c();
        Preconditions.checkNotNull(callable);
        zzfy zzfyVar = new zzfy(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f21646c) {
            if (!this.f21648e.isEmpty()) {
                this.f21734a.zzaA().zzk().zza("Callable skipped the worker queue.");
            }
            zzfyVar.run();
        } else {
            m(zzfyVar);
        }
        return zzfyVar;
    }

    public final Future zzi(Callable callable) throws IllegalStateException {
        c();
        Preconditions.checkNotNull(callable);
        zzfy zzfyVar = new zzfy(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f21646c) {
            zzfyVar.run();
        } else {
            m(zzfyVar);
        }
        return zzfyVar;
    }

    public final void zzo(Runnable runnable) throws IllegalStateException {
        c();
        Preconditions.checkNotNull(runnable);
        zzfy zzfyVar = new zzfy(this, runnable, false, "Task exception on network thread");
        synchronized (this.f21652i) {
            this.f21649f.add(zzfyVar);
            zzfz zzfzVar = this.f21647d;
            if (zzfzVar == null) {
                zzfz zzfzVar2 = new zzfz(this, "Measurement Network", this.f21649f);
                this.f21647d = zzfzVar2;
                zzfzVar2.setUncaughtExceptionHandler(this.f21651h);
                this.f21647d.start();
            } else {
                zzfzVar.a();
            }
        }
    }

    public final void zzp(Runnable runnable) throws IllegalStateException {
        c();
        Preconditions.checkNotNull(runnable);
        m(new zzfy(this, runnable, false, "Task exception on worker thread"));
    }

    public final void zzq(Runnable runnable) throws IllegalStateException {
        c();
        Preconditions.checkNotNull(runnable);
        m(new zzfy(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean zzs() {
        if (Thread.currentThread() == this.f21646c) {
            return true;
        }
        return false;
    }
}
