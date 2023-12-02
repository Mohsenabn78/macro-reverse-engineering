package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzefr {
    private final Clock zza;
    private final zzefs zzb;
    private final zzfgr zzc;
    private final List zzd = Collections.synchronizedList(new ArrayList());
    private final boolean zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgF)).booleanValue();
    private final zzech zzf;

    public zzefr(Clock clock, zzefs zzefsVar, zzech zzechVar, zzfgr zzfgrVar) {
        this.zza = clock;
        this.zzb = zzefsVar;
        this.zzf = zzechVar;
        this.zzc = zzfgrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzg(zzefr zzefrVar, String str, int i4, long j4, String str2, Integer num) {
        String str3 = str + "." + i4 + "." + j4;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + "." + str2;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzby)).booleanValue() && num != null && !TextUtils.isEmpty(str2)) {
            str3 = str3 + "." + num;
        }
        zzefrVar.zzd.add(str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfwm zze(zzezz zzezzVar, zzezn zzeznVar, zzfwm zzfwmVar, zzfgn zzfgnVar) {
        zzezq zzezqVar = zzezzVar.zzb.zzb;
        long elapsedRealtime = this.zza.elapsedRealtime();
        String str = zzeznVar.zzx;
        if (str != null) {
            zzfwc.zzq(zzfwmVar, new zzefq(this, elapsedRealtime, str, zzeznVar, zzezqVar, zzfgnVar, zzezzVar), zzcae.zzf);
        }
        return zzfwmVar;
    }

    public final String zzf() {
        return TextUtils.join("_", this.zzd);
    }
}
