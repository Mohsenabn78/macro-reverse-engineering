package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzdd {
    private static final String zzE;
    private static final String zzF;
    private static final String zzG;
    private static final String zzH;
    private static final String zzI;
    private static final String zzJ;
    private static final String zzK;
    private static final String zzL;
    private static final String zzM;
    private static final String zzN;
    private static final String zzO;
    private static final String zzP;
    private static final String zzQ;
    private static final String zzR;
    private static final String zzS;
    private static final String zzT;
    private static final String zzU;
    private static final String zzV;
    private static final String zzW;
    private static final String zzX;
    private static final String zzY;
    private static final String zzZ;
    public static final zzdd zza;
    private static final String zzaa;
    private static final String zzab;
    private static final String zzac;
    private static final String zzad;
    private static final String zzae;
    private static final String zzaf;
    private static final String zzag;
    @Deprecated
    public static final zzdd zzb;
    @Deprecated
    public static final zzn zzc;
    public final boolean zzA;
    public final boolean zzB;
    public final zzfsf zzC;
    public final zzfsh zzD;
    public final int zzd = Integer.MAX_VALUE;
    public final int zze = Integer.MAX_VALUE;
    public final int zzf = Integer.MAX_VALUE;
    public final int zzg = Integer.MAX_VALUE;
    public final int zzh = 0;
    public final int zzi = 0;
    public final int zzj = 0;
    public final int zzk = 0;
    public final int zzl;
    public final int zzm;
    public final boolean zzn;
    public final zzfsc zzo;
    public final int zzp;
    public final zzfsc zzq;
    public final int zzr;
    public final int zzs;
    public final int zzt;
    public final zzfsc zzu;
    public final int zzv;
    public final zzfsc zzw;
    public final int zzx;
    public final int zzy;
    public final boolean zzz;

    static {
        zzdd zzddVar = new zzdd(new zzdc());
        zza = zzddVar;
        zzb = zzddVar;
        zzE = Integer.toString(1, 36);
        zzF = Integer.toString(2, 36);
        zzG = Integer.toString(3, 36);
        zzH = Integer.toString(4, 36);
        zzI = Integer.toString(5, 36);
        zzJ = Integer.toString(6, 36);
        zzK = Integer.toString(7, 36);
        zzL = Integer.toString(8, 36);
        zzM = Integer.toString(9, 36);
        zzN = Integer.toString(10, 36);
        zzO = Integer.toString(11, 36);
        zzP = Integer.toString(12, 36);
        zzQ = Integer.toString(13, 36);
        zzR = Integer.toString(14, 36);
        zzS = Integer.toString(15, 36);
        zzT = Integer.toString(16, 36);
        zzU = Integer.toString(17, 36);
        zzV = Integer.toString(18, 36);
        zzW = Integer.toString(19, 36);
        zzX = Integer.toString(20, 36);
        zzY = Integer.toString(21, 36);
        zzZ = Integer.toString(22, 36);
        zzaa = Integer.toString(23, 36);
        zzab = Integer.toString(24, 36);
        zzac = Integer.toString(25, 36);
        zzad = Integer.toString(26, 36);
        zzae = Integer.toString(27, 36);
        zzaf = Integer.toString(28, 36);
        zzag = Integer.toString(29, 36);
        zzc = new zzn() { // from class: com.google.android.gms.internal.ads.zzdb
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdd(zzdc zzdcVar) {
        int i4;
        int i5;
        boolean z3;
        zzfsc zzfscVar;
        zzfsc zzfscVar2;
        zzfsc zzfscVar3;
        zzfsc zzfscVar4;
        int i6;
        HashMap hashMap;
        HashSet hashSet;
        i4 = zzdcVar.zze;
        this.zzl = i4;
        i5 = zzdcVar.zzf;
        this.zzm = i5;
        z3 = zzdcVar.zzg;
        this.zzn = z3;
        zzfscVar = zzdcVar.zzh;
        this.zzo = zzfscVar;
        this.zzp = 0;
        zzfscVar2 = zzdcVar.zzi;
        this.zzq = zzfscVar2;
        this.zzr = 0;
        this.zzs = Integer.MAX_VALUE;
        this.zzt = Integer.MAX_VALUE;
        zzfscVar3 = zzdcVar.zzl;
        this.zzu = zzfscVar3;
        this.zzv = 0;
        zzfscVar4 = zzdcVar.zzm;
        this.zzw = zzfscVar4;
        i6 = zzdcVar.zzn;
        this.zzx = i6;
        this.zzy = 0;
        this.zzz = false;
        this.zzA = false;
        this.zzB = false;
        hashMap = zzdcVar.zzo;
        this.zzC = zzfsf.zzc(hashMap);
        hashSet = zzdcVar.zzp;
        this.zzD = zzfsh.zzl(hashSet);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzdd zzddVar = (zzdd) obj;
            if (this.zzn == zzddVar.zzn && this.zzl == zzddVar.zzl && this.zzm == zzddVar.zzm && this.zzo.equals(zzddVar.zzo) && this.zzq.equals(zzddVar.zzq) && this.zzu.equals(zzddVar.zzu) && this.zzw.equals(zzddVar.zzw) && this.zzx == zzddVar.zzx && this.zzC.equals(zzddVar.zzC) && this.zzD.equals(zzddVar.zzD)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.zzn ? 1 : 0) - 1048002209) * 31) + this.zzl) * 31) + this.zzm) * 31) + this.zzo.hashCode()) * 961) + this.zzq.hashCode()) * 961) + Integer.MAX_VALUE) * 31) + Integer.MAX_VALUE) * 31) + this.zzu.hashCode()) * 923521) + this.zzw.hashCode()) * 31) + this.zzx) * 28629151) + this.zzC.hashCode()) * 31) + this.zzD.hashCode();
    }
}
