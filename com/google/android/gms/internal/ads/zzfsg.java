package com.google.android.gms.internal.ads;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfsg extends zzfrv {
    @CheckForNull
    Object[] zzd;
    private int zze;

    public zzfsg() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzfrv, com.google.android.gms.internal.ads.zzfrw
    public final /* bridge */ /* synthetic */ zzfrw zzb(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzfsg zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int zzh = zzfsh.zzh(this.zzb);
            int length = this.zzd.length;
            if (zzh <= length) {
                int hashCode = obj.hashCode();
                int zza = zzfru.zza(hashCode);
                while (true) {
                    Object[] objArr = this.zzd;
                    int i4 = zza & (length - 1);
                    Object obj2 = objArr[i4];
                    if (obj2 == null) {
                        objArr[i4] = obj;
                        this.zze += hashCode;
                        super.zza(obj);
                        break;
                    } else if (obj2.equals(obj)) {
                        break;
                    } else {
                        zza = i4 + 1;
                    }
                }
                return this;
            }
        }
        this.zzd = null;
        super.zza(obj);
        return this;
    }

    public final zzfsg zzg(Iterable iterable) {
        if (this.zzd != null) {
            for (Object obj : iterable) {
                zzf(obj);
            }
        } else {
            super.zzc(iterable);
        }
        return this;
    }

    public final zzfsh zzh() {
        zzfsh zzs;
        boolean zzt;
        int i4 = this.zzb;
        if (i4 != 0) {
            if (i4 != 1) {
                if (this.zzd == null || zzfsh.zzh(i4) != this.zzd.length) {
                    zzs = zzfsh.zzs(this.zzb, this.zza);
                    this.zzb = zzs.size();
                } else {
                    int i5 = this.zzb;
                    Object[] objArr = this.zza;
                    zzt = zzfsh.zzt(i5, objArr.length);
                    if (zzt) {
                        objArr = Arrays.copyOf(objArr, i5);
                    }
                    int i6 = this.zze;
                    Object[] objArr2 = this.zzd;
                    zzs = new zzfts(objArr, i6, objArr2, objArr2.length - 1, this.zzb);
                }
                this.zzc = true;
                this.zzd = null;
                return zzs;
            }
            Object obj = this.zza[0];
            obj.getClass();
            return new zzftz(obj);
        }
        return zzfts.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfsg(int i4) {
        super(i4);
        this.zzd = new Object[zzfsh.zzh(i4)];
    }
}
