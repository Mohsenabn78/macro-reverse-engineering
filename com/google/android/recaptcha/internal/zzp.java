package com.google.android.recaptcha.internal;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzp {
    @NotNull
    public static final zzp zza = new zzp();
    @NotNull
    private static final CoroutineScope zzb = CoroutineScopeKt.MainScope();
    @NotNull
    private static final CoroutineScope zzc;
    @NotNull
    private static final CoroutineScope zzd;

    static {
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(ThreadPoolDispatcherKt.newSingleThreadContext("reCaptcha"));
        e.e(CoroutineScope, null, null, new zzo(null), 3, null);
        zzc = CoroutineScope;
        zzd = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    private zzp() {
    }

    @NotNull
    public static final CoroutineScope zza() {
        return zzd;
    }

    @NotNull
    public static final CoroutineScope zzb() {
        return zzb;
    }

    @NotNull
    public static final CoroutineScope zzc() {
        return zzc;
    }
}
