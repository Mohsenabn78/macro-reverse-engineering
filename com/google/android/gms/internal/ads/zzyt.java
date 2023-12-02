package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzyt {
    private final zzzf zza;
    private final zzyu zzb;
    private final zzdj zze;
    private Handler zzf;
    @Nullable
    private zzdl zzg;
    @Nullable
    private CopyOnWriteArrayList zzh;
    @Nullable
    private Pair zzi;
    private final ArrayDeque zzc = new ArrayDeque();
    private final ArrayDeque zzd = new ArrayDeque();
    private boolean zzj = true;
    private final zzdn zzk = zzdn.zza;

    public zzyt(zzdj zzdjVar, zzzf zzzfVar, zzyu zzyuVar) {
        this.zze = zzdjVar;
        this.zza = zzzfVar;
        this.zzb = zzyuVar;
    }

    public final void zza(String str) {
        Context context;
        context = this.zzb.zze;
        if (zzfj.zza >= 29) {
            int i4 = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
        }
    }

    public final void zzb(Surface surface, zzfb zzfbVar) {
        Pair pair = this.zzi;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzfb) this.zzi.second).equals(zzfbVar)) {
            return;
        }
        this.zzi = Pair.create(surface, zzfbVar);
    }

    public final void zzc(List list) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.zzh;
        if (copyOnWriteArrayList == null) {
            this.zzh = new CopyOnWriteArrayList(list);
            return;
        }
        copyOnWriteArrayList.clear();
        this.zzh.addAll(list);
    }

    public final boolean zzd(zzam zzamVar, long j4) throws zzih {
        Pair create;
        zzih zzbe;
        boolean zzaP;
        Context context;
        int i4;
        if (!this.zzj) {
            return false;
        }
        if (this.zzh == null) {
            this.zzj = false;
            return false;
        }
        this.zzf = zzfj.zzt(null);
        zzs zzsVar = zzamVar.zzy;
        zzs zzsVar2 = zzs.zza;
        try {
            if (zzsVar != null) {
                int i5 = zzsVar.zzf;
                if (i5 != 7) {
                    if (i5 == 6) {
                        create = Pair.create(zzsVar, zzsVar);
                    }
                } else {
                    zzr zzc = zzsVar.zzc();
                    zzc.zzc(6);
                    create = Pair.create(zzsVar, zzc.zzd());
                }
                zzaP = zzyu.zzaP();
                if (!zzaP && (i4 = zzamVar.zzu) != 0) {
                    this.zzh.add(0, zzys.zza(i4));
                }
                zzdj zzdjVar = this.zze;
                context = this.zzb.zze;
                CopyOnWriteArrayList copyOnWriteArrayList = this.zzh;
                copyOnWriteArrayList.getClass();
                zzs zzsVar3 = (zzs) create.second;
                final Handler handler = this.zzf;
                handler.getClass();
                this.zzg = zzdjVar.zza(context, copyOnWriteArrayList, zzv.zzb, (zzs) create.first, zzsVar3, false, new Executor() { // from class: com.google.android.gms.internal.ads.zzyq
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        handler.post(runnable);
                    }
                }, new zzyr(this, zzamVar));
                throw null;
            }
            zzaP = zzyu.zzaP();
            if (!zzaP) {
                this.zzh.add(0, zzys.zza(i4));
            }
            zzdj zzdjVar2 = this.zze;
            context = this.zzb.zze;
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.zzh;
            copyOnWriteArrayList2.getClass();
            zzs zzsVar32 = (zzs) create.second;
            final Handler handler2 = this.zzf;
            handler2.getClass();
            this.zzg = zzdjVar2.zza(context, copyOnWriteArrayList2, zzv.zzb, (zzs) create.first, zzsVar32, false, new Executor() { // from class: com.google.android.gms.internal.ads.zzyq
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    handler2.post(runnable);
                }
            }, new zzyr(this, zzamVar));
            throw null;
        } catch (Exception e4) {
            zzbe = this.zzb.zzbe(e4, zzamVar, false, 7000);
            throw zzbe;
        }
        zzs zzsVar4 = zzs.zza;
        create = Pair.create(zzsVar4, zzsVar4);
    }
}
