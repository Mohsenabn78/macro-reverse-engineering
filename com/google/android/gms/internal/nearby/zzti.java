package com.google.android.gms.internal.nearby;

import java.io.IOException;
import java.math.RoundingMode;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzti extends zztk {
    private final zztk zza;
    private final String zzb = ":";

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzti(zztk zztkVar, String str, int i4) {
        this.zza = zztkVar;
    }

    public final String toString() {
        String obj = this.zza.toString();
        String str = this.zzb;
        return obj + ".withSeparator(\"" + str + "\", 2)";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zztk
    public final int zza(byte[] bArr, CharSequence charSequence) throws zzth {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            char charAt = charSequence.charAt(i4);
            if (this.zzb.indexOf(charAt) < 0) {
                sb.append(charAt);
            }
        }
        return this.zza.zza(bArr, sb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zztk
    public final void zzb(Appendable appendable, byte[] bArr, int i4, int i5) throws IOException {
        this.zza.zzb(new zztd(2, appendable, this.zzb), bArr, 0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zztk
    public final int zzc(int i4) {
        return this.zza.zzc(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zztk
    public final int zzd(int i4) {
        int zzd = this.zza.zzd(i4);
        return zzd + (this.zzb.length() * zztm.zza(Math.max(0, zzd - 1), 2, RoundingMode.FLOOR));
    }

    @Override // com.google.android.gms.internal.nearby.zztk
    public final zztk zze(String str, int i4) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.nearby.zztk
    public final CharSequence zzf(CharSequence charSequence) {
        return this.zza.zzf(charSequence);
    }
}
