package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FilePatternDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11215a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final AppCompatEditText filePatternDialogFilePattern;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TextView textView1;

    private FilePatternDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button2, @NonNull Button button3, @NonNull TextView textView) {
        this.f11215a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.filePatternDialogFilePattern = appCompatEditText;
        this.magicTextButton = button2;
        this.okButton = button3;
        this.textView1 = textView;
    }

    @NonNull
    public static FilePatternDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.file_pattern_dialog_file_pattern;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.file_pattern_dialog_file_pattern);
                if (appCompatEditText != null) {
                    i4 = R.id.magic_text_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_button);
                    if (button2 != null) {
                        i4 = R.id.okButton;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                        if (button3 != null) {
                            i4 = R.id.textView1;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView1);
                            if (textView != null) {
                                return new FilePatternDialogBinding((LinearLayout) view, linearLayout, button, appCompatEditText, button2, button3, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FilePatternDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FilePatternDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.file_pattern_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11215a;
    }
}
