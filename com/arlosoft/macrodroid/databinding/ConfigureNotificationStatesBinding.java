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
public final class ConfigureNotificationStatesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11003a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final ListView configureNotificationStates;
    @NonNull
    public final Button configureNotificationStatesButtonToggle;
    @NonNull
    public final Button okButton;

    private ConfigureNotificationStatesBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull ListView listView, @NonNull Button button2, @NonNull Button button3) {
        this.f11003a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.configureNotificationStates = listView;
        this.configureNotificationStatesButtonToggle = button2;
        this.okButton = button3;
    }

    @NonNull
    public static ConfigureNotificationStatesBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.configure_notification_states;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.configure_notification_states);
                if (listView != null) {
                    i4 = R.id.configure_notification_states_button_toggle;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configure_notification_states_button_toggle);
                    if (button2 != null) {
                        i4 = R.id.okButton;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                        if (button3 != null) {
                            return new ConfigureNotificationStatesBinding((LinearLayout) view, linearLayout, button, listView, button2, button3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ConfigureNotificationStatesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigureNotificationStatesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_notification_states, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11003a;
    }
}
