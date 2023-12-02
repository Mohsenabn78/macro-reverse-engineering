package com.arlosoft.macrodroid.taskerplugin;

import androidx.compose.runtime.internal.StabilityInferred;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TaskerPluginHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class App extends ExpandableGroup<Plugin> {
    public static final int $stable = 0;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f13618c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public App(@NotNull String packageName, @NotNull String appName, @NotNull List<Plugin> items) {
        super(packageName, items);
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(items, "items");
        this.f13618c = appName;
    }

    @NotNull
    public final String getAppName() {
        return this.f13618c;
    }
}
