package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzsp implements zztq {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zztx zzc = new zztx();
    private final zzqo zzd = new zzqo();
    @Nullable
    private Looper zze;
    @Nullable
    private zzcw zzf;
    @Nullable
    private zzoc zzg;

    @Override // com.google.android.gms.internal.ads.zztq
    public /* synthetic */ zzcw zzL() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzoc zzb() {
        zzoc zzocVar = this.zzg;
        zzdy.zzb(zzocVar);
        return zzocVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzqo zzc(@Nullable zzto zztoVar) {
        return this.zzd.zza(0, zztoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzqo zzd(int i4, @Nullable zzto zztoVar) {
        return this.zzd.zza(0, zztoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zztx zze(@Nullable zzto zztoVar) {
        return this.zzc.zza(0, zztoVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zztx zzf(int i4, @Nullable zzto zztoVar) {
        return this.zzc.zza(0, zztoVar);
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzg(Handler handler, zzqp zzqpVar) {
        this.zzd.zzb(handler, zzqpVar);
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzh(Handler handler, zzty zztyVar) {
        this.zzc.zzb(handler, zztyVar);
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzi(zztp zztpVar) {
        boolean z3 = !this.zzb.isEmpty();
        this.zzb.remove(zztpVar);
        if (z3 && this.zzb.isEmpty()) {
            zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzk(zztp zztpVar) {
        this.zze.getClass();
        boolean isEmpty = this.zzb.isEmpty();
        this.zzb.add(zztpVar);
        if (isEmpty) {
            zzl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzm(zztp zztpVar, @Nullable zzhg zzhgVar, zzoc zzocVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z3 = true;
        if (looper != null && looper != myLooper) {
            z3 = false;
        }
        zzdy.zzd(z3);
        this.zzg = zzocVar;
        zzcw zzcwVar = this.zzf;
        this.zza.add(zztpVar);
        if (this.zze == null) {
            this.zze = myLooper;
            this.zzb.add(zztpVar);
            zzn(zzhgVar);
        } else if (zzcwVar != null) {
            zzk(zztpVar);
            zztpVar.zza(this, zzcwVar);
        }
    }

    protected abstract void zzn(@Nullable zzhg zzhgVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzo(zzcw zzcwVar) {
        this.zzf = zzcwVar;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((zztp) arrayList.get(i4)).zza(this, zzcwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzp(zztp zztpVar) {
        this.zza.remove(zztpVar);
        if (this.zza.isEmpty()) {
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
            this.zzb.clear();
            zzq();
            return;
        }
        zzi(zztpVar);
    }

    protected abstract void zzq();

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzr(zzqp zzqpVar) {
        this.zzd.zzc(zzqpVar);
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzs(zzty zztyVar) {
        this.zzc.zzh(zztyVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzt() {
        if (!this.zzb.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public /* synthetic */ boolean zzu() {
        return true;
    }

    protected void zzj() {
    }

    protected void zzl() {
    }
}
