package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgfm {
    public static final Charset zza = Charset.forName("UTF-8");

    public static final zzgnk zza(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt >= '!' && charAt <= '~') {
                bArr[i4] = (byte) charAt;
            } else {
                throw new zzgfl("Not a printable ASCII character: " + charAt);
            }
        }
        return zzgnk.zzb(bArr);
    }
}
