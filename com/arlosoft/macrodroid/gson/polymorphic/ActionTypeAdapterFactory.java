package com.arlosoft.macrodroid.gson.polymorphic;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.ToastAction;
import com.arlosoft.macrodroid.gson.RuntimeTypeAdapterFactory;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActionTypeAdapterFactory.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ActionTypeAdapterFactory {
    public static final int $stable = 0;
    @NotNull
    public static final ActionTypeAdapterFactory INSTANCE = new ActionTypeAdapterFactory();

    private ActionTypeAdapterFactory() {
    }

    @JvmStatic
    @NotNull
    public static final RuntimeTypeAdapterFactory<Action> getActionAdapterFactory() {
        RuntimeTypeAdapterFactory<Action> registerSubtype = RuntimeTypeAdapterFactory.of(Action.class, "m_classType").registerSubtype(ToastAction.class, "ToastAction");
        Intrinsics.checkNotNullExpressionValue(registerSubtype, "of<Action>(Action::class…lass.java, \"ToastAction\")");
        return registerSubtype;
    }
}
