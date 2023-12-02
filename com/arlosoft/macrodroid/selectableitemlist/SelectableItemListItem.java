package com.arlosoft.macrodroid.selectableitemlist;

import android.animation.LayoutTransition;
import android.content.Context;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.cardview.widget.CardView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.selectableitemlist.SelectableItemListItem;
import com.arlosoft.macrodroid.settings.Settings;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractSectionableItem;
import eu.davidea.flexibleadapter.items.IFilterable;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectableItemListItem.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSelectableItemListItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectableItemListItem.kt\ncom/arlosoft/macrodroid/selectableitemlist/SelectableItemListItem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,160:1\n766#2:161\n857#2,2:162\n*S KotlinDebug\n*F\n+ 1 SelectableItemListItem.kt\ncom/arlosoft/macrodroid/selectableitemlist/SelectableItemListItem\n*L\n83#1:161\n83#1:162,2\n*E\n"})
/* loaded from: classes3.dex */
public class SelectableItemListItem extends AbstractSectionableItem<FlexibleViewHolder, SelectableItemCategoryHeader> implements IFilterable<String> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final Context f13355g;

    /* renamed from: h  reason: collision with root package name */
    private final int f13356h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final SelectableItemInfo f13357i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final SelectableItemChosenListener f13358j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final OptionsProvider f13359k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f13360l;

    /* compiled from: SelectableItemListItem.kt */
    /* loaded from: classes3.dex */
    public interface OptionsProvider {
        boolean getHelpEnabled();
    }

    /* compiled from: SelectableItemListItem.kt */
    @StabilityInferred(parameters = 0)
    @SourceDebugExtension({"SMAP\nSelectableItemListItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectableItemListItem.kt\ncom/arlosoft/macrodroid/selectableitemlist/SelectableItemListItem$ViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,160:1\n262#2,2:161\n262#2,2:163\n262#2,2:165\n262#2,2:167\n262#2,2:169\n262#2,2:171\n*S KotlinDebug\n*F\n+ 1 SelectableItemListItem.kt\ncom/arlosoft/macrodroid/selectableitemlist/SelectableItemListItem$ViewHolder\n*L\n127#1:161,2\n139#1:163,2\n142#1:165,2\n144#1:167,2\n149#1:169,2\n155#1:171,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends FlexibleViewHolder {
        public static final int $stable = 8;
        @BindView(R.id.container)
        public CardView background;
        @BindView(R.id.select_item_icon)
        public ImageView constraintIcon;
        @BindView(R.id.select_item_name)
        public TextView constraintName;
        @BindView(R.id.select_item_row_frame)
        public ViewGroup frame;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private final SelectableItemChosenListener f13361g;
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final OptionsProvider f13362h;
        @BindView(R.id.select_item_help)
        public TextView helpText;
        @BindView(R.id.select_item_info_label)
        public TextView infoLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View itemView, @NotNull FlexibleAdapter<?> adapter, @Nullable SelectableItemChosenListener selectableItemChosenListener, @NotNull OptionsProvider optionsProvider) {
            super(itemView, adapter);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(optionsProvider, "optionsProvider");
            this.f13361g = selectableItemChosenListener;
            this.f13362h = optionsProvider;
            ButterKnife.bind(this, itemView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(ViewHolder this$0, SelectableItemInfo selectableItemInfo, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(selectableItemInfo, "$selectableItemInfo");
            SelectableItemChosenListener selectableItemChosenListener = this$0.f13361g;
            if (selectableItemChosenListener != null) {
                selectableItemChosenListener.selectableItemChosen(selectableItemInfo);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean g(ViewHolder this$0, SelectableItemInfo selectableItemInfo, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(selectableItemInfo, "$selectableItemInfo");
            SelectableItemChosenListener selectableItemChosenListener = this$0.f13361g;
            if (selectableItemChosenListener != null) {
                selectableItemChosenListener.selectableItemHelpChosen(selectableItemInfo);
                return true;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(ViewHolder this$0, SelectableItemInfo selectableItemInfo, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(selectableItemInfo, "$selectableItemInfo");
            SelectableItemChosenListener selectableItemChosenListener = this$0.f13361g;
            if (selectableItemChosenListener != null) {
                selectableItemChosenListener.selectableItemChosen(selectableItemInfo);
            }
        }

        public final void bind(@NotNull final SelectableItemInfo selectableItemInfo, boolean z3) {
            LayoutTransition layoutTransition;
            Intrinsics.checkNotNullParameter(selectableItemInfo, "selectableItemInfo");
            getFrame().getX();
            Context context = getContentView().getContext();
            getFrame().setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.selectableitemlist.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectableItemListItem.ViewHolder.f(SelectableItemListItem.ViewHolder.this, selectableItemInfo, view);
                }
            });
            getFrame().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.arlosoft.macrodroid.selectableitemlist.f
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean g4;
                    g4 = SelectableItemListItem.ViewHolder.g(SelectableItemListItem.ViewHolder.this, selectableItemInfo, view);
                    return g4;
                }
            });
            getConstraintName().setText(selectableItemInfo.getName());
            getConstraintIcon().setImageDrawable(ContextCompat.getDrawable(context, selectableItemInfo.getIcon()));
            if (z3) {
                getBackground().setCardBackgroundColor(ContextCompat.getColor(context, R.color.condition_primary));
            } else {
                getBackground().setCardBackgroundColor(ContextCompat.getColor(context, selectableItemInfo.getItemColor(false)));
            }
            getInfoLabel().setText("");
            if (selectableItemInfo.isRootOnly()) {
                getInfoLabel().setVisibility(0);
                if (selectableItemInfo.supportsAdbHack()) {
                    if (Settings.getRootEnabled(context)) {
                        getInfoLabel().setText(R.string.root_or_adb_hack);
                    } else {
                        getInfoLabel().setText(R.string.adb_hack);
                    }
                } else {
                    getInfoLabel().setText(R.string.root_only);
                }
            } else if (selectableItemInfo.isExperimental()) {
                getInfoLabel().setText(this.itemView.getContext().getText(R.string.experimental));
                getInfoLabel().setVisibility(0);
            } else if (selectableItemInfo.isBeta()) {
                getInfoLabel().setText(this.itemView.getContext().getText(R.string.feature_beta_label));
                getInfoLabel().setVisibility(0);
            } else {
                getInfoLabel().setVisibility(8);
            }
            if (this.f13362h.getHelpEnabled()) {
                ViewGroup frame = getFrame();
                layoutTransition = SelectableItemListItemKt.f13364a;
                frame.setLayoutTransition(layoutTransition);
                getHelpText().setVisibility(0);
                getHelpText().setText(selectableItemInfo.getHelpInfo());
                Linkify.addLinks(getHelpText(), 15);
                getHelpText().setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.selectableitemlist.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SelectableItemListItem.ViewHolder.h(SelectableItemListItem.ViewHolder.this, selectableItemInfo, view);
                    }
                });
                return;
            }
            getFrame().setLayoutTransition(null);
            getHelpText().setVisibility(8);
        }

        @NotNull
        public final CardView getBackground() {
            CardView cardView = this.background;
            if (cardView != null) {
                return cardView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("background");
            return null;
        }

        @NotNull
        public final ImageView getConstraintIcon() {
            ImageView imageView = this.constraintIcon;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("constraintIcon");
            return null;
        }

        @NotNull
        public final TextView getConstraintName() {
            TextView textView = this.constraintName;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("constraintName");
            return null;
        }

        @NotNull
        public final ViewGroup getFrame() {
            ViewGroup viewGroup = this.frame;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException(TypedValues.AttributesType.S_FRAME);
            return null;
        }

        @NotNull
        public final TextView getHelpText() {
            TextView textView = this.helpText;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("helpText");
            return null;
        }

        @NotNull
        public final TextView getInfoLabel() {
            TextView textView = this.infoLabel;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("infoLabel");
            return null;
        }

        public final void setBackground(@NotNull CardView cardView) {
            Intrinsics.checkNotNullParameter(cardView, "<set-?>");
            this.background = cardView;
        }

        public final void setConstraintIcon(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.constraintIcon = imageView;
        }

        public final void setConstraintName(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.constraintName = textView;
        }

        public final void setFrame(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.frame = viewGroup;
        }

        public final void setHelpText(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.helpText = textView;
        }

        public final void setInfoLabel(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.infoLabel = textView;
        }
    }

    /* loaded from: classes3.dex */
    public final class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: a  reason: collision with root package name */
        private ViewHolder f13363a;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f13363a = viewHolder;
            viewHolder.frame = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.select_item_row_frame, "field 'frame'", ViewGroup.class);
            viewHolder.constraintName = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_name, "field 'constraintName'", TextView.class);
            viewHolder.infoLabel = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_info_label, "field 'infoLabel'", TextView.class);
            viewHolder.constraintIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.select_item_icon, "field 'constraintIcon'", ImageView.class);
            viewHolder.helpText = (TextView) Utils.findRequiredViewAsType(view, R.id.select_item_help, "field 'helpText'", TextView.class);
            viewHolder.background = (CardView) Utils.findRequiredViewAsType(view, R.id.container, "field 'background'", CardView.class);
        }

        @Override // butterknife.Unbinder
        public void unbind() {
            ViewHolder viewHolder = this.f13363a;
            if (viewHolder != null) {
                this.f13363a = null;
                viewHolder.frame = null;
                viewHolder.constraintName = null;
                viewHolder.infoLabel = null;
                viewHolder.constraintIcon = null;
                viewHolder.helpText = null;
                viewHolder.background = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public /* synthetic */ SelectableItemListItem(Context context, SelectableItemCategoryHeader selectableItemCategoryHeader, int i4, SelectableItemInfo selectableItemInfo, SelectableItemChosenListener selectableItemChosenListener, OptionsProvider optionsProvider, boolean z3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, selectableItemCategoryHeader, i4, selectableItemInfo, selectableItemChosenListener, optionsProvider, (i5 & 64) != 0 ? false : z3);
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
        if (!(obj instanceof SelectableItemListItem) || this.f13356h != ((SelectableItemListItem) obj).id()) {
            return false;
        }
        return true;
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.select_item_box;
    }

    public int hashCode() {
        return this.f13356h;
    }

    public final int id() {
        return this.f13356h;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectableItemListItem(@NotNull Context context, @NotNull SelectableItemCategoryHeader header, int i4, @Nullable SelectableItemInfo selectableItemInfo, @NotNull SelectableItemChosenListener itemChosenListener, @NotNull OptionsProvider optionsProvider, boolean z3) {
        super(header);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(itemChosenListener, "itemChosenListener");
        Intrinsics.checkNotNullParameter(optionsProvider, "optionsProvider");
        this.f13355g = context;
        this.f13356h = i4;
        this.f13357i = selectableItemInfo;
        this.f13358j = itemChosenListener;
        this.f13359k = optionsProvider;
        this.f13360l = z3;
    }

    public void bindViewHolder(@NotNull FlexibleAdapter<IFlexible<?>> adapter, @NotNull FlexibleViewHolder holder, int i4, @NotNull List<?> payloads) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        adapter.getItem(i4);
        Intrinsics.checkNotNullExpressionValue(adapter.getCurrentItems(), "adapter.currentItems");
        SelectableItemInfo selectableItemInfo = this.f13357i;
        Intrinsics.checkNotNull(selectableItemInfo);
        ((ViewHolder) holder).bind(selectableItemInfo, this.f13360l);
    }

    @Override // eu.davidea.flexibleadapter.items.AbstractFlexibleItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public ViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<IFlexible<?>> adapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        return new ViewHolder(view, adapter, this.f13358j, this.f13359k);
    }

    @Override // eu.davidea.flexibleadapter.items.IFilterable
    public boolean filter(@NotNull String filterText) {
        boolean any;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(filterText, "filterText");
        SelectableItemInfo selectableItemInfo = this.f13357i;
        Intrinsics.checkNotNull(selectableItemInfo);
        ArrayList arrayList = new ArrayList();
        for (Object obj : selectableItemInfo.getSerchTerms()) {
            String string = this.f13355g.getString(((Number) obj).intValue());
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(it)");
            Locale locale = Locale.ROOT;
            String lowerCase = string.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            String lowerCase2 = filterText.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null);
            if (contains$default) {
                arrayList.add(obj);
            }
        }
        any = CollectionsKt___CollectionsKt.any(arrayList);
        return any;
    }
}
