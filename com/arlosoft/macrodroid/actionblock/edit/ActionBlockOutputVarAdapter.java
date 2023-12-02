package com.arlosoft.macrodroid.actionblock.edit;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.databinding.ListItemActionBlockTestOutputBinding;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActionBlockOutputVarAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class ActionBlockOutputVarAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<MacroDroidVariable> f5560a;

    /* compiled from: ActionBlockOutputVarAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemActionBlockTestOutputBinding f5561a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ListItemActionBlockTestOutputBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f5561a = binding;
        }

        public final void bind(@NotNull MacroDroidVariable variable) {
            boolean z3;
            Intrinsics.checkNotNullParameter(variable, "variable");
            this.f5561a.key.setText(variable.getName());
            if (variable.toString().length() == 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                TextView textView = this.f5561a.value;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.value");
                Sdk27PropertiesKt.setTextColor(textView, ContextCompat.getColor(this.f5561a.getRoot().getContext(), R.color.white_transparent));
                ListItemActionBlockTestOutputBinding listItemActionBlockTestOutputBinding = this.f5561a;
                listItemActionBlockTestOutputBinding.value.setText(listItemActionBlockTestOutputBinding.getRoot().getContext().getString(R.string.empty));
                return;
            }
            TextView textView2 = this.f5561a.value;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.value");
            Sdk27PropertiesKt.setTextColor(textView2, ContextCompat.getColor(this.f5561a.getRoot().getContext(), R.color.white));
            this.f5561a.value.setText(variable.toString());
        }
    }

    public ActionBlockOutputVarAdapter(@NotNull List<MacroDroidVariable> varsList) {
        Intrinsics.checkNotNullParameter(varsList, "varsList");
        this.f5560a = varsList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f5560a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f5560a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemActionBlockTestOutputBinding inflate = ListItemActionBlockTestOutputBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate);
    }
}
