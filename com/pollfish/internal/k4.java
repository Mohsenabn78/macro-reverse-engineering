package com.pollfish.internal;

import android.content.Context;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class k4 {

    /* renamed from: a  reason: collision with root package name */
    public static i2 f36985a;

    /* renamed from: b  reason: collision with root package name */
    public static m f36986b;

    /* renamed from: c  reason: collision with root package name */
    public static m f36987c;

    /* renamed from: d  reason: collision with root package name */
    public static a f36988d;

    /* renamed from: e  reason: collision with root package name */
    public static WeakReference<Context> f36989e;

    /* renamed from: f  reason: collision with root package name */
    public static x4 f36990f;

    public static void a(@NotNull h2 h2Var, @NotNull l lVar, @NotNull n nVar, @NotNull a aVar, @NotNull Context context, @NotNull x4 x4Var) {
        f36985a = h2Var;
        f36987c = lVar;
        f36986b = nVar;
        f36988d = aVar;
        f36990f = x4Var;
        f36989e = new WeakReference<>(context);
    }

    @NotNull
    public static p b() {
        m mVar = f36986b;
        m mVar2 = null;
        if (mVar == null) {
            mVar = null;
        }
        m mVar3 = f36987c;
        if (mVar3 != null) {
            mVar2 = mVar3;
        }
        return new p(mVar, mVar2);
    }

    @Nullable
    public static m0 c() {
        WeakReference<Context> weakReference = f36989e;
        if (weakReference == null) {
            weakReference = null;
        }
        Context context = weakReference.get();
        if (context == null) {
            return null;
        }
        return new m0(context);
    }

    @NotNull
    public static k2 d() {
        i2 i2Var = f36985a;
        if (i2Var == null) {
            i2Var = null;
        }
        return new k2(i2Var);
    }

    @NotNull
    public static e a() {
        a aVar = f36988d;
        if (aVar == null) {
            aVar = null;
        }
        x4 x4Var = f36990f;
        return new e(aVar, (x4Var != null ? x4Var : null).p());
    }
}
