package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public class zzax extends zzaw {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzax(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzba
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzba) || zzd() != ((zzba) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzax) {
            zzax zzaxVar = (zzax) obj;
            int zzk = zzk();
            int zzk2 = zzaxVar.zzk();
            if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= zzaxVar.zzd()) {
                if (zzd <= zzaxVar.zzd()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzaxVar.zza;
                    zzaxVar.zzc();
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
                int zzd2 = zzaxVar.zzd();
                throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd2);
            }
            int zzd3 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd3);
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzba
    public byte zza(int i4) {
        return this.zza[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzba
    public byte zzb(int i4) {
        return this.zza[i4];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzba
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzba
    protected final int zze(int i4, int i5, int i6) {
        return zzcg.zzb(i4, this.zza, 0, i6);
    }

    @Override // com.google.android.gms.internal.play_billing.zzba
    public final zzba zzf(int i4, int i5) {
        int zzj = zzba.zzj(0, i5, zzd());
        if (zzj == 0) {
            return zzba.zzb;
        }
        return new zzau(this.zza, 0, zzj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzba
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzba
    public final void zzh(zzaq zzaqVar) throws IOException {
        ((zzbf) zzaqVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.play_billing.zzba
    public final boolean zzi() {
        return zzev.zze(this.zza, 0, zzd());
    }
}
