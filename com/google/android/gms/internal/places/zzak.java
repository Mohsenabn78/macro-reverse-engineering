package com.google.android.gms.internal.places;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzak extends zzai {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzet;
    private int zzeu;
    private int zzev;
    private int zzew;

    private zzak(byte[] bArr, int i4, int i5, boolean z3) {
        super();
        this.zzew = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i5 + i4;
        this.pos = i4;
        this.zzev = i4;
        this.zzet = z3;
    }

    @Override // com.google.android.gms.internal.places.zzai
    public final int zzaj() {
        return this.pos - this.zzev;
    }

    @Override // com.google.android.gms.internal.places.zzai
    public final int zzl(int i4) throws zzbk {
        if (i4 >= 0) {
            int zzaj = i4 + zzaj();
            int i5 = this.zzew;
            if (zzaj <= i5) {
                this.zzew = zzaj;
                int i6 = this.limit + this.zzeu;
                this.limit = i6;
                int i7 = i6 - this.zzev;
                if (i7 > zzaj) {
                    int i8 = i7 - zzaj;
                    this.zzeu = i8;
                    this.limit = i6 - i8;
                } else {
                    this.zzeu = 0;
                }
                return i5;
            }
            throw zzbk.zzbp();
        }
        throw zzbk.zzbq();
    }
}
