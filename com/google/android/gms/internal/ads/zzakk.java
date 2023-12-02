package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzakk implements zzakj {
    private final FileChannel zza;
    private final long zzb;
    private final long zzc;

    public zzakk(FileChannel fileChannel, long j4, long j5) {
        this.zza = fileChannel;
        this.zzb = j4;
        this.zzc = j5;
    }

    @Override // com.google.android.gms.internal.ads.zzakj
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzakj
    public final void zzb(MessageDigest[] messageDigestArr, long j4, int i4) throws IOException {
        MappedByteBuffer map = this.zza.map(FileChannel.MapMode.READ_ONLY, this.zzb + j4, i4);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
