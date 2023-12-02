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

/* loaded from: classes3.dex */
public final class ListItemSubscriptionUpdateBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11313a;
    @NonNull
    public final AvatarView avatarImage;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final LinearLayout item;
    @NonNull
    public final TextView timeLabel;
    @NonNull
    public final TextView title;
    @NonNull
    public final TextView updateText;
    @NonNull
    public final FrameLayout userContainer;
    @NonNull
    public final TextView userNameLabel;

    private ListItemSubscriptionUpdateBinding(@NonNull CardView cardView, @NonNull AvatarView avatarView, @NonNull CardView cardView2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull FrameLayout frameLayout, @NonNull TextView textView4) {
        this.f11313a = cardView;
        this.avatarImage = avatarView;
        this.cardView = cardView2;
        this.icon = imageView;
        this.item = linearLayout;
        this.timeLabel = textView;
        this.title = textView2;
        this.updateText = textView3;
        this.userContainer = frameLayout;
        this.userNameLabel = textView4;
    }

    @NonNull
    public static ListItemSubscriptionUpdateBinding bind(@NonNull View view) {
        int i4 = R.id.avatarImage;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.avatarImage);
        if (avatarView != null) {
            CardView cardView = (CardView) view;
            i4 = R.id.icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
            if (imageView != null) {
                i4 = R.id.item;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.item);
                if (linearLayout != null) {
                    i4 = R.id.timeLabel;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.timeLabel);
                    if (textView != null) {
                        i4 = R.id.title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                        if (textView2 != null) {
                            i4 = R.id.updateText;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.updateText);
                            if (textView3 != null) {
                                i4 = R.id.userContainer;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.userContainer);
                                if (frameLayout != null) {
                                    i4 = R.id.userNameLabel;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.userNameLabel);
                                    if (textView4 != null) {
                                        return new ListItemSubscriptionUpdateBinding(cardView, avatarView, cardView, imageView, linearLayout, textView, textView2, textView3, frameLayout, textView4);
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
    public static ListItemSubscriptionUpdateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemSubscriptionUpdateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_subscription_update, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11313a;
    }
}
