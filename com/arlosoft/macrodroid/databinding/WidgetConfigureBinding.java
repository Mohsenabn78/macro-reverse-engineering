package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class WidgetConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11428a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox fadedCheckbox;
    @NonNull
    public final Button okButton;
    @NonNull
    public final Button specialTextButton;
    @NonNull
    public final AppCompatEditText widgetConfigureLabel;
    @NonNull
    public final ImageView widgetConfigurePreviewImage;
    @NonNull
    public final TextView widgetConfigurePreviewText;
    @NonNull
    public final Button widgetConfigureSelectIconButton;

    private WidgetConfigureBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull Button button2, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull Button button4) {
        this.f11428a = scrollView;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.fadedCheckbox = checkBox;
        this.okButton = button2;
        this.specialTextButton = button3;
        this.widgetConfigureLabel = appCompatEditText;
        this.widgetConfigurePreviewImage = imageView;
        this.widgetConfigurePreviewText = textView;
        this.widgetConfigureSelectIconButton = button4;
    }

    @NonNull
    public static WidgetConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.faded_checkbox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.faded_checkbox);
                if (checkBox != null) {
                    i4 = R.id.okButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                    if (button2 != null) {
                        i4 = R.id.special_text_button;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.special_text_button);
                        if (button3 != null) {
                            i4 = R.id.widget_configure_label;
                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.widget_configure_label);
                            if (appCompatEditText != null) {
                                i4 = R.id.widget_configure_preview_image;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.widget_configure_preview_image);
                                if (imageView != null) {
                                    i4 = R.id.widget_configure_preview_text;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.widget_configure_preview_text);
                                    if (textView != null) {
                                        i4 = R.id.widget_configure_select_icon_button;
                                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.widget_configure_select_icon_button);
                                        if (button4 != null) {
                                            return new WidgetConfigureBinding((ScrollView) view, linearLayout, button, checkBox, button2, button3, appCompatEditText, imageView, textView, button4);
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
    public static WidgetConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static WidgetConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.widget_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11428a;
    }
}
