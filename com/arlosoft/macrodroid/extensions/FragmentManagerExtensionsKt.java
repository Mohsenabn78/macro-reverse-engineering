package com.arlosoft.macrodroid.extensions;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: FragmentManagerExtensions.kt */
/* loaded from: classes3.dex */
public final class FragmentManagerExtensionsKt {
    public static final void inTransaction(@NotNull FragmentManager fragmentManager, @NotNull Function1<? super FragmentTransaction, Unit> func) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(func, "func");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        func.invoke(beginTransaction);
        beginTransaction.commit();
    }
}
