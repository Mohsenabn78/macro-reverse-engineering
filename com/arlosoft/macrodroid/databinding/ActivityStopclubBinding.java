package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.extras.ui.views.SubscriptionOptionView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public final class ActivityStopclubBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10966a;
    @NonNull
    public final TextView activeIndicatorText;
    @NonNull
    public final FrameLayout activeStateIndicator;
    @NonNull
    public final View barBottomSpace;
    @NonNull
    public final View blockerView;
    @NonNull
    public final TextView description;
    @NonNull
    public final TextView details;
    @NonNull
    public final TextView emailAddress;
    @NonNull
    public final LinearLayout emailContainer;
    @NonNull
    public final LinearLayout emptyState;
    @NonNull
    public final ShapeableImageView icon;
    @NonNull
    public final ExpandableLayout infoBar;
    @NonNull
    public final FrameLayout infoBarBg;
    @NonNull
    public final ImageView infoBarDismissButton;
    @NonNull
    public final ImageView infoIcon;
    @NonNull
    public final TextView infoText;
    @NonNull
    public final TextView installMacrodroidUpdateButton;
    @NonNull
    public final MaterialButton installUpdateButton;
    @NonNull
    public final FrameLayout installingUpdateContainer;
    @NonNull
    public final TextView installingUpdateText;
    @NonNull
    public final LinearLayout macrodroidUpdateRequiredIndicator;
    @NonNull
    public final TextView macrodroidUpdateRequiredText;
    @NonNull
    public final MaterialButton manageSubscriptionLink;
    @NonNull
    public final SubscriptionOptionView monthlySubscriptionOption;
    @NonNull
    public final SwitchCompat onOffSwitch;
    @NonNull
    public final TextView promotionText;
    @NonNull
    public final MaterialButton resetButton;
    @NonNull
    public final Button retryButton;
    @NonNull
    public final TextView retryValidationButton;
    @NonNull
    public final ScrollView scrollView;
    @NonNull
    public final MaterialButton settingsButton;
    @NonNull
    public final LinearLayout settingsContainer;
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
    public final TextView titleText;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final LinearLayout updateAvailableContainer;
    @NonNull
    public final TextView updateAvailableDescription;
    @NonNull
    public final TextView updateVersion;
    @NonNull
    public final FrameLayout validatingPurchaseContainer;
    @NonNull
    public final TextView validatingPurchaseText;
    @NonNull
    public final LinearLayout validationFailedIndicator;
    @NonNull
    public final TextView version;
    @NonNull
    public final ViewFlipper viewFlipper;
    @NonNull
    public final SubscriptionOptionView weeklySubscriptionOption;
    @NonNull
    public final LinearLayout whatsappContainer;
    @NonNull
    public final TextView whatsappLink;
    @NonNull
    public final SubscriptionOptionView yearlySubscriptionOption;

    private ActivityStopclubBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull View view2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ShapeableImageView shapeableImageView, @NonNull ExpandableLayout expandableLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull MaterialButton materialButton, @NonNull FrameLayout frameLayout3, @NonNull TextView textView7, @NonNull LinearLayout linearLayout4, @NonNull TextView textView8, @NonNull MaterialButton materialButton2, @NonNull SubscriptionOptionView subscriptionOptionView, @NonNull SwitchCompat switchCompat, @NonNull TextView textView9, @NonNull MaterialButton materialButton3, @NonNull Button button, @NonNull TextView textView10, @NonNull ScrollView scrollView, @NonNull MaterialButton materialButton4, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull LinearLayout linearLayout7, @NonNull MaterialButton materialButton5, @NonNull LinearLayout linearLayout8, @NonNull TextView textView11, @NonNull TextView textView12, @NonNull TextView textView13, @NonNull LinearLayout linearLayout9, @NonNull TextView textView14, @NonNull TextView textView15, @NonNull TextView textView16, @NonNull Toolbar toolbar, @NonNull LinearLayout linearLayout10, @NonNull TextView textView17, @NonNull TextView textView18, @NonNull FrameLayout frameLayout4, @NonNull TextView textView19, @NonNull LinearLayout linearLayout11, @NonNull TextView textView20, @NonNull ViewFlipper viewFlipper, @NonNull SubscriptionOptionView subscriptionOptionView2, @NonNull LinearLayout linearLayout12, @NonNull TextView textView21, @NonNull SubscriptionOptionView subscriptionOptionView3) {
        this.f10966a = linearLayout;
        this.activeIndicatorText = textView;
        this.activeStateIndicator = frameLayout;
        this.barBottomSpace = view;
        this.blockerView = view2;
        this.description = textView2;
        this.details = textView3;
        this.emailAddress = textView4;
        this.emailContainer = linearLayout2;
        this.emptyState = linearLayout3;
        this.icon = shapeableImageView;
        this.infoBar = expandableLayout;
        this.infoBarBg = frameLayout2;
        this.infoBarDismissButton = imageView;
        this.infoIcon = imageView2;
        this.infoText = textView5;
        this.installMacrodroidUpdateButton = textView6;
        this.installUpdateButton = materialButton;
        this.installingUpdateContainer = frameLayout3;
        this.installingUpdateText = textView7;
        this.macrodroidUpdateRequiredIndicator = linearLayout4;
        this.macrodroidUpdateRequiredText = textView8;
        this.manageSubscriptionLink = materialButton2;
        this.monthlySubscriptionOption = subscriptionOptionView;
        this.onOffSwitch = switchCompat;
        this.promotionText = textView9;
        this.resetButton = materialButton3;
        this.retryButton = button;
        this.retryValidationButton = textView10;
        this.scrollView = scrollView;
        this.settingsButton = materialButton4;
        this.settingsContainer = linearLayout5;
        this.setupElements = linearLayout6;
        this.setupRequiredContainer = linearLayout7;
        this.subscribeButton = materialButton5;
        this.subscribeButtonsContainer = linearLayout8;
        this.subscribeHeading = textView11;
        this.subscribeText = textView12;
        this.supportTitle = textView13;
        this.telegramContainer = linearLayout9;
        this.telegramLink = textView14;
        this.title = textView15;
        this.titleText = textView16;
        this.toolbar = toolbar;
        this.updateAvailableContainer = linearLayout10;
        this.updateAvailableDescription = textView17;
        this.updateVersion = textView18;
        this.validatingPurchaseContainer = frameLayout4;
        this.validatingPurchaseText = textView19;
        this.validationFailedIndicator = linearLayout11;
        this.version = textView20;
        this.viewFlipper = viewFlipper;
        this.weeklySubscriptionOption = subscriptionOptionView2;
        this.whatsappContainer = linearLayout12;
        this.whatsappLink = textView21;
        this.yearlySubscriptionOption = subscriptionOptionView3;
    }

    @NonNull
    public static ActivityStopclubBinding bind(@NonNull View view) {
        int i4 = R.id.active_indicator_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.active_indicator_text);
        if (textView != null) {
            i4 = R.id.active_state_indicator;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.active_state_indicator);
            if (frameLayout != null) {
                i4 = R.id.barBottomSpace;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.barBottomSpace);
                if (findChildViewById != null) {
                    i4 = R.id.blocker_view;
                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.blocker_view);
                    if (findChildViewById2 != null) {
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
                                        i4 = R.id.empty_state;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.empty_state);
                                        if (linearLayout2 != null) {
                                            i4 = R.id.icon;
                                            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.findChildViewById(view, R.id.icon);
                                            if (shapeableImageView != null) {
                                                i4 = R.id.infoBar;
                                                ExpandableLayout expandableLayout = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.infoBar);
                                                if (expandableLayout != null) {
                                                    i4 = R.id.infoBarBg;
                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.infoBarBg);
                                                    if (frameLayout2 != null) {
                                                        i4 = R.id.infoBarDismissButton;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.infoBarDismissButton);
                                                        if (imageView != null) {
                                                            i4 = R.id.infoIcon;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.infoIcon);
                                                            if (imageView2 != null) {
                                                                i4 = R.id.infoText;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.infoText);
                                                                if (textView5 != null) {
                                                                    i4 = R.id.install_macrodroid_update_button;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.install_macrodroid_update_button);
                                                                    if (textView6 != null) {
                                                                        i4 = R.id.install_update_button;
                                                                        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, R.id.install_update_button);
                                                                        if (materialButton != null) {
                                                                            i4 = R.id.installing_update_container;
                                                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.installing_update_container);
                                                                            if (frameLayout3 != null) {
                                                                                i4 = R.id.installing_update_text;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.installing_update_text);
                                                                                if (textView7 != null) {
                                                                                    i4 = R.id.macrodroid_update_required_indicator;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macrodroid_update_required_indicator);
                                                                                    if (linearLayout3 != null) {
                                                                                        i4 = R.id.macrodroid_update_required_text;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.macrodroid_update_required_text);
                                                                                        if (textView8 != null) {
                                                                                            i4 = R.id.manage_subscription_link;
                                                                                            MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, R.id.manage_subscription_link);
                                                                                            if (materialButton2 != null) {
                                                                                                i4 = R.id.monthlySubscriptionOption;
                                                                                                SubscriptionOptionView subscriptionOptionView = (SubscriptionOptionView) ViewBindings.findChildViewById(view, R.id.monthlySubscriptionOption);
                                                                                                if (subscriptionOptionView != null) {
                                                                                                    i4 = R.id.onOffSwitch;
                                                                                                    SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.onOffSwitch);
                                                                                                    if (switchCompat != null) {
                                                                                                        i4 = R.id.promotion_text;
                                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.promotion_text);
                                                                                                        if (textView9 != null) {
                                                                                                            i4 = R.id.reset_button;
                                                                                                            MaterialButton materialButton3 = (MaterialButton) ViewBindings.findChildViewById(view, R.id.reset_button);
                                                                                                            if (materialButton3 != null) {
                                                                                                                i4 = R.id.retry_button;
                                                                                                                Button button = (Button) ViewBindings.findChildViewById(view, R.id.retry_button);
                                                                                                                if (button != null) {
                                                                                                                    i4 = R.id.retryValidationButton;
                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.retryValidationButton);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i4 = R.id.scroll_view;
                                                                                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                                                                                                                        if (scrollView != null) {
                                                                                                                            i4 = R.id.settings_button;
                                                                                                                            MaterialButton materialButton4 = (MaterialButton) ViewBindings.findChildViewById(view, R.id.settings_button);
                                                                                                                            if (materialButton4 != null) {
                                                                                                                                i4 = R.id.settings_container;
                                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.settings_container);
                                                                                                                                if (linearLayout4 != null) {
                                                                                                                                    i4 = R.id.setup_elements;
                                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.setup_elements);
                                                                                                                                    if (linearLayout5 != null) {
                                                                                                                                        i4 = R.id.setup_required_container;
                                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.setup_required_container);
                                                                                                                                        if (linearLayout6 != null) {
                                                                                                                                            i4 = R.id.subscribe_button;
                                                                                                                                            MaterialButton materialButton5 = (MaterialButton) ViewBindings.findChildViewById(view, R.id.subscribe_button);
                                                                                                                                            if (materialButton5 != null) {
                                                                                                                                                i4 = R.id.subscribe_buttons_container;
                                                                                                                                                LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.subscribe_buttons_container);
                                                                                                                                                if (linearLayout7 != null) {
                                                                                                                                                    i4 = R.id.subscribe_heading;
                                                                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.subscribe_heading);
                                                                                                                                                    if (textView11 != null) {
                                                                                                                                                        i4 = R.id.subscribe_text;
                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, R.id.subscribe_text);
                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                            i4 = R.id.support_title;
                                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, R.id.support_title);
                                                                                                                                                            if (textView13 != null) {
                                                                                                                                                                i4 = R.id.telegram_container;
                                                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.telegram_container);
                                                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                                                    i4 = R.id.telegram_link;
                                                                                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, R.id.telegram_link);
                                                                                                                                                                    if (textView14 != null) {
                                                                                                                                                                        i4 = R.id.title;
                                                                                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                                                                                                                                                        if (textView15 != null) {
                                                                                                                                                                            i4 = R.id.titleText;
                                                                                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view, R.id.titleText);
                                                                                                                                                                            if (textView16 != null) {
                                                                                                                                                                                i4 = R.id.toolbar;
                                                                                                                                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                                                                                                                                if (toolbar != null) {
                                                                                                                                                                                    i4 = R.id.update_available_container;
                                                                                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.update_available_container);
                                                                                                                                                                                    if (linearLayout9 != null) {
                                                                                                                                                                                        i4 = R.id.update_available_description;
                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, R.id.update_available_description);
                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                            i4 = R.id.update_version;
                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, R.id.update_version);
                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                i4 = R.id.validating_purchase_container;
                                                                                                                                                                                                FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.validating_purchase_container);
                                                                                                                                                                                                if (frameLayout4 != null) {
                                                                                                                                                                                                    i4 = R.id.validating_purchase_text;
                                                                                                                                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(view, R.id.validating_purchase_text);
                                                                                                                                                                                                    if (textView19 != null) {
                                                                                                                                                                                                        i4 = R.id.validation_failed_indicator;
                                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.validation_failed_indicator);
                                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                                            i4 = R.id.version;
                                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(view, R.id.version);
                                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                                i4 = R.id.view_flipper;
                                                                                                                                                                                                                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.view_flipper);
                                                                                                                                                                                                                if (viewFlipper != null) {
                                                                                                                                                                                                                    i4 = R.id.weeklySubscriptionOption;
                                                                                                                                                                                                                    SubscriptionOptionView subscriptionOptionView2 = (SubscriptionOptionView) ViewBindings.findChildViewById(view, R.id.weeklySubscriptionOption);
                                                                                                                                                                                                                    if (subscriptionOptionView2 != null) {
                                                                                                                                                                                                                        i4 = R.id.whatsapp_container;
                                                                                                                                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.whatsapp_container);
                                                                                                                                                                                                                        if (linearLayout11 != null) {
                                                                                                                                                                                                                            i4 = R.id.whatsapp_link;
                                                                                                                                                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(view, R.id.whatsapp_link);
                                                                                                                                                                                                                            if (textView21 != null) {
                                                                                                                                                                                                                                i4 = R.id.yearlySubscriptionOption;
                                                                                                                                                                                                                                SubscriptionOptionView subscriptionOptionView3 = (SubscriptionOptionView) ViewBindings.findChildViewById(view, R.id.yearlySubscriptionOption);
                                                                                                                                                                                                                                if (subscriptionOptionView3 != null) {
                                                                                                                                                                                                                                    return new ActivityStopclubBinding((LinearLayout) view, textView, frameLayout, findChildViewById, findChildViewById2, textView2, textView3, textView4, linearLayout, linearLayout2, shapeableImageView, expandableLayout, frameLayout2, imageView, imageView2, textView5, textView6, materialButton, frameLayout3, textView7, linearLayout3, textView8, materialButton2, subscriptionOptionView, switchCompat, textView9, materialButton3, button, textView10, scrollView, materialButton4, linearLayout4, linearLayout5, linearLayout6, materialButton5, linearLayout7, textView11, textView12, textView13, linearLayout8, textView14, textView15, textView16, toolbar, linearLayout9, textView17, textView18, frameLayout4, textView19, linearLayout10, textView20, viewFlipper, subscriptionOptionView2, linearLayout11, textView21, subscriptionOptionView3);
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
    public static ActivityStopclubBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityStopclubBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_stopclub, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10966a;
    }
}
