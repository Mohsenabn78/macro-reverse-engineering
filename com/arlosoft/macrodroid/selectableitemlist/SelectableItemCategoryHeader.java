package com.arlosoft.macrodroid.selectableitemlist;

import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager2;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.categories.SelectableItemCategory;
import com.getpebble.android.kit.Constants;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractExpandableHeaderItem;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.ExpandableViewHolder;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectableItemCategoryHeader.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public class SelectableItemCategoryHeader extends AbstractExpandableHeaderItem<HeaderViewHolder, AbstractSectionableItem<FlexibleViewHolder, SelectableItemCategoryHeader>> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final SelectableItemCategory f13345h;

    /* renamed from: i  reason: collision with root package name */
    private final int f13346i;

    /* renamed from: j  reason: collision with root package name */
    private final int f13347j;

    /* compiled from: SelectableItemCategoryHeader.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class HeaderViewHolder extends ExpandableViewHolder {
        public static final int $stable = 8;
        @BindView(R.id.background)
        public View background;
        @BindView(R.id.category_name)
        public TextView categoryName;
        @BindView(R.id.category_container)
        public LinearLayout container;
        @BindView(R.id.divider_bottom)
        public View dividerBottom;
        @BindView(R.id.divider_top)
        public View dividerTop;

        /* renamed from: g  reason: collision with root package name */
        private final int f13348g;
        @BindView(R.id.icon)
        public ImageView icon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> adapter, int i4) {
            super(view, adapter, false);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.f13348g = ContextCompat.getColor(this.itemView.getContext(), i4);
            ButterKnife.bind(this, view);
        }

        public final void bind(@NotNull SelectableItemCategory category) {
            Intrinsics.checkNotNullParameter(category, "category");
            getCategoryName().setText(category.getCategoryName());
            getCategoryName().setTextColor(this.f13348g);
            getDividerTop().setBackgroundColor(this.f13348g);
            getDividerTop().setAlpha(0.2f);
            getDividerBottom().setBackgroundColor(this.f13348g);
            getIcon().setColorFilter(this.f13348g, PorterDuff.Mode.MULTIPLY);
            getIcon().setImageResource(category.getIconRes());
        }

        @NotNull
        public final View getBackground() {
            View view = this.background;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("background");
            return null;
        }

        @NotNull
        public final TextView getCategoryName() {
            TextView textView = this.categoryName;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("categoryName");
            return null;
        }

        @NotNull
        public final LinearLayout getContainer() {
            LinearLayout linearLayout = this.container;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("container");
            return null;
        }

        @NotNull
        public final View getDividerBottom() {
            View view = this.dividerBottom;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dividerBottom");
            return null;
        }

        @NotNull
        public final View getDividerTop() {
            View view = this.dividerTop;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dividerTop");
            return null;
        }

        @NotNull
        public final ImageView getIcon() {
            ImageView imageView = this.icon;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException(Constants.CUST_ICON);
            return null;
        }

        public final void setBackground(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.background = view;
        }

        public final void setCategoryName(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.categoryName = textView;
        }

        public final void setContainer(@NotNull LinearLayout linearLayout) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.container = linearLayout;
        }

        public final void setDividerBottom(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.dividerBottom = view;
        }

        public final void setDividerTop(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.dividerTop = view;
        }

        public final void setIcon(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.icon = imageView;
        }
    }

    /* loaded from: classes3.dex */
    public final class HeaderViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private HeaderViewHolder f13349a;

        @UiThread
        public HeaderViewHolder_ViewBinding(HeaderViewHolder headerViewHolder, View view) {
            this.f13349a = headerViewHolder;
            headerViewHolder.container = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.category_container, "field 'container'", LinearLayout.class);
            headerViewHolder.categoryName = (TextView) Utils.findRequiredViewAsType(view, R.id.category_name, "field 'categoryName'", TextView.class);
            headerViewHolder.dividerTop = Utils.findRequiredView(view, R.id.divider_top, "field 'dividerTop'");
            headerViewHolder.dividerBottom = Utils.findRequiredView(view, R.id.divider_bottom, "field 'dividerBottom'");
            headerViewHolder.background = Utils.findRequiredView(view, R.id.background, "field 'background'");
            headerViewHolder.icon = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon, "field 'icon'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            HeaderViewHolder headerViewHolder = this.f13349a;
            if (headerViewHolder != null) {
                this.f13349a = null;
                headerViewHolder.container = null;
                headerViewHolder.categoryName = null;
                headerViewHolder.dividerTop = null;
                headerViewHolder.dividerBottom = null;
                headerViewHolder.background = null;
                headerViewHolder.icon = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public SelectableItemCategoryHeader(@NotNull SelectableItemCategory category, int i4, int i5) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.f13345h = category;
        this.f13346i = i4;
        this.f13347j = i5;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void bindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i4, List list) {
        bindViewHolder((FlexibleAdapter<IFlexible<?>>) flexibleAdapter, (HeaderViewHolder) viewHolder, i4, (List<?>) list);
    }

    @NotNull
    public final SelectableItemCategory category() {
        return this.f13345h;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder createViewHolder(View view, FlexibleAdapter flexibleAdapter) {
        return createViewHolder(view, (FlexibleAdapter<IFlexible<?>>) flexibleAdapter);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof SelectableItemCategoryHeader) && hashCode() == ((SelectableItemCategoryHeader) obj).hashCode()) {
            return true;
        }
        return false;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.selectable_item_category;
    }

    public int hashCode() {
        return this.f13346i;
    }

    public void bindViewHolder(@NotNull FlexibleAdapter<IFlexible<?>> adapter, @NotNull HeaderViewHolder holder, int i4, @NotNull List<?> payloads) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.bind(this.f13345h);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager2.LayoutParams");
        ((StaggeredGridLayoutManager2.LayoutParams) layoutParams).setFullSpan(true);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public HeaderViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<IFlexible<?>> adapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        return new HeaderViewHolder(view, adapter, this.f13347j);
    }
}
