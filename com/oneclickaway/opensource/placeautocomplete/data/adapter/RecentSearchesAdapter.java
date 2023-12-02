package com.oneclickaway.opensource.placeautocomplete.data.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.action.activities.PopUpActionActivity;
import com.oneclickaway.opensource.placeautocomplete.R;
import com.oneclickaway.opensource.placeautocomplete.data.adapter.RecentSearchesAdapter;
import com.oneclickaway.opensource.placeautocomplete.interfaces.SearchPlaces;
import com.oneclickaway.opensource.placeautocomplete.utils.GroupStrategy;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: RecentSearchesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u001c\u0010\u001a\u001a\u00020\u00142\n\u0010\u001b\u001a\u00060\u001cR\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001c\u0010\u001f\u001a\u00020\u00142\n\u0010 \u001a\u00060!R\u00020\u00002\u0006\u0010\"\u001a\u00020#H\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006&"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/RecentSearchesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "listSearchSelectedItem", "", "Lcom/oneclickaway/opensource/placeautocomplete/utils/GroupStrategy$ListItem;", "recentOnItemItemSelectedListener", "Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$RecentItemSelectedListener;", "(Ljava/util/List;Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$RecentItemSelectedListener;)V", "getListSearchSelectedItem", "()Ljava/util/List;", "getRecentOnItemItemSelectedListener", "()Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$RecentItemSelectedListener;", "setRecentOnItemItemSelectedListener", "(Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$RecentItemSelectedListener;)V", "getItemCount", "", "getItemViewType", PopUpActionActivity.EXTRA_POSITION, "onBindViewHolder", "", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "itemViewType", "setDateView", "dateViewHolder", "Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/RecentSearchesAdapter$DateViewHolder;", "dateItem", "Lcom/oneclickaway/opensource/placeautocomplete/utils/GroupStrategy$DateItem;", "setSearchedItem", "generalItemViewHolder", "Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/RecentSearchesAdapter$GeneralItemViewHolder;", "generalItem", "Lcom/oneclickaway/opensource/placeautocomplete/utils/GroupStrategy$GeneralItem;", "DateViewHolder", "GeneralItemViewHolder", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class RecentSearchesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private final List<GroupStrategy.ListItem> listSearchSelectedItem;
    @NotNull
    private SearchPlaces.RecentItemSelectedListener recentOnItemItemSelectedListener;

    /* compiled from: RecentSearchesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/RecentSearchesAdapter$DateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/RecentSearchesAdapter;Landroid/view/View;)V", "groupTitleTV", "Landroid/widget/TextView;", "getGroupTitleTV", "()Landroid/widget/TextView;", "setGroupTitleTV", "(Landroid/widget/TextView;)V", "inflateView", "", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public final class DateViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public TextView groupTitleTV;
        final /* synthetic */ RecentSearchesAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DateViewHolder(@NotNull RecentSearchesAdapter recentSearchesAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkParameterIsNotNull(itemView, "itemView");
            this.this$0 = recentSearchesAdapter;
            inflateView();
        }

        private final void inflateView() {
            View findViewById = this.itemView.findViewById(R.id.groupTitleTV);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.groupTitleTV)");
            this.groupTitleTV = (TextView) findViewById;
        }

        @NotNull
        public final TextView getGroupTitleTV() {
            TextView textView = this.groupTitleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("groupTitleTV");
            }
            return textView;
        }

        public final void setGroupTitleTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.groupTitleTV = textView;
        }
    }

    /* compiled from: RecentSearchesAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/RecentSearchesAdapter$GeneralItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/RecentSearchesAdapter;Landroid/view/View;)V", "recentPlaceFormattedAddressTV", "Landroid/widget/TextView;", "getRecentPlaceFormattedAddressTV", "()Landroid/widget/TextView;", "setRecentPlaceFormattedAddressTV", "(Landroid/widget/TextView;)V", "recentPlaceTitleTV", "getRecentPlaceTitleTV", "setRecentPlaceTitleTV", "inflateView", "", "setOnClickLister", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public final class GeneralItemViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        public TextView recentPlaceFormattedAddressTV;
        @NotNull
        public TextView recentPlaceTitleTV;
        final /* synthetic */ RecentSearchesAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GeneralItemViewHolder(@NotNull RecentSearchesAdapter recentSearchesAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkParameterIsNotNull(itemView, "itemView");
            this.this$0 = recentSearchesAdapter;
            inflateView();
            setOnClickLister(itemView);
        }

        private final void inflateView() {
            View findViewById = this.itemView.findViewById(R.id.recentPlaceFormattedAddressTV);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.…tPlaceFormattedAddressTV)");
            this.recentPlaceFormattedAddressTV = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.recentPlaceTitleTV);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.id.recentPlaceTitleTV)");
            this.recentPlaceTitleTV = (TextView) findViewById2;
        }

        private final void setOnClickLister(View view) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.oneclickaway.opensource.placeautocomplete.data.adapter.RecentSearchesAdapter$GeneralItemViewHolder$setOnClickLister$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RecentSearchesAdapter.GeneralItemViewHolder.this.this$0.getRecentOnItemItemSelectedListener().onRecantsItemSelected(RecentSearchesAdapter.GeneralItemViewHolder.this.this$0.getListSearchSelectedItem().get(RecentSearchesAdapter.GeneralItemViewHolder.this.getAdapterPosition()));
                }
            });
        }

        @NotNull
        public final TextView getRecentPlaceFormattedAddressTV() {
            TextView textView = this.recentPlaceFormattedAddressTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentPlaceFormattedAddressTV");
            }
            return textView;
        }

        @NotNull
        public final TextView getRecentPlaceTitleTV() {
            TextView textView = this.recentPlaceTitleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentPlaceTitleTV");
            }
            return textView;
        }

        public final void setRecentPlaceFormattedAddressTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.recentPlaceFormattedAddressTV = textView;
        }

        public final void setRecentPlaceTitleTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.recentPlaceTitleTV = textView;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecentSearchesAdapter(@NotNull List<? extends GroupStrategy.ListItem> listSearchSelectedItem, @NotNull SearchPlaces.RecentItemSelectedListener recentOnItemItemSelectedListener) {
        Intrinsics.checkParameterIsNotNull(listSearchSelectedItem, "listSearchSelectedItem");
        Intrinsics.checkParameterIsNotNull(recentOnItemItemSelectedListener, "recentOnItemItemSelectedListener");
        this.listSearchSelectedItem = listSearchSelectedItem;
        this.recentOnItemItemSelectedListener = recentOnItemItemSelectedListener;
    }

    private final void setDateView(DateViewHolder dateViewHolder, GroupStrategy.DateItem dateItem) {
        TextView groupTitleTV = dateViewHolder.getGroupTitleTV();
        String date = dateItem.getDate();
        if (date != null) {
            String upperCase = date.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            groupTitleTV.setText(upperCase);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final void setSearchedItem(GeneralItemViewHolder generalItemViewHolder, GroupStrategy.GeneralItem generalItem) {
        generalItemViewHolder.getRecentPlaceTitleTV().setText(generalItem.getSearchSelectedItem().getMainText());
        generalItemViewHolder.getRecentPlaceFormattedAddressTV().setText(generalItem.getSearchSelectedItem().getSecondaryText());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listSearchSelectedItem.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        GroupStrategy.ListItem listItem = this.listSearchSelectedItem.get(i4);
        if (listItem instanceof GroupStrategy.DateItem) {
            return 101;
        }
        if (listItem instanceof GroupStrategy.GeneralItem) {
            return 102;
        }
        return -1;
    }

    @NotNull
    public final List<GroupStrategy.ListItem> getListSearchSelectedItem() {
        return this.listSearchSelectedItem;
    }

    @NotNull
    public final SearchPlaces.RecentItemSelectedListener getRecentOnItemItemSelectedListener() {
        return this.recentOnItemItemSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i4) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "viewHolder");
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType != 101) {
            if (itemViewType == 102) {
                GeneralItemViewHolder generalItemViewHolder = (GeneralItemViewHolder) viewHolder;
                GroupStrategy.ListItem listItem = this.listSearchSelectedItem.get(i4);
                if (listItem != null) {
                    setSearchedItem(generalItemViewHolder, (GroupStrategy.GeneralItem) listItem);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.oneclickaway.opensource.placeautocomplete.utils.GroupStrategy.GeneralItem");
            }
            return;
        }
        DateViewHolder dateViewHolder = (DateViewHolder) viewHolder;
        GroupStrategy.ListItem listItem2 = this.listSearchSelectedItem.get(i4);
        if (listItem2 != null) {
            setDateView(dateViewHolder, (GroupStrategy.DateItem) listItem2);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.oneclickaway.opensource.placeautocomplete.utils.GroupStrategy.DateItem");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i4) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "viewGroup");
        if (i4 == 102) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recent_search_result_row, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(view…  false\n                )");
            return new GeneralItemViewHolder(this, inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.date_item_row, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate2, "LayoutInflater.from(view…  false\n                )");
        return new DateViewHolder(this, inflate2);
    }

    public final void setRecentOnItemItemSelectedListener(@NotNull SearchPlaces.RecentItemSelectedListener recentItemSelectedListener) {
        Intrinsics.checkParameterIsNotNull(recentItemSelectedListener, "<set-?>");
        this.recentOnItemItemSelectedListener = recentItemSelectedListener;
    }
}
