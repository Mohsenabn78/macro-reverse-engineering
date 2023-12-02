package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class AndroidExplorerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10982a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final ListView list;
    @NonNull
    public final Button okButton;
    @NonNull
    public final TextView path;
    @NonNull
    public final TextView topLabel;

    private AndroidExplorerBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull ListView listView, @NonNull Button button2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f10982a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.list = listView;
        this.okButton = button2;
        this.path = textView;
        this.topLabel = textView2;
    }

    @NonNull
    public static AndroidExplorerBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = 16908298;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, 16908298);
                if (listView != null) {
                    i4 = R.id.okButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                    if (button2 != null) {
                        i4 = R.id.path;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.path);
                        if (textView != null) {
                            i4 = R.id.top_label;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.top_label);
                            if (textView2 != null) {
                                return new AndroidExplorerBinding((LinearLayout) view, linearLayout, button, listView, button2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static AndroidExplorerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AndroidExplorerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.android_explorer, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10982a;
    }
}
