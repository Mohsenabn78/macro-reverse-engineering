package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzqg {
    private ByteBuffer zza = zzdr.zza;
    private int zzc = 0;
    private int zzb = 2;

    public final void zza(zzhp zzhpVar) {
        ByteBuffer byteBuffer = zzhpVar.zzb;
        byteBuffer.getClass();
        if (byteBuffer.limit() - zzhpVar.zzb.position() == 0) {
            return;
        }
        ByteBuffer byteBuffer2 = zzhpVar.zzb;
        int position = byteBuffer2.position();
        int limit = byteBuffer2.limit();
        int i4 = limit - position;
        int i5 = (i4 + 255) / 255;
        int i6 = i5 + 27 + i4;
        if (this.zza.capacity() < i6) {
            this.zza = ByteBuffer.allocate(i6).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.zza.clear();
        }
        ByteBuffer byteBuffer3 = this.zza;
        byteBuffer3.put((byte) 79);
        byteBuffer3.put((byte) 103);
        byteBuffer3.put((byte) 103);
        byteBuffer3.put((byte) 83);
        byteBuffer3.put((byte) 0);
        byteBuffer3.put((byte) 0);
        int zzb = this.zzc + zzabr.zzb(byteBuffer2);
        this.zzc = zzb;
        byteBuffer3.putLong(zzb);
        byteBuffer3.putInt(0);
        byteBuffer3.putInt(this.zzb);
        this.zzb++;
        byteBuffer3.putInt(0);
        byteBuffer3.put((byte) i5);
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 >= 255) {
                byteBuffer3.put((byte) -1);
                i4 -= 255;
            } else {
                byteBuffer3.put((byte) i4);
                i4 = 0;
            }
        }
        while (position < limit) {
            byteBuffer3.put(byteBuffer2.get(position));
            position++;
        }
        byteBuffer2.position(byteBuffer2.limit());
        byteBuffer3.flip();
        byteBuffer3.putInt(22, zzfj.zzd(byteBuffer3.array(), byteBuffer3.arrayOffset(), byteBuffer3.limit() - byteBuffer3.position(), 0));
        byteBuffer3.position(0);
        this.zza = byteBuffer3;
        zzhpVar.zzb();
        zzhpVar.zzj(this.zza.remaining());
        zzhpVar.zzb.put(this.zza);
        zzhpVar.zzk();
    }

    public final void zzb() {
        this.zza = zzdr.zza;
        this.zzc = 0;
        this.zzb = 2;
    }
}
