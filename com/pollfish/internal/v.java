package com.pollfish.internal;

import android.content.Context;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<Context> f37269a;

    public static void a(@NotNull Context context) {
        f37269a = new WeakReference<>(context);
    }

    @Nullable
    public static f2 a() {
        WeakReference<Context> weakReference = f37269a;
        if (weakReference == null) {
            weakReference = null;
        }
        Context context = weakReference.get();
        if (context != null) {
            return new f2(context);
        }
        return null;
    }
}
