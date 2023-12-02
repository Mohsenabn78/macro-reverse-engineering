package com.pollfish.internal;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class t5 {

    /* renamed from: a  reason: collision with root package name */
    public static m1 f37246a;

    /* renamed from: b  reason: collision with root package name */
    public static u3 f37247b;

    /* renamed from: c  reason: collision with root package name */
    public static x0 f37248c;

    public static void a(@NotNull m1 m1Var, @NotNull u3 u3Var, @NotNull x0 x0Var) {
        f37246a = m1Var;
        f37247b = u3Var;
        f37248c = x0Var;
    }

    @NotNull
    public static k3 b(@NotNull Context context) {
        u3 u3Var;
        x0 x0Var;
        u3 u3Var2 = f37247b;
        m1 m1Var = null;
        if (u3Var2 == null) {
            u3Var = null;
        } else {
            u3Var = u3Var2;
        }
        x0 x0Var2 = f37248c;
        if (x0Var2 == null) {
            x0Var = null;
        } else {
            x0Var = x0Var2;
        }
        m1 m1Var2 = f37246a;
        if (m1Var2 != null) {
            m1Var = m1Var2;
        }
        return new k3(context, u3Var, x0Var, p3.a(m1Var.b()), new d2(context));
    }

    @NotNull
    public static c4 c(@NotNull Context context) {
        u3 u3Var = f37247b;
        if (u3Var == null) {
            u3Var = null;
        }
        return new c4(context, u3Var);
    }

    @NotNull
    public static b4 d(@NotNull Context context) {
        u3 u3Var = f37247b;
        if (u3Var == null) {
            u3Var = null;
        }
        return new b4(context, u3Var, new s3(context));
    }

    public static void a(@NotNull m1 m1Var, @NotNull u3 u3Var) {
        f37246a = m1Var;
        f37247b = u3Var;
    }

    @NotNull
    public static void a(@NotNull Context context) {
        u3 u3Var = f37247b;
        if (u3Var == null) {
            u3Var = null;
        }
        x0 x0Var = f37248c;
        if (x0Var == null) {
            x0Var = null;
        }
        m1 m1Var = f37246a;
        new n2(context, u3Var, x0Var, m1Var != null ? m1Var : null);
    }

    @NotNull
    public static void a(@NotNull ViewGroup viewGroup) {
        u3 u3Var = f37247b;
        if (u3Var == null) {
            u3Var = null;
        }
        x0 x0Var = f37248c;
        new o3(viewGroup, u3Var, x0Var != null ? x0Var : null, new d2(viewGroup.getContext()));
    }

    @NotNull
    public static w5 a(@NotNull Context context, @Nullable ViewGroup viewGroup) {
        w5 w5Var;
        Context context2 = viewGroup != null ? viewGroup.getContext() : null;
        if (context2 instanceof Activity) {
            u3 u3Var = f37247b;
            if (u3Var == null) {
                u3Var = null;
            }
            x0 x0Var = f37248c;
            return new w5(u3Var, x0Var != null ? x0Var : null, viewGroup);
        }
        if (context2 == null) {
            u3 u3Var2 = f37247b;
            if (u3Var2 == null) {
                u3Var2 = null;
            }
            x0 x0Var2 = f37248c;
            w5Var = new w5(u3Var2, x0Var2 != null ? x0Var2 : null, context);
        } else {
            Log.w("Pollfish", "Passing a View that does not belong to an Activity is not supported. Please make sure the ViewGroup.context is an Activity instance.");
            u3 u3Var3 = f37247b;
            if (u3Var3 == null) {
                u3Var3 = null;
            }
            x0 x0Var3 = f37248c;
            w5Var = new w5(u3Var3, x0Var3 != null ? x0Var3 : null, context);
        }
        return w5Var;
    }
}
