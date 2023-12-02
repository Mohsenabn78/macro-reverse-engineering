package com.arlosoft.macrodroid.macrolist;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.macrolist.MacroListCategoryHeader;
import com.arlosoft.macrodroid.utils.ColorUtils;
import com.arlosoft.macrodroid.widget.SwitchPlus;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractExpandableHeaderItem;
import eu.davidea.viewholders.ExpandableViewHolder;
import java.util.List;

/* loaded from: classes3.dex */
public class MacroListCategoryHeader extends AbstractExpandableHeaderItem<HeaderViewHolder, MacroListItem> {

    /* renamed from: h  reason: collision with root package name */
    private final Category f12876h;

    /* renamed from: i  reason: collision with root package name */
    private final OnCategoryClickedListener f12877i;

    /* renamed from: j  reason: collision with root package name */
    private final View.OnLongClickListener f12878j;

    /* renamed from: k  reason: collision with root package name */
    private final int f12879k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12880l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f12881m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12882n;

    /* renamed from: o  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f12883o;

    /* renamed from: p  reason: collision with root package name */
    private HeadingColorMapper f12884p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class HeaderViewHolder extends ExpandableViewHolder {
        @BindView(R.id.category_container)
        View categoryContainer;
        @BindView(R.id.group_title)
        TextView categoryTitle;

        /* renamed from: g  reason: collision with root package name */
        private HeadingColorMapper f12885g;
        @BindView(R.id.lockImage)
        ImageView lockImage;
        @BindView(R.id.group_on_off_button)
        SwitchPlus onOffButton;

        public HeaderViewHolder(@NonNull View view, @NonNull FlexibleAdapter flexibleAdapter, HeadingColorMapper headingColorMapper) {
            super(view, flexibleAdapter, false);
            ButterKnife.bind(this, view);
            this.f12885g = headingColorMapper;
        }

        @Override // eu.davidea.viewholders.ExpandableViewHolder
        protected boolean h() {
            return true;
        }

        public void k(@NonNull Category category, boolean z3, boolean z4, int i4, boolean z5, @NonNull final OnCategoryClickedListener onCategoryClickedListener, @Nullable View.OnLongClickListener onLongClickListener, @Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener, final MacroListCategoryHeader macroListCategoryHeader) {
            int i5;
            int i6;
            int headingColor = this.f12885g.getHeadingColor(category.getColor());
            this.onOffButton.setOffColor(ColorUtils.darkenOrLightenBasedOnDarkMode(this.itemView.getContext(), headingColor));
            TextView textView = this.categoryTitle;
            textView.setText(category.getName() + " (" + i4 + ")");
            this.categoryContainer.setBackgroundColor(headingColor);
            this.categoryContainer.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.macrolist.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MacroListCategoryHeader.OnCategoryClickedListener.this.onClick(macroListCategoryHeader);
                }
            });
            this.categoryContainer.setOnLongClickListener(onLongClickListener);
            this.onOffButton.setOnCheckedChangeListener(null);
            this.onOffButton.setChecked(z3);
            this.onOffButton.setOnCheckedChangeListener(onCheckedChangeListener);
            SwitchPlus switchPlus = this.onOffButton;
            int i7 = 0;
            if (z4) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            switchPlus.setVisibility(i5);
            ImageView imageView = this.lockImage;
            if (!category.isLocked()) {
                i7 = 8;
            }
            imageView.setVisibility(i7);
            ImageView imageView2 = this.lockImage;
            if (z5) {
                i6 = R.drawable.ic_lock_open_outline_white_24dp;
            } else {
                i6 = R.drawable.ic_lock_white_24dp;
            }
            imageView2.setImageResource(i6);
        }
    }

    /* loaded from: classes3.dex */
    public class HeaderViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private HeaderViewHolder f12886a;

        @UiThread
        public HeaderViewHolder_ViewBinding(HeaderViewHolder headerViewHolder, View view) {
            this.f12886a = headerViewHolder;
            headerViewHolder.categoryContainer = Utils.findRequiredView(view, R.id.category_container, "field 'categoryContainer'");
            headerViewHolder.categoryTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.group_title, "field 'categoryTitle'", TextView.class);
            headerViewHolder.onOffButton = (SwitchPlus) Utils.findRequiredViewAsType(view, R.id.group_on_off_button, "field 'onOffButton'", SwitchPlus.class);
            headerViewHolder.lockImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.lockImage, "field 'lockImage'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            HeaderViewHolder headerViewHolder = this.f12886a;
            if (headerViewHolder != null) {
                this.f12886a = null;
                headerViewHolder.categoryContainer = null;
                headerViewHolder.categoryTitle = null;
                headerViewHolder.onOffButton = null;
                headerViewHolder.lockImage = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes3.dex */
    public interface OnCategoryClickedListener {
        void onClick(MacroListCategoryHeader macroListCategoryHeader);
    }

    public MacroListCategoryHeader(@NonNull Category category, int i4, boolean z3, boolean z4, boolean z5, @Nullable OnCategoryClickedListener onCategoryClickedListener, @Nullable View.OnLongClickListener onLongClickListener, HeadingColorMapper headingColorMapper) {
        this.f12876h = category;
        this.f12879k = i4;
        this.f12882n = z4;
        this.f12881m = z5;
        this.f12877i = onCategoryClickedListener;
        this.f12878j = onLongClickListener;
        this.f12880l = z3;
        this.f12884p = headingColorMapper;
        setExpanded(category.isExpanded());
    }

    private int a() {
        return this.f12879k;
    }

    private int b() {
        List<S> subItems = getSubItems();
        int i4 = 0;
        if (subItems != 0) {
            for (S s3 : subItems) {
                i4 += !s3.isHidden();
            }
        }
        return i4;
    }

    public Category category() {
        return this.f12876h;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof MacroListCategoryHeader) && this.f12879k == ((MacroListCategoryHeader) obj).a()) {
            return true;
        }
        return false;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.group_item;
    }

    public int hashCode() {
        return this.f12879k;
    }

    public void setCategoryEnabled(boolean z3) {
        this.f12880l = z3;
    }

    public void setHasUnlocked(boolean z3) {
        this.f12881m = z3;
    }

    public void setOnOffListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f12883o = onCheckedChangeListener;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public void bindViewHolder(FlexibleAdapter flexibleAdapter, HeaderViewHolder headerViewHolder, int i4, List list) {
        headerViewHolder.k(this.f12876h, this.f12880l, this.f12882n, b(), this.f12881m, this.f12877i, this.f12878j, this.f12883o, this);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public HeaderViewHolder createViewHolder(View view, FlexibleAdapter flexibleAdapter) {
        return new HeaderViewHolder(view, flexibleAdapter, this.f12884p);
    }
}
