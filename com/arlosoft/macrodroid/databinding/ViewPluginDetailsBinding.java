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
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.varunest.sparkbutton.SparkButton2;

/* loaded from: classes3.dex */
public final class ViewPluginDetailsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11413a;
    @NonNull
    public final AvatarView avatarImage;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final TextView commentCount;
    @NonNull
    public final FrameLayout commentsButton;
    @NonNull
    public final TextView description;
    @NonNull
    public final TextView developerName;
    @NonNull
    public final LinearLayout layoutRoot;
    @NonNull
    public final TextView link;
    @NonNull
    public final ImageView overflowButton;
    @NonNull
    public final ImageView pluginIcon;
    @NonNull
    public final TextView pluginName;
    @NonNull
    public final LinearLayout pluginTitle;
    @NonNull
    public final FrameLayout starButton;
    @NonNull
    public final SparkButton2 starIcon;
    @NonNull
    public final TextView starRating;
    @NonNull
    public final TextView timeLabel;
    @NonNull
    public final LinearLayout userContainer;
    @NonNull
    public final TextView usernameEdit;

    private ViewPluginDetailsBinding(@NonNull CardView cardView, @NonNull AvatarView avatarView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView5, @NonNull LinearLayout linearLayout2, @NonNull FrameLayout frameLayout2, @NonNull SparkButton2 sparkButton2, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull LinearLayout linearLayout3, @NonNull TextView textView8) {
        this.f11413a = cardView;
        this.avatarImage = avatarView;
        this.cardView = cardView2;
        this.commentCount = textView;
        this.commentsButton = frameLayout;
        this.description = textView2;
        this.developerName = textView3;
        this.layoutRoot = linearLayout;
        this.link = textView4;
        this.overflowButton = imageView;
        this.pluginIcon = imageView2;
        this.pluginName = textView5;
        this.pluginTitle = linearLayout2;
        this.starButton = frameLayout2;
        this.starIcon = sparkButton2;
        this.starRating = textView6;
        this.timeLabel = textView7;
        this.userContainer = linearLayout3;
        this.usernameEdit = textView8;
    }

    @NonNull
    public static ViewPluginDetailsBinding bind(@NonNull View view) {
        int i4 = R.id.avatarImage;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.avatarImage);
        if (avatarView != null) {
            CardView cardView = (CardView) view;
            i4 = R.id.commentCount;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.commentCount);
            if (textView != null) {
                i4 = R.id.commentsButton;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.commentsButton);
                if (frameLayout != null) {
                    i4 = R.id.description;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.description);
                    if (textView2 != null) {
                        i4 = R.id.developerName;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.developerName);
                        if (textView3 != null) {
                            i4 = R.id.layoutRoot;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layoutRoot);
                            if (linearLayout != null) {
                                i4 = R.id.link;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.link);
                                if (textView4 != null) {
                                    i4 = R.id.overflowButton;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.overflowButton);
                                    if (imageView != null) {
                                        i4 = R.id.pluginIcon;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.pluginIcon);
                                        if (imageView2 != null) {
                                            i4 = R.id.pluginName;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.pluginName);
                                            if (textView5 != null) {
                                                i4 = R.id.pluginTitle;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pluginTitle);
                                                if (linearLayout2 != null) {
                                                    i4 = R.id.starButton;
                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.starButton);
                                                    if (frameLayout2 != null) {
                                                        i4 = R.id.starIcon;
                                                        SparkButton2 sparkButton2 = (SparkButton2) ViewBindings.findChildViewById(view, R.id.starIcon);
                                                        if (sparkButton2 != null) {
                                                            i4 = R.id.starRating;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.starRating);
                                                            if (textView6 != null) {
                                                                i4 = R.id.timeLabel;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.timeLabel);
                                                                if (textView7 != null) {
                                                                    i4 = R.id.userContainer;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.userContainer);
                                                                    if (linearLayout3 != null) {
                                                                        i4 = R.id.usernameEdit;
                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.usernameEdit);
                                                                        if (textView8 != null) {
                                                                            return new ViewPluginDetailsBinding(cardView, avatarView, cardView, textView, frameLayout, textView2, textView3, linearLayout, textView4, imageView, imageView2, textView5, linearLayout2, frameLayout2, sparkButton2, textView6, textView7, linearLayout3, textView8);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ViewPluginDetailsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewPluginDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_plugin_details, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11413a;
    }
}
