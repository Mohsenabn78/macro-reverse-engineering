package com.google.android.recaptcha.internal;

import java.util.HashMap;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbn {
    @NotNull
    private final zzbm zza;
    private byte zzb;
    @NotNull
    private final HashMap zzc;

    public zzbn() {
        zzbm zzbmVar = new zzbm();
        this.zza = zzbmVar;
        this.zzb = (byte) RangesKt.random(new IntRange(1, 127), Random.Default);
        HashMap hashMap = new HashMap();
        this.zzc = hashMap;
        zzbmVar.zze(173, hashMap);
    }

    public final byte zza() {
        return this.zzb;
    }

    @NotNull
    public final zzbm zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zzd();
        this.zza.zze(173, this.zzc);
    }

    public final void zzd(byte b4) {
        this.zzb = b4;
    }

    public final void zze(@NotNull int i4, @NotNull Object obj) {
        this.zzc.put(1, obj);
    }
}
