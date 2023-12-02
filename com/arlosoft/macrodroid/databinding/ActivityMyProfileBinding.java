package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;

/* loaded from: classes3.dex */
public final class ActivityMyProfileBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f10956a;
    @NonNull
    public final FrameLayout avatarFrame;
    @NonNull
    public final AvatarView avatarImage;
    @NonNull
    public final ConstraintLayout coordinatorLayout;
    @NonNull
    public final TextView description;
    @NonNull
    public final ImageView editDescriptionButton;
    @NonNull
    public final FrameLayout frameLayout;
    @NonNull
    public final FrameLayout loadingView;
    @NonNull
    public final AppCompatButton saveButton;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final AppCompatEditText usernameEdit;

    private ActivityMyProfileBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull AvatarView avatarView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull AppCompatButton appCompatButton, @NonNull Toolbar toolbar, @NonNull AppCompatEditText appCompatEditText) {
        this.f10956a = constraintLayout;
        this.avatarFrame = frameLayout;
        this.avatarImage = avatarView;
        this.coordinatorLayout = constraintLayout2;
        this.description = textView;
        this.editDescriptionButton = imageView;
        this.frameLayout = frameLayout2;
        this.loadingView = frameLayout3;
        this.saveButton = appCompatButton;
        this.toolbar = toolbar;
        this.usernameEdit = appCompatEditText;
    }

    @NonNull
    public static ActivityMyProfileBinding bind(@NonNull View view) {
        int i4 = R.id.avatarFrame;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.avatarFrame);
        if (frameLayout != null) {
            i4 = R.id.avatarImage;
            AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.avatarImage);
            if (avatarView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i4 = R.id.description;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.description);
                if (textView != null) {
                    i4 = R.id.editDescriptionButton;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.editDescriptionButton);
                    if (imageView != null) {
                        i4 = R.id.frameLayout;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.frameLayout);
                        if (frameLayout2 != null) {
                            i4 = R.id.loadingView;
                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingView);
                            if (frameLayout3 != null) {
                                i4 = R.id.saveButton;
                                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.saveButton);
                                if (appCompatButton != null) {
                                    i4 = R.id.toolbar;
                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                    if (toolbar != null) {
                                        i4 = R.id.usernameEdit;
                                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.usernameEdit);
                                        if (appCompatEditText != null) {
                                            return new ActivityMyProfileBinding(constraintLayout, frameLayout, avatarView, constraintLayout, textView, imageView, frameLayout2, frameLayout3, appCompatButton, toolbar, appCompatEditText);
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
    public static ActivityMyProfileBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityMyProfileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_my_profile, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.f10956a;
    }
}
