package com.pollfish.internal;

import android.content.Context;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<Context> f36693a;

    public static void a(@NotNull Context context) {
        f36693a = new WeakReference<>(context);
    }

    public static void a(@NotNull a aVar, @NotNull Context context) {
        f36693a = new WeakReference<>(context);
        ((l1) aVar).a(context);
    }

    @Nullable
    public static l1 a() {
        WeakReference<Context> weakReference = f36693a;
        if (weakReference == null) {
            weakReference = null;
        }
        Context context = weakReference.get();
        if (context != null) {
            return new l1(context);
        }
        return null;
    }
}
