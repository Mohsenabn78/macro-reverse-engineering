package com.google.android.gms.internal.stats;

import androidx.annotation.Nullable;
import java.io.Closeable;

/* compiled from: com.google.android.gms:play-services-stats@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzb implements Closeable {
    private static final zzb zza = new zzb(false, null);

    private zzb(boolean z3, @Nullable zzd zzdVar) {
    }

    public static zzb zza(boolean z3, @Nullable zzc zzcVar) {
        return zza;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
