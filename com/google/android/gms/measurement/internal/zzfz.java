package com.google.android.gms.measurement.internal;

import android.os.Process;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfz extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Object f21641a;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue f21642b;
    @GuardedBy("threadLifeCycleLock")

    /* renamed from: c  reason: collision with root package name */
    private boolean f21643c = false;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzga f21644d;

    public zzfz(zzga zzgaVar, String str, BlockingQueue blockingQueue) {
        this.f21644d = zzgaVar;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.f21641a = new Object();
        this.f21642b = blockingQueue;
        setName(str);
    }

    private final void b() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        zzfz zzfzVar;
        zzfz zzfzVar2;
        obj = this.f21644d.f21652i;
        synchronized (obj) {
            if (!this.f21643c) {
                semaphore = this.f21644d.f21653j;
                semaphore.release();
                obj2 = this.f21644d.f21652i;
                obj2.notifyAll();
                zzga zzgaVar = this.f21644d;
                zzfzVar = zzgaVar.f21646c;
                if (this != zzfzVar) {
                    zzfzVar2 = zzgaVar.f21647d;
                    if (this == zzfzVar2) {
                        zzgaVar.f21647d = null;
                    } else {
                        zzgaVar.f21734a.zzaA().zzd().zza("Current scheduler thread is neither worker nor network");
                    }
                } else {
                    zzgaVar.f21646c = null;
                }
                this.f21643c = true;
            }
        }
    }

    private final void c(InterruptedException interruptedException) {
        this.f21644d.f21734a.zzaA().zzk().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        synchronized (this.f21641a) {
            this.f21641a.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Semaphore semaphore;
        int i4;
        Object obj;
        boolean z3 = false;
        while (!z3) {
            try {
                semaphore = this.f21644d.f21653j;
                semaphore.acquire();
                z3 = true;
            } catch (InterruptedException e4) {
                c(e4);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                zzfy zzfyVar = (zzfy) this.f21642b.poll();
                if (zzfyVar != null) {
                    if (true != zzfyVar.f21638b) {
                        i4 = 10;
                    } else {
                        i4 = threadPriority;
                    }
                    Process.setThreadPriority(i4);
                    zzfyVar.run();
                } else {
                    synchronized (this.f21641a) {
                        if (this.f21642b.peek() == null) {
                            zzga.l(this.f21644d);
                            try {
                                this.f21641a.wait(30000L);
                            } catch (InterruptedException e5) {
                                c(e5);
                            }
                        }
                    }
                    obj = this.f21644d.f21652i;
                    synchronized (obj) {
                        if (this.f21642b.peek() == null) {
                            b();
                            return;
                        }
                    }
                }
            }
        } finally {
            b();
        }
    }
}
