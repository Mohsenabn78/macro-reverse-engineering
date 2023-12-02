package com.arlosoft.macrodroid.taskerplugin;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.util.Pair;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import com.twofortyfouram.locale.sdk.host.model.PluginInstanceData;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TaskerVariableHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TaskerVariableData {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Pair<Plugin, PluginInstanceData> f13642a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ArrayHandlingOption f13643b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f13644c;

    public TaskerVariableData(@NotNull Pair<Plugin, PluginInstanceData> pluginInstanceDataPair, @NotNull ArrayHandlingOption arrayHandlingOption, boolean z3) {
        Intrinsics.checkNotNullParameter(pluginInstanceDataPair, "pluginInstanceDataPair");
        Intrinsics.checkNotNullParameter(arrayHandlingOption, "arrayHandlingOption");
        this.f13642a = pluginInstanceDataPair;
        this.f13643b = arrayHandlingOption;
        this.f13644c = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskerVariableData copy$default(TaskerVariableData taskerVariableData, Pair pair, ArrayHandlingOption arrayHandlingOption, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            pair = taskerVariableData.f13642a;
        }
        if ((i4 & 2) != 0) {
            arrayHandlingOption = taskerVariableData.f13643b;
        }
        if ((i4 & 4) != 0) {
            z3 = taskerVariableData.f13644c;
        }
        return taskerVariableData.copy(pair, arrayHandlingOption, z3);
    }

    @NotNull
    public final Pair<Plugin, PluginInstanceData> component1() {
        return this.f13642a;
    }

    @NotNull
    public final ArrayHandlingOption component2() {
        return this.f13643b;
    }

    public final boolean component3() {
        return this.f13644c;
    }

    @NotNull
    public final TaskerVariableData copy(@NotNull Pair<Plugin, PluginInstanceData> pluginInstanceDataPair, @NotNull ArrayHandlingOption arrayHandlingOption, boolean z3) {
        Intrinsics.checkNotNullParameter(pluginInstanceDataPair, "pluginInstanceDataPair");
        Intrinsics.checkNotNullParameter(arrayHandlingOption, "arrayHandlingOption");
        return new TaskerVariableData(pluginInstanceDataPair, arrayHandlingOption, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskerVariableData)) {
            return false;
        }
        TaskerVariableData taskerVariableData = (TaskerVariableData) obj;
        if (Intrinsics.areEqual(this.f13642a, taskerVariableData.f13642a) && this.f13643b == taskerVariableData.f13643b && this.f13644c == taskerVariableData.f13644c) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayHandlingOption getArrayHandlingOption() {
        return this.f13643b;
    }

    public final boolean getBlockActions() {
        return this.f13644c;
    }

    @NotNull
    public final Pair<Plugin, PluginInstanceData> getPluginInstanceDataPair() {
        return this.f13642a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f13642a.hashCode() * 31) + this.f13643b.hashCode()) * 31;
        boolean z3 = this.f13644c;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode + i4;
    }

    @NotNull
    public String toString() {
        Pair<Plugin, PluginInstanceData> pair = this.f13642a;
        ArrayHandlingOption arrayHandlingOption = this.f13643b;
        boolean z3 = this.f13644c;
        return "TaskerVariableData(pluginInstanceDataPair=" + pair + ", arrayHandlingOption=" + arrayHandlingOption + ", blockActions=" + z3 + ")";
    }
}
