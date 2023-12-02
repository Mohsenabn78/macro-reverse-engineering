package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzgoa extends zzgnz {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgoa(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgoe) || zzd() != ((zzgoe) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzgoa) {
            zzgoa zzgoaVar = (zzgoa) obj;
            int zzr = zzr();
            int zzr2 = zzgoaVar.zzr();
            if (zzr != 0 && zzr2 != 0 && zzr != zzr2) {
                return false;
            }
            return zzg(zzgoaVar, 0, zzd());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public byte zza(int i4) {
        return this.zza[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public byte zzb(int i4) {
        return this.zza[i4];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public int zzd() {
        return this.zza.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public void zze(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zza, i4, bArr, i5, i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    final boolean zzg(zzgoe zzgoeVar, int i4, int i5) {
        if (i5 <= zzgoeVar.zzd()) {
            int i6 = i4 + i5;
            if (i6 <= zzgoeVar.zzd()) {
                if (zzgoeVar instanceof zzgoa) {
                    zzgoa zzgoaVar = (zzgoa) zzgoeVar;
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzgoaVar.zza;
                    int zzc = zzc() + i5;
                    int zzc2 = zzc();
                    int zzc3 = zzgoaVar.zzc() + i4;
                    while (zzc2 < zzc) {
                        if (bArr[zzc2] != bArr2[zzc3]) {
                            return false;
                        }
                        zzc2++;
                        zzc3++;
                    }
                    return true;
                }
                return zzgoeVar.zzk(i4, i6).equals(zzk(0, i5));
            }
            int zzd = zzgoeVar.zzd();
            throw new IllegalArgumentException("Ran off end of other: " + i4 + ", " + i5 + ", " + zzd);
        }
        int zzd2 = zzd();
        throw new IllegalArgumentException("Length too large: " + i5 + zzd2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public final int zzi(int i4, int i5, int i6) {
        return zzgpw.zzb(i4, this.zza, zzc() + i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public final int zzj(int i4, int i5, int i6) {
        int zzc = zzc() + i5;
        return zzgsv.zzf(i4, this.zza, zzc, i6 + zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final zzgoe zzk(int i4, int i5) {
        int zzq = zzgoe.zzq(i4, i5, zzd());
        if (zzq == 0) {
            return zzgoe.zzb;
        }
        return new zzgnx(this.zza, zzc() + i4, zzq);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final zzgom zzl() {
        return zzgom.zzI(this.zza, zzc(), zzd(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    protected final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgoe
    public final void zzo(zzgnt zzgntVar) throws IOException {
        zzgntVar.zza(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgoe
    public final boolean zzp() {
        int zzc = zzc();
        return zzgsv.zzj(this.zza, zzc, zzd() + zzc);
    }
}
