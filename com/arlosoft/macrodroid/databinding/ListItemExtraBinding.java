package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.extras.ui.views.SubscriptionOptionView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: classes3.dex */
public final class ListItemExtraBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11291a;
    @NonNull
    public final TextView activeIndicator;
    @NonNull
    public final TextView description;
    @NonNull
    public final TextView details;
    @NonNull
    public final TextView emailAddress;
    @NonNull
    public final LinearLayout emailContainer;
    @NonNull
    public final MaterialButton enableDisableButton;
    @NonNull
    public final ShapeableImageView icon;
    @NonNull
    public final TextView installMacrodroidUpdateButton;
    @NonNull
    public final MaterialButton installUpdateButton;
    @NonNull
    public final LinearLayout macrodroidUpdateRequiredIndicator;
    @NonNull
    public final TextView macrodroidUpdateRequiredText;
    @NonNull
    public final MaterialButton manageSubscriptionLink;
    @NonNull
    public final SubscriptionOptionView monthlySubscriptionOption;
    @NonNull
    public final TextView retryValidationButton;
    @NonNull
    public final LinearLayout setupElements;
    @NonNull
    public final LinearLayout setupRequiredContainer;
    @NonNull
    public final MaterialButton subscribeButton;
    @NonNull
    public final LinearLayout subscribeButtonsContainer;
    @NonNull
    public final TextView subscribeHeading;
    @NonNull
    public final TextView subscribeText;
    @NonNull
    public final TextView supportTitle;
    @NonNull
    public final LinearLayout telegramContainer;
    @NonNull
    public final TextView telegramLink;
    @NonNull
    public final TextView title;
    @NonNull
    public final LinearLayout updateAvailableContainer;
    @NonNull
    public final TextView updateAvailableDescription;
    @NonNull
    public final TextView updateVersion;
    @NonNull
    public final FrameLayout validatingPurchaseContainer;
    @NonNull
    public final LinearLayout validationFailedIndicator;
    @NonNull
    public final TextView version;
    @NonNull
    public final SubscriptionOptionView weeklySubscriptionOption;
    @NonNull
    public final LinearLayout whatsappContainer;
    @NonNull
    public final TextView whatsappLink;
    @NonNull
    public final SubscriptionOptionView yearlySubscriptionOption;

    private ListItemExtraBinding(@NonNull MaterialCardView materialCardView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull ShapeableImageView shapeableImageView, @NonNull TextView textView5, @NonNull MaterialButton materialButton2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView6, @NonNull MaterialButton materialButton3, @NonNull SubscriptionOptionView subscriptionOptionView, @NonNull TextView textView7, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull MaterialButton materialButton4, @NonNull LinearLayout linearLayout5, @NonNull TextView textView8, @NonNull TextView textView9, @NonNull TextView textView10, @NonNull LinearLayout linearLayout6, @NonNull TextView textView11, @NonNull TextView textView12, @NonNull LinearLayout linearLayout7, @NonNull TextView textView13, @NonNull TextView textView14, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout8, @NonNull TextView textView15, @NonNull SubscriptionOptionView subscriptionOptionView2, @NonNull LinearLayout linearLayout9, @NonNull TextView textView16, @NonNull SubscriptionOptionView subscriptionOptionView3) {
        this.f11291a = materialCardView;
        this.activeIndicator = textView;
        this.description = textView2;
        this.details = textView3;
        this.emailAddress = textView4;
        this.emailContainer = linearLayout;
        this.enableDisableButton = materialButton;
        this.icon = shapeableImageView;
        this.installMacrodroidUpdateButton = textView5;
        this.installUpdateButton = materialButton2;
        this.macrodroidUpdateRequiredIndicator = linearLayout2;
        this.macrodroidUpdateRequiredText = textView6;
        this.manageSubscriptionLink = materialButton3;
        this.monthlySubscriptionOption = subscriptionOptionView;
        this.retryValidationButton = textView7;
        this.setupElements = linearLayout3;
        this.setupRequiredContainer = linearLayout4;
        this.subscribeButton = materialButton4;
        this.subscribeButtonsContainer = linearLayout5;
        this.subscribeHeading = textView8;
        this.subscribeText = textView9;
        this.supportTitle = textView10;
        this.telegramContainer = linearLayout6;
        this.telegramLink = textView11;
        this.title = textView12;
        this.updateAvailableContainer = linearLayout7;
        this.updateAvailableDescription = textView13;
        this.updateVersion = textView14;
        this.validatingPurchaseContainer = frameLayout;
        this.validationFailedIndicator = linearLayout8;
        this.version = textView15;
        this.weeklySubscriptionOption = subscriptionOptionView2;
        this.whatsappContainer = linearLayout9;
        this.whatsappLink = textView16;
        this.yearlySubscriptionOption = subscriptionOptionView3;
    }

    @NonNull
    public static ListItemExtraBinding bind(@NonNull View view) {
        int i4 = R.id.active_indicator;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.active_indicator);
        if (textView != null) {
            i4 = R.id.description;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.description);
            if (textView2 != null) {
                i4 = R.id.details;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.details);
                if (textView3 != null) {
                    i4 = R.id.email_Address;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.email_Address);
                    if (textView4 != null) {
                        i4 = R.id.email_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.email_container);
                        if (linearLayout != null) {
                            i4 = R.id.enable_disable_button;
                            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, R.id.enable_disable_button);
                            if (materialButton != null) {
                                i4 = R.id.icon;
                                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, R.id.icon);
                                if (shapeableImageView != null) {
                                    i4 = R.id.install_macrodroid_update_button;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.install_macrodroid_update_button);
                                    if (textView5 != null) {
                                        i4 = R.id.install_update_button;
                                        MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, R.id.install_update_button);
                                        if (materialButton2 != null) {
                                            i4 = R.id.macrodroid_update_required_indicator;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macrodroid_update_required_indicator);
                                            if (linearLayout2 != null) {
                                                i4 = R.id.macrodroid_update_required_text;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.macrodroid_update_required_text);
                                                if (textView6 != null) {
                                                    i4 = R.id.manage_subscription_link;
                                                    MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, R.id.manage_subscription_link);
                                                    if (materialButton3 != null) {
                                                        i4 = R.id.monthlySubscriptionOption;
                                                        SubscriptionOptionView subscriptionOptionView = (SubscriptionOptionView) ViewBindings.findChildViewById(view, R.id.monthlySubscriptionOption);
                                                        if (subscriptionOptionView != null) {
                                                            i4 = R.id.retryValidationButton;
                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.retryValidationButton);
                                                            if (textView7 != null) {
                                                                i4 = R.id.setup_elements;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.setup_elements);
                                                                if (linearLayout3 != null) {
                                                                    i4 = R.id.setup_required_container;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.setup_required_container);
                                                                    if (linearLayout4 != null) {
                                                                        i4 = R.id.subscribe_button;
                                                                        MaterialButton materialButton4 = (MaterialButton) ViewBindings.findChildViewById(view, R.id.subscribe_button);
                                                                        if (materialButton4 != null) {
                                                                            i4 = R.id.subscribe_buttons_container;
                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.subscribe_buttons_container);
                                                                            if (linearLayout5 != null) {
                                                                                i4 = R.id.subscribe_heading;
                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.subscribe_heading);
                                                                                if (textView8 != null) {
                                                                                    i4 = R.id.subscribe_text;
                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.subscribe_text);
                                                                                    if (textView9 != null) {
                                                                                        i4 = R.id.support_title;
                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.support_title);
                                                                                        if (textView10 != null) {
                                                                                            i4 = R.id.telegram_container;
                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.telegram_container);
                                                                                            if (linearLayout6 != null) {
                                                                                                i4 = R.id.telegram_link;
                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.telegram_link);
                                                                                                if (textView11 != null) {
                                                                                                    i4 = R.id.title;
                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                                                                                    if (textView12 != null) {
                                                                                                        i4 = R.id.update_available_container;
                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.update_available_container);
                                                                                                        if (linearLayout7 != null) {
                                                                                                            i4 = R.id.update_available_description;
                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, R.id.update_available_description);
                                                                                                            if (textView13 != null) {
                                                                                                                i4 = R.id.update_version;
                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view, R.id.update_version);
                                                                                                                if (textView14 != null) {
                                                                                                                    i4 = R.id.validating_purchase_container;
                                                                                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.validating_purchase_container);
                                                                                                                    if (frameLayout != null) {
                                                                                                                        i4 = R.id.validation_failed_indicator;
                                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.validation_failed_indicator);
                                                                                                                        if (linearLayout8 != null) {
                                                                                                                            i4 = R.id.version;
                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, R.id.version);
                                                                                                                            if (textView15 != null) {
                                                                                                                                i4 = R.id.weeklySubscriptionOption;
                                                                                                                                SubscriptionOptionView subscriptionOptionView2 = (SubscriptionOptionView) ViewBindings.findChildViewById(view, R.id.weeklySubscriptionOption);
                                                                                                                                if (subscriptionOptionView2 != null) {
                                                                                                                                    i4 = R.id.whatsapp_container;
                                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.whatsapp_container);
                                                                                                                                    if (linearLayout9 != null) {
                                                                                                                                        i4 = R.id.whatsapp_link;
                                                                                                                                        TextView textView16 = (TextView) ViewBindings.findChildViewById(view, R.id.whatsapp_link);
                                                                                                                                        if (textView16 != null) {
                                                                                                                                            i4 = R.id.yearlySubscriptionOption;
                                                                                                                                            SubscriptionOptionView subscriptionOptionView3 = (SubscriptionOptionView) ViewBindings.findChildViewById(view, R.id.yearlySubscriptionOption);
                                                                                                                                            if (subscriptionOptionView3 != null) {
                                                                                                                                                return new ListItemExtraBinding((MaterialCardView) view, textView, textView2, textView3, textView4, linearLayout, materialButton, shapeableImageView, textView5, materialButton2, linearLayout2, textView6, materialButton3, subscriptionOptionView, textView7, linearLayout3, linearLayout4, materialButton4, linearLayout5, textView8, textView9, textView10, linearLayout6, textView11, textView12, linearLayout7, textView13, textView14, frameLayout, linearLayout8, textView15, subscriptionOptionView2, linearLayout9, textView16, subscriptionOptionView3);
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
    public static ListItemExtraBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemExtraBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_extra, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11291a;
    }
}
