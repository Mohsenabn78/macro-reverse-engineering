package com.arlosoft.macrodroid.plugins.data;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.HashMap;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalPluginListOverrideStore.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class LocalPluginListOverrideStore {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<Integer, PluginDetail> f13171a = new HashMap<>();

    public final void addLocalOverride(int i4, @NotNull PluginDetail pluginDetail) {
        Intrinsics.checkNotNullParameter(pluginDetail, "pluginDetail");
        this.f13171a.put(Integer.valueOf(i4), pluginDetail);
    }

    public final void clearAll() {
        this.f13171a.clear();
    }

    @Nullable
    public final PluginDetail getLocalOverride(int i4) {
        return this.f13171a.get(Integer.valueOf(i4));
    }
}
