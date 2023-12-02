package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogExtractToActionBlockBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11063a;
    @NonNull
    public final EditText actionBlockNameText;
    @NonNull
    public final CardView actionsContainer;
    @NonNull
    public final ImageButton bottomDownButton;
    @NonNull
    public final ImageButton bottomUpButton;
    @NonNull
    public final RecyclerView extractActionsList;
    @NonNull
    public final ImageButton topDownButton;
    @NonNull
    public final ImageButton topUpButton;

    private DialogExtractToActionBlockBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull CardView cardView, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull RecyclerView recyclerView, @NonNull ImageButton imageButton3, @NonNull ImageButton imageButton4) {
        this.f11063a = linearLayout;
        this.actionBlockNameText = editText;
        this.actionsContainer = cardView;
        this.bottomDownButton = imageButton;
        this.bottomUpButton = imageButton2;
        this.extractActionsList = recyclerView;
        this.topDownButton = imageButton3;
        this.topUpButton = imageButton4;
    }

    @NonNull
    public static DialogExtractToActionBlockBinding bind(@NonNull View view) {
        int i4 = R.id.actionBlockNameText;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.actionBlockNameText);
        if (editText != null) {
            i4 = R.id.actionsContainer;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.actionsContainer);
            if (cardView != null) {
                i4 = R.id.bottomDownButton;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.bottomDownButton);
                if (imageButton != null) {
                    i4 = R.id.bottomUpButton;
                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.bottomUpButton);
                    if (imageButton2 != null) {
                        i4 = R.id.extractActionsList;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.extractActionsList);
                        if (recyclerView != null) {
                            i4 = R.id.topDownButton;
                            ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.topDownButton);
                            if (imageButton3 != null) {
                                i4 = R.id.topUpButton;
                                ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, R.id.topUpButton);
                                if (imageButton4 != null) {
                                    return new DialogExtractToActionBlockBinding((LinearLayout) view, editText, cardView, imageButton, imageButton2, recyclerView, imageButton3, imageButton4);
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
    public static DialogExtractToActionBlockBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogExtractToActionBlockBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_extract_to_action_block, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11063a;
    }
}
