package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzamz extends zzgvn {
    private Date zza;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk;
    private float zzl;
    private zzgvx zzm;
    private long zzn;

    public zzamz() {
        super("mvhd");
        this.zzk = 1.0d;
        this.zzl = 1.0f;
        this.zzm = zzgvx.zza;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zza + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzd() {
        return this.zzj;
    }

    public final long zze() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzgvl
    public final void zzf(ByteBuffer byteBuffer) {
        zzi(byteBuffer);
        if (zzh() == 1) {
            this.zza = zzgvs.zza(zzamv.zzf(byteBuffer));
            this.zzh = zzgvs.zza(zzamv.zzf(byteBuffer));
            this.zzi = zzamv.zze(byteBuffer);
            this.zzj = zzamv.zzf(byteBuffer);
        } else {
            this.zza = zzgvs.zza(zzamv.zze(byteBuffer));
            this.zzh = zzgvs.zza(zzamv.zze(byteBuffer));
            this.zzi = zzamv.zze(byteBuffer);
            this.zzj = zzamv.zze(byteBuffer);
        }
        this.zzk = zzamv.zzb(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((short) ((bArr[1] & 255) | ((short) (65280 & (bArr[0] << 8))))) / 256.0f;
        zzamv.zzd(byteBuffer);
        zzamv.zze(byteBuffer);
        zzamv.zze(byteBuffer);
        double zzb = zzamv.zzb(byteBuffer);
        double zzb2 = zzamv.zzb(byteBuffer);
        double zza = zzamv.zza(byteBuffer);
        this.zzm = new zzgvx(zzb, zzb2, zzamv.zzb(byteBuffer), zzamv.zzb(byteBuffer), zza, zzamv.zza(byteBuffer), zzamv.zza(byteBuffer), zzamv.zzb(byteBuffer), zzamv.zzb(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzamv.zze(byteBuffer);
    }
}
