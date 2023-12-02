package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;

/* loaded from: classes3.dex */
public final class ListItemMyUserSubscriptionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11301a;
    @NonNull
    public final AvatarView avatarImage;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final TextView maroName;

    private ListItemMyUserSubscriptionBinding(@NonNull CardView cardView, @NonNull AvatarView avatarView, @NonNull CardView cardView2, @NonNull TextView textView) {
        this.f11301a = cardView;
        this.avatarImage = avatarView;
        this.cardView = cardView2;
        this.maroName = textView;
    }

    @NonNull
    public static ListItemMyUserSubscriptionBinding bind(@NonNull View view) {
        int i4 = R.id.avatarImage;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.avatarImage);
        if (avatarView != null) {
            CardView cardView = (CardView) view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.maroName);
            if (textView != null) {
                return new ListItemMyUserSubscriptionBinding(cardView, avatarView, cardView, textView);
            }
            i4 = R.id.maroName;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemMyUserSubscriptionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemMyUserSubscriptionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_my_user_subscription, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11301a;
    }
}
