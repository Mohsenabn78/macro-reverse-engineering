package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityKeepAccessibilityServicesRunningBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NestedScrollView f10948a;
    @NonNull
    public final RecyclerView accessibilityServiceList;
    @NonNull
    public final CardView adbHackCard;
    @NonNull
    public final Button adbHackOkButton;
    @NonNull
    public final InfoCardBinding infoCard;
    @NonNull
    public final TextView infoCardTitle;

    private ActivityKeepAccessibilityServicesRunningBinding(@NonNull NestedScrollView nestedScrollView, @NonNull RecyclerView recyclerView, @NonNull CardView cardView, @NonNull Button button, @NonNull InfoCardBinding infoCardBinding, @NonNull TextView textView) {
        this.f10948a = nestedScrollView;
        this.accessibilityServiceList = recyclerView;
        this.adbHackCard = cardView;
        this.adbHackOkButton = button;
        this.infoCard = infoCardBinding;
        this.infoCardTitle = textView;
    }

    @NonNull
    public static ActivityKeepAccessibilityServicesRunningBinding bind(@NonNull View view) {
        int i4 = R.id.accessibilityServiceList;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.accessibilityServiceList);
        if (recyclerView != null) {
            i4 = R.id.adbHackCard;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.adbHackCard);
            if (cardView != null) {
                i4 = R.id.adbHackOkButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.adbHackOkButton);
                if (button != null) {
                    i4 = R.id.infoCard;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.infoCard);
                    if (findChildViewById != null) {
                        InfoCardBinding bind = InfoCardBinding.bind(findChildViewById);
                        i4 = R.id.infoCardTitle;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.infoCardTitle);
                        if (textView != null) {
                            return new ActivityKeepAccessibilityServicesRunningBinding((NestedScrollView) view, recyclerView, cardView, button, bind, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityKeepAccessibilityServicesRunningBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityKeepAccessibilityServicesRunningBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_keep_accessibility_services_running, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public NestedScrollView getRoot() {
        return this.f10948a;
    }
}
