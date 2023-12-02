package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgwb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashSet zza(int i4) {
        return new HashSet(zzd(i4));
    }

    public static LinkedHashMap zzb(int i4) {
        return new LinkedHashMap(zzd(i4));
    }

    public static List zzc(int i4) {
        if (i4 == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i4);
    }

    private static int zzd(int i4) {
        if (i4 < 3) {
            return i4 + 1;
        }
        if (i4 < 1073741824) {
            return (int) ((i4 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }
}
