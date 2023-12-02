package com.google.android.recaptcha.internal;

import kotlin.UInt;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final /* synthetic */ class zzbh {
    @NotNull
    public static String zza(zzbi zzbiVar, @NotNull String str, byte b4) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i4 = 0; i4 < str.length(); i4++) {
            sb.append((char) UInt.m4222constructorimpl(UInt.m4222constructorimpl(str.charAt(i4)) ^ UInt.m4222constructorimpl(b4)));
        }
        return sb.toString();
    }
}
