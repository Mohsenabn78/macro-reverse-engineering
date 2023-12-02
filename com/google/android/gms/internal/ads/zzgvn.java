package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzgvn extends zzgvl {
    private int zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgvn(String str) {
        super("mvhd");
    }

    public final int zzh() {
        if (!this.zzc) {
            zzg();
        }
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzi(ByteBuffer byteBuffer) {
        this.zza = zzamv.zzc(byteBuffer.get());
        zzamv.zzd(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
