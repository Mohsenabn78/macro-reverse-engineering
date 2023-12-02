package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdqf;
import com.google.android.gms.internal.ads.zzfai;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzf {
    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static void a(zzdqf zzdqfVar, @Nullable zzdpv zzdpvVar, String str, Pair... pairArr) {
        Map zza;
        if (zzdpvVar == null) {
            zza = zzdqfVar.zzc();
        } else {
            zza = zzdpvVar.zza();
        }
        b(zza, "action", str);
        for (Pair pair : pairArr) {
            b(zza, (String) pair.first, (String) pair.second);
        }
        zzdqfVar.zze(zza);
    }

    private static void b(Map map, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String zza(@Nullable String str) {
        char c4;
        if (TextUtils.isEmpty(str)) {
            return "unspecified";
        }
        switch (str.hashCode()) {
            case 1743582862:
                if (str.equals("requester_type_0")) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case 1743582863:
                if (str.equals("requester_type_1")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 1743582864:
                if (str.equals("requester_type_2")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 1743582865:
                if (str.equals("requester_type_3")) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 1743582866:
                if (str.equals("requester_type_4")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 1743582867:
                if (str.equals("requester_type_5")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case 1743582868:
                if (str.equals("requester_type_6")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case 1743582869:
                if (str.equals("requester_type_7")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case 1743582870:
                if (str.equals("requester_type_8")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                return "0";
            case 1:
                return "1";
            case 2:
                return ExifInterface.GPS_MEASUREMENT_2D;
            case 3:
                return ExifInterface.GPS_MEASUREMENT_3D;
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case '\b':
                return "8";
            default:
                return str;
        }
    }

    @Nullable
    public static String zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        Bundle bundle = zzlVar.zzc;
        if (bundle == null) {
            return "unspecified";
        }
        return bundle.getString("query_info_type");
    }

    public static void zzc(final zzdqf zzdqfVar, @Nullable final zzdpv zzdpvVar, final String str, final Pair... pairArr) {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgN)).booleanValue()) {
            return;
        }
        zzcae.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zze
            @Override // java.lang.Runnable
            public final void run() {
                zzf.a(zzdqf.this, zzdpvVar, str, pairArr);
            }
        });
    }

    public static int zze(zzfai zzfaiVar) {
        if (zzfaiVar.zzq) {
            return 2;
        }
        com.google.android.gms.ads.internal.client.zzl zzlVar = zzfaiVar.zzd;
        com.google.android.gms.ads.internal.client.zzc zzcVar = zzlVar.zzs;
        if (zzcVar == null && zzlVar.zzx == null) {
            return 1;
        }
        if (zzcVar != null && zzlVar.zzx != null) {
            return 5;
        }
        if (zzcVar != null) {
            return 3;
        }
        return 4;
    }
}
