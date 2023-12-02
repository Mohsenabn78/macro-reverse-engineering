package com.google.android.gms.internal.mlkit_translate;

import androidx.annotation.Nullable;
import java.util.Date;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzqn {
    private final Date zza;
    private final zzqk zzb;
    @Nullable
    private final String zzc;

    private zzqn(Date date, int i4, zzqk zzqkVar, @Nullable String str) {
        this.zza = date;
        this.zzb = zzqkVar;
        this.zzc = str;
    }

    public static zzqn zzb(Date date) {
        return new zzqn(date, 1, null, null);
    }

    public static zzqn zzc(zzqk zzqkVar, String str) {
        return new zzqn(zzqkVar.zzc(), 0, zzqkVar, str);
    }

    public final zzqk zza() {
        return this.zzb;
    }
}
