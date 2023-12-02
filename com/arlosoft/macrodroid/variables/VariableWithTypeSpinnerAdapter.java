package com.arlosoft.macrodroid.variables;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.variables.VariableOrOption;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VariableWithTypeSpinnerAdapter.kt */
@SourceDebugExtension({"SMAP\nVariableWithTypeSpinnerAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VariableWithTypeSpinnerAdapter.kt\ncom/arlosoft/macrodroid/variables/VariableWithTypeSpinnerAdapter\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,85:1\n262#2,2:86\n262#2,2:88\n262#2,2:90\n262#2,2:93\n1#3:92\n*S KotlinDebug\n*F\n+ 1 VariableWithTypeSpinnerAdapter.kt\ncom/arlosoft/macrodroid/variables/VariableWithTypeSpinnerAdapter\n*L\n44#1:86,2\n49#1:88,2\n51#1:90,2\n73#1:93,2\n*E\n"})
/* loaded from: classes3.dex */
public final class VariableWithTypeSpinnerAdapter extends ArrayAdapter<VariableOrOption> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f16299a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<VariableOrOption> f16300b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Integer f16301c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f16302d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16303e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VariableWithTypeSpinnerAdapter(@NotNull Activity activity, @NotNull List<? extends VariableOrOption> items, @Nullable Integer num) {
        super(activity, (int) R.layout.spinner_item_macro_action_block, items);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(items, "items");
        this.f16299a = activity;
        this.f16300b = items;
        this.f16301c = num;
        this.f16303e = activity.getResources().getDimensionPixelOffset(R.dimen.runnable_item_selection_name_only_height);
    }

    public final void forceSelectedValueName(@Nullable String str) {
        this.f16302d = str;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    @NotNull
    public View getDropDownView(int i4, @Nullable View view, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (view == null) {
            LayoutInflater layoutInflater = this.f16299a.getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "activity.layoutInflater");
            view = layoutInflater.inflate(R.layout.spinner_item_macro_action_block, parent, false);
        }
        Intrinsics.checkNotNull(view);
        TextView textView = (TextView) view.findViewById(R.id.nameText);
        TextView typeText = (TextView) view.findViewById(R.id.typeText);
        VariableOrOption item = getItem(i4);
        if (item == null) {
            textView.setText(this.f16299a.getString(R.string.none));
            Intrinsics.checkNotNullExpressionValue(typeText, "typeText");
            typeText.setVisibility(8);
        } else {
            textView.setText(item.getLabel());
            if (item instanceof VariableOrOption.Variable) {
                typeText.setText(((VariableOrOption.Variable) item).getVariable().getTypeAsString(this.f16299a));
                Intrinsics.checkNotNullExpressionValue(typeText, "typeText");
                typeText.setVisibility(0);
            } else {
                Intrinsics.checkNotNullExpressionValue(typeText, "typeText");
                typeText.setVisibility(8);
            }
        }
        return view;
    }

    public final int getMinHeight() {
        return this.f16303e;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int i4, @Nullable View view, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        boolean z3 = false;
        if (view == null) {
            LayoutInflater layoutInflater = this.f16299a.getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "activity.layoutInflater");
            view = layoutInflater.inflate(R.layout.spinner_item_macro_action_block, parent, false);
        }
        Intrinsics.checkNotNull(view);
        TextView textView = (TextView) view.findViewById(R.id.nameText);
        TextView typeText = (TextView) view.findViewById(R.id.typeText);
        Integer num = this.f16301c;
        if (num != null) {
            textView.setTextColor(num.intValue());
        }
        VariableOrOption item = getItem(i4);
        Intrinsics.checkNotNullExpressionValue(typeText, "typeText");
        typeText.setVisibility(8);
        if (item == null) {
            textView.setText(this.f16299a.getString(R.string.none));
        } else {
            String str = this.f16302d;
            if (!((str == null || str.length() == 0) ? true : true)) {
                textView.setText(this.f16302d);
            } else {
                textView.setText(item.getLabel());
            }
        }
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public VariableOrOption getItem(int i4) {
        return this.f16300b.get(i4);
    }
}
