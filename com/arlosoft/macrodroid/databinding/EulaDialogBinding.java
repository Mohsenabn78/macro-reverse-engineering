package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class EulaDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11207a;
    @NonNull
    public final Button eulaDialogEulaAccept;
    @NonNull
    public final Button eulaDialogEulaDecline;
    @NonNull
    public final ScrollView eulaDialogEulaScrollView;
    @NonNull
    public final TextView eulaDialogEulaText;

    private EulaDialogBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull ScrollView scrollView, @NonNull TextView textView) {
        this.f11207a = linearLayout;
        this.eulaDialogEulaAccept = button;
        this.eulaDialogEulaDecline = button2;
        this.eulaDialogEulaScrollView = scrollView;
        this.eulaDialogEulaText = textView;
    }

    @NonNull
    public static EulaDialogBinding bind(@NonNull View view) {
        int i4 = R.id.eula_dialog_eula_accept;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.eula_dialog_eula_accept);
        if (button != null) {
            i4 = R.id.eula_dialog_eula_decline;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.eula_dialog_eula_decline);
            if (button2 != null) {
                i4 = R.id.eula_dialog_eula_scroll_view;
                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.eula_dialog_eula_scroll_view);
                if (scrollView != null) {
                    i4 = R.id.eula_dialog_eula_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.eula_dialog_eula_text);
                    if (textView != null) {
                        return new EulaDialogBinding((LinearLayout) view, button, button2, scrollView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EulaDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EulaDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.eula_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11207a;
    }
}
