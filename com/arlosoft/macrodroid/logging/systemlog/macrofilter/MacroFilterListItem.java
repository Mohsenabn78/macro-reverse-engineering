package com.arlosoft.macrodroid.logging.systemlog.macrofilter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.arlosoft.macrodroid.macro.Macro;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.util.List;

/* loaded from: classes3.dex */
public class MacroFilterListItem extends AbstractSectionableItem<FilterViewHolder, MacroFilterCategoryHeader> {

    /* renamed from: g  reason: collision with root package name */
    private final Macro f12757g;

    /* renamed from: h  reason: collision with root package name */
    private final int f12758h;

    /* renamed from: i  reason: collision with root package name */
    private long f12759i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12760j;

    /* renamed from: k  reason: collision with root package name */
    private FlexibleViewHolder f12761k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12762l;

    /* renamed from: m  reason: collision with root package name */
    private OnFilterChangeListener f12763m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12764n;

    /* loaded from: classes3.dex */
    public class FilterViewHolder extends FlexibleViewHolder {
        @BindView(R.id.filterEnabledCheckbox)
        CheckBox filterEnabledCheckbox;
        @BindView(R.id.macroName)
        TextView macroName;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements CompoundButton.OnCheckedChangeListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ OnFilterChangeListener f12766a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MacroFilterListItem f12767b;

            a(OnFilterChangeListener onFilterChangeListener, MacroFilterListItem macroFilterListItem) {
                this.f12766a = onFilterChangeListener;
                this.f12767b = macroFilterListItem;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                if (this.f12766a != null) {
                    this.f12767b.setEnabledState(z3);
                    this.f12766a.filterStateChanged(Long.valueOf(this.f12767b.f12757g.getGUID()), z3);
                }
            }
        }

        public FilterViewHolder(@NonNull View view, @NonNull FlexibleAdapter flexibleAdapter) {
            super(view, flexibleAdapter);
            ButterKnife.bind(this, view);
        }

        public void bind(@NonNull MacroFilterListItem macroFilterListItem, @Nullable OnFilterChangeListener onFilterChangeListener, boolean z3) {
            this.macroName.setText(macroFilterListItem.f12757g.getName());
            this.filterEnabledCheckbox.setOnCheckedChangeListener(null);
            this.filterEnabledCheckbox.setChecked(z3);
            this.filterEnabledCheckbox.setOnCheckedChangeListener(new a(onFilterChangeListener, macroFilterListItem));
        }
    }

    /* loaded from: classes3.dex */
    public class FilterViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private FilterViewHolder f12769a;

        @UiThread
        public FilterViewHolder_ViewBinding(FilterViewHolder filterViewHolder, View view) {
            this.f12769a = filterViewHolder;
            filterViewHolder.macroName = (TextView) Utils.findRequiredViewAsType(view, R.id.macroName, "field 'macroName'", TextView.class);
            filterViewHolder.filterEnabledCheckbox = (CheckBox) Utils.findRequiredViewAsType(view, R.id.filterEnabledCheckbox, "field 'filterEnabledCheckbox'", CheckBox.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            FilterViewHolder filterViewHolder = this.f12769a;
            if (filterViewHolder != null) {
                this.f12769a = null;
                filterViewHolder.macroName = null;
                filterViewHolder.filterEnabledCheckbox = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes3.dex */
    public interface OnFilterChangeListener {
        void filterStateChanged(Long l4, boolean z3);
    }

    public MacroFilterListItem(@NonNull MacroFilterCategoryHeader macroFilterCategoryHeader, int i4, @NonNull Macro macro, boolean z3, @Nullable OnFilterChangeListener onFilterChangeListener) {
        super(macroFilterCategoryHeader);
        this.f12757g = macro;
        this.f12758h = i4;
        this.f12759i = this.f12759i;
        this.f12762l = this.f12762l;
        this.f12760j = this.f12760j;
        this.f12764n = z3;
        this.f12763m = onFilterChangeListener;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem
    public boolean equals(Object obj) {
        if (!(obj instanceof MacroFilterListItem) || this.f12758h != ((MacroFilterListItem) obj).id()) {
            return false;
        }
        return true;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.view_macro_filter_entry;
    }

    public Macro getMacro() {
        return this.f12757g;
    }

    public int hashCode() {
        return this.f12758h;
    }

    @NonNull
    public int id() {
        return this.f12758h;
    }

    public void setEnabledState(boolean z3) {
        this.f12764n = z3;
    }

    public void unbind() {
        this.f12761k = null;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public void bindViewHolder(FlexibleAdapter flexibleAdapter, FilterViewHolder filterViewHolder, int i4, List list) {
        filterViewHolder.bind(this, this.f12763m, this.f12764n);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public FilterViewHolder createViewHolder(View view, FlexibleAdapter flexibleAdapter) {
        return new FilterViewHolder(view, flexibleAdapter);
    }
}
