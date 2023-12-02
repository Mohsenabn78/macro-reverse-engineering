package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public class zzat extends zzas {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.wearable.zzaw
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaw) || zzd() != ((zzaw) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzat) {
            zzat zzatVar = (zzat) obj;
            int zzl = zzl();
            int zzl2 = zzatVar.zzl();
            if (zzl != 0 && zzl2 != 0 && zzl != zzl2) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= zzatVar.zzd()) {
                if (zzd <= zzatVar.zzd()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzatVar.zza;
                    zzatVar.zzc();
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
                int zzd2 = zzatVar.zzd();
                throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd2);
            }
            int zzd3 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd3);
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.wearable.zzaw
    public byte zza(int i4) {
        return this.zza[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.wearable.zzaw
    public byte zzb(int i4) {
        return this.zza[i4];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.wearable.zzaw
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.wearable.zzaw
    protected void zze(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zza, 0, bArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.wearable.zzaw
    protected final int zzf(int i4, int i5, int i6) {
        return zzcd.zzd(i4, this.zza, 0, i6);
    }

    @Override // com.google.android.gms.internal.wearable.zzaw
    public final zzaw zzg(int i4, int i5) {
        int zzk = zzaw.zzk(0, i5, zzd());
        if (zzk == 0) {
            return zzaw.zzb;
        }
        return new zzaq(this.zza, 0, zzk);
    }

    @Override // com.google.android.gms.internal.wearable.zzaw
    protected final String zzh(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.wearable.zzaw
    public final void zzi(zzam zzamVar) throws IOException {
        ((zzbb) zzamVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.wearable.zzaw
    public final boolean zzj() {
        return zzet.zzf(this.zza, 0, zzd());
    }
}
