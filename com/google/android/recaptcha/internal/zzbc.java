package com.google.android.recaptcha.internal;

import android.webkit.WebView;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzbc {
    @NotNull
    private final WebView zza;
    @NotNull
    private final CoroutineScope zzb;

    public zzbc(@NotNull WebView webView, @NotNull CoroutineScope coroutineScope) {
        this.zza = webView;
        this.zzb = coroutineScope;
    }

    public final void zzb(@NotNull String str, @NotNull String... strArr) {
        e.e(this.zzb, null, null, new zzbb(strArr, this, str, null), 3, null);
    }
}
