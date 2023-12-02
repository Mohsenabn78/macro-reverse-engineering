package com.arlosoft.macrodroid.selectableitemlist;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager2;
import com.arlosoft.macrodroid.R;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectableItemBlank.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SelectableItemBlank extends AbstractSectionableItem<FlexibleViewHolder, SelectableItemCategoryHeader> {
    public static final int $stable = 0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectableItemBlank(@NotNull SelectableItemCategoryHeader header) {
        super(header);
        Intrinsics.checkNotNullParameter(header, "header");
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void bindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i4, List list) {
        bindViewHolder((FlexibleAdapter<IFlexible<?>>) flexibleAdapter, (FlexibleViewHolder) viewHolder, i4, (List<?>) list);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder createViewHolder(View view, FlexibleAdapter flexibleAdapter) {
        return createViewHolder(view, (FlexibleAdapter<IFlexible<?>>) flexibleAdapter);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SelectableItemBlank) || id() != ((SelectableItemBlank) obj).id()) {
            return false;
        }
        return true;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.selectableitem_blank;
    }

    public int hashCode() {
        return id();
    }

    public final int id() {
        return -2;
    }

    public void bindViewHolder(@NotNull FlexibleAdapter<IFlexible<?>> adapter, @NotNull FlexibleViewHolder holder, int i4, @NotNull List<?> payloads) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager2.LayoutParams");
        ((StaggeredGridLayoutManager2.LayoutParams) layoutParams).setFullSpan(true);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public FlexibleViewHolder createViewHolder(@NotNull final View view, @NotNull final FlexibleAdapter<IFlexible<?>> adapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        return new FlexibleViewHolder(view, adapter) { // from class: com.arlosoft.macrodroid.selectableitemlist.SelectableItemBlank$createViewHolder$1
        };
    }
}
