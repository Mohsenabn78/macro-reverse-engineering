package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzccz implements zzbij {
    private boolean zza;

    private static int zzb(Context context, Map map, String str, int i4) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                com.google.android.gms.ads.internal.client.zzay.zzb();
                i4 = zzbzk.zzx(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                zzbzr.zzj("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Parse pixels for " + str + ", got string " + str2 + ", int " + i4 + ".");
        }
        return i4;
    }

    private static void zzc(zzcbo zzcboVar, Map map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzcboVar.zzB(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzbzr.zzj(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzcboVar.zzA(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzcboVar.zzy(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzcboVar.zzz(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzcboVar.zzD(Integer.parseInt(str5));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzbij
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zza(java.lang.Object r22, java.util.Map r23) {
        /*
            Method dump skipped, instructions count: 1163
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccz.zza(java.lang.Object, java.util.Map):void");
    }
}
