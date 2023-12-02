package com.google.mlkit.nl.translate.internal;

import com.google.android.gms.internal.mlkit_translate.zznx;
import com.google.android.gms.internal.mlkit_translate.zzps;
import com.google.android.gms.internal.mlkit_translate.zzpu;
import com.google.android.gms.internal.mlkit_translate.zzqf;
import com.google.mlkit.common.sdkinternal.MlKitContext;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzr {

    /* renamed from: a  reason: collision with root package name */
    private final zzps f33134a;

    /* renamed from: b  reason: collision with root package name */
    private final zzpu f33135b;

    public zzr() {
        zzps zzb = zzqf.zzb("translate");
        zzpu zza = zzpu.zza(MlKitContext.getInstance().getApplicationContext());
        this.f33134a = zzb;
        this.f33135b = zza;
    }

    public final zzt zza(zznx zznxVar) {
        return new zzt(this.f33134a, this.f33135b, zznxVar, null);
    }
}
