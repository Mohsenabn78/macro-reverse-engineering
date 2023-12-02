package com.arlosoft.macrodroid.homescreen.quickrun;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.ListItemQuickRunMacroBinding;
import com.arlosoft.macrodroid.macro.Macro;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: QuickRunMacroAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class QuickRunMacroAdapter extends RecyclerView.Adapter<QuickRunMacroViewHolder> implements DraggableItemAdapter<QuickRunMacroViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private List<Macro> f12385a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f12386b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private MacroSelectionListener f12387c;

    public QuickRunMacroAdapter(@NotNull List<Macro> macros) {
        Intrinsics.checkNotNullParameter(macros, "macros");
        this.f12385a = macros;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12385a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f12385a.get(i4).getGUID();
    }

    @NotNull
    public final List<Macro> getMacros() {
        return this.f12385a;
    }

    public final boolean isInEditMode() {
        return this.f12386b;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanDrop(int i4, int i5) {
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanStartDrag(@NotNull QuickRunMacroViewHolder holder, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    @Nullable
    public ItemDraggableRange onGetItemDraggableRange(@NotNull QuickRunMacroViewHolder holder, int i4) {
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
        this.f12385a.add(i5, this.f12385a.remove(i4));
    }

    public final void removeMacro(@NotNull Macro macro) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        int indexOf = this.f12385a.indexOf(macro);
        this.f12385a.remove(macro);
        notifyItemRemoved(indexOf);
    }

    public final void setMacroSelectedListener(@NotNull MacroSelectionListener macroSelectedListener) {
        Intrinsics.checkNotNullParameter(macroSelectedListener, "macroSelectedListener");
        this.f12387c = macroSelectedListener;
    }

    public final void setMacros(@NotNull List<Macro> macros) {
        Intrinsics.checkNotNullParameter(macros, "macros");
        this.f12385a = macros;
    }

    public final void showEditMode(boolean z3) {
        this.f12386b = z3;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull QuickRunMacroViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f12385a.get(i4), this.f12386b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public QuickRunMacroViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemQuickRunMacroBinding inflate = ListItemQuickRunMacroBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new QuickRunMacroViewHolder(inflate, this.f12387c);
    }
}
