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
public final class MessageDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11331a;
    @NonNull
    public final View buttonDividerBar;
    @NonNull
    public final TextView messageDialogMessage;
    @NonNull
    public final ScrollView messageTopLevelContainer;
    @NonNull
    public final Button okButton;

    private MessageDialogBinding(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull TextView textView, @NonNull ScrollView scrollView, @NonNull Button button) {
        this.f11331a = linearLayout;
        this.buttonDividerBar = view;
        this.messageDialogMessage = textView;
        this.messageTopLevelContainer = scrollView;
        this.okButton = button;
    }

    @NonNull
    public static MessageDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_divider_bar;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.button_divider_bar);
        if (findChildViewById != null) {
            i4 = R.id.message_dialog_message;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.message_dialog_message);
            if (textView != null) {
                i4 = R.id.message_top_level_container;
                ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.message_top_level_container);
                if (scrollView != null) {
                    i4 = R.id.okButton;
                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                    if (button != null) {
                        return new MessageDialogBinding((LinearLayout) view, findChildViewById, textView, scrollView, button);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static MessageDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MessageDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.message_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11331a;
    }
}
