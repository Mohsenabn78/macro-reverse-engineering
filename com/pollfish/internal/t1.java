package com.pollfish.internal;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class t1 extends WebChromeClient {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final u1<Integer> f37224a = new u1<>(0);

    @NotNull
    public final u1<Integer> a() {
        return this.f37224a;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(@Nullable WebView webView, int i4) {
        this.f37224a.a((u1<Integer>) Integer.valueOf(i4));
    }
}
