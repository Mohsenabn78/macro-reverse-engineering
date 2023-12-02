package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzele implements zzeqy {
    private final zzeqy zza;
    private final zzfai zzb;
    private final Context zzc;
    private final zzbza zzd;

    public zzele(zzemy zzemyVar, zzfai zzfaiVar, Context context, zzbza zzbzaVar) {
        this.zza = zzemyVar;
        this.zzb = zzfaiVar;
        this.zzc = context;
        this.zzd = zzbzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 7;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return zzfwc.zzl(this.zza.zzb(), new zzfov() { // from class: com.google.android.gms.internal.ads.zzeld
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                return zzele.this.zzc((zzerd) obj);
            }
        }, zzcae.zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzelf zzc(zzerd zzerdVar) {
        String str;
        boolean z3;
        String str2;
        int i4;
        float f4;
        int i5;
        int i6;
        DisplayMetrics displayMetrics;
        com.google.android.gms.ads.internal.client.zzq zzqVar = this.zzb.zze;
        com.google.android.gms.ads.internal.client.zzq[] zzqVarArr = zzqVar.zzg;
        if (zzqVarArr == null) {
            str = zzqVar.zza;
            z3 = zzqVar.zzi;
        } else {
            str = null;
            boolean z4 = false;
            boolean z5 = false;
            z3 = false;
            for (com.google.android.gms.ads.internal.client.zzq zzqVar2 : zzqVarArr) {
                boolean z6 = zzqVar2.zzi;
                if (!z6 && !z4) {
                    str = zzqVar2.zza;
                    z4 = true;
                }
                if (z6) {
                    if (!z5) {
                        z5 = true;
                        z3 = true;
                    } else {
                        z5 = true;
                    }
                }
                if (z4 && z5) {
                    break;
                }
            }
        }
        Resources resources = this.zzc.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            float f5 = displayMetrics.density;
            int i7 = displayMetrics.widthPixels;
            i4 = displayMetrics.heightPixels;
            str2 = this.zzd.zzh().zzm();
            i5 = i7;
            f4 = f5;
        } else {
            str2 = null;
            i4 = 0;
            f4 = 0.0f;
            i5 = 0;
        }
        StringBuilder sb = new StringBuilder();
        com.google.android.gms.ads.internal.client.zzq[] zzqVarArr2 = zzqVar.zzg;
        if (zzqVarArr2 != null) {
            boolean z7 = false;
            for (com.google.android.gms.ads.internal.client.zzq zzqVar3 : zzqVarArr2) {
                if (zzqVar3.zzi) {
                    z7 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    int i8 = zzqVar3.zze;
                    if (i8 == -1) {
                        if (f4 != 0.0f) {
                            i8 = (int) (zzqVar3.zzf / f4);
                        } else {
                            i8 = -1;
                        }
                    }
                    sb.append(i8);
                    sb.append("x");
                    int i9 = zzqVar3.zzb;
                    if (i9 == -2) {
                        if (f4 != 0.0f) {
                            i9 = (int) (zzqVar3.zzc / f4);
                        } else {
                            i9 = -2;
                        }
                    }
                    sb.append(i9);
                }
            }
            if (z7) {
                if (sb.length() != 0) {
                    i6 = 0;
                    sb.insert(0, "|");
                } else {
                    i6 = 0;
                }
                sb.insert(i6, "320x50");
            }
        }
        return new zzelf(zzqVar, str, z3, sb.toString(), f4, i5, i4, str2, this.zzb.zzp);
    }
}
