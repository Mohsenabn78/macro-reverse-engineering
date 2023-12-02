package com.oneclickaway.opensource.placeautocomplete.data.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.action.activities.PopUpActionActivity;
import com.jakewharton.rxbinding2.view.RxView;
import com.oneclickaway.opensource.placeautocomplete.R;
import com.oneclickaway.opensource.placeautocomplete.data.adapter.SearchResultAdapter;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response.PredictionsItem;
import com.oneclickaway.opensource.placeautocomplete.data.api.bean.places_response.StructuredFormatting;
import com.oneclickaway.opensource.placeautocomplete.interfaces.SearchPlaces;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SearchResultAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB!\u0012\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0010\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004R$\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/SearchResultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/SearchResultAdapter$ViewHolder;", "listOfCandidatesItem", "", "Lcom/oneclickaway/opensource/placeautocomplete/data/api/bean/places_response/PredictionsItem;", "placeItemSelectedListener", "Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$PlaceItemSelectedListener;", "(Ljava/util/List;Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$PlaceItemSelectedListener;)V", "getListOfCandidatesItem", "()Ljava/util/List;", "setListOfCandidatesItem", "(Ljava/util/List;)V", "getPlaceItemSelectedListener", "()Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$PlaceItemSelectedListener;", "setPlaceItemSelectedListener", "(Lcom/oneclickaway/opensource/placeautocomplete/interfaces/SearchPlaces$PlaceItemSelectedListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", PopUpActionActivity.EXTRA_POSITION, "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "setSearchCandidates", "ViewHolder", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class SearchResultAdapter extends RecyclerView.Adapter<ViewHolder> {
    @Nullable
    private List<PredictionsItem> listOfCandidatesItem;
    @NotNull
    private SearchPlaces.PlaceItemSelectedListener placeItemSelectedListener;

    /* compiled from: SearchResultAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/SearchResultAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroid/view/View;", "(Lcom/oneclickaway/opensource/placeautocomplete/data/adapter/SearchResultAdapter;Landroid/view/View;)V", "getBinding", "()Landroid/view/View;", "setBinding", "(Landroid/view/View;)V", "placeFormattedAddressTV", "Landroid/widget/TextView;", "getPlaceFormattedAddressTV", "()Landroid/widget/TextView;", "setPlaceFormattedAddressTV", "(Landroid/widget/TextView;)V", "placeTitleTV", "getPlaceTitleTV", "setPlaceTitleTV", "inflateViews", "", "setItemClickListener", "place_autocomplete_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private View binding;
        @NotNull
        public TextView placeFormattedAddressTV;
        @NotNull
        public TextView placeTitleTV;
        final /* synthetic */ SearchResultAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull SearchResultAdapter searchResultAdapter, View binding) {
            super(binding);
            Intrinsics.checkParameterIsNotNull(binding, "binding");
            this.this$0 = searchResultAdapter;
            this.binding = binding;
            inflateViews();
            setItemClickListener();
        }

        private final void inflateViews() {
            View findViewById = this.itemView.findViewById(R.id.placeTitleTV);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.placeTitleTV)");
            this.placeTitleTV = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.placeFormattedAddressTV);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById(R.….placeFormattedAddressTV)");
            this.placeFormattedAddressTV = (TextView) findViewById2;
        }

        @SuppressLint({"CheckResult"})
        private final void setItemClickListener() {
            RxView.clicks(this.binding).throttleFirst(700L, TimeUnit.MILLISECONDS).subscribe(new Consumer<Object>() { // from class: com.oneclickaway.opensource.placeautocomplete.data.adapter.SearchResultAdapter$ViewHolder$setItemClickListener$1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PredictionsItem predictionsItem;
                    SearchPlaces.PlaceItemSelectedListener placeItemSelectedListener = SearchResultAdapter.ViewHolder.this.this$0.getPlaceItemSelectedListener();
                    List<PredictionsItem> listOfCandidatesItem = SearchResultAdapter.ViewHolder.this.this$0.getListOfCandidatesItem();
                    if (listOfCandidatesItem != null) {
                        predictionsItem = listOfCandidatesItem.get(SearchResultAdapter.ViewHolder.this.getAdapterPosition());
                    } else {
                        predictionsItem = null;
                    }
                    placeItemSelectedListener.onPlaceItemSelected(predictionsItem);
                }
            });
        }

        @NotNull
        public final View getBinding() {
            return this.binding;
        }

        @NotNull
        public final TextView getPlaceFormattedAddressTV() {
            TextView textView = this.placeFormattedAddressTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeFormattedAddressTV");
            }
            return textView;
        }

        @NotNull
        public final TextView getPlaceTitleTV() {
            TextView textView = this.placeTitleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("placeTitleTV");
            }
            return textView;
        }

        public final void setBinding(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "<set-?>");
            this.binding = view;
        }

        public final void setPlaceFormattedAddressTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.placeFormattedAddressTV = textView;
        }

        public final void setPlaceTitleTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.placeTitleTV = textView;
        }
    }

    public /* synthetic */ SearchResultAdapter(List list, SearchPlaces.PlaceItemSelectedListener placeItemSelectedListener, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? new ArrayList() : list, placeItemSelectedListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Integer num;
        List<PredictionsItem> list = this.listOfCandidatesItem;
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        if (num == null) {
            Intrinsics.throwNpe();
        }
        return num.intValue();
    }

    @Nullable
    public final List<PredictionsItem> getListOfCandidatesItem() {
        return this.listOfCandidatesItem;
    }

    @NotNull
    public final SearchPlaces.PlaceItemSelectedListener getPlaceItemSelectedListener() {
        return this.placeItemSelectedListener;
    }

    public final void setListOfCandidatesItem(@Nullable List<PredictionsItem> list) {
        this.listOfCandidatesItem = list;
    }

    public final void setPlaceItemSelectedListener(@NotNull SearchPlaces.PlaceItemSelectedListener placeItemSelectedListener) {
        Intrinsics.checkParameterIsNotNull(placeItemSelectedListener, "<set-?>");
        this.placeItemSelectedListener = placeItemSelectedListener;
    }

    public final void setSearchCandidates(@Nullable List<PredictionsItem> list) {
        this.listOfCandidatesItem = list;
        notifyDataSetChanged();
    }

    public SearchResultAdapter(@Nullable List<PredictionsItem> list, @NotNull SearchPlaces.PlaceItemSelectedListener placeItemSelectedListener) {
        Intrinsics.checkParameterIsNotNull(placeItemSelectedListener, "placeItemSelectedListener");
        this.listOfCandidatesItem = list;
        this.placeItemSelectedListener = placeItemSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        PredictionsItem predictionsItem;
        StructuredFormatting structuredFormatting;
        PredictionsItem predictionsItem2;
        StructuredFormatting structuredFormatting2;
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        TextView placeTitleTV = holder.getPlaceTitleTV();
        List<PredictionsItem> list = this.listOfCandidatesItem;
        String str = null;
        placeTitleTV.setText((list == null || (predictionsItem2 = list.get(i4)) == null || (structuredFormatting2 = predictionsItem2.getStructuredFormatting()) == null) ? null : structuredFormatting2.getMainText());
        TextView placeFormattedAddressTV = holder.getPlaceFormattedAddressTV();
        List<PredictionsItem> list2 = this.listOfCandidatesItem;
        if (list2 != null && (predictionsItem = list2.get(i4)) != null && (structuredFormatting = predictionsItem.getStructuredFormatting()) != null) {
            str = structuredFormatting.getSecondaryText();
        }
        placeFormattedAddressTV.setText(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup p02, int i4) {
        Intrinsics.checkParameterIsNotNull(p02, "p0");
        View inflate = LayoutInflater.from(p02.getContext()).inflate(R.layout.search_result_row, p02, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(p0.c…ch_result_row, p0, false)");
        return new ViewHolder(this, inflate);
    }
}
