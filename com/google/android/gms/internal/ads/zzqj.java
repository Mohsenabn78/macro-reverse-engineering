package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzqj extends zzds {
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private byte[] zzh = zzfj.zzf;
    private int zzi;
    private long zzj;

    @Override // com.google.android.gms.internal.ads.zzds, com.google.android.gms.internal.ads.zzdr
    public final ByteBuffer zzb() {
        int i4;
        if (super.zzh() && (i4 = this.zzi) > 0) {
            zzj(i4).put(this.zzh, 0, this.zzi).flip();
            this.zzi = 0;
        }
        return super.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzdr
    public final void zze(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i4 = limit - position;
        if (i4 == 0) {
            return;
        }
        int min = Math.min(i4, this.zzg);
        this.zzj += min / this.zzb.zze;
        this.zzg -= min;
        byteBuffer.position(position + min);
        if (this.zzg > 0) {
            return;
        }
        int i5 = i4 - min;
        int length = (this.zzi + i5) - this.zzh.length;
        ByteBuffer zzj = zzj(length);
        int max = Math.max(0, Math.min(length, this.zzi));
        zzj.put(this.zzh, 0, max);
        int max2 = Math.max(0, Math.min(length - max, i5));
        byteBuffer.limit(byteBuffer.position() + max2);
        zzj.put(byteBuffer);
        byteBuffer.limit(limit);
        int i6 = i5 - max2;
        int i7 = this.zzi - max;
        this.zzi = i7;
        byte[] bArr = this.zzh;
        System.arraycopy(bArr, max, bArr, 0, i7);
        byteBuffer.get(this.zzh, this.zzi, i6);
        this.zzi += i6;
        zzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzds, com.google.android.gms.internal.ads.zzdr
    public final boolean zzh() {
        if (super.zzh() && this.zzi == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzds
    public final zzdp zzi(zzdp zzdpVar) throws zzdq {
        if (zzdpVar.zzd == 2) {
            this.zzf = true;
            if (this.zzd == 0 && this.zze == 0) {
                return zzdp.zza;
            }
            return zzdpVar;
        }
        throw new zzdq("Unhandled input format:", zzdpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzds
    protected final void zzk() {
        if (this.zzf) {
            this.zzf = false;
            int i4 = this.zze;
            int i5 = this.zzb.zze;
            this.zzh = new byte[i4 * i5];
            this.zzg = this.zzd * i5;
        }
        this.zzi = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzds
    protected final void zzl() {
        int i4;
        if (this.zzf) {
            if (this.zzi > 0) {
                this.zzj += i4 / this.zzb.zze;
            }
            this.zzi = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzds
    protected final void zzm() {
        this.zzh = zzfj.zzf;
    }

    public final long zzo() {
        return this.zzj;
    }

    public final void zzp() {
        this.zzj = 0L;
    }

    public final void zzq(int i4, int i5) {
        this.zzd = i4;
        this.zze = i5;
    }
}
