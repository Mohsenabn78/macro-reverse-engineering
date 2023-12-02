package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@ShowFirstParty
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zze {
    public static final Api.ClientKey<zzae> zza;
    public static final Api<Api.ApiOptions.NoOptions> zzb;
    @Deprecated
    public static final zzz zzc;
    private static final Api.AbstractClientBuilder<zzae, Api.ApiOptions.NoOptions> zzd;

    static {
        Api.ClientKey<zzae> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzd zzdVar = new zzd();
        zzd = zzdVar;
        zzb = new Api<>("AppDataSearch.LIGHTWEIGHT_API", zzdVar, clientKey);
        zzc = new zzal();
    }
}
