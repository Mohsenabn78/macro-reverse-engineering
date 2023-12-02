package com.arlosoft.macrodroid.gson.polymorphic;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.gson.RuntimeTypeAdapterFactory;
import com.arlosoft.macrodroid.triggers.ShakeDeviceTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TriggerTypeAdapterFactory.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TriggerTypeAdapterFactory {
    public static final int $stable = 0;
    @NotNull
    public static final TriggerTypeAdapterFactory INSTANCE = new TriggerTypeAdapterFactory();

    private TriggerTypeAdapterFactory() {
    }

    @JvmStatic
    @NotNull
    public static final RuntimeTypeAdapterFactory<Trigger> getTriggerAdapterFactory() {
        RuntimeTypeAdapterFactory<Trigger> registerSubtype = RuntimeTypeAdapterFactory.of(Trigger.class, "m_classType").registerSubtype(ShakeDeviceTrigger.class, "ShakeDeviceTrigger");
        Intrinsics.checkNotNullExpressionValue(registerSubtype, "of<Trigger>(Trigger::cla…va, \"ShakeDeviceTrigger\")");
        return registerSubtype;
    }
}
