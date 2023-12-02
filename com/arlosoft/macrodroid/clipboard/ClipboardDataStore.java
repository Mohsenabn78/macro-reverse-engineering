package com.arlosoft.macrodroid.clipboard;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClipboardDataStore.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ClipboardDataStore {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static String f9760a;
    @NotNull
    public static final ClipboardDataStore INSTANCE = new ClipboardDataStore();
    public static final int $stable = 8;

    private ClipboardDataStore() {
    }

    @JvmStatic
    @Nullable
    public static final String getClipboardText() {
        return f9760a;
    }

    @JvmStatic
    public static final void setClipboardText(@NotNull String clipboardText) {
        Intrinsics.checkNotNullParameter(clipboardText, "clipboardText");
        f9760a = clipboardText;
    }
}
