package com.google.mlkit.nl.translate.internal;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.nl.translate.TranslatorOptions;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzj extends LazyInstanceMap {

    /* renamed from: a  reason: collision with root package name */
    private final zzaf f33127a;

    /* renamed from: b  reason: collision with root package name */
    private final ModelFileHelper f33128b;

    /* renamed from: c  reason: collision with root package name */
    private final zzr f33129c;

    public zzj(zzaf zzafVar, ModelFileHelper modelFileHelper, zzr zzrVar) {
        this.f33127a = zzafVar;
        this.f33128b = modelFileHelper;
        this.f33129c = zzrVar;
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        TranslatorOptions translatorOptions = (TranslatorOptions) obj;
        return new TranslateJni(this.f33127a, this.f33129c.zza(translatorOptions.zza()), this.f33128b, translatorOptions.zzb(), translatorOptions.zzc());
    }
}
