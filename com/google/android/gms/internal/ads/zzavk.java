package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzavk extends zzavb {
    private MessageDigest zzb;
    private final int zzc;
    private final int zzd;

    public zzavk(int i4) {
        int i5 = i4 >> 3;
        this.zzc = (i4 & 7) > 0 ? i5 + 1 : i5;
        this.zzd = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzavb
    public final byte[] zzb(String str) {
        synchronized (this.zza) {
            MessageDigest zza = zza();
            this.zzb = zza;
            if (zza == null) {
                return new byte[0];
            }
            zza.reset();
            this.zzb.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] digest = this.zzb.digest();
            int length = digest.length;
            int i4 = this.zzc;
            if (length > i4) {
                length = i4;
            }
            byte[] bArr = new byte[length];
            System.arraycopy(digest, 0, bArr, 0, length);
            if ((this.zzd & 7) > 0) {
                long j4 = 0;
                for (int i5 = 0; i5 < length; i5++) {
                    if (i5 > 0) {
                        j4 <<= 8;
                    }
                    j4 += bArr[i5] & 255;
                }
                long j5 = j4 >>> (8 - (this.zzd & 7));
                int i6 = this.zzc;
                while (true) {
                    i6--;
                    if (i6 < 0) {
                        break;
                    }
                    bArr[i6] = (byte) (255 & j5);
                    j5 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
