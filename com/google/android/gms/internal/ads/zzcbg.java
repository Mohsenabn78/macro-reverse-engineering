package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzcbg extends TextureView implements zzccd {
    protected final zzcbu zza;
    protected final zzcce zzb;

    public zzcbg(Context context) {
        super(context);
        this.zza = new zzcbu();
        this.zzb = new zzcce(context, this);
    }

    public void zzC(@Nullable String str, @Nullable String[] strArr, @Nullable Integer num) {
        zzs(str);
    }

    public abstract int zza();

    public abstract int zzb();

    public abstract int zzc();

    public abstract int zzd();

    public abstract int zze();

    public abstract long zzf();

    public abstract long zzg();

    public abstract long zzh();

    public abstract String zzj();

    public abstract void zzn();

    public abstract void zzo();

    public abstract void zzp();

    public abstract void zzq(int i4);

    public abstract void zzr(zzcbf zzcbfVar);

    public abstract void zzs(@Nullable String str);

    public abstract void zzt();

    public abstract void zzu(float f4, float f5);

    @Nullable
    public Integer zzw() {
        return null;
    }

    public void zzA(int i4) {
    }

    public void zzB(int i4) {
    }

    public void zzx(int i4) {
    }

    public void zzy(int i4) {
    }

    public void zzz(int i4) {
    }
}
