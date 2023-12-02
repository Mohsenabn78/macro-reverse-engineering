package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public final class TroubleshootingHelpItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11394a;
    @NonNull
    public final Button actionButton;
    @NonNull
    public final ImageView chevron;
    @NonNull
    public final MaterialCardView dontKeepAcitvitesWarning;
    @NonNull
    public final ExpandableLayout expandableLayout;
    @NonNull
    public final TextView helpDescription;
    @NonNull
    public final LinearLayout helpHeader;
    @NonNull
    public final TextView helpTitle;
    @NonNull
    public final Button optionalButton1;
    @NonNull
    public final Button optionalButton2;
    @NonNull
    public final Button optionalButton3;
    @NonNull
    public final TextView optionalLinksDescription;

    private TroubleshootingHelpItemBinding(@NonNull MaterialCardView materialCardView, @NonNull Button button, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView2, @NonNull ExpandableLayout expandableLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull TextView textView3) {
        this.f11394a = materialCardView;
        this.actionButton = button;
        this.chevron = imageView;
        this.dontKeepAcitvitesWarning = materialCardView2;
        this.expandableLayout = expandableLayout;
        this.helpDescription = textView;
        this.helpHeader = linearLayout;
        this.helpTitle = textView2;
        this.optionalButton1 = button2;
        this.optionalButton2 = button3;
        this.optionalButton3 = button4;
        this.optionalLinksDescription = textView3;
    }

    @NonNull
    public static TroubleshootingHelpItemBinding bind(@NonNull View view) {
        int i4 = R.id.actionButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.actionButton);
        if (button != null) {
            i4 = R.id.chevron;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.chevron);
            if (imageView != null) {
                MaterialCardView materialCardView = (MaterialCardView) view;
                i4 = R.id.expandableLayout;
                ExpandableLayout expandableLayout = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.expandableLayout);
                if (expandableLayout != null) {
                    i4 = R.id.helpDescription;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.helpDescription);
                    if (textView != null) {
                        i4 = R.id.helpHeader;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.helpHeader);
                        if (linearLayout != null) {
                            i4 = R.id.helpTitle;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.helpTitle);
                            if (textView2 != null) {
                                i4 = R.id.optionalButton1;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.optionalButton1);
                                if (button2 != null) {
                                    i4 = R.id.optionalButton2;
                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.optionalButton2);
                                    if (button3 != null) {
                                        i4 = R.id.optionalButton3;
                                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.optionalButton3);
                                        if (button4 != null) {
                                            i4 = R.id.optionalLinksDescription;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.optionalLinksDescription);
                                            if (textView3 != null) {
                                                return new TroubleshootingHelpItemBinding(materialCardView, button, imageView, materialCardView, expandableLayout, textView, linearLayout, textView2, button2, button3, button4, textView3);
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
    public static TroubleshootingHelpItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TroubleshootingHelpItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.troubleshooting_help_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11394a;
    }
}
