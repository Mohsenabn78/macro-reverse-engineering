package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogJsonOutputBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11085a;
    @NonNull
    public final Button addStringVariableButton;
    @NonNull
    public final NDSpinner dictionaryVariableSpinner;
    @NonNull
    public final NDSpinner stringVariableSpinner;

    private DialogJsonOutputBinding(@NonNull ScrollView scrollView, @NonNull Button button, @NonNull NDSpinner nDSpinner, @NonNull NDSpinner nDSpinner2) {
        this.f11085a = scrollView;
        this.addStringVariableButton = button;
        this.dictionaryVariableSpinner = nDSpinner;
        this.stringVariableSpinner = nDSpinner2;
    }

    @NonNull
    public static DialogJsonOutputBinding bind(@NonNull View view) {
        int i4 = R.id.addStringVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addStringVariableButton);
        if (button != null) {
            i4 = R.id.dictionaryVariableSpinner;
            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.dictionaryVariableSpinner);
            if (nDSpinner != null) {
                i4 = R.id.stringVariableSpinner;
                NDSpinner nDSpinner2 = (NDSpinner) ViewBindings.findChildViewById(view, R.id.stringVariableSpinner);
                if (nDSpinner2 != null) {
                    return new DialogJsonOutputBinding((ScrollView) view, button, nDSpinner, nDSpinner2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogJsonOutputBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogJsonOutputBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_json_output, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11085a;
    }
}
