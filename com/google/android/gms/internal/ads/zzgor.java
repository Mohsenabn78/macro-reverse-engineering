package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgor extends zzgoo {
    private final OutputStream zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgor(OutputStream outputStream, int i4) {
        super(i4);
        this.zzg = outputStream;
    }

    private final void zzG() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzH(int i4) throws IOException {
        if (this.zzb - this.zzc < i4) {
            zzG();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzI() throws IOException {
        if (this.zzc > 0) {
            zzG();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzJ(byte b4) throws IOException {
        if (this.zzc == this.zzb) {
            zzG();
        }
        zzc(b4);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzK(int i4, boolean z3) throws IOException {
        zzH(11);
        zzf(i4 << 3);
        zzc(z3 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzL(int i4, zzgoe zzgoeVar) throws IOException {
        zzs((i4 << 3) | 2);
        zzs(zzgoeVar.zzd());
        zzgoeVar.zzo(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgot, com.google.android.gms.internal.ads.zzgnt
    public final void zza(byte[] bArr, int i4, int i5) throws IOException {
        zzp(bArr, i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzh(int i4, int i5) throws IOException {
        zzH(14);
        zzf((i4 << 3) | 5);
        zzd(i5);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzi(int i4) throws IOException {
        zzH(4);
        zzd(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzj(int i4, long j4) throws IOException {
        zzH(18);
        zzf((i4 << 3) | 1);
        zze(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzk(long j4) throws IOException {
        zzH(8);
        zze(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzl(int i4, int i5) throws IOException {
        zzH(20);
        zzf(i4 << 3);
        if (i5 >= 0) {
            zzf(i5);
        } else {
            zzg(i5);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzm(int i4) throws IOException {
        if (i4 >= 0) {
            zzs(i4);
        } else {
            zzu(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzn(int i4, zzgqw zzgqwVar, zzgrp zzgrpVar) throws IOException {
        zzs((i4 << 3) | 2);
        zzs(((zzgnn) zzgqwVar).zzat(zzgrpVar));
        zzgrpVar.zzm(zzgqwVar, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzo(int i4, String str) throws IOException {
        zzs((i4 << 3) | 2);
        zzv(str);
    }

    public final void zzp(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = this.zzb;
        int i7 = this.zzc;
        int i8 = i6 - i7;
        if (i8 >= i5) {
            System.arraycopy(bArr, i4, this.zza, i7, i5);
            this.zzc += i5;
            this.zzd += i5;
            return;
        }
        System.arraycopy(bArr, i4, this.zza, i7, i8);
        int i9 = i4 + i8;
        this.zzc = this.zzb;
        this.zzd += i8;
        zzG();
        int i10 = i5 - i8;
        if (i10 <= this.zzb) {
            System.arraycopy(bArr, i9, this.zza, 0, i10);
            this.zzc = i10;
        } else {
            this.zzg.write(bArr, i9, i10);
        }
        this.zzd += i10;
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzq(int i4, int i5) throws IOException {
        zzs((i4 << 3) | i5);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzr(int i4, int i5) throws IOException {
        zzH(20);
        zzf(i4 << 3);
        zzf(i5);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzs(int i4) throws IOException {
        zzH(5);
        zzf(i4);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzt(int i4, long j4) throws IOException {
        zzH(20);
        zzf(i4 << 3);
        zzg(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final void zzu(long j4) throws IOException {
        zzH(10);
        zzg(j4);
    }

    public final void zzv(String str) throws IOException {
        int zze;
        try {
            int length = str.length() * 3;
            int zzA = zzgot.zzA(length);
            int i4 = zzA + length;
            int i5 = this.zzb;
            if (i4 > i5) {
                byte[] bArr = new byte[length];
                int zzd = zzgsv.zzd(str, bArr, 0, length);
                zzs(zzd);
                zzp(bArr, 0, zzd);
                return;
            }
            if (i4 > i5 - this.zzc) {
                zzG();
            }
            int zzA2 = zzgot.zzA(str.length());
            int i6 = this.zzc;
            try {
                if (zzA2 == zzA) {
                    int i7 = i6 + zzA2;
                    this.zzc = i7;
                    int zzd2 = zzgsv.zzd(str, this.zza, i7, this.zzb - i7);
                    this.zzc = i6;
                    zze = (zzd2 - i6) - zzA2;
                    zzf(zze);
                    this.zzc = zzd2;
                } else {
                    zze = zzgsv.zze(str);
                    zzf(zze);
                    this.zzc = zzgsv.zzd(str, this.zza, this.zzc, zze);
                }
                this.zzd += zze;
            } catch (zzgsu e4) {
                this.zzd -= this.zzc - i6;
                this.zzc = i6;
                throw e4;
            } catch (ArrayIndexOutOfBoundsException e5) {
                throw new zzgoq(e5);
            }
        } catch (zzgsu e6) {
            zzE(str, e6);
        }
    }
}
