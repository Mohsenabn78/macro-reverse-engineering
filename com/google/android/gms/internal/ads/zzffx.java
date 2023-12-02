package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzffx {
    public static void zza(zzfwm zzfwmVar, zzffy zzffyVar, zzffn zzffnVar) {
        zzg(zzfwmVar, zzffyVar, zzffnVar, false);
    }

    public static void zzb(zzfwm zzfwmVar, zzffy zzffyVar, zzffn zzffnVar) {
        zzg(zzfwmVar, zzffyVar, zzffnVar, true);
    }

    public static void zzc(zzfwm zzfwmVar, zzffy zzffyVar, zzffn zzffnVar) {
        if (!((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            return;
        }
        zzfwc.zzq(zzfvt.zzv(zzfwmVar), new zzffw(zzffyVar, zzffnVar), zzcae.zzf);
    }

    public static void zzd(zzfwm zzfwmVar, zzffn zzffnVar) {
        if (!((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            return;
        }
        zzfwc.zzq(zzfvt.zzv(zzfwmVar), new zzffu(zzffnVar), zzcae.zzf);
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzio), str);
    }

    public static int zzf(zzfai zzfaiVar) {
        int zze = com.google.android.gms.ads.nonagon.signalgeneration.zzf.zze(zzfaiVar) - 1;
        if (zze != 0 && zze != 1) {
            return 23;
        }
        return 7;
    }

    private static void zzg(zzfwm zzfwmVar, zzffy zzffyVar, zzffn zzffnVar, boolean z3) {
        if (!((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            return;
        }
        zzfwc.zzq(zzfvt.zzv(zzfwmVar), new zzffv(zzffyVar, zzffnVar, z3), zzcae.zzf);
    }
}
