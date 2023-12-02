package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzgf extends IOException {
    public final int zza;

    public zzgf(int i4) {
        this.zza = i4;
    }

    public zzgf(@Nullable String str, int i4) {
        super(str);
        this.zza = i4;
    }

    public zzgf(@Nullable String str, @Nullable Throwable th, int i4) {
        super(str, th);
        this.zza = i4;
    }

    public zzgf(@Nullable Throwable th, int i4) {
        super(th);
        this.zza = i4;
    }
}
