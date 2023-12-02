package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzpe extends zzds {
    @Nullable
    private int[] zzd;
    @Nullable
    private int[] zze;

    @Override // com.google.android.gms.internal.ads.zzdr
    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        iArr.getClass();
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer zzj = zzj(((limit - position) / this.zzb.zze) * this.zzc.zze);
        while (position < limit) {
            for (int i4 : iArr) {
                zzj.putShort(byteBuffer.getShort(i4 + i4 + position));
            }
            position += this.zzb.zze;
        }
        byteBuffer.position(limit);
        zzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzds
    public final zzdp zzi(zzdp zzdpVar) throws zzdq {
        boolean z3;
        boolean z4;
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzdp.zza;
        }
        if (zzdpVar.zzd == 2) {
            if (zzdpVar.zzc != iArr.length) {
                z3 = true;
            } else {
                z3 = false;
            }
            int i4 = 0;
            while (true) {
                int length = iArr.length;
                if (i4 < length) {
                    int i5 = iArr[i4];
                    if (i5 < zzdpVar.zzc) {
                        if (i5 != i4) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        z3 |= z4;
                        i4++;
                    } else {
                        throw new zzdq("Unhandled input format:", zzdpVar);
                    }
                } else if (z3) {
                    return new zzdp(zzdpVar.zzb, length, 2);
                } else {
                    return zzdp.zza;
                }
            }
        } else {
            throw new zzdq("Unhandled input format:", zzdpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzds
    protected final void zzk() {
        this.zze = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzds
    protected final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(@Nullable int[] iArr) {
        this.zzd = iArr;
    }
}
