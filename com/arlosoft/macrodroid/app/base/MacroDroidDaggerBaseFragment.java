package com.arlosoft.macrodroid.app.base;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import dagger.android.support.AndroidSupportInjection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: MacroDroidDaggerBaseFragment.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class MacroDroidDaggerBaseFragment extends MacroDroidBaseFragment {
    public static final int $stable = 0;

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }
}
