package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ActivityAddDaysBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10933a;
    @NonNull
    public final MaterialCardView anonymousDataEnabledCard;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final ImageButton backButton;
    @NonNull
    public final TextView currentlySharingText;
    @NonNull
    public final MaterialCardView dataSharingCard;
    @NonNull
    public final TextView dataSharingInformation;
    @NonNull
    public final TextView dataSharingTitle;
    @NonNull
    public final Button disableDataSharingButton;
    @NonNull
    public final TextView freeUsageInfoText;
    @NonNull
    public final ProgressBar loadAdvertSpinner;
    @NonNull
    public final TextView rewardAdvertDescription;
    @NonNull
    public final MaterialCardView rewardAdvertsCard;
    @NonNull
    public final Button shareDataButton;
    @NonNull
    public final MaterialCardView surveysCard;
    @NonNull
    public final TextView surveysDescription;
    @NonNull
    public final Button takeSurveyButton;
    @NonNull
    public final ProgressBar takeSurveySpinner;
    @NonNull
    public final TextView title;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final LinearLayout topLevelContainer;
    @NonNull
    public final Button upgradeToProButton;
    @NonNull
    public final MaterialCardView upgradeToProCard;
    @NonNull
    public final Button watchAdvertButton;
    @NonNull
    public final TextView whatDataIsShared;

    private ActivityAddDaysBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialCardView materialCardView, @NonNull AppBarLayout appBarLayout, @NonNull ImageButton imageButton, @NonNull TextView textView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull Button button, @NonNull TextView textView4, @NonNull ProgressBar progressBar, @NonNull TextView textView5, @NonNull MaterialCardView materialCardView3, @NonNull Button button2, @NonNull MaterialCardView materialCardView4, @NonNull TextView textView6, @NonNull Button button3, @NonNull ProgressBar progressBar2, @NonNull TextView textView7, @NonNull Toolbar toolbar, @NonNull LinearLayout linearLayout2, @NonNull Button button4, @NonNull MaterialCardView materialCardView5, @NonNull Button button5, @NonNull TextView textView8) {
        this.f10933a = linearLayout;
        this.anonymousDataEnabledCard = materialCardView;
        this.appBarLayout = appBarLayout;
        this.backButton = imageButton;
        this.currentlySharingText = textView;
        this.dataSharingCard = materialCardView2;
        this.dataSharingInformation = textView2;
        this.dataSharingTitle = textView3;
        this.disableDataSharingButton = button;
        this.freeUsageInfoText = textView4;
        this.loadAdvertSpinner = progressBar;
        this.rewardAdvertDescription = textView5;
        this.rewardAdvertsCard = materialCardView3;
        this.shareDataButton = button2;
        this.surveysCard = materialCardView4;
        this.surveysDescription = textView6;
        this.takeSurveyButton = button3;
        this.takeSurveySpinner = progressBar2;
        this.title = textView7;
        this.toolbar = toolbar;
        this.topLevelContainer = linearLayout2;
        this.upgradeToProButton = button4;
        this.upgradeToProCard = materialCardView5;
        this.watchAdvertButton = button5;
        this.whatDataIsShared = textView8;
    }

    @NonNull
    public static ActivityAddDaysBinding bind(@NonNull View view) {
        int i4 = R.id.anonymous_data_enabled_card;
        MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.anonymous_data_enabled_card);
        if (materialCardView != null) {
            i4 = R.id.appBarLayout;
            AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
            if (appBarLayout != null) {
                i4 = R.id.backButton;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.backButton);
                if (imageButton != null) {
                    i4 = R.id.currently_sharing_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.currently_sharing_text);
                    if (textView != null) {
                        i4 = R.id.data_sharing_card;
                        MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.data_sharing_card);
                        if (materialCardView2 != null) {
                            i4 = R.id.data_sharing_information;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.data_sharing_information);
                            if (textView2 != null) {
                                i4 = R.id.data_sharing_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.data_sharing_title);
                                if (textView3 != null) {
                                    i4 = R.id.disable_data_sharing_button;
                                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.disable_data_sharing_button);
                                    if (button != null) {
                                        i4 = R.id.free_usage_info_text;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.free_usage_info_text);
                                        if (textView4 != null) {
                                            i4 = R.id.load_advert_spinner;
                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.load_advert_spinner);
                                            if (progressBar != null) {
                                                i4 = R.id.reward_advert_description;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.reward_advert_description);
                                                if (textView5 != null) {
                                                    i4 = R.id.reward_adverts_card;
                                                    MaterialCardView materialCardView3 = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.reward_adverts_card);
                                                    if (materialCardView3 != null) {
                                                        i4 = R.id.share_data_button;
                                                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.share_data_button);
                                                        if (button2 != null) {
                                                            i4 = R.id.surveys_card;
                                                            MaterialCardView materialCardView4 = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.surveys_card);
                                                            if (materialCardView4 != null) {
                                                                i4 = R.id.surveys_description;
                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.surveys_description);
                                                                if (textView6 != null) {
                                                                    i4 = R.id.take_survey_button;
                                                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.take_survey_button);
                                                                    if (button3 != null) {
                                                                        i4 = R.id.take_survey_spinner;
                                                                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.take_survey_spinner);
                                                                        if (progressBar2 != null) {
                                                                            i4 = R.id.title;
                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                                                            if (textView7 != null) {
                                                                                i4 = R.id.toolbar;
                                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                                if (toolbar != null) {
                                                                                    LinearLayout linearLayout = (LinearLayout) view;
                                                                                    i4 = R.id.upgrade_to_pro_button;
                                                                                    Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.upgrade_to_pro_button);
                                                                                    if (button4 != null) {
                                                                                        i4 = R.id.upgrade_to_pro_card;
                                                                                        MaterialCardView materialCardView5 = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.upgrade_to_pro_card);
                                                                                        if (materialCardView5 != null) {
                                                                                            i4 = R.id.watch_advert_button;
                                                                                            Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.watch_advert_button);
                                                                                            if (button5 != null) {
                                                                                                i4 = R.id.what_data_is_shared;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.what_data_is_shared);
                                                                                                if (textView8 != null) {
                                                                                                    return new ActivityAddDaysBinding(linearLayout, materialCardView, appBarLayout, imageButton, textView, materialCardView2, textView2, textView3, button, textView4, progressBar, textView5, materialCardView3, button2, materialCardView4, textView6, button3, progressBar2, textView7, toolbar, linearLayout, button4, materialCardView5, button5, textView8);
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
    public static ActivityAddDaysBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityAddDaysBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_add_days, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10933a;
    }
}
