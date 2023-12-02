package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class MacroEditEntrySmallLegacyBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f11327a;
    @NonNull
    public final ImageView collapseExpandButton;
    @NonNull
    public final LinearLayout collapsedParentIcons;
    @NonNull
    public final LinearLayout constraintContainer;
    @NonNull
    public final View constraintLinkUnderAction;
    @NonNull
    public final ImageView dragHandle;
    @NonNull
    public final TextView iconText;
    @NonNull
    public final TextView macroEditEntryComment;
    @NonNull
    public final TextView macroEditEntryDetail;
    @NonNull
    public final View macroEditEntryExtrasJoiner;
    @NonNull
    public final ImageView macroEditEntryIcon;
    @NonNull
    public final TextView macroEditEntryName;
    @NonNull
    public final TextView macroEditEntryWarningText;
    @NonNull
    public final ImageView macroEditWarningIcon;
    @NonNull
    public final View startSpacing;
    @NonNull
    public final ConstraintLayout topLevelContainer;
    @NonNull
    public final FrameLayout topLevelExtrasContainer;

    private MacroEditEntrySmallLegacyBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull View view, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull View view2, @NonNull ImageView imageView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ImageView imageView4, @NonNull View view3, @NonNull ConstraintLayout constraintLayout2, @NonNull FrameLayout frameLayout) {
        this.f11327a = constraintLayout;
        this.collapseExpandButton = imageView;
        this.collapsedParentIcons = linearLayout;
        this.constraintContainer = linearLayout2;
        this.constraintLinkUnderAction = view;
        this.dragHandle = imageView2;
        this.iconText = textView;
        this.macroEditEntryComment = textView2;
        this.macroEditEntryDetail = textView3;
        this.macroEditEntryExtrasJoiner = view2;
        this.macroEditEntryIcon = imageView3;
        this.macroEditEntryName = textView4;
        this.macroEditEntryWarningText = textView5;
        this.macroEditWarningIcon = imageView4;
        this.startSpacing = view3;
        this.topLevelContainer = constraintLayout2;
        this.topLevelExtrasContainer = frameLayout;
    }

    @NonNull
    public static MacroEditEntrySmallLegacyBinding bind(@NonNull View view) {
        int i4 = R.id.collapse_expand_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.collapse_expand_button);
        if (imageView != null) {
            i4 = R.id.collapsed_parent_icons;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.collapsed_parent_icons);
            if (linearLayout != null) {
                i4 = R.id.constraintContainer;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.constraintContainer);
                if (linearLayout2 != null) {
                    i4 = R.id.constraintLinkUnderAction;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.constraintLinkUnderAction);
                    if (findChildViewById != null) {
                        i4 = R.id.dragHandle;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.dragHandle);
                        if (imageView2 != null) {
                            i4 = R.id.iconText;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.iconText);
                            if (textView != null) {
                                i4 = R.id.macro_edit_entry_comment;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.macro_edit_entry_comment);
                                if (textView2 != null) {
                                    i4 = R.id.macro_edit_entry_detail;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.macro_edit_entry_detail);
                                    if (textView3 != null) {
                                        i4 = R.id.macro_edit_entry_extras_joiner;
                                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.macro_edit_entry_extras_joiner);
                                        if (findChildViewById2 != null) {
                                            i4 = R.id.macro_edit_entry_icon;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.macro_edit_entry_icon);
                                            if (imageView3 != null) {
                                                i4 = R.id.macro_edit_entry_name;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.macro_edit_entry_name);
                                                if (textView4 != null) {
                                                    i4 = R.id.macro_edit_entry_warning_text;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.macro_edit_entry_warning_text);
                                                    if (textView5 != null) {
                                                        i4 = R.id.macro_edit_warning_icon;
                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.macro_edit_warning_icon);
                                                        if (imageView4 != null) {
                                                            i4 = R.id.start_spacing;
                                                            View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.start_spacing);
                                                            if (findChildViewById3 != null) {
                                                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                i4 = R.id.topLevelExtrasContainer;
                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.topLevelExtrasContainer);
                                                                if (frameLayout != null) {
                                                                    return new MacroEditEntrySmallLegacyBinding(constraintLayout, imageView, linearLayout, linearLayout2, findChildViewById, imageView2, textView, textView2, textView3, findChildViewById2, imageView3, textView4, textView5, imageView4, findChildViewById3, constraintLayout, frameLayout);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static MacroEditEntrySmallLegacyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MacroEditEntrySmallLegacyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.macro_edit_entry_small_legacy, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.f11327a;
    }
}
