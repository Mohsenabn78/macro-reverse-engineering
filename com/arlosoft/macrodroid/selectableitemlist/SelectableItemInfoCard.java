package com.arlosoft.macrodroid.selectableitemlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager2;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.AddSelectableItemInfoCard;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectableItemInfoCard.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SelectableItemInfoCard extends AbstractFlexibleItem<AddSelectableItemInfoCard.ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final Context f13350f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13351g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f13352h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final AddSelectableItemInfoCard.InfoCardDismissedListener f13353i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f13354j;

    public /* synthetic */ SelectableItemInfoCard(Context context, int i4, boolean z3, AddSelectableItemInfoCard.InfoCardDismissedListener infoCardDismissedListener, boolean z4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i4, z3, infoCardDismissedListener, (i5 & 16) != 0 ? false : z4);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void bindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i4, List list) {
        bindViewHolder((FlexibleAdapter<IFlexible<?>>) flexibleAdapter, (AddSelectableItemInfoCard.ViewHolder) viewHolder, i4, (List<?>) list);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder createViewHolder(View view, FlexibleAdapter flexibleAdapter) {
        return createViewHolder(view, (FlexibleAdapter<IFlexible<?>>) flexibleAdapter);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SelectableItemInfoCard) || id() != ((SelectableItemInfoCard) obj).id()) {
            return false;
        }
        return true;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.info_card;
    }

    public int hashCode() {
        return id();
    }

    public final int id() {
        return -1;
    }

    public SelectableItemInfoCard(@NotNull Context context, int i4, boolean z3, @NotNull AddSelectableItemInfoCard.InfoCardDismissedListener dismissListener, boolean z4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dismissListener, "dismissListener");
        this.f13350f = context;
        this.f13351g = i4;
        this.f13352h = z3;
        this.f13353i = dismissListener;
        this.f13354j = z4;
    }

    public void bindViewHolder(@NotNull FlexibleAdapter<IFlexible<?>> adapter, @NotNull AddSelectableItemInfoCard.ViewHolder holder, int i4, @NotNull List<?> payloads) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        AddSelectableItemInfoCard.bindInfoCard(this.f13350f, holder, this.f13351g, this.f13352h, this.f13353i);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager2.LayoutParams");
        StaggeredGridLayoutManager2.LayoutParams layoutParams2 = (StaggeredGridLayoutManager2.LayoutParams) layoutParams;
        layoutParams2.setFullSpan(true);
        if (this.f13354j) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = 0;
        }
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public AddSelectableItemInfoCard.ViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<IFlexible<?>> adapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        return new AddSelectableItemInfoCard.ViewHolder(view);
    }
}
