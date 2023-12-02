package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class CustomWidgetSelectionListRowBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11013a;
    @NonNull
    public final TextView customWidgetSelectionListRowMacroName;
    @NonNull
    public final ImageView customWidgetSelectionListRowWidgetImage;
    @NonNull
    public final TextView customWidgetSelectionListRowWidgetText;

    private CustomWidgetSelectionListRowBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f11013a = linearLayout;
        this.customWidgetSelectionListRowMacroName = textView;
        this.customWidgetSelectionListRowWidgetImage = imageView;
        this.customWidgetSelectionListRowWidgetText = textView2;
    }

    @NonNull
    public static CustomWidgetSelectionListRowBinding bind(@NonNull View view) {
        int i4 = R.id.custom_widget_selection_list_row_macro_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.custom_widget_selection_list_row_macro_name);
        if (textView != null) {
            i4 = R.id.custom_widget_selection_list_row_widget_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.custom_widget_selection_list_row_widget_image);
            if (imageView != null) {
                i4 = R.id.custom_widget_selection_list_row_widget_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.custom_widget_selection_list_row_widget_text);
                if (textView2 != null) {
                    return new CustomWidgetSelectionListRowBinding((LinearLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static CustomWidgetSelectionListRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CustomWidgetSelectionListRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.custom_widget_selection_list_row, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11013a;
    }
}
