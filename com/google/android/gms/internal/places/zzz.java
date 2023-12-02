package com.google.android.gms.internal.places;

/* loaded from: classes4.dex */
final class zzz extends zzag {
    private final int zzek;
    private final int zzel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(byte[] bArr, int i4, int i5) {
        super(bArr);
        zzw.zzc(i4, i4 + i5, bArr.length);
        this.zzek = i4;
        this.zzel = i5;
    }

    @Override // com.google.android.gms.internal.places.zzag, com.google.android.gms.internal.places.zzw
    public final int size() {
        return this.zzel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.places.zzag
    public final int zzag() {
        return this.zzek;
    }

    @Override // com.google.android.gms.internal.places.zzag, com.google.android.gms.internal.places.zzw
    protected final void zzb(byte[] bArr, int i4, int i5, int i6) {
        System.arraycopy(this.zzen, zzag(), bArr, 0, i6);
    }

    @Override // com.google.android.gms.internal.places.zzag, com.google.android.gms.internal.places.zzw
    public final byte zzi(int i4) {
        int size = size();
        if (((size - (i4 + 1)) | i4) < 0) {
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
            sb2.append(size);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        return this.zzen[this.zzek + i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzag, com.google.android.gms.internal.places.zzw
    public final byte zzj(int i4) {
        return this.zzen[this.zzek + i4];
    }
}
