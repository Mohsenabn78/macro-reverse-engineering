package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.avatar.views.AvatarView;

/* loaded from: classes3.dex */
public final class ItemTemplatesUserBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11282a;
    @NonNull
    public final AvatarView avatarImage;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final TextView description;
    @NonNull
    public final ImageView macroIcon;
    @NonNull
    public final TextView name;
    @NonNull
    public final TextView numMacros;
    @NonNull
    public final TextView rank;
    @NonNull
    public final ImageView starIcon;
    @NonNull
    public final TextView starRating;
    @NonNull
    public final ImageView subscriptionIndicator;

    private ItemTemplatesUserBinding(@NonNull CardView cardView, @NonNull AvatarView avatarView, @NonNull CardView cardView2, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull ImageView imageView2, @NonNull TextView textView5, @NonNull ImageView imageView3) {
        this.f11282a = cardView;
        this.avatarImage = avatarView;
        this.cardView = cardView2;
        this.description = textView;
        this.macroIcon = imageView;
        this.name = textView2;
        this.numMacros = textView3;
        this.rank = textView4;
        this.starIcon = imageView2;
        this.starRating = textView5;
        this.subscriptionIndicator = imageView3;
    }

    @NonNull
    public static ItemTemplatesUserBinding bind(@NonNull View view) {
        int i4 = R.id.avatarImage;
        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.avatarImage);
        if (avatarView != null) {
            CardView cardView = (CardView) view;
            i4 = R.id.description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.description);
            if (textView != null) {
                i4 = R.id.macroIcon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.macroIcon);
                if (imageView != null) {
                    i4 = R.id.name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.name);
                    if (textView2 != null) {
                        i4 = R.id.numMacros;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.numMacros);
                        if (textView3 != null) {
                            i4 = R.id.rank;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.rank);
                            if (textView4 != null) {
                                i4 = R.id.starIcon;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.starIcon);
                                if (imageView2 != null) {
                                    i4 = R.id.starRating;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.starRating);
                                    if (textView5 != null) {
                                        i4 = R.id.subscriptionIndicator;
                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.subscriptionIndicator);
                                        if (imageView3 != null) {
                                            return new ItemTemplatesUserBinding(cardView, avatarView, cardView, textView, imageView, textView2, textView3, textView4, imageView2, textView5, imageView3);
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
    public static ItemTemplatesUserBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemTemplatesUserBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.item_templates_user, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11282a;
    }
}
