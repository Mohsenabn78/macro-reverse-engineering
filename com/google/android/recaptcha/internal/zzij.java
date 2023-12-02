package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzij implements zzhv {
    private final zzhy zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzij(zzhy zzhyVar, String str, Object[] objArr) {
        this.zza = zzhyVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i4 = charAt & 8191;
        int i5 = 1;
        int i6 = 13;
        while (true) {
            int i7 = i5 + 1;
            char charAt2 = str.charAt(i5);
            if (charAt2 >= 55296) {
                i4 |= (charAt2 & 8191) << i6;
                i6 += 13;
                i5 = i7;
            } else {
                this.zzd = i4 | (charAt2 << i6);
                return;
            }
        }
    }

    @Override // com.google.android.recaptcha.internal.zzhv
    public final zzhy zza() {
        return this.zza;
    }

    @Override // com.google.android.recaptcha.internal.zzhv
    public final boolean zzb() {
        if ((this.zzd & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzhv
    public final int zzc() {
        if ((this.zzd & 1) == 1) {
            return 1;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }
}
