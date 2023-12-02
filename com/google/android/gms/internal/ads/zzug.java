package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzug extends zzsx {
    private static final zzbp zza;
    private final zztq[] zzb;
    private final zzcw[] zzc;
    private final ArrayList zzd;
    private final Map zze;
    private final zzfsy zzf;
    private int zzg;
    private long[][] zzh;
    @Nullable
    private zzuf zzi;
    private final zzsz zzj;

    static {
        zzar zzarVar = new zzar();
        zzarVar.zza("MergingMediaSource");
        zza = zzarVar.zzc();
    }

    public zzug(boolean z3, boolean z4, zztq... zztqVarArr) {
        zzsz zzszVar = new zzsz();
        this.zzb = zztqVarArr;
        this.zzj = zzszVar;
        this.zzd = new ArrayList(Arrays.asList(zztqVarArr));
        this.zzg = -1;
        this.zzc = new zzcw[zztqVarArr.length];
        this.zzh = new long[0];
        this.zze = new HashMap();
        this.zzf = zzftg.zzb(8).zzb(2).zza();
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final void zzF(zztm zztmVar) {
        zzue zzueVar = (zzue) zztmVar;
        int i4 = 0;
        while (true) {
            zztq[] zztqVarArr = this.zzb;
            if (i4 < zztqVarArr.length) {
                zztqVarArr[i4].zzF(zzueVar.zzn(i4));
                i4++;
            } else {
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final zztm zzH(zzto zztoVar, zzxp zzxpVar, long j4) {
        int length = this.zzb.length;
        zztm[] zztmVarArr = new zztm[length];
        int zza2 = this.zzc[0].zza(zztoVar.zza);
        for (int i4 = 0; i4 < length; i4++) {
            zztmVarArr[i4] = this.zzb[i4].zzH(zztoVar.zzc(this.zzc[i4].zzf(zza2)), zzxpVar, j4 - this.zzh[zza2][i4]);
        }
        return new zzue(this.zzj, this.zzh[zza2], zztmVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zztq
    public final zzbp zzI() {
        zztq[] zztqVarArr = this.zzb;
        if (zztqVarArr.length > 0) {
            return zztqVarArr[0].zzI();
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsx, com.google.android.gms.internal.ads.zzsp
    public final void zzn(@Nullable zzhg zzhgVar) {
        super.zzn(zzhgVar);
        for (int i4 = 0; i4 < this.zzb.length; i4++) {
            zzA(Integer.valueOf(i4), this.zzb[i4]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsx, com.google.android.gms.internal.ads.zzsp
    public final void zzq() {
        super.zzq();
        Arrays.fill(this.zzc, (Object) null);
        this.zzg = -1;
        this.zzi = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsx
    @Nullable
    public final /* bridge */ /* synthetic */ zzto zzx(Object obj, zzto zztoVar) {
        if (((Integer) obj).intValue() == 0) {
            return zztoVar;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzsx, com.google.android.gms.internal.ads.zztq
    public final void zzy() throws IOException {
        zzuf zzufVar = this.zzi;
        if (zzufVar == null) {
            super.zzy();
            return;
        }
        throw zzufVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzsx
    public final /* bridge */ /* synthetic */ void zzz(Object obj, zztq zztqVar, zzcw zzcwVar) {
        int i4;
        if (this.zzi == null) {
            if (this.zzg == -1) {
                i4 = zzcwVar.zzb();
                this.zzg = i4;
            } else {
                int zzb = zzcwVar.zzb();
                int i5 = this.zzg;
                if (zzb != i5) {
                    this.zzi = new zzuf(0);
                    return;
                }
                i4 = i5;
            }
            if (this.zzh.length == 0) {
                this.zzh = (long[][]) Array.newInstance(Long.TYPE, i4, this.zzc.length);
            }
            this.zzd.remove(zztqVar);
            this.zzc[((Integer) obj).intValue()] = zzcwVar;
            if (this.zzd.isEmpty()) {
                zzo(this.zzc[0]);
            }
        }
    }
}
