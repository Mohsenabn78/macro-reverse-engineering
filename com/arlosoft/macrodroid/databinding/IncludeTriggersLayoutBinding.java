package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class IncludeTriggersLayoutBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11270a;
    @NonNull
    public final ImageButton addTriggerButton;
    @NonNull
    public final LinearLayout triggersLayout;

    private IncludeTriggersLayoutBinding(@NonNull CardView cardView, @NonNull ImageButton imageButton, @NonNull LinearLayout linearLayout) {
        this.f11270a = cardView;
        this.addTriggerButton = imageButton;
        this.triggersLayout = linearLayout;
    }

    @NonNull
    public static IncludeTriggersLayoutBinding bind(@NonNull View view) {
        int i4 = R.id.add_trigger_button;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.add_trigger_button);
        if (imageButton != null) {
            i4 = R.id.triggers_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.triggers_layout);
            if (linearLayout != null) {
                return new IncludeTriggersLayoutBinding((CardView) view, imageButton, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static IncludeTriggersLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeTriggersLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_triggers_layout, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11270a;
    }
}
