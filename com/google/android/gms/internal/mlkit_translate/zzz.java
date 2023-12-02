package com.google.android.gms.internal.mlkit_translate;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzz extends zzp {
    public zzz() {
        super(4);
    }

    public final zzz zzc(Object obj) {
        obj.getClass();
        super.zza(obj);
        return this;
    }

    public final zzaa zzd() {
        zzaa zzl;
        int i4 = this.zzb;
        if (i4 != 0) {
            if (i4 != 1) {
                zzl = zzaa.zzl(i4, this.zza);
                this.zzb = zzl.size();
                this.zzc = true;
                return zzl;
            }
            Object obj = this.zza[0];
            obj.getClass();
            return new zzal(obj);
        }
        return zzaj.zza;
    }
}
