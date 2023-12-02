package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfy extends FutureTask implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    private final long f21637a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f21638b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21639c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzga f21640d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfy(zzga zzgaVar, Runnable runnable, boolean z3, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        this.f21640d = zzgaVar;
        Preconditions.checkNotNull(str);
        atomicLong = zzga.f21645l;
        long andIncrement = atomicLong.getAndIncrement();
        this.f21637a = andIncrement;
        this.f21639c = str;
        this.f21638b = z3;
        if (andIncrement == Long.MAX_VALUE) {
            zzgaVar.f21734a.zzaA().zzd().zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
        zzfy zzfyVar = (zzfy) obj;
        boolean z3 = this.f21638b;
        if (z3 != zzfyVar.f21638b) {
            if (!z3) {
                return 1;
            }
            return -1;
        }
        int i4 = (this.f21637a > zzfyVar.f21637a ? 1 : (this.f21637a == zzfyVar.f21637a ? 0 : -1));
        if (i4 < 0) {
            return -1;
        }
        if (i4 > 0) {
            return 1;
        }
        this.f21640d.f21734a.zzaA().zzh().zzb("Two tasks share the same index. index", Long.valueOf(this.f21637a));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.f21640d.f21734a.zzaA().zzd().zzb(this.f21639c, th);
        if ((th instanceof zzfw) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfy(zzga zzgaVar, Callable callable, boolean z3, String str) {
        super(callable);
        AtomicLong atomicLong;
        this.f21640d = zzgaVar;
        Preconditions.checkNotNull("Task exception on worker thread");
        atomicLong = zzga.f21645l;
        long andIncrement = atomicLong.getAndIncrement();
        this.f21637a = andIncrement;
        this.f21639c = "Task exception on worker thread";
        this.f21638b = z3;
        if (andIncrement == Long.MAX_VALUE) {
            zzgaVar.f21734a.zzaA().zzd().zza("Tasks index overflow");
        }
    }
}
