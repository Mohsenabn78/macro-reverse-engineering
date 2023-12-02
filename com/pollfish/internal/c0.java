package com.pollfish.internal;

import android.content.Context;
import android.os.Handler;
import com.pollfish.internal.c0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class c0 {
    public static final void a(@NotNull Context context, @NotNull final Function0<Unit> function0) {
        new Handler(context.getMainLooper()).post(new Runnable() { // from class: k1.e
            @Override // java.lang.Runnable
            public final void run() {
                c0.a(Function0.this);
            }
        });
    }

    public static final void a(Function0 function0) {
        function0.invoke();
    }

    public static final boolean a(@NotNull Context context) {
        return (context.getApplicationInfo().flags & 2) == 0;
    }
}
