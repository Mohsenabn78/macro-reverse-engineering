package com.arlosoft.macrodroid.actionblock.common;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.arlosoft.macrodroid.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActionBlockMacroAdapter.kt */
/* loaded from: classes.dex */
public final class ActionBlockMacroAdapter extends ArrayAdapter<RunnableItem> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f5502a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<RunnableItem> f5503b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5504c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBlockMacroAdapter(@NotNull Activity activity, @NotNull List<RunnableItem> items) {
        super(activity, (int) R.layout.spinner_item_macro_action_block, items);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(items, "items");
        this.f5502a = activity;
        this.f5503b = items;
        this.f5504c = activity.getResources().getDimensionPixelOffset(R.dimen.runnable_item_selection_name_only_height);
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    @NotNull
    public View getDropDownView(int i4, @Nullable View view, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return getView(i4, view, parent);
    }

    public final int getMinHeight() {
        return this.f5504c;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int i4, @Nullable View view, @NotNull ViewGroup parent) {
        Activity activity;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(parent, "parent");
        int i7 = 0;
        if (view == null) {
            LayoutInflater layoutInflater = this.f5502a.getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "activity.layoutInflater");
            view = layoutInflater.inflate(R.layout.spinner_item_macro_action_block, parent, false);
        }
        Intrinsics.checkNotNull(view);
        TextView textView = (TextView) view.findViewById(R.id.nameText);
        TextView textView2 = (TextView) view.findViewById(R.id.typeText);
        RunnableItem item = getItem(i4);
        String component1 = item.component1();
        long component2 = item.component2();
        boolean component3 = item.component3();
        textView.setText(component1);
        if (component3) {
            activity = this.f5502a;
            i5 = R.string.action_block;
        } else {
            activity = this.f5502a;
            i5 = R.string.action_disable_macro_macro;
        }
        textView2.setText(activity.getString(i5));
        int i8 = (component2 > 0L ? 1 : (component2 == 0L ? 0 : -1));
        textView2.setVisibility((i8 == 0 || component2 == 1 || component2 == 2) ? 8 : 8);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (i8 != 0 && component2 != 1 && component2 != 2) {
            i6 = -2;
        } else {
            i6 = this.f5504c;
        }
        layoutParams.height = i6;
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public RunnableItem getItem(int i4) {
        return this.f5503b.get(i4);
    }
}
