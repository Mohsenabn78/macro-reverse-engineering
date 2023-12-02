package com.google.mlkit.nl.translate.internal;

import com.google.mlkit.nl.translate.TranslateRemoteModel;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzaa {

    /* renamed from: a  reason: collision with root package name */
    private final zzh f33084a;

    /* renamed from: b  reason: collision with root package name */
    private final zzz f33085b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f33086c = new HashMap();

    public zzaa(zzz zzzVar, zzh zzhVar) {
        this.f33085b = zzzVar;
        this.f33084a = zzhVar;
    }

    public final zzac zza(TranslateRemoteModel translateRemoteModel, boolean z3) {
        String zza = TranslateRemoteModel.zza(zzad.zze(translateRemoteModel.getLanguage()));
        synchronized (this.f33086c) {
            if (!this.f33086c.containsKey(zza)) {
                zzac zzacVar = new zzac(this.f33084a.zza(translateRemoteModel), this.f33085b, null);
                if (z3) {
                    this.f33086c.put(zza, zzacVar);
                }
                return zzacVar;
            }
            return (zzac) this.f33086c.get(zza);
        }
    }
}
