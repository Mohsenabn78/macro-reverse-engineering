package com.arlosoft.macrodroid.utils;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: FragmentViewBindingDelegate.kt */
/* loaded from: classes3.dex */
public final class FragmentViewBindingDelegateKt {
    @NotNull
    public static final <T extends ViewBinding> FragmentViewBindingDelegate<T> viewBinding(@NotNull Fragment fragment, @NotNull Function1<? super View, ? extends T> viewBindingFactory) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(viewBindingFactory, "viewBindingFactory");
        return new FragmentViewBindingDelegate<>(fragment, viewBindingFactory);
    }
}
