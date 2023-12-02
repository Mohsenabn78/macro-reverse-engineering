package com.google.android.gms.internal.mlkit_common;

import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzab {
    private static final Logger zza = Logger.getLogger(zzab.class.getName());
    private static final zzaa zzb = new zzaa(null);

    private zzab() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(@CheckForNull String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb(@CheckForNull String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }
}
