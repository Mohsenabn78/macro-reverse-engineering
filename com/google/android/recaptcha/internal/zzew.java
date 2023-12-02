package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public class zzew extends zzev {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzew(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.recaptcha.internal.zzez
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzez) || zzd() != ((zzez) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzew) {
            zzew zzewVar = (zzew) obj;
            int zzl = zzl();
            int zzl2 = zzewVar.zzl();
            if (zzl != 0 && zzl2 != 0 && zzl != zzl2) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= zzewVar.zzd()) {
                if (zzd <= zzewVar.zzd()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzewVar.zza;
                    zzewVar.zzc();
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
                int zzd2 = zzewVar.zzd();
                throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd2);
            }
            int zzd3 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd3);
        }
        return obj.equals(this);
    }

    @Override // com.google.android.recaptcha.internal.zzez
    public byte zza(int i4) {
        return this.zza[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzez
    public byte zzb(int i4) {
        return this.zza[i4];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzez
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.recaptcha.internal.zzez
    protected void zze(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zza, 0, bArr, 0, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzez
    protected final int zzf(int i4, int i5, int i6) {
        return zzgw.zzb(i4, this.zza, 0, i6);
    }

    @Override // com.google.android.recaptcha.internal.zzez
    public final zzez zzg(int i4, int i5) {
        int zzk = zzez.zzk(0, i5, zzd());
        if (zzk == 0) {
            return zzez.zzb;
        }
        return new zzet(this.zza, 0, zzk);
    }

    @Override // com.google.android.recaptcha.internal.zzez
    protected final String zzh(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.recaptcha.internal.zzez
    public final void zzi(zzep zzepVar) throws IOException {
        ((zzfh) zzepVar).zzc(this.zza, 0, zzd());
    }

    @Override // com.google.android.recaptcha.internal.zzez
    public final boolean zzj() {
        return zzju.zzf(this.zza, 0, zzd());
    }
}
