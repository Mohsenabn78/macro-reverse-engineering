package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;
import org.apmem.tools.layouts.FlowLayout;

/* loaded from: classes3.dex */
public final class TroubleshootingProblemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11395a;
    @NonNull
    public final Button configureButton;
    @NonNull
    public final Button configureButton2;
    @NonNull
    public final MaterialCardView dontKeepAcitvitesWarning;
    @NonNull
    public final FlowLayout macroList;
    @NonNull
    public final TextView problemDescription;
    @NonNull
    public final TextView problemTitle;

    private TroubleshootingProblemBinding(@NonNull MaterialCardView materialCardView, @NonNull Button button, @NonNull Button button2, @NonNull MaterialCardView materialCardView2, @NonNull FlowLayout flowLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11395a = materialCardView;
        this.configureButton = button;
        this.configureButton2 = button2;
        this.dontKeepAcitvitesWarning = materialCardView2;
        this.macroList = flowLayout;
        this.problemDescription = textView;
        this.problemTitle = textView2;
    }

    @NonNull
    public static TroubleshootingProblemBinding bind(@NonNull View view) {
        int i4 = R.id.configureButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.configureButton);
        if (button != null) {
            i4 = R.id.configureButton2;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configureButton2);
            if (button2 != null) {
                MaterialCardView materialCardView = (MaterialCardView) view;
                i4 = R.id.macroList;
                FlowLayout flowLayout = (FlowLayout) ViewBindings.findChildViewById(view, R.id.macroList);
                if (flowLayout != null) {
                    i4 = R.id.problemDescription;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.problemDescription);
                    if (textView != null) {
                        i4 = R.id.problemTitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.problemTitle);
                        if (textView2 != null) {
                            return new TroubleshootingProblemBinding(materialCardView, button, button2, materialCardView, flowLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static TroubleshootingProblemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TroubleshootingProblemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.troubleshooting_problem, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11395a;
    }
}
