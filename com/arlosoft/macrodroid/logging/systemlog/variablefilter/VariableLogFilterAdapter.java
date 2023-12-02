package com.arlosoft.macrodroid.logging.systemlog.variablefilter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.ViewVariableFilterEntryBinding;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: VariableLogFilterAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VariableLogFilterAdapter extends RecyclerView.Adapter<VariableLogFilterViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private List<VariableWithFilteredState> f12792a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final OnFilterChangeListener f12793b;

    /* compiled from: VariableLogFilterAdapter.kt */
    /* loaded from: classes3.dex */
    public interface OnFilterChangeListener {
        void filterStateChanged(@NotNull String str, boolean z3);
    }

    public VariableLogFilterAdapter(@NotNull List<VariableWithFilteredState> variables, @NotNull OnFilterChangeListener filterChangeListener) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(filterChangeListener, "filterChangeListener");
        this.f12792a = variables;
        this.f12793b = filterChangeListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12792a.size();
    }

    public final void setVariables(@NotNull List<VariableWithFilteredState> variables) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        this.f12792a = variables;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull VariableLogFilterViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f12792a.get(i4), this.f12793b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public VariableLogFilterViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewVariableFilterEntryBinding inflate = ViewVariableFilterEntryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new VariableLogFilterViewHolder(inflate);
    }
}
