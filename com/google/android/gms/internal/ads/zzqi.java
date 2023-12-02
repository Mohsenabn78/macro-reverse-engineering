package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzqi extends zzds {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    private static void zzo(int i4, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i4 * 4.656612875245797E-10d));
        if (floatToIntBits == zzd) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // com.google.android.gms.internal.ads.zzdr
    public final void zze(ByteBuffer byteBuffer) {
        ByteBuffer zzj;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i4 = limit - position;
        int i5 = this.zzb.zzd;
        if (i5 != 536870912) {
            if (i5 == 805306368) {
                zzj = zzj(i4);
                while (position < limit) {
                    zzo((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), zzj);
                    position += 4;
                }
            } else {
                throw new IllegalStateException();
            }
        } else {
            zzj = zzj((i4 / 3) * 4);
            while (position < limit) {
                zzo(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), zzj);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        zzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzds
    public final zzdp zzi(zzdp zzdpVar) throws zzdq {
        int i4 = zzdpVar.zzd;
        int i5 = zzfj.zza;
        if (i4 != 536870912 && i4 != 805306368) {
            if (i4 == 4) {
                return zzdp.zza;
            }
            throw new zzdq("Unhandled input format:", zzdpVar);
        }
        return new zzdp(zzdpVar.zzb, zzdpVar.zzc, 4);
    }
}
