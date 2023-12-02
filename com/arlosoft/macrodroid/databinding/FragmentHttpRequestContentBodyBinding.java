package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentHttpRequestContentBodyBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ViewFlipper f11225a;
    @NonNull
    public final LinearLayout bodyFileLayout;
    @NonNull
    public final TextView bodyFilePath;
    @NonNull
    public final Button bodyMagicTextButton;
    @NonNull
    public final LinearLayout bodyTextLayout;
    @NonNull
    public final AppCompatEditText contentBodyText;
    @NonNull
    public final EditText contentTypeCustom;
    @NonNull
    public final Spinner contentTypeSpinner;
    @NonNull
    public final RadioButton radioButtonFile;
    @NonNull
    public final RadioButton radioButtonText;
    @NonNull
    public final ImageButton selectFileButton;
    @NonNull
    public final ViewFlipper viewFlipper;

    private FragmentHttpRequestContentBodyBinding(@NonNull ViewFlipper viewFlipper, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull Button button, @NonNull LinearLayout linearLayout2, @NonNull AppCompatEditText appCompatEditText, @NonNull EditText editText, @NonNull Spinner spinner, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull ImageButton imageButton, @NonNull ViewFlipper viewFlipper2) {
        this.f11225a = viewFlipper;
        this.bodyFileLayout = linearLayout;
        this.bodyFilePath = textView;
        this.bodyMagicTextButton = button;
        this.bodyTextLayout = linearLayout2;
        this.contentBodyText = appCompatEditText;
        this.contentTypeCustom = editText;
        this.contentTypeSpinner = spinner;
        this.radioButtonFile = radioButton;
        this.radioButtonText = radioButton2;
        this.selectFileButton = imageButton;
        this.viewFlipper = viewFlipper2;
    }

    @NonNull
    public static FragmentHttpRequestContentBodyBinding bind(@NonNull View view) {
        int i4 = R.id.bodyFileLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.bodyFileLayout);
        if (linearLayout != null) {
            i4 = R.id.bodyFilePath;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bodyFilePath);
            if (textView != null) {
                i4 = R.id.bodyMagicTextButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.bodyMagicTextButton);
                if (button != null) {
                    i4 = R.id.bodyTextLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.bodyTextLayout);
                    if (linearLayout2 != null) {
                        i4 = R.id.contentBodyText;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.contentBodyText);
                        if (appCompatEditText != null) {
                            i4 = R.id.contentTypeCustom;
                            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.contentTypeCustom);
                            if (editText != null) {
                                i4 = R.id.contentTypeSpinner;
                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.contentTypeSpinner);
                                if (spinner != null) {
                                    i4 = R.id.radioButtonFile;
                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonFile);
                                    if (radioButton != null) {
                                        i4 = R.id.radioButtonText;
                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonText);
                                        if (radioButton2 != null) {
                                            i4 = R.id.selectFileButton;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.selectFileButton);
                                            if (imageButton != null) {
                                                ViewFlipper viewFlipper = (ViewFlipper) view;
                                                return new FragmentHttpRequestContentBodyBinding(viewFlipper, linearLayout, textView, button, linearLayout2, appCompatEditText, editText, spinner, radioButton, radioButton2, imageButton, viewFlipper);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentHttpRequestContentBodyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentHttpRequestContentBodyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_http_request_content_body, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ViewFlipper getRoot() {
        return this.f11225a;
    }
}
