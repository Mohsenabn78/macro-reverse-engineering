package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzg  reason: invalid package */
/* loaded from: classes4.dex */
final class zzg extends zzf {
    private final char zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(char c4) {
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

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzj
    public final boolean zza(char c4) {
        if (c4 == this.zza) {
            return true;
        }
        return false;
    }
}
