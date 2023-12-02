package com.arlosoft.macrodroid.plugins.pluginlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.arlosoft.macrodroid.databinding.ViewPluginDetailsBinding;
import com.arlosoft.macrodroid.plugins.data.LocalPluginListOverrideStore;
import com.arlosoft.macrodroid.plugins.data.PluginDetail;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: PluginListAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PluginListAdapter extends PagedListAdapter<PluginDetail, PluginViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final PluginListViewModel f13200a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ProfileImageProvider f13201b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final LocalPluginListOverrideStore f13202c;

    /* compiled from: PluginListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class PluginDiffCallback extends DiffUtil.ItemCallback<PluginDetail> {
        public static final int $stable = 0;

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull PluginDetail oldItem, @NotNull PluginDetail newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull PluginDetail oldItem, @NotNull PluginDetail newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getPackageName(), newItem.getPackageName());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginListAdapter(@NotNull PluginListViewModel viewModel, @NotNull ProfileImageProvider profileImageProvider, @NotNull LocalPluginListOverrideStore pluginOverrideStore) {
        super(new PluginDiffCallback());
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(profileImageProvider, "profileImageProvider");
        Intrinsics.checkNotNullParameter(pluginOverrideStore, "pluginOverrideStore");
        this.f13200a = viewModel;
        this.f13201b = profileImageProvider;
        this.f13202c = pluginOverrideStore;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull PluginViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PluginDetail item = getItem(i4);
        Intrinsics.checkNotNull(item);
        PluginDetail pluginDetail = item;
        PluginDetail localOverride = this.f13202c.getLocalOverride(pluginDetail.getId());
        if (localOverride != null) {
            pluginDetail = localOverride;
        }
        holder.bind(pluginDetail);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public PluginViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewPluginDetailsBinding inflate = ViewPluginDetailsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new PluginViewHolder(inflate, this.f13200a, this.f13201b);
    }
}
