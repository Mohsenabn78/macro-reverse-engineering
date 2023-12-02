package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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
public final class ItemTemplateMacroBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11281a;
    @NonNull
    public final TextView actions;
    @NonNull
    public final LinearLayout actionsContainer;
    @NonNull
    public final View actionsDivider;
    @NonNull
    public final TextView actionsLabel;
    @NonNull
    public final AvatarView avatarImage;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final TextView commentCount;
    @NonNull
    public final FrameLayout commentsButton;
    @NonNull
    public final TextView constraints;
    @NonNull
    public final LinearLayout constraintsContainer;
    @NonNull
    public final View constraintsDivider;
    @NonNull
    public final TextView constraintsLabel;
    @NonNull
    public final TextView description;
    @NonNull
    public final ImageView expandAndMenuButton;
    @NonNull
    public final ImageView flagIcon;
    @NonNull
    public final LinearLayout layoutRoot;
    @NonNull
    public final LinearLayout macroConfigContainer;
    @NonNull
    public final TextView name;
    @NonNull
    public final TextView reportCount;
    @NonNull
    public final ImageView reportsIcon;
    @NonNull
    public final FrameLayout reportsPanel;
    @NonNull
    public final TextView rootOnlyLabel;
    @NonNull
    public final FrameLayout starButton;
    @NonNull
    public final SparkButton2 starIcon;
    @NonNull
    public final TextView starRating;
    @NonNull
    public final ImageView subscribeButton;
    @NonNull
    public final ProgressBar subscribingProgress;
    @NonNull
    public final LinearLayout templateRowBottomBar;
    @NonNull
    public final LinearLayout templateTile;
    @NonNull
    public final TextView timeLabel;
    @NonNull
    public final View topDivider;
    @NonNull
    public final TextView triggers;
    @NonNull
    public final LinearLayout triggersContainer;
    @NonNull
    public final View triggersDivider;
    @NonNull
    public final TextView triggersLabel;
    @NonNull
    public final FrameLayout userContainer;
    @NonNull
    public final ImageView userSubscriptionIndicator;
    @NonNull
    public final TextView usernameEdit;

    private ItemTemplateMacroBinding(@NonNull CardView cardView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull TextView textView2, @NonNull AvatarView avatarView, @NonNull CardView cardView2, @NonNull TextView textView3, @NonNull FrameLayout frameLayout, @NonNull TextView textView4, @NonNull LinearLayout linearLayout2, @NonNull View view2, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull TextView textView7, @NonNull TextView textView8, @NonNull ImageView imageView3, @NonNull FrameLayout frameLayout2, @NonNull TextView textView9, @NonNull FrameLayout frameLayout3, @NonNull SparkButton2 sparkButton2, @NonNull TextView textView10, @NonNull ImageView imageView4, @NonNull ProgressBar progressBar, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull TextView textView11, @NonNull View view3, @NonNull TextView textView12, @NonNull LinearLayout linearLayout7, @NonNull View view4, @NonNull TextView textView13, @NonNull FrameLayout frameLayout4, @NonNull ImageView imageView5, @NonNull TextView textView14) {
        this.f11281a = cardView;
        this.actions = textView;
        this.actionsContainer = linearLayout;
        this.actionsDivider = view;
        this.actionsLabel = textView2;
        this.avatarImage = avatarView;
        this.cardView = cardView2;
        this.commentCount = textView3;
        this.commentsButton = frameLayout;
        this.constraints = textView4;
        this.constraintsContainer = linearLayout2;
        this.constraintsDivider = view2;
        this.constraintsLabel = textView5;
        this.description = textView6;
        this.expandAndMenuButton = imageView;
        this.flagIcon = imageView2;
        this.layoutRoot = linearLayout3;
        this.macroConfigContainer = linearLayout4;
        this.name = textView7;
        this.reportCount = textView8;
        this.reportsIcon = imageView3;
        this.reportsPanel = frameLayout2;
        this.rootOnlyLabel = textView9;
        this.starButton = frameLayout3;
        this.starIcon = sparkButton2;
        this.starRating = textView10;
        this.subscribeButton = imageView4;
        this.subscribingProgress = progressBar;
        this.templateRowBottomBar = linearLayout5;
        this.templateTile = linearLayout6;
        this.timeLabel = textView11;
        this.topDivider = view3;
        this.triggers = textView12;
        this.triggersContainer = linearLayout7;
        this.triggersDivider = view4;
        this.triggersLabel = textView13;
        this.userContainer = frameLayout4;
        this.userSubscriptionIndicator = imageView5;
        this.usernameEdit = textView14;
    }

    @NonNull
    public static ItemTemplateMacroBinding bind(@NonNull View view) {
        int i4 = R.id.actions;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.actions);
        if (textView != null) {
            i4 = R.id.actionsContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.actionsContainer);
            if (linearLayout != null) {
                i4 = R.id.actionsDivider;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.actionsDivider);
                if (findChildViewById != null) {
                    i4 = R.id.actionsLabel;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.actionsLabel);
                    if (textView2 != null) {
                        i4 = R.id.avatarImage;
                        AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.avatarImage);
                        if (avatarView != null) {
                            CardView cardView = (CardView) view;
                            i4 = R.id.commentCount;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.commentCount);
                            if (textView3 != null) {
                                i4 = R.id.commentsButton;
                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.commentsButton);
                                if (frameLayout != null) {
                                    i4 = R.id.constraints;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.constraints);
                                    if (textView4 != null) {
                                        i4 = R.id.constraintsContainer;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.constraintsContainer);
                                        if (linearLayout2 != null) {
                                            i4 = R.id.constraintsDivider;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.constraintsDivider);
                                            if (findChildViewById2 != null) {
                                                i4 = R.id.constraintsLabel;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.constraintsLabel);
                                                if (textView5 != null) {
                                                    i4 = R.id.description;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.description);
                                                    if (textView6 != null) {
                                                        i4 = R.id.expandAndMenuButton;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.expandAndMenuButton);
                                                        if (imageView != null) {
                                                            i4 = R.id.flagIcon;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.flagIcon);
                                                            if (imageView2 != null) {
                                                                i4 = R.id.layoutRoot;
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.layoutRoot);
                                                                if (linearLayout3 != null) {
                                                                    i4 = R.id.macroConfigContainer;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.macroConfigContainer);
                                                                    if (linearLayout4 != null) {
                                                                        i4 = R.id.name;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.name);
                                                                        if (textView7 != null) {
                                                                            i4 = R.id.reportCount;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.reportCount);
                                                                            if (textView8 != null) {
                                                                                i4 = R.id.reportsIcon;
                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.reportsIcon);
                                                                                if (imageView3 != null) {
                                                                                    i4 = R.id.reportsPanel;
                                                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.reportsPanel);
                                                                                    if (frameLayout2 != null) {
                                                                                        i4 = R.id.rootOnlyLabel;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, R.id.rootOnlyLabel);
                                                                                        if (textView9 != null) {
                                                                                            i4 = R.id.starButton;
                                                                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.starButton);
                                                                                            if (frameLayout3 != null) {
                                                                                                i4 = R.id.starIcon;
                                                                                                SparkButton2 sparkButton2 = (SparkButton2) ViewBindings.findChildViewById(view, R.id.starIcon);
                                                                                                if (sparkButton2 != null) {
                                                                                                    i4 = R.id.starRating;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, R.id.starRating);
                                                                                                    if (textView10 != null) {
                                                                                                        i4 = R.id.subscribeButton;
                                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.subscribeButton);
                                                                                                        if (imageView4 != null) {
                                                                                                            i4 = R.id.subscribingProgress;
                                                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.subscribingProgress);
                                                                                                            if (progressBar != null) {
                                                                                                                i4 = R.id.templateRowBottomBar;
                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.templateRowBottomBar);
                                                                                                                if (linearLayout5 != null) {
                                                                                                                    i4 = R.id.templateTile;
                                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.templateTile);
                                                                                                                    if (linearLayout6 != null) {
                                                                                                                        i4 = R.id.timeLabel;
                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, R.id.timeLabel);
                                                                                                                        if (textView11 != null) {
                                                                                                                            i4 = R.id.topDivider;
                                                                                                                            View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.topDivider);
                                                                                                                            if (findChildViewById3 != null) {
                                                                                                                                i4 = R.id.triggers;
                                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, R.id.triggers);
                                                                                                                                if (textView12 != null) {
                                                                                                                                    i4 = R.id.triggersContainer;
                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.triggersContainer);
                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                        i4 = R.id.triggersDivider;
                                                                                                                                        View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.triggersDivider);
                                                                                                                                        if (findChildViewById4 != null) {
                                                                                                                                            i4 = R.id.triggersLabel;
                                                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, R.id.triggersLabel);
                                                                                                                                            if (textView13 != null) {
                                                                                                                                                i4 = R.id.userContainer;
                                                                                                                                                FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.userContainer);
                                                                                                                                                if (frameLayout4 != null) {
                                                                                                                                                    i4 = R.id.userSubscriptionIndicator;
                                                                                                                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.userSubscriptionIndicator);
                                                                                                                                                    if (imageView5 != null) {
                                                                                                                                                        i4 = R.id.usernameEdit;
                                                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, R.id.usernameEdit);
                                                                                                                                                        if (textView14 != null) {
                                                                                                                                                            return new ItemTemplateMacroBinding(cardView, textView, linearLayout, findChildViewById, textView2, avatarView, cardView, textView3, frameLayout, textView4, linearLayout2, findChildViewById2, textView5, textView6, imageView, imageView2, linearLayout3, linearLayout4, textView7, textView8, imageView3, frameLayout2, textView9, frameLayout3, sparkButton2, textView10, imageView4, progressBar, linearLayout5, linearLayout6, textView11, findChildViewById3, textView12, linearLayout7, findChildViewById4, textView13, frameLayout4, imageView5, textView14);
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
    public static ItemTemplateMacroBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemTemplateMacroBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.item_template_macro, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11281a;
    }
}
