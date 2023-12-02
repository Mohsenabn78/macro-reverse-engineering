package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfuq;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import net.bytebuddy.description.method.MethodDescription;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
abstract class zzfvh extends zzfuq.zzi {
    private static final zzfvd zzbb;
    private static final Logger zzbc = Logger.getLogger(zzfvh.class.getName());
    private volatile int remaining;
    @CheckForNull
    private volatile Set<Throwable> seenExceptions = null;

    static {
        zzfvd zzfvgVar;
        Throwable th;
        try {
            zzfvgVar = new zzfve(AtomicReferenceFieldUpdater.newUpdater(zzfvh.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzfvh.class, "remaining"));
            th = null;
        } catch (Error | RuntimeException e4) {
            zzfvgVar = new zzfvg(null);
            th = e4;
        }
        zzbb = zzfvgVar;
        if (th != null) {
            zzbc.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", MethodDescription.TYPE_INITIALIZER_INTERNAL_NAME, "SafeAtomicHelper is broken!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfvh(int i4) {
        this.remaining = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzB() {
        return zzbb.zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set zzD() {
        Set<Throwable> set = this.seenExceptions;
        if (set == null) {
            Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
            zzf(newSetFromMap);
            zzbb.zzb(this, null, newSetFromMap);
            Set<Throwable> set2 = this.seenExceptions;
            set2.getClass();
            return set2;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG() {
        this.seenExceptions = null;
    }

    abstract void zzf(Set set);
}
