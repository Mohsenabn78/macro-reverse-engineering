package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class ExportimportViewBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11212a;
    @NonNull
    public final FloatingActionButton exportimportExportButton;
    @NonNull
    public final FloatingActionButton exportimportExportShareButton;
    @NonNull
    public final FloatingActionButton exportimportImportButton;
    @NonNull
    public final LinearLayout exportimportImportContainer;
    @NonNull
    public final CheckBox exportimportResetVariables;
    @NonNull
    public final LinearLayout rootLayout;
    @NonNull
    public final TextView textView2;
    @NonNull
    public final TextView textView3;
    @NonNull
    public final Toolbar toolbar;

    private ExportimportViewBinding(@NonNull LinearLayout linearLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull FloatingActionButton floatingActionButton2, @NonNull FloatingActionButton floatingActionButton3, @NonNull LinearLayout linearLayout2, @NonNull CheckBox checkBox, @NonNull LinearLayout linearLayout3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Toolbar toolbar) {
        this.f11212a = linearLayout;
        this.exportimportExportButton = floatingActionButton;
        this.exportimportExportShareButton = floatingActionButton2;
        this.exportimportImportButton = floatingActionButton3;
        this.exportimportImportContainer = linearLayout2;
        this.exportimportResetVariables = checkBox;
        this.rootLayout = linearLayout3;
        this.textView2 = textView;
        this.textView3 = textView2;
        this.toolbar = toolbar;
    }

    @NonNull
    public static ExportimportViewBinding bind(@NonNull View view) {
        int i4 = R.id.exportimport_export_button;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.exportimport_export_button);
        if (floatingActionButton != null) {
            i4 = R.id.exportimport_export_share_button;
            FloatingActionButton floatingActionButton2 = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.exportimport_export_share_button);
            if (floatingActionButton2 != null) {
                i4 = R.id.exportimport_import_button;
                FloatingActionButton floatingActionButton3 = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.exportimport_import_button);
                if (floatingActionButton3 != null) {
                    i4 = R.id.exportimport_import_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.exportimport_import_container);
                    if (linearLayout != null) {
                        i4 = R.id.exportimport_reset_variables;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.exportimport_reset_variables);
                        if (checkBox != null) {
                            LinearLayout linearLayout2 = (LinearLayout) view;
                            i4 = R.id.textView2;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView2);
                            if (textView != null) {
                                i4 = R.id.textView3;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.textView3);
                                if (textView2 != null) {
                                    i4 = R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (toolbar != null) {
                                        return new ExportimportViewBinding(linearLayout2, floatingActionButton, floatingActionButton2, floatingActionButton3, linearLayout, checkBox, linearLayout2, textView, textView2, toolbar);
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
    public static ExportimportViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ExportimportViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.exportimport_view, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11212a;
    }
}
