package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzcd extends IOException {
    public final boolean zza;
    public final int zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzcd(@Nullable String str, @Nullable Throwable th, boolean z3, int i4) {
        super(str, th);
        this.zza = z3;
        this.zzb = i4;
    }

    public static zzcd zza(@Nullable String str, @Nullable Throwable th) {
        return new zzcd(str, th, true, 1);
    }

    public static zzcd zzb(@Nullable String str, @Nullable Throwable th) {
        return new zzcd(str, th, true, 0);
    }

    public static zzcd zzc(@Nullable String str) {
        return new zzcd(str, null, false, 1);
    }

    @Override // java.lang.Throwable
    @Nullable
    public final String getMessage() {
        String message = super.getMessage();
        boolean z3 = this.zza;
        int i4 = this.zzb;
        return message + "{contentIsMalformed=" + z3 + ", dataType=" + i4 + "}";
    }
}
