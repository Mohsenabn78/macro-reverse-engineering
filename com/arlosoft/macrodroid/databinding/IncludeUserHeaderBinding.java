package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;

/* loaded from: classes3.dex */
public final class IncludeUserHeaderBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f11271a;
    @NonNull
    public final AvatarView avatarImage;
    @NonNull
    public final TextView description;
    @NonNull
    public final ImageView macrosImage;
    @NonNull
    public final TextView numMacros;
    @NonNull
    public final ImageView starImage;
    @NonNull
    public final ImageView starImageBackground;
    @NonNull
    public final TextView starRating;
    @NonNull
    public final ConstraintLayout userHeader;
    @NonNull
    public final TextView userRank;
    @NonNull
    public final LinearLayout userRankContainer;
    @NonNull
    public final ImageView userRankImage;
    @NonNull
    public final LinearLayout userStatsLayout;

    private IncludeUserHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AvatarView avatarView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView3, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView4, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout2) {
        this.f11271a = constraintLayout;
        this.avatarImage = avatarView;
        this.description = textView;
        this.macrosImage = imageView;
        this.numMacros = textView2;
        this.starImage = imageView2;
        this.starImageBackground = imageView3;
        this.starRating = textView3;
        this.userHeader = constraintLayout2;
        this.userRank = textView4;
        this.userRankContainer = linearLayout;
        this.userRankImage = imageView4;
        this.userStatsLayout = linearLayout2;
    }

    @NonNull
    public static IncludeUserHeaderBinding bind(@NonNull View view) {
        int i4 = R.id.avatarImage;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.avatarImage);
        if (avatarView != null) {
            i4 = R.id.description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.description);
            if (textView != null) {
                i4 = R.id.macrosImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.macrosImage);
                if (imageView != null) {
                    i4 = R.id.numMacros;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.numMacros);
                    if (textView2 != null) {
                        i4 = R.id.starImage;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.starImage);
                        if (imageView2 != null) {
                            i4 = R.id.starImageBackground;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.starImageBackground);
                            if (imageView3 != null) {
                                i4 = R.id.starRating;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.starRating);
                                if (textView3 != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                    i4 = R.id.userRank;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.userRank);
                                    if (textView4 != null) {
                                        i4 = R.id.userRankContainer;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.userRankContainer);
                                        if (linearLayout != null) {
                                            i4 = R.id.userRankImage;
                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.userRankImage);
                                            if (imageView4 != null) {
                                                i4 = R.id.userStatsLayout;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.userStatsLayout);
                                                if (linearLayout2 != null) {
                                                    return new IncludeUserHeaderBinding(constraintLayout, avatarView, textView, imageView, textView2, imageView2, imageView3, textView3, constraintLayout, textView4, linearLayout, imageView4, linearLayout2);
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
    public static IncludeUserHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeUserHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_user_header, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.f11271a;
    }
}
