package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogCommentBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11035a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final ImageButton clearButton;
    @NonNull
    public final AppCompatEditText enterCommentText;
    @NonNull
    public final Button okButton;

    private DialogCommentBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull ImageButton imageButton, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button2) {
        this.f11035a = scrollView;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.clearButton = imageButton;
        this.enterCommentText = appCompatEditText;
        this.okButton = button2;
    }

    @NonNull
    public static DialogCommentBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.clear_button;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.clear_button);
                if (imageButton != null) {
                    i4 = R.id.enter_comment_text;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.enter_comment_text);
                    if (appCompatEditText != null) {
                        i4 = R.id.okButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                        if (button2 != null) {
                            return new DialogCommentBinding((ScrollView) view, linearLayout, button, imageButton, appCompatEditText, button2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogCommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogCommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_comment, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11035a;
    }
}
