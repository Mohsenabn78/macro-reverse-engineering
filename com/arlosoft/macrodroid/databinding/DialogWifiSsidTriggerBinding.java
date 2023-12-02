package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogWifiSsidTriggerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11168a;
    @NonNull
    public final Button buttonAdd;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final ListView list;
    @NonNull
    public final Button okButton;

    private DialogWifiSsidTriggerBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull LinearLayout linearLayout2, @NonNull Button button2, @NonNull ListView listView, @NonNull Button button3) {
        this.f11168a = linearLayout;
        this.buttonAdd = button;
        this.buttonBar = linearLayout2;
        this.cancelButton = button2;
        this.list = listView;
        this.okButton = button3;
    }

    @NonNull
    public static DialogWifiSsidTriggerBinding bind(@NonNull View view) {
        int i4 = R.id.button_add;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.button_add);
        if (button != null) {
            i4 = R.id.button_bar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
            if (linearLayout != null) {
                i4 = R.id.cancelButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button2 != null) {
                    i4 = R.id.list;
                    ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.list);
                    if (listView != null) {
                        i4 = R.id.okButton;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                        if (button3 != null) {
                            return new DialogWifiSsidTriggerBinding((LinearLayout) view, button, linearLayout, button2, listView, button3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogWifiSsidTriggerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogWifiSsidTriggerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_wifi_ssid_trigger, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11168a;
    }
}
