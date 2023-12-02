package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public class zzjx extends zzjw {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjx(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzka) || zzd() != ((zzka) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzjx) {
            zzjx zzjxVar = (zzjx) obj;
            int zzk = zzk();
            int zzk2 = zzjxVar.zzk();
            if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= zzjxVar.zzd()) {
                if (zzd <= zzjxVar.zzd()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzjxVar.zza;
                    zzjxVar.zzc();
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < zzd) {
                        if (bArr[i4] != bArr2[i5]) {
                            return false;
                        }
                        i4++;
                        i5++;
                    }
                    return true;
                }
                int zzd2 = zzjxVar.zzd();
                throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd2);
            }
            int zzd3 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd3);
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public byte zza(int i4) {
        return this.zza[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzka
    public byte zzb(int i4) {
        return this.zza[i4];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    protected final int zze(int i4, int i5, int i6) {
        return zzlj.zzb(i4, this.zza, 0, i6);
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final zzka zzf(int i4, int i5) {
        int zzj = zzka.zzj(0, i5, zzd());
        if (zzj == 0) {
            return zzka.zzb;
        }
        return new zzju(this.zza, 0, zzj);
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzka
    public final void zzh(zzjq zzjqVar) throws IOException {
        ((zzkf) zzjqVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.measurement.zzka
    public final boolean zzi() {
        return zznz.zze(this.zza, 0, zzd());
    }
}
