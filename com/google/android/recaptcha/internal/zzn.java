package com.google.android.recaptcha.internal;

import androidx.annotation.OpenForTesting;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
@OpenForTesting
/* loaded from: classes5.dex */
public final class zzn {
    @NotNull
    public static final zzm zza = new zzm(null);
    private final long zzb = System.currentTimeMillis();
    @NotNull
    private final zzdk zzc = zzdk.zzb();

    public final long zza(@NotNull TimeUnit timeUnit) {
        return this.zzc.zza(timeUnit);
    }

    public final long zzb() {
        return this.zzb;
    }
}
