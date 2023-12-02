package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzaks;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzfwm;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbo {

    /* renamed from: a  reason: collision with root package name */
    private static zzaln f19303a;

    /* renamed from: b  reason: collision with root package name */
    private static final Object f19304b = new Object();
    @Deprecated
    public static final zzbj zza = new zzbg();

    public zzbo(Context context) {
        zzaln zza2;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (f19304b) {
            if (f19303a == null) {
                zzbbm.zza(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeg)).booleanValue()) {
                        zza2 = zzax.zzb(context);
                        f19303a = zza2;
                    }
                }
                zza2 = zzamq.zza(context, null);
                f19303a = zza2;
            }
        }
    }

    public final zzfwm zza(String str) {
        zzcaj zzcajVar = new zzcaj();
        f19303a.zza(new zzbn(str, null, zzcajVar));
        return zzcajVar;
    }

    public final zzfwm zzb(int i4, String str, @Nullable Map map, @Nullable byte[] bArr) {
        zzbl zzblVar = new zzbl(null);
        zzbh zzbhVar = new zzbh(this, str, zzblVar);
        zzbzq zzbzqVar = new zzbzq(null);
        zzbi zzbiVar = new zzbi(this, i4, str, zzblVar, zzbhVar, bArr, map, zzbzqVar);
        if (zzbzq.zzk()) {
            try {
                zzbzqVar.zzd(str, "GET", zzbiVar.zzl(), zzbiVar.zzx());
            } catch (zzaks e4) {
                zzbzr.zzj(e4.getMessage());
            }
        }
        f19303a.zza(zzbiVar);
        return zzblVar;
    }
}
