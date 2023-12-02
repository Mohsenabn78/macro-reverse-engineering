package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public class zzcd extends zzcc {
    protected final byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcd(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.icing.zzcf
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcf) || zzc() != ((zzcf) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (obj instanceof zzcd) {
            zzcd zzcdVar = (zzcd) obj;
            int zzl = zzl();
            int zzl2 = zzcdVar.zzl();
            if (zzl != 0 && zzl2 != 0 && zzl != zzl2) {
                return false;
            }
            int zzc = zzc();
            if (zzc <= zzcdVar.zzc()) {
                if (zzc <= zzcdVar.zzc()) {
                    byte[] bArr = this.zza;
                    byte[] bArr2 = zzcdVar.zza;
                    zzcdVar.zzd();
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < zzc) {
                        if (bArr[i4] != bArr2[i5]) {
                            return false;
                        }
                        i4++;
                        i5++;
                    }
                    return true;
                }
                int zzc2 = zzcdVar.zzc();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: 0, ");
                sb.append(zzc);
                sb.append(", ");
                sb.append(zzc2);
                throw new IllegalArgumentException(sb.toString());
            }
            int zzc3 = zzc();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(zzc);
            sb2.append(zzc3);
            throw new IllegalArgumentException(sb2.toString());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.icing.zzcf
    public byte zza(int i4) {
        return this.zza[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.icing.zzcf
    public byte zzb(int i4) {
        return this.zza[i4];
    }

    @Override // com.google.android.gms.internal.icing.zzcf
    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    @Override // com.google.android.gms.internal.icing.zzcf
    public final zzcf zze(int i4, int i5) {
        zzcf.zzm(0, i5, zzc());
        if (i5 == 0) {
            return zzcf.zzb;
        }
        return new zzca(this.zza, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.icing.zzcf
    public final void zzf(zzbw zzbwVar) throws IOException {
        ((zzck) zzbwVar).zzp(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.icing.zzcf
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzc(), charset);
    }

    @Override // com.google.android.gms.internal.icing.zzcf
    public final boolean zzh() {
        return zzfr.zzb(this.zza, 0, zzc());
    }

    @Override // com.google.android.gms.internal.icing.zzcf
    protected final int zzi(int i4, int i5, int i6) {
        return zzdh.zzh(i4, this.zza, 0, i6);
    }
}
