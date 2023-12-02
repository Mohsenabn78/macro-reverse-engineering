package com.google.mlkit.nl.translate.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final /* synthetic */ class zzao implements Continuation {
    public final /* synthetic */ TranslatorImpl zza;
    public final /* synthetic */ DownloadConditions zzb;

    public /* synthetic */ zzao(TranslatorImpl translatorImpl, DownloadConditions downloadConditions) {
        this.zza = translatorImpl;
        this.zzb = downloadConditions;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        return this.zza.b(this.zzb, task);
    }
}
