package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaln {
    private final AtomicInteger zza;
    private final Set zzb;
    private final PriorityBlockingQueue zzc;
    private final PriorityBlockingQueue zzd;
    private final zzaku zze;
    private final zzald zzf;
    private final zzale[] zzg;
    private zzakw zzh;
    private final List zzi;
    private final List zzj;
    private final zzalb zzk;

    public zzaln(zzaku zzakuVar, zzald zzaldVar, int i4) {
        zzalb zzalbVar = new zzalb(new Handler(Looper.getMainLooper()));
        this.zza = new AtomicInteger();
        this.zzb = new HashSet();
        this.zzc = new PriorityBlockingQueue();
        this.zzd = new PriorityBlockingQueue();
        this.zzi = new ArrayList();
        this.zzj = new ArrayList();
        this.zze = zzakuVar;
        this.zzf = zzaldVar;
        this.zzg = new zzale[4];
        this.zzk = zzalbVar;
    }

    public final zzalk zza(zzalk zzalkVar) {
        zzalkVar.zzf(this);
        synchronized (this.zzb) {
            this.zzb.add(zzalkVar);
        }
        zzalkVar.zzg(this.zza.incrementAndGet());
        zzalkVar.zzm("add-to-queue");
        zzc(zzalkVar, 0);
        this.zzc.add(zzalkVar);
        return zzalkVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzalk zzalkVar) {
        synchronized (this.zzb) {
            this.zzb.remove(zzalkVar);
        }
        synchronized (this.zzi) {
            for (zzalm zzalmVar : this.zzi) {
                zzalmVar.zza();
            }
        }
        zzc(zzalkVar, 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(zzalk zzalkVar, int i4) {
        synchronized (this.zzj) {
            for (zzall zzallVar : this.zzj) {
                zzallVar.zza();
            }
        }
    }

    public final void zzd() {
        zzakw zzakwVar = this.zzh;
        if (zzakwVar != null) {
            zzakwVar.zzb();
        }
        zzale[] zzaleVarArr = this.zzg;
        for (int i4 = 0; i4 < 4; i4++) {
            zzale zzaleVar = zzaleVarArr[i4];
            if (zzaleVar != null) {
                zzaleVar.zza();
            }
        }
        zzakw zzakwVar2 = new zzakw(this.zzc, this.zzd, this.zze, this.zzk);
        this.zzh = zzakwVar2;
        zzakwVar2.start();
        for (int i5 = 0; i5 < 4; i5++) {
            zzale zzaleVar2 = new zzale(this.zzd, this.zzf, this.zze, this.zzk);
            this.zzg[i5] = zzaleVar2;
            zzaleVar2.start();
        }
    }
}
