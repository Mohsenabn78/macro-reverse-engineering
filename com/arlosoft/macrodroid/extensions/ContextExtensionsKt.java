package com.arlosoft.macrodroid.extensions;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ContextExtensions.kt */
/* loaded from: classes3.dex */
public final class ContextExtensionsKt {
    @NotNull
    public static final Executor theMainExecutor(@NotNull Context context) {
        Executor mainExecutor;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (Build.VERSION.SDK_INT >= 28) {
            mainExecutor = context.getMainExecutor();
            Intrinsics.checkNotNullExpressionValue(mainExecutor, "{\n        mainExecutor\n    }");
            return mainExecutor;
        }
        return new HandlerExecutor(context.getMainLooper());
    }
}
