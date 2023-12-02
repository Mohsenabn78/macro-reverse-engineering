package com.pollfish.internal;

import android.media.MediaPlayer;
import android.view.View;
import android.webkit.WebChromeClient;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class y3 extends WebChromeClient implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final u3 f37362a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final z5 f37363b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public WebChromeClient.CustomViewCallback f37364c;

    public y3(@NotNull u3 u3Var, @NotNull z5 z5Var) {
        this.f37362a = u3Var;
        this.f37363b = z5Var;
    }

    @Override // android.webkit.WebChromeClient
    @NotNull
    public final View getVideoLoadingProgressView() {
        this.f37363b.b();
        return (v2) this.f37363b.getPollfishLoadingView();
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(@Nullable MediaPlayer mediaPlayer) {
        onHideCustomView();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(@Nullable MediaPlayer mediaPlayer, int i4, int i5) {
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        this.f37362a.y();
        WebChromeClient.CustomViewCallback customViewCallback = this.f37364c;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
        }
        this.f37363b.c();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(@Nullable MediaPlayer mediaPlayer) {
        this.f37363b.a();
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated(message = "Deprecated in Java")
    public final void onShowCustomView(@Nullable View view, int i4, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(@Nullable View view, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
        this.f37363b.a(view);
        this.f37362a.j();
        this.f37364c = customViewCallback;
    }
}
