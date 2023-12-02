package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SystemVolumeDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11382a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final CheckBox setVolumeSetInForground;
    @NonNull
    public final ListView setVolumeStreamList;

    private SystemVolumeDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull CheckBox checkBox, @NonNull ListView listView) {
        this.f11382a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.okButton = button2;
        this.setVolumeSetInForground = checkBox;
        this.setVolumeStreamList = listView;
    }

    @NonNull
    public static SystemVolumeDialogBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.okButton;
                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                if (button2 != null) {
                    i4 = R.id.set_volume_set_in_forground;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.set_volume_set_in_forground);
                    if (checkBox != null) {
                        i4 = R.id.set_volume_streamList;
                        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.set_volume_streamList);
                        if (listView != null) {
                            return new SystemVolumeDialogBinding((LinearLayout) view, linearLayout, button, button2, checkBox, listView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SystemVolumeDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SystemVolumeDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.system_volume_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11382a;
    }
}
