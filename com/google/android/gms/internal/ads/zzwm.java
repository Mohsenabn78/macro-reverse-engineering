package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzwm extends zzdd {
    public static final zzwm zzE;
    @Deprecated
    public static final zzwm zzF;
    public static final zzn zzG;
    private static final String zzU;
    private static final String zzV;
    private static final String zzW;
    private static final String zzX;
    private static final String zzY;
    private static final String zzZ;
    private static final String zzaa;
    private static final String zzab;
    private static final String zzac;
    private static final String zzad;
    private static final String zzae;
    private static final String zzaf;
    private static final String zzag;
    private static final String zzah;
    private static final String zzai;
    private static final String zzaj;
    private static final String zzak;
    private static final String zzal;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final boolean zzR;
    public final boolean zzS;
    public final boolean zzT;
    private final SparseArray zzam;
    private final SparseBooleanArray zzan;

    static {
        zzwm zzwmVar = new zzwm(new zzwk());
        zzE = zzwmVar;
        zzF = zzwmVar;
        zzU = Integer.toString(1000, 36);
        zzV = Integer.toString(1001, 36);
        zzW = Integer.toString(1002, 36);
        zzX = Integer.toString(1003, 36);
        zzY = Integer.toString(1004, 36);
        zzZ = Integer.toString(1005, 36);
        zzaa = Integer.toString(1006, 36);
        zzab = Integer.toString(1007, 36);
        zzac = Integer.toString(1008, 36);
        zzad = Integer.toString(1009, 36);
        zzae = Integer.toString(1010, 36);
        zzaf = Integer.toString(1011, 36);
        zzag = Integer.toString(1012, 36);
        zzah = Integer.toString(1013, 36);
        zzai = Integer.toString(1014, 36);
        zzaj = Integer.toString(1015, 36);
        zzak = Integer.toString(1016, 36);
        zzal = Integer.toString(1017, 36);
        zzG = new zzn() { // from class: com.google.android.gms.internal.ads.zzwi
        };
    }

    public static zzwm zzd(Context context) {
        return new zzwm(new zzwk(context));
    }

    @Override // com.google.android.gms.internal.ads.zzdd
    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzwm.class == obj.getClass()) {
            zzwm zzwmVar = (zzwm) obj;
            if (super.equals(zzwmVar) && this.zzH == zzwmVar.zzH && this.zzJ == zzwmVar.zzJ && this.zzL == zzwmVar.zzL && this.zzQ == zzwmVar.zzQ && this.zzR == zzwmVar.zzR && this.zzT == zzwmVar.zzT) {
                SparseBooleanArray sparseBooleanArray = this.zzan;
                SparseBooleanArray sparseBooleanArray2 = zzwmVar.zzan;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i4 = 0;
                    while (true) {
                        if (i4 < size) {
                            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i4)) < 0) {
                                break;
                            }
                            i4++;
                        } else {
                            SparseArray sparseArray = this.zzam;
                            SparseArray sparseArray2 = zzwmVar.zzam;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                for (int i5 = 0; i5 < size2; i5++) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i5));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i5);
                                        Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                zzvn zzvnVar = (zzvn) entry.getKey();
                                                if (map2.containsKey(zzvnVar)) {
                                                    if (!zzfj.zzC(entry.getValue(), map2.get(zzvnVar))) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdd
    public final int hashCode() {
        return (((((((((((((super.hashCode() + 31) * 31) + (this.zzH ? 1 : 0)) * 961) + (this.zzJ ? 1 : 0)) * 961) + (this.zzL ? 1 : 0)) * 28629151) + (this.zzQ ? 1 : 0)) * 31) + (this.zzR ? 1 : 0)) * 961) + (this.zzT ? 1 : 0)) * 31;
    }

    public final zzwk zzc() {
        return new zzwk(this, null);
    }

    @Nullable
    @Deprecated
    public final zzwo zze(int i4, zzvn zzvnVar) {
        Map map = (Map) this.zzam.get(i4);
        if (map != null) {
            return (zzwo) map.get(zzvnVar);
        }
        return null;
    }

    public final boolean zzf(int i4) {
        return this.zzan.get(i4);
    }

    @Deprecated
    public final boolean zzg(int i4, zzvn zzvnVar) {
        Map map = (Map) this.zzam.get(i4);
        if (map != null && map.containsKey(zzvnVar)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zzwm(zzwk zzwkVar) {
        super(zzwkVar);
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        SparseArray sparseArray;
        SparseBooleanArray sparseBooleanArray;
        z3 = zzwkVar.zza;
        this.zzH = z3;
        this.zzI = false;
        z4 = zzwkVar.zzb;
        this.zzJ = z4;
        this.zzK = false;
        z5 = zzwkVar.zzc;
        this.zzL = z5;
        this.zzM = false;
        this.zzN = false;
        this.zzO = false;
        this.zzP = false;
        z6 = zzwkVar.zzd;
        this.zzQ = z6;
        z7 = zzwkVar.zze;
        this.zzR = z7;
        this.zzS = false;
        z8 = zzwkVar.zzf;
        this.zzT = z8;
        sparseArray = zzwkVar.zzg;
        this.zzam = sparseArray;
        sparseBooleanArray = zzwkVar.zzh;
        this.zzan = sparseBooleanArray;
    }
}
