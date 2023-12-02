package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfop extends zzfoo {
    private final char zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfop(char c4) {
        this.zza = c4;
    }

    public final String toString() {
        int i4 = this.zza;
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i5 = 0; i5 < 4; i5++) {
            cArr[5 - i5] = "0123456789ABCDEF".charAt(i4 & 15);
            i4 >>= 4;
        }
        String copyValueOf = String.copyValueOf(cArr);
        return "CharMatcher.is('" + copyValueOf + "')";
    }

    @Override // com.google.android.gms.internal.ads.zzfos
    public final boolean zzb(char c4) {
        if (c4 == this.zza) {
            return true;
        }
        return false;
    }
}
