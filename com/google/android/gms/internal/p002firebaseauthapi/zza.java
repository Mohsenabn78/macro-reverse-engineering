package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zza  reason: invalid package */
/* loaded from: classes4.dex */
final class zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    @ChecksSdkIntAtLeast(api = 33)
    public static boolean zza() {
        if (Build.VERSION.SDK_INT >= 33) {
            return true;
        }
        return false;
    }
}
