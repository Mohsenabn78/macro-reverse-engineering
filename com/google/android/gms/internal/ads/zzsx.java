package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzsx extends zzsp {
    private final HashMap zza = new HashMap();
    @Nullable
    private Handler zzb;
    @Nullable
    private zzhg zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzA(final Object obj, zztq zztqVar) {
        zzdy.zzd(!this.zza.containsKey(obj));
        zztp zztpVar = new zztp() { // from class: com.google.android.gms.internal.ads.zzsu
            @Override // com.google.android.gms.internal.ads.zztp
            public final void zza(zztq zztqVar2, zzcw zzcwVar) {
                zzsx.this.zzz(obj, zztqVar2, zzcwVar);
            }
        };
        zzsv zzsvVar = new zzsv(this, obj);
        this.zza.put(obj, new zzsw(zztqVar, zztpVar, zzsvVar));
        Handler handler = this.zzb;
        handler.getClass();
        zztqVar.zzh(handler, zzsvVar);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zztqVar.zzg(handler2, zzsvVar);
        zztqVar.zzm(zztpVar, this.zzc, zzb());
        if (!zzt()) {
            zztqVar.zzi(zztpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    @CallSuper
    protected final void zzj() {
        for (zzsw zzswVar : this.zza.values()) {
            zzswVar.zza.zzi(zzswVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    @CallSuper
    protected final void zzl() {
        for (zzsw zzswVar : this.zza.values()) {
            zzswVar.zza.zzk(zzswVar.zzb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsp
    @CallSuper
    public void zzn(@Nullable zzhg zzhgVar) {
        this.zzc = zzhgVar;
        this.zzb = zzfj.zzt(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsp
    @CallSuper
    public void zzq() {
        for (zzsw zzswVar : this.zza.values()) {
            zzswVar.zza.zzp(zzswVar.zzb);
            zzswVar.zza.zzs(zzswVar.zzc);
            zzswVar.zza.zzr(zzswVar.zzc);
        }
        this.zza.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzv(Object obj, int i4) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public zzto zzx(Object obj, zzto zztoVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zztq
    @CallSuper
    public void zzy() throws IOException {
        for (zzsw zzswVar : this.zza.values()) {
            zzswVar.zza.zzy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void zzz(Object obj, zztq zztqVar, zzcw zzcwVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public long zzw(Object obj, long j4) {
        return j4;
    }
}
