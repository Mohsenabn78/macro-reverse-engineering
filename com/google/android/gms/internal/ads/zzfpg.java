package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfpg {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = Logger.getLogger(zzfpg.class.getName());
    private static final zzfpf zzc = new zzfpf(null);

    private zzfpg() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(@CheckForNull String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }
}
