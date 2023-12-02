package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzlg extends zzhq {
    public static final /* synthetic */ int zzc = 0;
    private final int zzd;
    private final int zze;
    private final int[] zzf;
    private final int[] zzg;
    private final zzcw[] zzh;
    private final Object[] zzi;
    private final HashMap zzj;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzlg(Collection collection, zzvi zzviVar) {
        super(false, zzviVar);
        int i4 = 0;
        int size = collection.size();
        this.zzf = new int[size];
        this.zzg = new int[size];
        this.zzh = new zzcw[size];
        this.zzi = new Object[size];
        this.zzj = new HashMap();
        Iterator it = collection.iterator();
        int i5 = 0;
        int i6 = 0;
        while (it.hasNext()) {
            zzkq zzkqVar = (zzkq) it.next();
            this.zzh[i6] = zzkqVar.zza();
            this.zzg[i6] = i4;
            this.zzf[i6] = i5;
            i4 += this.zzh[i6].zzc();
            i5 += this.zzh[i6].zzb();
            this.zzi[i6] = zzkqVar.zzb();
            this.zzj.put(this.zzi[i6], Integer.valueOf(i6));
            i6++;
        }
        this.zzd = i4;
        this.zze = i5;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzcw
    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhq
    protected final int zzp(Object obj) {
        Integer num = (Integer) this.zzj.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.ads.zzhq
    protected final int zzq(int i4) {
        return zzfj.zzb(this.zzf, i4 + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhq
    protected final int zzr(int i4) {
        return zzfj.zzb(this.zzg, i4 + 1, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhq
    protected final int zzs(int i4) {
        return this.zzf[i4];
    }

    @Override // com.google.android.gms.internal.ads.zzhq
    protected final int zzt(int i4) {
        return this.zzg[i4];
    }

    @Override // com.google.android.gms.internal.ads.zzhq
    protected final zzcw zzu(int i4) {
        return this.zzh[i4];
    }

    @Override // com.google.android.gms.internal.ads.zzhq
    protected final Object zzv(int i4) {
        return this.zzi[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List zzw() {
        return Arrays.asList(this.zzh);
    }
}
