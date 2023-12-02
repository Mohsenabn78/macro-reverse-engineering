package com.google.android.recaptcha.internal;

import java.util.TimerTask;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.e;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzal extends TimerTask {
    final /* synthetic */ zzao zza;

    public zzal(zzao zzaoVar) {
        this.zza = zzaoVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        CoroutineScope coroutineScope;
        coroutineScope = this.zza.zzd;
        e.e(coroutineScope, null, null, new zzam(this.zza, null), 3, null);
    }
}
