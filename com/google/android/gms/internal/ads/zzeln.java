package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeln {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    @Nullable
    private zzelm zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzelm zza() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzelm zzelmVar) {
        this.zzb = zzelmVar;
    }

    public final void zzc(boolean z3) {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
