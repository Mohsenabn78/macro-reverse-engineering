package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzcx implements zzci {
    private final int flags;
    private final String info;
    private final Object[] zzkt;
    private final zzck zzkw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcx(zzck zzckVar, String str, Object[] objArr) {
        this.zzkw = zzckVar;
        this.info = str;
        this.zzkt = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        int i4 = charAt & 8191;
        int i5 = 13;
        int i6 = 1;
        while (true) {
            int i7 = i6 + 1;
            char charAt2 = str.charAt(i6);
            if (charAt2 >= 55296) {
                i4 |= (charAt2 & 8191) << i5;
                i5 += 13;
                i6 = i7;
            } else {
                this.flags = i4 | (charAt2 << i5);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.places.zzci
    public final int zzcj() {
        if ((this.flags & 1) == 1) {
            return zzbc.zze.zzit;
        }
        return zzbc.zze.zziu;
    }

    @Override // com.google.android.gms.internal.places.zzci
    public final boolean zzck() {
        if ((this.flags & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.places.zzci
    public final zzck zzcl() {
        return this.zzkw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzcr() {
        return this.info;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zzcs() {
        return this.zzkt;
    }
}
