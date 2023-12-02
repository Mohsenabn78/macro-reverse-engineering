package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzcq {
    @NotNull
    public static final zzcp zza = new zzcp(null);
    private int zzb;

    public zzcq(short s3, short s4) {
        this.zzb = Math.abs((int) s3);
    }

    public final short zza() {
        int i4 = ((this.zzb * 4391) + 277) % 32779;
        this.zzb = i4;
        return (short) (i4 % 255);
    }
}
