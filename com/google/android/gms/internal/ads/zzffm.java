package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzffm {
    public static zzffn zza(Context context, int i4) {
        boolean booleanValue;
        if (zzfgb.zza()) {
            int i5 = i4 - 2;
            if (i5 != 20 && i5 != 21) {
                switch (i5) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        booleanValue = ((Boolean) zzbcy.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        booleanValue = ((Boolean) zzbcy.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        booleanValue = ((Boolean) zzbcy.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                booleanValue = ((Boolean) zzbcy.zze.zze()).booleanValue();
            }
            if (booleanValue) {
                return new zzffp(context, i4);
            }
        }
        return new zzfgk();
    }

    public static zzffn zzb(Context context, int i4, int i5, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        zzffn zza = zza(context, i4);
        if (!(zza instanceof zzffp)) {
            return zza;
        }
        zza.zzh();
        zza.zzm(i5);
        if (zzffx.zze(zzlVar.zzp)) {
            zza.zze(zzlVar.zzp);
        }
        return zza;
    }
}
