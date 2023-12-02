package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgng {
    private static final ThreadLocal zza = new zzgnf();

    public static byte[] zza(int i4) {
        byte[] bArr = new byte[i4];
        ((SecureRandom) zza.get()).nextBytes(bArr);
        return bArr;
    }
}
