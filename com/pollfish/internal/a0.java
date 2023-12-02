package com.pollfish.internal;

import androidx.core.os.EnvironmentCompat;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;

/* loaded from: classes6.dex */
public final /* synthetic */ class a0 {
    public static final String a(int i4) {
        return b(i4);
    }

    public static /* synthetic */ String b(int i4) {
        if (i4 == 1) {
            return "3G";
        }
        if (i4 == 2) {
            return "WIFI";
        }
        if (i4 == 3) {
            return KeyPropertiesCompact.DIGEST_NONE;
        }
        if (i4 == 4) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        throw null;
    }
}
