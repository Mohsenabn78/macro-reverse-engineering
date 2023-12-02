package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzwk extends zzdc {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;

    @Deprecated
    public zzwk() {
        this.zzg = new SparseArray();
        this.zzh = new SparseBooleanArray();
        zzv();
    }

    private final void zzv() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final /* synthetic */ zzdc zze(int i4, int i5, boolean z3) {
        super.zze(i4, i5, true);
        return this;
    }

    public final zzwk zzo(int i4, boolean z3) {
        if (this.zzh.get(i4) == z3) {
            return this;
        }
        if (z3) {
            this.zzh.put(i4, true);
        } else {
            this.zzh.delete(i4);
        }
        return this;
    }

    public zzwk(Context context) {
        super.zzd(context);
        Point zzr = zzfj.zzr(context);
        zze(zzr.x, zzr.y, true);
        this.zzg = new SparseArray();
        this.zzh = new SparseBooleanArray();
        zzv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzwk(zzwm zzwmVar, zzwj zzwjVar) {
        super(zzwmVar);
        this.zza = zzwmVar.zzH;
        this.zzb = zzwmVar.zzJ;
        this.zzc = zzwmVar.zzL;
        this.zzd = zzwmVar.zzQ;
        this.zze = zzwmVar.zzR;
        this.zzf = zzwmVar.zzT;
        SparseArray zza = zzwm.zza(zzwmVar);
        SparseArray sparseArray = new SparseArray();
        for (int i4 = 0; i4 < zza.size(); i4++) {
            sparseArray.put(zza.keyAt(i4), new HashMap((Map) zza.valueAt(i4)));
        }
        this.zzg = sparseArray;
        this.zzh = zzwm.zzb(zzwmVar).clone();
    }
}
