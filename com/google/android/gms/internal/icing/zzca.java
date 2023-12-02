package com.google.android.gms.internal.icing;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzca extends zzcd {
    private final int zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzca(byte[] bArr, int i4, int i5) {
        super(bArr);
        zzcf.zzm(0, i5, bArr.length);
        this.zzc = i5;
    }

    @Override // com.google.android.gms.internal.icing.zzcd, com.google.android.gms.internal.icing.zzcf
    public final byte zza(int i4) {
        int i5 = this.zzc;
        if (((i5 - (i4 + 1)) | i4) < 0) {
            if (i4 < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i4);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i4);
            sb2.append(", ");
            sb2.append(i5);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        return ((zzcd) this).zza[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.icing.zzcd, com.google.android.gms.internal.icing.zzcf
    public final byte zzb(int i4) {
        return ((zzcd) this).zza[i4];
    }

    @Override // com.google.android.gms.internal.icing.zzcd, com.google.android.gms.internal.icing.zzcf
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.icing.zzcd
    protected final int zzd() {
        return 0;
    }
}
