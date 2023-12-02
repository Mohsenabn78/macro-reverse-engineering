package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogConfirmDataSharingBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11039a;
    @NonNull
    public final CheckBox confirmCheckbox;
    @NonNull
    public final TextView permissionsText;
    @NonNull
    public final TextView whatDataIsShared;

    private DialogConfirmDataSharingBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11039a = linearLayout;
        this.confirmCheckbox = checkBox;
        this.permissionsText = textView;
        this.whatDataIsShared = textView2;
    }

    @NonNull
    public static DialogConfirmDataSharingBinding bind(@NonNull View view) {
        int i4 = R.id.confirm_checkbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.confirm_checkbox);
        if (checkBox != null) {
            i4 = R.id.permissions_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.permissions_text);
            if (textView != null) {
                i4 = R.id.what_data_is_shared;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.what_data_is_shared);
                if (textView2 != null) {
                    return new DialogConfirmDataSharingBinding((LinearLayout) view, checkBox, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogConfirmDataSharingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogConfirmDataSharingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_confirm_data_sharing, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11039a;
    }
}
