package com.google.android.gms.internal.mlkit_translate;

import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzi {
    private static final Logger zza = Logger.getLogger(zzi.class.getName());
    private static final zzh zzb = new zzh(null);

    private zzi() {
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
