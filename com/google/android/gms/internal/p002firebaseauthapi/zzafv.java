package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafv  reason: invalid package */
/* loaded from: classes4.dex */
public class zzafv extends zzafu {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzafv(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzafy) || zzd() != ((zzafy) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzafv) {
            zzafv zzafvVar = (zzafv) obj;
            int zzm = zzm();
            int zzm2 = zzafvVar.zzm();
            if (zzm != 0 && zzm2 != 0 && zzm != zzm2) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= zzafvVar.zzd()) {
                if (zzd <= zzafvVar.zzd()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzafvVar.zza;
                    zzafvVar.zzc();
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
                int zzd2 = zzafvVar.zzd();
                throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + ", " + zzd2);
            }
            int zzd3 = zzd();
            throw new IllegalArgumentException("Length too large: " + zzd + zzd3);
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public byte zza(int i4) {
        return this.zza[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public byte zzb(int i4) {
        return this.zza[i4];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    protected void zze(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zza, 0, bArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    protected final int zzf(int i4, int i5, int i6) {
        return zzahj.zzb(i4, this.zza, 0, i6);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final zzafy zzg(int i4, int i5) {
        int zzl = zzafy.zzl(0, i5, zzd());
        if (zzl == 0) {
            return zzafy.zzb;
        }
        return new zzafs(this.zza, 0, zzl);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final zzage zzh() {
        return zzage.zzH(this.zza, 0, zzd(), true);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    protected final String zzi(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final void zzj(zzafo zzafoVar) throws IOException {
        zzafoVar.zza(this.zza, 0, zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafy
    public final boolean zzk() {
        return zzakd.zzf(this.zza, 0, zzd());
    }
}
