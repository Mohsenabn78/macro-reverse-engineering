package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaki implements zzakj {
    private final ByteBuffer zza;

    public zzaki(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.slice();
    }

    @Override // com.google.android.gms.internal.ads.zzakj
    public final long zza() {
        return this.zza.capacity();
    }

    @Override // com.google.android.gms.internal.ads.zzakj
    public final void zzb(MessageDigest[] messageDigestArr, long j4, int i4) throws IOException {
        ByteBuffer slice;
        synchronized (this.zza) {
            int i5 = (int) j4;
            this.zza.position(i5);
            this.zza.limit(i5 + i4);
            slice = this.zza.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            slice.position(0);
            messageDigest.update(slice);
        }
    }
}
