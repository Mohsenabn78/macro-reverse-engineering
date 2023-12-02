package com.arlosoft.macrodroid.selectableitemlist;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager2;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.wizard.AddedItemViewHolder;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChosenItemsListItem.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ChosenItemsListItem extends AbstractFlexibleItem<AddedItemViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final Activity f13341f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final Macro f13342g;

    /* renamed from: h  reason: collision with root package name */
    private final int f13343h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private List<? extends SelectableItem> f13344i;

    public ChosenItemsListItem(@NotNull Activity activity, @NotNull Macro macro, int i4) {
        List<? extends SelectableItem> emptyList;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(macro, "macro");
        this.f13341f = activity;
        this.f13342g = macro;
        this.f13343h = i4;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f13344i = emptyList;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void bindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i4, List list) {
        bindViewHolder((FlexibleAdapter<IFlexible<?>>) flexibleAdapter, (AddedItemViewHolder) viewHolder, i4, (List<?>) list);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder createViewHolder(View view, FlexibleAdapter flexibleAdapter) {
        return createViewHolder(view, (FlexibleAdapter<IFlexible<?>>) flexibleAdapter);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem
    public boolean equals(@Nullable Object obj) {
        return obj instanceof ChosenItemsListItem;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.list_item_wizard_header;
    }

    public int hashCode() {
        return Integer.MAX_VALUE;
    }

    public final void updateChosenItems(@NotNull List<? extends SelectableItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f13344i = items;
    }

    public void bindViewHolder(@NotNull FlexibleAdapter<IFlexible<?>> adapter, @NotNull AddedItemViewHolder holder, int i4, @NotNull List<?> payloads) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.bind(this.f13344i);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager2.LayoutParams");
        ((StaggeredGridLayoutManager2.LayoutParams) layoutParams).setFullSpan(true);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public AddedItemViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<IFlexible<?>> adapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        return new AddedItemViewHolder(this.f13341f, view, this.f13342g, this.f13343h);
    }
}
