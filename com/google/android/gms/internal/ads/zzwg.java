package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.LocaleList;
import android.text.TextUtils;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzwg extends zzwu implements Comparable {
    private final int zze;
    private final boolean zzf;
    @Nullable
    private final String zzg;
    private final zzwm zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    public zzwg(int i4, zzcy zzcyVar, int i5, zzwm zzwmVar, int i6, boolean z3, zzfpi zzfpiVar) {
        super(i4, zzcyVar, i5);
        int i7;
        int i8;
        boolean z4;
        String[] strArr;
        int i9;
        boolean z5;
        boolean z6;
        boolean z7;
        LocaleList locales;
        String languageTags;
        this.zzh = zzwmVar;
        this.zzg = zzwy.zzg(this.zzd.zzd);
        int i10 = 0;
        this.zzi = zzwy.zzn(i6, false);
        int i11 = 0;
        while (true) {
            i7 = Integer.MAX_VALUE;
            if (i11 < zzwmVar.zzq.size()) {
                i8 = zzwy.zza(this.zzd, (String) zzwmVar.zzq.get(i11), false);
                if (i8 > 0) {
                    break;
                }
                i11++;
            } else {
                i11 = Integer.MAX_VALUE;
                i8 = 0;
                break;
            }
        }
        this.zzk = i11;
        this.zzj = i8;
        int i12 = this.zzd.zzf;
        this.zzl = Integer.bitCount(0);
        zzam zzamVar = this.zzd;
        int i13 = zzamVar.zzf;
        this.zzm = true;
        if (1 != (zzamVar.zze & 1)) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.zzp = z4;
        this.zzq = zzamVar.zzz;
        this.zzr = zzamVar.zzA;
        this.zzs = zzamVar.zzi;
        this.zzf = zzfpiVar.zza(zzamVar);
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (zzfj.zza >= 24) {
            locales = configuration.getLocales();
            languageTags = locales.toLanguageTags();
            strArr = languageTags.split(",", -1);
        } else {
            strArr = new String[]{zzfj.zzx(configuration.locale)};
        }
        for (int i14 = 0; i14 < strArr.length; i14++) {
            strArr[i14] = zzfj.zzz(strArr[i14]);
        }
        int i15 = 0;
        while (true) {
            if (i15 < strArr.length) {
                i9 = zzwy.zza(this.zzd, strArr[i15], false);
                if (i9 > 0) {
                    break;
                }
                i15++;
            } else {
                i15 = Integer.MAX_VALUE;
                i9 = 0;
                break;
            }
        }
        this.zzn = i15;
        this.zzo = i9;
        int i16 = 0;
        while (true) {
            if (i16 >= zzwmVar.zzu.size()) {
                break;
            }
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzwmVar.zzu.get(i16))) {
                i7 = i16;
                break;
            }
            i16++;
        }
        this.zzt = i7;
        if ((i6 & 384) == 128) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.zzu = z5;
        if ((i6 & 64) == 64) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.zzv = z6;
        zzwm zzwmVar2 = this.zzh;
        if (zzwy.zzn(i6, zzwmVar2.zzR) && ((z7 = this.zzf) || zzwmVar2.zzL)) {
            i10 = (!zzwy.zzn(i6, false) || !z7 || this.zzd.zzi == -1 || (!zzwmVar2.zzT && z3)) ? 1 : 2;
        }
        this.zze = i10;
    }

    @Override // java.lang.Comparable
    /* renamed from: zza */
    public final int compareTo(zzwg zzwgVar) {
        zzftl zzftlVar;
        zzftl zza;
        zzftl zzftlVar2;
        if (!this.zzf || !this.zzi) {
            zzftlVar = zzwy.zzc;
            zza = zzftlVar.zza();
        } else {
            zza = zzwy.zzc;
        }
        zzfrr zzc = zzfrr.zzj().zzd(this.zzi, zzwgVar.zzi).zzc(Integer.valueOf(this.zzk), Integer.valueOf(zzwgVar.zzk), zzftl.zzc().zza()).zzb(this.zzj, zzwgVar.zzj).zzb(this.zzl, zzwgVar.zzl).zzd(this.zzp, zzwgVar.zzp).zzd(true, true).zzc(Integer.valueOf(this.zzn), Integer.valueOf(zzwgVar.zzn), zzftl.zzc().zza()).zzb(this.zzo, zzwgVar.zzo).zzd(this.zzf, zzwgVar.zzf).zzc(Integer.valueOf(this.zzt), Integer.valueOf(zzwgVar.zzt), zzftl.zzc().zza());
        Integer valueOf = Integer.valueOf(this.zzs);
        Integer valueOf2 = Integer.valueOf(zzwgVar.zzs);
        boolean z3 = this.zzh.zzA;
        zzftlVar2 = zzwy.zzd;
        zzfrr zzc2 = zzc.zzc(valueOf, valueOf2, zzftlVar2).zzd(this.zzu, zzwgVar.zzu).zzd(this.zzv, zzwgVar.zzv).zzc(Integer.valueOf(this.zzq), Integer.valueOf(zzwgVar.zzq), zza).zzc(Integer.valueOf(this.zzr), Integer.valueOf(zzwgVar.zzr), zza);
        Integer valueOf3 = Integer.valueOf(this.zzs);
        Integer valueOf4 = Integer.valueOf(zzwgVar.zzs);
        if (!zzfj.zzC(this.zzg, zzwgVar.zzg)) {
            zza = zzwy.zzd;
        }
        return zzc2.zzc(valueOf3, valueOf4, zza).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final /* bridge */ /* synthetic */ boolean zzc(zzwu zzwuVar) {
        String str;
        zzwg zzwgVar = (zzwg) zzwuVar;
        boolean z3 = this.zzh.zzO;
        zzam zzamVar = this.zzd;
        int i4 = zzamVar.zzz;
        if (i4 != -1) {
            zzam zzamVar2 = zzwgVar.zzd;
            if (i4 == zzamVar2.zzz && (str = zzamVar.zzm) != null && TextUtils.equals(str, zzamVar2.zzm)) {
                boolean z4 = this.zzh.zzN;
                int i5 = this.zzd.zzA;
                if (i5 != -1 && i5 == zzwgVar.zzd.zzA && this.zzu == zzwgVar.zzu && this.zzv == zzwgVar.zzv) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }
}
