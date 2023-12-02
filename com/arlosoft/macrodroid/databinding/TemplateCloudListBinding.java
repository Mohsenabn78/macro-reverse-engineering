package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class TemplateCloudListBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11384a;
    @NonNull
    public final ListView templateCloudListList;
    @NonNull
    public final TextView templateCloudListNoConnectionText;
    @NonNull
    public final Button templateCloudListRetryButton;
    @NonNull
    public final ViewFlipper templateCloudListViewflipper;

    private TemplateCloudListBinding(@NonNull FrameLayout frameLayout, @NonNull ListView listView, @NonNull TextView textView, @NonNull Button button, @NonNull ViewFlipper viewFlipper) {
        this.f11384a = frameLayout;
        this.templateCloudListList = listView;
        this.templateCloudListNoConnectionText = textView;
        this.templateCloudListRetryButton = button;
        this.templateCloudListViewflipper = viewFlipper;
    }

    @NonNull
    public static TemplateCloudListBinding bind(@NonNull View view) {
        int i4 = R.id.template_cloud_list_list;
        ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.template_cloud_list_list);
        if (listView != null) {
            i4 = R.id.template_cloud_list_no_connection_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.template_cloud_list_no_connection_text);
            if (textView != null) {
                i4 = R.id.template_cloud_list_retry_button;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.template_cloud_list_retry_button);
                if (button != null) {
                    i4 = R.id.template_cloud_list_viewflipper;
                    ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.template_cloud_list_viewflipper);
                    if (viewFlipper != null) {
                        return new TemplateCloudListBinding((FrameLayout) view, listView, textView, button, viewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static TemplateCloudListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TemplateCloudListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.template_cloud_list, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11384a;
    }
}
