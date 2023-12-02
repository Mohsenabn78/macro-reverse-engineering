package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.javascriptengine.IsolateStartupParameters;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalk;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzaly;
import com.google.android.gms.internal.ads.zzalz;
import com.google.android.gms.internal.ads.zzamg;
import com.google.android.gms.internal.ads.zzamk;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbke;
import com.google.android.gms.internal.ads.zzbzk;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzax extends zzalz {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19286a;

    private zzax(Context context, zzaly zzalyVar) {
        super(zzalyVar);
        this.f19286a = context;
    }

    public static zzaln zzb(Context context) {
        zzaln zzalnVar = new zzaln(new zzamg(new File(context.getCacheDir(), "admob_volley"), (int) IsolateStartupParameters.DEFAULT_MAX_EVALUATION_RETURN_SIZE_BYTES), new zzax(context, new zzamk()), 4);
        zzalnVar.zzd();
        return zzalnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzalz, com.google.android.gms.internal.ads.zzald
    public final zzalg zza(zzalk zzalkVar) throws zzalt {
        if (zzalkVar.zza() == 0) {
            if (Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeh), zzalkVar.zzk())) {
                com.google.android.gms.ads.internal.client.zzay.zzb();
                if (zzbzk.zzs(this.f19286a, 13400000)) {
                    zzalg zza = new zzbke(this.f19286a).zza(zzalkVar);
                    if (zza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzalkVar.zzk())));
                        return zza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzalkVar.zzk())));
                }
            }
        }
        return super.zza(zzalkVar);
    }
}
