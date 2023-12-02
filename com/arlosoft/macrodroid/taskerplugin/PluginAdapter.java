package com.arlosoft.macrodroid.taskerplugin;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.databinding.ListItemPluginAppBinding;
import com.arlosoft.macrodroid.databinding.ListItemPluginBinding;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.twofortyfouram.locale.sdk.host.model.Plugin;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TaskerPluginHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PluginAdapter extends ExpandableRecyclerViewAdapter<AppViewHolder, PluginViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final PluginSelectedListener f13621e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginAdapter(@NotNull List<? extends ExpandableGroup<?>> groups, @NotNull PluginSelectedListener pluginSelectedListener) {
        super(groups);
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(pluginSelectedListener, "pluginSelectedListener");
        this.f13621e = pluginSelectedListener;
    }

    @Override // com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
    public /* bridge */ /* synthetic */ void onBindChildViewHolder(PluginViewHolder pluginViewHolder, int i4, ExpandableGroup expandableGroup, int i5) {
        onBindChildViewHolder2(pluginViewHolder, i4, (ExpandableGroup<?>) expandableGroup, i5);
    }

    @Override // com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
    public /* bridge */ /* synthetic */ void onBindGroupViewHolder(AppViewHolder appViewHolder, int i4, ExpandableGroup expandableGroup) {
        onBindGroupViewHolder2(appViewHolder, i4, (ExpandableGroup<?>) expandableGroup);
    }

    /* renamed from: onBindChildViewHolder  reason: avoid collision after fix types in other method */
    public void onBindChildViewHolder2(@Nullable PluginViewHolder pluginViewHolder, int i4, @Nullable ExpandableGroup<?> expandableGroup, int i5) {
        Intrinsics.checkNotNull(expandableGroup, "null cannot be cast to non-null type com.arlosoft.macrodroid.taskerplugin.App");
        Plugin plugin = ((App) expandableGroup).getItems().get(i5);
        if (pluginViewHolder != null) {
            Intrinsics.checkNotNullExpressionValue(plugin, "plugin");
            pluginViewHolder.onBind(plugin, this.f13621e);
        }
    }

    /* renamed from: onBindGroupViewHolder  reason: avoid collision after fix types in other method */
    public void onBindGroupViewHolder2(@Nullable AppViewHolder appViewHolder, int i4, @Nullable ExpandableGroup<?> expandableGroup) {
        if (appViewHolder != null) {
            Intrinsics.checkNotNull(expandableGroup, "null cannot be cast to non-null type com.arlosoft.macrodroid.taskerplugin.App");
            String title = ((App) expandableGroup).getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "group as App).title");
            appViewHolder.onBind(title);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
    @NotNull
    public PluginViewHolder onCreateChildViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemPluginBinding inflate = ListItemPluginBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new PluginViewHolder(inflate);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
    @NotNull
    public AppViewHolder onCreateGroupViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemPluginAppBinding inflate = ListItemPluginAppBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new AppViewHolder(inflate);
    }
}
