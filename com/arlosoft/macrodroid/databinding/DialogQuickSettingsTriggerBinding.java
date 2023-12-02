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
public final class DialogQuickSettingsTriggerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11112a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final TextView configureTiles;
    @NonNull
    public final ListView list;
    @NonNull
    public final Button okButton;

    private DialogQuickSettingsTriggerBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull TextView textView, @NonNull ListView listView, @NonNull Button button2) {
        this.f11112a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.configureTiles = textView;
        this.list = listView;
        this.okButton = button2;
    }

    @NonNull
    public static DialogQuickSettingsTriggerBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.configure_tiles;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.configure_tiles);
                if (textView != null) {
                    i4 = R.id.list;
                    ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.list);
                    if (listView != null) {
                        i4 = R.id.okButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                        if (button2 != null) {
                            return new DialogQuickSettingsTriggerBinding((LinearLayout) view, linearLayout, button, textView, listView, button2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogQuickSettingsTriggerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogQuickSettingsTriggerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_quick_settings_trigger, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11112a;
    }
}
