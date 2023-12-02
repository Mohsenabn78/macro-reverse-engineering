package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityValidatePurchaseBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10977a;
    @NonNull
    public final EditText emailAddress;
    @NonNull
    public final Button exportMacrosButton;
    @NonNull
    public final FrameLayout loadingBlocker;
    @NonNull
    public final EditText serialCode;
    @NonNull
    public final Button uninstallButton;
    @NonNull
    public final Button upgradeWithSerialButton;

    private ActivityValidatePurchaseBinding(@NonNull FrameLayout frameLayout, @NonNull EditText editText, @NonNull Button button, @NonNull FrameLayout frameLayout2, @NonNull EditText editText2, @NonNull Button button2, @NonNull Button button3) {
        this.f10977a = frameLayout;
        this.emailAddress = editText;
        this.exportMacrosButton = button;
        this.loadingBlocker = frameLayout2;
        this.serialCode = editText2;
        this.uninstallButton = button2;
        this.upgradeWithSerialButton = button3;
    }

    @NonNull
    public static ActivityValidatePurchaseBinding bind(@NonNull View view) {
        int i4 = R.id.emailAddress;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.emailAddress);
        if (editText != null) {
            i4 = R.id.exportMacrosButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.exportMacrosButton);
            if (button != null) {
                i4 = R.id.loadingBlocker;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingBlocker);
                if (frameLayout != null) {
                    i4 = R.id.serialCode;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.serialCode);
                    if (editText2 != null) {
                        i4 = R.id.uninstallButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.uninstallButton);
                        if (button2 != null) {
                            i4 = R.id.upgradeWithSerialButton;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.upgradeWithSerialButton);
                            if (button3 != null) {
                                return new ActivityValidatePurchaseBinding((FrameLayout) view, editText, button, frameLayout, editText2, button2, button3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityValidatePurchaseBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityValidatePurchaseBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_validate_purchase, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10977a;
    }
}
