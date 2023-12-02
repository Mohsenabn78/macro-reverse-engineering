package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfvb extends zzfvh {
    private static final Logger zza = Logger.getLogger(zzfvb.class.getName());
    @CheckForNull
    private zzfrx zzb;
    private final boolean zzc;
    private final boolean zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfvb(zzfrx zzfrxVar, boolean z3, boolean z4) {
        super(zzfrxVar.size());
        this.zzb = zzfrxVar;
        this.zzc = z3;
        this.zze = z4;
    }

    private final void zzH(int i4, Future future) {
        try {
            zzg(i4, zzfwc.zzo(future));
        } catch (Error e4) {
            e = e4;
            zzJ(e);
        } catch (RuntimeException e5) {
            e = e5;
            zzJ(e);
        } catch (ExecutionException e6) {
            zzJ(e6.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzI */
    public final void zzy(@CheckForNull zzfrx zzfrxVar) {
        boolean z3;
        int zzB = zzB();
        int i4 = 0;
        if (zzB >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzfph.zzi(z3, "Less than 0 remaining futures");
        if (zzB == 0) {
            if (zzfrxVar != null) {
                zzfuc it = zzfrxVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzH(i4, future);
                    }
                    i4++;
                }
            }
            zzG();
            zzv();
            zzz(2);
        }
    }

    private final void zzJ(Throwable th) {
        th.getClass();
        if (this.zzc && !zze(th) && zzL(zzD(), th)) {
            zzK(th);
        } else if (th instanceof Error) {
            zzK(th);
        }
    }

    private static void zzK(Throwable th) {
        String str;
        if (true != (th instanceof Error)) {
            str = "Got more than one input Future failure. Logging failures after the first";
        } else {
            str = "Input Future failed with Error";
        }
        zza.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", str, th);
    }

    private static boolean zzL(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfuq
    @CheckForNull
    public final String zza() {
        zzfrx zzfrxVar = this.zzb;
        if (zzfrxVar != null) {
            return "futures=".concat(zzfrxVar.toString());
        }
        return super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzfuq
    protected final void zzb() {
        zzfrx zzfrxVar = this.zzb;
        boolean z3 = true;
        zzz(1);
        boolean isCancelled = isCancelled();
        if (zzfrxVar == null) {
            z3 = false;
        }
        if (z3 & isCancelled) {
            boolean zzu = zzu();
            zzfuc it = zzfrxVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zzu);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    final void zzf(Set set) {
        set.getClass();
        if (!isCancelled()) {
            Throwable zzm = zzm();
            zzm.getClass();
            zzL(set, zzm);
        }
    }

    abstract void zzg(int i4, Object obj);

    abstract void zzv();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzw() {
        final zzfrx zzfrxVar;
        zzfrx zzfrxVar2 = this.zzb;
        zzfrxVar2.getClass();
        if (zzfrxVar2.isEmpty()) {
            zzv();
        } else if (this.zzc) {
            zzfuc it = this.zzb.iterator();
            final int i4 = 0;
            while (it.hasNext()) {
                final zzfwm zzfwmVar = (zzfwm) it.next();
                zzfwmVar.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfuz
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzfvb.this.zzx(zzfwmVar, i4);
                    }
                }, zzfvq.INSTANCE);
                i4++;
            }
        } else {
            if (this.zze) {
                zzfrxVar = this.zzb;
            } else {
                zzfrxVar = null;
            }
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfva
                @Override // java.lang.Runnable
                public final void run() {
                    zzfvb.this.zzy(zzfrxVar);
                }
            };
            zzfuc it2 = this.zzb.iterator();
            while (it2.hasNext()) {
                ((zzfwm) it2.next()).zzc(runnable, zzfvq.INSTANCE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(zzfwm zzfwmVar, int i4) {
        try {
            if (zzfwmVar.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzH(i4, zzfwmVar);
            }
        } finally {
            zzy(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzz(int i4) {
        this.zzb = null;
    }
}
