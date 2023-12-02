package com.google.android.gms.internal.places;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class zzag extends zzad {
    protected final byte[] zzen;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(byte[] bArr) {
        bArr.getClass();
        this.zzen = bArr;
    }

    @Override // com.google.android.gms.internal.places.zzw
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzw) || size() != ((zzw) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof zzag) {
            zzag zzagVar = (zzag) obj;
            int zzaf = zzaf();
            int zzaf2 = zzagVar.zzaf();
            if (zzaf != 0 && zzaf2 != 0 && zzaf != zzaf2) {
                return false;
            }
            return zzb(zzagVar, 0, size());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.places.zzw
    public int size() {
        return this.zzen.length;
    }

    @Override // com.google.android.gms.internal.places.zzw
    public final boolean zzae() {
        int zzag = zzag();
        return zzea.zzf(this.zzen, zzag, size() + zzag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int zzag() {
        return 0;
    }

    @Override // com.google.android.gms.internal.places.zzw
    public final zzw zzb(int i4, int i5) {
        int zzc = zzw.zzc(0, i5, size());
        if (zzc == 0) {
            return zzw.zzeg;
        }
        return new zzz(this.zzen, zzag(), zzc);
    }

    @Override // com.google.android.gms.internal.places.zzw
    public byte zzi(int i4) {
        return this.zzen[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzw
    public byte zzj(int i4) {
        return this.zzen[i4];
    }

    @Override // com.google.android.gms.internal.places.zzw
    protected void zzb(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zzen, 0, bArr, 0, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzw
    public final void zzb(zzt zztVar) throws IOException {
        zztVar.zzb(this.zzen, zzag(), size());
    }

    @Override // com.google.android.gms.internal.places.zzw
    protected final String zzb(Charset charset) {
        return new String(this.zzen, zzag(), size(), charset);
    }

    @Override // com.google.android.gms.internal.places.zzad
    final boolean zzb(zzw zzwVar, int i4, int i5) {
        if (i5 <= zzwVar.size()) {
            if (i5 <= zzwVar.size()) {
                if (zzwVar instanceof zzag) {
                    zzag zzagVar = (zzag) zzwVar;
                    byte[] bArr = this.zzen;
                    byte[] bArr2 = zzagVar.zzen;
                    int zzag = zzag() + i5;
                    int zzag2 = zzag();
                    int zzag3 = zzagVar.zzag();
                    while (zzag2 < zzag) {
                        if (bArr[zzag2] != bArr2[zzag3]) {
                            return false;
                        }
                        zzag2++;
                        zzag3++;
                    }
                    return true;
                }
                return zzwVar.zzb(0, i5).equals(zzb(0, i5));
            }
            int size = zzwVar.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: 0, ");
            sb.append(i5);
            sb.append(", ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i5);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.places.zzw
    protected final int zzb(int i4, int i5, int i6) {
        return zzbd.zzb(i4, this.zzen, zzag(), i6);
    }
}
