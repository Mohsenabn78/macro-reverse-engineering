package com.arlosoft.macrodroid.editscreen;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.actionblock.edit.VariableType;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalVarsAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LocalVarsAdapter extends RecyclerView.Adapter<LocalVarsViewHolder> {
    public static final int $stable = 8;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11813a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Resources f11814b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11815c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Function1<MacroDroidVariable, Unit> f11816d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final VariableType f11817e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private List<MacroDroidVariable> f11818f;

    /* compiled from: LocalVarsAdapter.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VariableType.values().length];
            try {
                iArr[VariableType.INPUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VariableType.OUTPUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VariableType.LOCAL_WORKING_VAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LocalVarsAdapter(@NotNull Macro macro, boolean z3, @NotNull Resources resources, boolean z4, @NotNull Function1<? super MacroDroidVariable, Unit> clickListener, @Nullable VariableType variableType) {
        int i4;
        List<MacroDroidVariable> localVariablesSorted;
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.f11813a = z3;
        this.f11814b = resources;
        this.f11815c = z4;
        this.f11816d = clickListener;
        this.f11817e = variableType;
        if (variableType == null) {
            i4 = -1;
        } else {
            i4 = WhenMappings.$EnumSwitchMapping$0[variableType.ordinal()];
        }
        if (i4 != -1) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        localVariablesSorted = macro.getActionBlockWorkingVariables(true);
                        Intrinsics.checkNotNullExpressionValue(localVariablesSorted, "macro.getActionBlockWorkingVariables(true)");
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    localVariablesSorted = macro.getOutputOnlyActionBlockVariables(true);
                    Intrinsics.checkNotNullExpressionValue(localVariablesSorted, "macro.getOutputOnlyActionBlockVariables(true)");
                }
            } else {
                localVariablesSorted = macro.getInputOnlyActionBlockVariables(true);
                Intrinsics.checkNotNullExpressionValue(localVariablesSorted, "macro.getInputOnlyActionBlockVariables(true)");
            }
        } else {
            localVariablesSorted = macro.getLocalVariablesSorted();
            Intrinsics.checkNotNullExpressionValue(localVariablesSorted, "macro.localVariablesSorted");
        }
        this.f11818f = localVariablesSorted;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f11818f.size();
    }

    @Nullable
    public final VariableType getVariableType() {
        return this.f11817e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull LocalVarsViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f11818f.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public LocalVarsViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(this.f11813a ? R.layout.macro_edit_entry_small : R.layout.macro_edit_entry, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…te(layout, parent, false)");
        return new LocalVarsViewHolder(inflate, this.f11814b, this.f11815c, this.f11816d);
    }
}
