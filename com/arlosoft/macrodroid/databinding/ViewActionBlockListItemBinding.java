package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import org.apmem.tools.layouts.FlowLayout;

/* loaded from: classes3.dex */
public final class ViewActionBlockListItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11409a;
    @NonNull
    public final LinearLayout actionBlockContainer;
    @NonNull
    public final TextView actionsList;
    @NonNull
    public final TextView actionsOneChar;
    @NonNull
    public final View bottomSpace;
    @NonNull
    public final TextView description;
    @NonNull
    public final View dividerLine;
    @NonNull
    public final LinearLayout macroActionsContainer;
    @NonNull
    public final TextView name;
    @NonNull
    public final FlowLayout usedInList;

    private ViewActionBlockListItemBinding(@NonNull CardView cardView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view, @NonNull TextView textView3, @NonNull View view2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView4, @NonNull FlowLayout flowLayout) {
        this.f11409a = cardView;
        this.actionBlockContainer = linearLayout;
        this.actionsList = textView;
        this.actionsOneChar = textView2;
        this.bottomSpace = view;
        this.description = textView3;
        this.dividerLine = view2;
        this.macroActionsContainer = linearLayout2;
        this.name = textView4;
        this.usedInList = flowLayout;
    }

    @NonNull
    public static ViewActionBlockListItemBinding bind(@NonNull View view) {
        int i4 = R.id.actionBlockContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.actionBlockContainer);
        if (linearLayout != null) {
            i4 = R.id.actionsList;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.actionsList);
            if (textView != null) {
                i4 = R.id.actions_one_char;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.actions_one_char);
                if (textView2 != null) {
                    i4 = R.id.bottomSpace;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.bottomSpace);
                    if (findChildViewById != null) {
                        i4 = R.id.description;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.description);
                        if (textView3 != null) {
                            i4 = R.id.divider_line;
                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.divider_line);
                            if (findChildViewById2 != null) {
                                i4 = R.id.macroActionsContainer;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macroActionsContainer);
                                if (linearLayout2 != null) {
                                    i4 = R.id.name;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.name);
                                    if (textView4 != null) {
                                        i4 = R.id.usedInList;
                                        FlowLayout flowLayout = (FlowLayout) ViewBindings.findChildViewById(view, R.id.usedInList);
                                        if (flowLayout != null) {
                                            return new ViewActionBlockListItemBinding((CardView) view, linearLayout, textView, textView2, findChildViewById, textView3, findChildViewById2, linearLayout2, textView4, flowLayout);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ViewActionBlockListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewActionBlockListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_action_block_list_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11409a;
    }
}
