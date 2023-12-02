package com.pollfish.internal;

import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class r2 extends InputConnectionWrapper {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final z f37193a;

    public r2(@NotNull InputConnection inputConnection, @NotNull z zVar) {
        super(inputConnection, false);
        this.f37193a = zVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitCompletion(@Nullable CompletionInfo completionInfo) {
        this.f37193a.c();
        return true;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int i4) {
        this.f37193a.a();
        return true;
    }
}
