package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
final class zzef {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(boolean z3, String str, long j4, long j5) {
        if (z3) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j4 + ", " + j5 + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(boolean z3) {
        if (z3) {
            return;
        }
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }
}
