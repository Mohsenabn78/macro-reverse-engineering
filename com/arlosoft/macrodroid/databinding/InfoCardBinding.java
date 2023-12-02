package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class InfoCardBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11273a;
    @NonNull
    public final LinearLayout infoCard;
    @NonNull
    public final TextView infoCardDetail;
    @NonNull
    public final Button infoCardGotIt;
    @NonNull
    public final TextView infoCardTitle;
    @NonNull
    public final CardView infoCardView;

    private InfoCardBinding(@NonNull CardView cardView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull Button button, @NonNull TextView textView2, @NonNull CardView cardView2) {
        this.f11273a = cardView;
        this.infoCard = linearLayout;
        this.infoCardDetail = textView;
        this.infoCardGotIt = button;
        this.infoCardTitle = textView2;
        this.infoCardView = cardView2;
    }

    @NonNull
    public static InfoCardBinding bind(@NonNull View view) {
        int i4 = R.id.info_card;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.info_card);
        if (linearLayout != null) {
            i4 = R.id.infoCardDetail;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.infoCardDetail);
            if (textView != null) {
                i4 = R.id.infoCardGotIt;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.infoCardGotIt);
                if (button != null) {
                    i4 = R.id.infoCardTitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.infoCardTitle);
                    if (textView2 != null) {
                        CardView cardView = (CardView) view;
                        return new InfoCardBinding(cardView, linearLayout, textView, button, textView2, cardView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static InfoCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static InfoCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.info_card, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11273a;
    }
}
