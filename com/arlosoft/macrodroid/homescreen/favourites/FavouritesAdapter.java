package com.arlosoft.macrodroid.homescreen.favourites;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.ListItemFavouritesBinding;
import com.arlosoft.macrodroid.macro.Macro;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FavouritesAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FavouritesAdapter extends RecyclerView.Adapter<FavouritesViewHolder> implements DraggableItemAdapter<FavouritesViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private List<Macro> f12337a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12338b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private MacroSelectionListener f12339c;

    public FavouritesAdapter(@NotNull List<Macro> macros) {
        Intrinsics.checkNotNullParameter(macros, "macros");
        this.f12337a = macros;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12337a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f12337a.get(i4).getGUID();
    }

    @NotNull
    public final List<Macro> getMacros() {
        return this.f12337a;
    }

    public final boolean isInEditMode() {
        return this.f12338b;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanDrop(int i4, int i5) {
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanStartDrag(@NotNull FavouritesViewHolder holder, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    @Nullable
    public ItemDraggableRange onGetItemDraggableRange(@NotNull FavouritesViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return null;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragFinished(int i4, int i5, boolean z3) {
        notifyDataSetChanged();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragStarted(int i4) {
        notifyDataSetChanged();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onMoveItem(int i4, int i5) {
        this.f12337a.add(i5, this.f12337a.remove(i4));
    }

    public final void removeMacro(@NotNull Macro macro) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        int indexOf = this.f12337a.indexOf(macro);
        this.f12337a.remove(macro);
        notifyItemRemoved(indexOf);
    }

    public final void setMacroSelectedListener(@NotNull MacroSelectionListener macroSelectedListener) {
        Intrinsics.checkNotNullParameter(macroSelectedListener, "macroSelectedListener");
        this.f12339c = macroSelectedListener;
    }

    public final void setMacros(@NotNull List<Macro> macros) {
        Intrinsics.checkNotNullParameter(macros, "macros");
        this.f12337a = macros;
    }

    public final void showEditMode(boolean z3) {
        this.f12338b = z3;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull FavouritesViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f12337a.get(i4), this.f12338b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public FavouritesViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemFavouritesBinding inflate = ListItemFavouritesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new FavouritesViewHolder(inflate, this.f12339c);
    }
}
