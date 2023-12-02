package com.arlosoft.macrodroid.action.activities;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.JavaScriptAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaScriptEditActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class JavaScriptEditingStore {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static JavaScriptAction f2861a;
    @NotNull
    public static final JavaScriptEditingStore INSTANCE = new JavaScriptEditingStore();
    public static final int $stable = 8;

    private JavaScriptEditingStore() {
    }

    @Nullable
    public final JavaScriptAction getAction() {
        return f2861a;
    }

    public final void setAction(@Nullable JavaScriptAction javaScriptAction) {
        f2861a = javaScriptAction;
    }
}
