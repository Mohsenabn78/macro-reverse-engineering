package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityMacrodroidProAdvertBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10955a;
    @NonNull
    public final ImageView closeButton;
    @NonNull
    public final TextView cloudBackupLabel;
    @NonNull
    public final ImageView countDownBlockClose;
    @NonNull
    public final TextView countdownText;
    @NonNull
    public final ImageView endButton;
    @NonNull
    public final TextView joinTheCommunityLabel;
    @NonNull
    public final ImageView logoImage;
    @NonNull
    public final LinearLayout macroDroidBox;
    @NonNull
    public final TextView macrodroidLabel;
    @NonNull
    public final TextView oneTimePaymentLabel;
    @NonNull
    public final TextView proLabel;
    @NonNull
    public final TextView removeAllAdvertsLabel;
    @NonNull
    public final TextView supportDeveloperLabel;
    @NonNull
    public final TextView unlimitedMacrosLabel;
    @NonNull
    public final Button upgradeNowButton;

    private ActivityMacrodroidProAdvertBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull ImageView imageView3, @NonNull TextView textView3, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull Button button) {
        this.f10955a = frameLayout;
        this.closeButton = imageView;
        this.cloudBackupLabel = textView;
        this.countDownBlockClose = imageView2;
        this.countdownText = textView2;
        this.endButton = imageView3;
        this.joinTheCommunityLabel = textView3;
        this.logoImage = imageView4;
        this.macroDroidBox = linearLayout;
        this.macrodroidLabel = textView4;
        this.oneTimePaymentLabel = textView5;
        this.proLabel = textView6;
        this.removeAllAdvertsLabel = textView7;
        this.supportDeveloperLabel = textView8;
        this.unlimitedMacrosLabel = textView9;
        this.upgradeNowButton = button;
    }

    @NonNull
    public static ActivityMacrodroidProAdvertBinding bind(@NonNull View view) {
        int i4 = R.id.closeButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.closeButton);
        if (imageView != null) {
            i4 = R.id.cloudBackupLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.cloudBackupLabel);
            if (textView != null) {
                i4 = R.id.countDownBlockClose;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.countDownBlockClose);
                if (imageView2 != null) {
                    i4 = R.id.countdownText;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.countdownText);
                    if (textView2 != null) {
                        i4 = R.id.endButton;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.endButton);
                        if (imageView3 != null) {
                            i4 = R.id.joinTheCommunityLabel;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.joinTheCommunityLabel);
                            if (textView3 != null) {
                                i4 = R.id.logoImage;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.logoImage);
                                if (imageView4 != null) {
                                    i4 = R.id.macroDroidBox;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macroDroidBox);
                                    if (linearLayout != null) {
                                        i4 = R.id.macrodroidLabel;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.macrodroidLabel);
                                        if (textView4 != null) {
                                            i4 = R.id.oneTimePaymentLabel;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.oneTimePaymentLabel);
                                            if (textView5 != null) {
                                                i4 = R.id.proLabel;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.proLabel);
                                                if (textView6 != null) {
                                                    i4 = R.id.removeAllAdvertsLabel;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.removeAllAdvertsLabel);
                                                    if (textView7 != null) {
                                                        i4 = R.id.supportDeveloperLabel;
                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.supportDeveloperLabel);
                                                        if (textView8 != null) {
                                                            i4 = R.id.unlimitedMacrosLabel;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.unlimitedMacrosLabel);
                                                            if (textView9 != null) {
                                                                i4 = R.id.upgradeNowButton;
                                                                Button button = (Button) ViewBindings.findChildViewById(view, R.id.upgradeNowButton);
                                                                if (button != null) {
                                                                    return new ActivityMacrodroidProAdvertBinding((FrameLayout) view, imageView, textView, imageView2, textView2, imageView3, textView3, imageView4, linearLayout, textView4, textView5, textView6, textView7, textView8, textView9, button);
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
    public static ActivityMacrodroidProAdvertBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityMacrodroidProAdvertBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_macrodroid_pro_advert, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10955a;
    }
}
