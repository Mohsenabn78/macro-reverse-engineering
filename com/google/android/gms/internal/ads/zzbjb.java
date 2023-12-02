package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
import org.apache.http.cookie.ClientCookie;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbjb implements zzbij {
    private final zzdsx zza;

    public zzbjb(zzdsx zzdsxVar) {
        Preconditions.checkNotNull(zzdsxVar, "The Inspector Manager must not be null");
        this.zza = zzdsxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final void zza(Object obj, Map map) {
        if (map != null && map.containsKey("extras")) {
            long j4 = Long.MAX_VALUE;
            if (map.containsKey(ClientCookie.EXPIRES_ATTR)) {
                try {
                    j4 = Long.parseLong((String) map.get(ClientCookie.EXPIRES_ATTR));
                } catch (NumberFormatException unused) {
                }
            }
            this.zza.zzi((String) map.get("extras"), j4);
        }
    }
}
