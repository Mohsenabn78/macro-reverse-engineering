package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import io.github.rosemoe.sora.widget.CodeEditor;

/* loaded from: classes3.dex */
public final class DialogJavascriptActionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11082a;
    @NonNull
    public final CodeEditor codeEditor;

    private DialogJavascriptActionBinding(@NonNull LinearLayout linearLayout, @NonNull CodeEditor codeEditor) {
        this.f11082a = linearLayout;
        this.codeEditor = codeEditor;
    }

    @NonNull
    public static DialogJavascriptActionBinding bind(@NonNull View view) {
        CodeEditor codeEditor = (CodeEditor) ViewBindings.findChildViewById(view, R.id.codeEditor);
        if (codeEditor != null) {
            return new DialogJavascriptActionBinding((LinearLayout) view, codeEditor);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.codeEditor)));
    }

    @NonNull
    public static DialogJavascriptActionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogJavascriptActionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_javascript_action, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11082a;
    }
}
