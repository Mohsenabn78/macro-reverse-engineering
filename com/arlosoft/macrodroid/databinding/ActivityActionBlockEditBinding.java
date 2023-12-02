package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.SelectableItemsRecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public final class ActivityActionBlockEditBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f10931a;
    @NonNull
    public final FloatingActionButton acceptButton;
    @NonNull
    public final ImageButton actionBack;
    @NonNull
    public final EditText actionBlockNameText;
    @NonNull
    public final LinearLayout actionLayout;
    @NonNull
    public final CardView actionsContainer;
    @NonNull
    public final SelectableItemsRecyclerView actionsList;
    @NonNull
    public final ImageButton addActionButton;
    @NonNull
    public final ImageButton addInputVariableButton;
    @NonNull
    public final ImageButton addLocalVariableButton;
    @NonNull
    public final ImageButton addOutputVariableButton;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final FrameLayout contentOverlay;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final AppCompatEditText description;
    @NonNull
    public final ExpandableLayout descriptionExpandable;
    @NonNull
    public final Button deviceButton;
    @NonNull
    public final ImageView dismissButton;
    @NonNull
    public final ConstraintLayout infoBarBg;
    @NonNull
    public final ImageButton inputCollapseExpandButton;
    @NonNull
    public final LinearLayout inputTopLevelLinearLayout;
    @NonNull
    public final TextView inputVariablesHeading;
    @NonNull
    public final CardView inputVarsContainer;
    @NonNull
    public final FrameLayout inputVarsContent;
    @NonNull
    public final RecyclerView inputVarsList;
    @NonNull
    public final ImageButton localCollapseExpandButton;
    @NonNull
    public final LinearLayout localTopLevelLinearLayout;
    @NonNull
    public final TextView localVariablesHeading;
    @NonNull
    public final CardView localVarsContainer;
    @NonNull
    public final FrameLayout localVarsContent;
    @NonNull
    public final RecyclerView localVarsList;
    @NonNull
    public final ImageView nearbyImage;
    @NonNull
    public final ExpandableLayout nearbySharePanel;
    @NonNull
    public final TextView noActionsText;
    @NonNull
    public final TextView noInputVarsText;
    @NonNull
    public final TextView noLocalVarsText;
    @NonNull
    public final TextView noOutputVarsText;
    @NonNull
    public final ImageButton outputCollapseExpandButton;
    @NonNull
    public final LinearLayout outputTopLevelLinearLayout;
    @NonNull
    public final TextView outputVariablesHeading;
    @NonNull
    public final CardView outputVarsContainer;
    @NonNull
    public final FrameLayout outputVarsContent;
    @NonNull
    public final RecyclerView outputVarsList;
    @NonNull
    public final ImageButton pasteActionButton;
    @NonNull
    public final ImageButton reorderActionsButton;
    @NonNull
    public final ProgressBar scanningSpinner;
    @NonNull
    public final NestedScrollView scrollView;
    @NonNull
    public final TextView shareNearbyText;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final LinearLayout topLayout;
    @NonNull
    public final LinearLayout topLevelLayout;

    private ActivityActionBlockEditBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull ImageButton imageButton, @NonNull EditText editText, @NonNull LinearLayout linearLayout, @NonNull CardView cardView, @NonNull SelectableItemsRecyclerView selectableItemsRecyclerView, @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton3, @NonNull ImageButton imageButton4, @NonNull ImageButton imageButton5, @NonNull AppBarLayout appBarLayout, @NonNull FrameLayout frameLayout, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull AppCompatEditText appCompatEditText, @NonNull ExpandableLayout expandableLayout, @NonNull Button button, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton6, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull CardView cardView2, @NonNull FrameLayout frameLayout2, @NonNull RecyclerView recyclerView, @NonNull ImageButton imageButton7, @NonNull LinearLayout linearLayout3, @NonNull TextView textView2, @NonNull CardView cardView3, @NonNull FrameLayout frameLayout3, @NonNull RecyclerView recyclerView2, @NonNull ImageView imageView2, @NonNull ExpandableLayout expandableLayout2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull ImageButton imageButton8, @NonNull LinearLayout linearLayout4, @NonNull TextView textView7, @NonNull CardView cardView4, @NonNull FrameLayout frameLayout4, @NonNull RecyclerView recyclerView3, @NonNull ImageButton imageButton9, @NonNull ImageButton imageButton10, @NonNull ProgressBar progressBar, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView8, @NonNull Toolbar toolbar, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6) {
        this.f10931a = coordinatorLayout;
        this.acceptButton = floatingActionButton;
        this.actionBack = imageButton;
        this.actionBlockNameText = editText;
        this.actionLayout = linearLayout;
        this.actionsContainer = cardView;
        this.actionsList = selectableItemsRecyclerView;
        this.addActionButton = imageButton2;
        this.addInputVariableButton = imageButton3;
        this.addLocalVariableButton = imageButton4;
        this.addOutputVariableButton = imageButton5;
        this.appBarLayout = appBarLayout;
        this.contentOverlay = frameLayout;
        this.coordinatorLayout = coordinatorLayout2;
        this.description = appCompatEditText;
        this.descriptionExpandable = expandableLayout;
        this.deviceButton = button;
        this.dismissButton = imageView;
        this.infoBarBg = constraintLayout;
        this.inputCollapseExpandButton = imageButton6;
        this.inputTopLevelLinearLayout = linearLayout2;
        this.inputVariablesHeading = textView;
        this.inputVarsContainer = cardView2;
        this.inputVarsContent = frameLayout2;
        this.inputVarsList = recyclerView;
        this.localCollapseExpandButton = imageButton7;
        this.localTopLevelLinearLayout = linearLayout3;
        this.localVariablesHeading = textView2;
        this.localVarsContainer = cardView3;
        this.localVarsContent = frameLayout3;
        this.localVarsList = recyclerView2;
        this.nearbyImage = imageView2;
        this.nearbySharePanel = expandableLayout2;
        this.noActionsText = textView3;
        this.noInputVarsText = textView4;
        this.noLocalVarsText = textView5;
        this.noOutputVarsText = textView6;
        this.outputCollapseExpandButton = imageButton8;
        this.outputTopLevelLinearLayout = linearLayout4;
        this.outputVariablesHeading = textView7;
        this.outputVarsContainer = cardView4;
        this.outputVarsContent = frameLayout4;
        this.outputVarsList = recyclerView3;
        this.pasteActionButton = imageButton9;
        this.reorderActionsButton = imageButton10;
        this.scanningSpinner = progressBar;
        this.scrollView = nestedScrollView;
        this.shareNearbyText = textView8;
        this.toolbar = toolbar;
        this.topLayout = linearLayout5;
        this.topLevelLayout = linearLayout6;
    }

    @NonNull
    public static ActivityActionBlockEditBinding bind(@NonNull View view) {
        int i4 = R.id.acceptButton;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.acceptButton);
        if (floatingActionButton != null) {
            i4 = R.id.actionBack;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.actionBack);
            if (imageButton != null) {
                i4 = R.id.actionBlockNameText;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.actionBlockNameText);
                if (editText != null) {
                    i4 = R.id.actionLayout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.actionLayout);
                    if (linearLayout != null) {
                        i4 = R.id.actionsContainer;
                        CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.actionsContainer);
                        if (cardView != null) {
                            i4 = R.id.actionsList;
                            SelectableItemsRecyclerView selectableItemsRecyclerView = (SelectableItemsRecyclerView) ViewBindings.findChildViewById(view, R.id.actionsList);
                            if (selectableItemsRecyclerView != null) {
                                i4 = R.id.addActionButton;
                                ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.addActionButton);
                                if (imageButton2 != null) {
                                    i4 = R.id.addInputVariableButton;
                                    ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.addInputVariableButton);
                                    if (imageButton3 != null) {
                                        i4 = R.id.addLocalVariableButton;
                                        ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, R.id.addLocalVariableButton);
                                        if (imageButton4 != null) {
                                            i4 = R.id.addOutputVariableButton;
                                            ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(view, R.id.addOutputVariableButton);
                                            if (imageButton5 != null) {
                                                i4 = R.id.appBarLayout;
                                                AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
                                                if (appBarLayout != null) {
                                                    i4 = R.id.content_overlay;
                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.content_overlay);
                                                    if (frameLayout != null) {
                                                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                                        i4 = R.id.description;
                                                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.description);
                                                        if (appCompatEditText != null) {
                                                            i4 = R.id.descriptionExpandable;
                                                            ExpandableLayout expandableLayout = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.descriptionExpandable);
                                                            if (expandableLayout != null) {
                                                                i4 = R.id.deviceButton;
                                                                Button button = (Button) ViewBindings.findChildViewById(view, R.id.deviceButton);
                                                                if (button != null) {
                                                                    i4 = R.id.dismissButton;
                                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.dismissButton);
                                                                    if (imageView != null) {
                                                                        i4 = R.id.infoBarBg;
                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.infoBarBg);
                                                                        if (constraintLayout != null) {
                                                                            i4 = R.id.inputCollapseExpandButton;
                                                                            ImageButton imageButton6 = (ImageButton) ViewBindings.findChildViewById(view, R.id.inputCollapseExpandButton);
                                                                            if (imageButton6 != null) {
                                                                                i4 = R.id.inputTopLevelLinearLayout;
                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.inputTopLevelLinearLayout);
                                                                                if (linearLayout2 != null) {
                                                                                    i4 = R.id.inputVariablesHeading;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.inputVariablesHeading);
                                                                                    if (textView != null) {
                                                                                        i4 = R.id.inputVarsContainer;
                                                                                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, R.id.inputVarsContainer);
                                                                                        if (cardView2 != null) {
                                                                                            i4 = R.id.inputVarsContent;
                                                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.inputVarsContent);
                                                                                            if (frameLayout2 != null) {
                                                                                                i4 = R.id.inputVarsList;
                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.inputVarsList);
                                                                                                if (recyclerView != null) {
                                                                                                    i4 = R.id.localCollapseExpandButton;
                                                                                                    ImageButton imageButton7 = (ImageButton) ViewBindings.findChildViewById(view, R.id.localCollapseExpandButton);
                                                                                                    if (imageButton7 != null) {
                                                                                                        i4 = R.id.localTopLevelLinearLayout;
                                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.localTopLevelLinearLayout);
                                                                                                        if (linearLayout3 != null) {
                                                                                                            i4 = R.id.localVariablesHeading;
                                                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.localVariablesHeading);
                                                                                                            if (textView2 != null) {
                                                                                                                i4 = R.id.localVarsContainer;
                                                                                                                CardView cardView3 = (CardView) ViewBindings.findChildViewById(view, R.id.localVarsContainer);
                                                                                                                if (cardView3 != null) {
                                                                                                                    i4 = R.id.localVarsContent;
                                                                                                                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.localVarsContent);
                                                                                                                    if (frameLayout3 != null) {
                                                                                                                        i4 = R.id.localVarsList;
                                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, R.id.localVarsList);
                                                                                                                        if (recyclerView2 != null) {
                                                                                                                            i4 = R.id.nearbyImage;
                                                                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.nearbyImage);
                                                                                                                            if (imageView2 != null) {
                                                                                                                                i4 = R.id.nearbySharePanel;
                                                                                                                                ExpandableLayout expandableLayout2 = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.nearbySharePanel);
                                                                                                                                if (expandableLayout2 != null) {
                                                                                                                                    i4 = R.id.noActionsText;
                                                                                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.noActionsText);
                                                                                                                                    if (textView3 != null) {
                                                                                                                                        i4 = R.id.noInputVarsText;
                                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.noInputVarsText);
                                                                                                                                        if (textView4 != null) {
                                                                                                                                            i4 = R.id.noLocalVarsText;
                                                                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.noLocalVarsText);
                                                                                                                                            if (textView5 != null) {
                                                                                                                                                i4 = R.id.noOutputVarsText;
                                                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.noOutputVarsText);
                                                                                                                                                if (textView6 != null) {
                                                                                                                                                    i4 = R.id.outputCollapseExpandButton;
                                                                                                                                                    ImageButton imageButton8 = (ImageButton) ViewBindings.findChildViewById(view, R.id.outputCollapseExpandButton);
                                                                                                                                                    if (imageButton8 != null) {
                                                                                                                                                        i4 = R.id.outputTopLevelLinearLayout;
                                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.outputTopLevelLinearLayout);
                                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                                            i4 = R.id.outputVariablesHeading;
                                                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.outputVariablesHeading);
                                                                                                                                                            if (textView7 != null) {
                                                                                                                                                                i4 = R.id.outputVarsContainer;
                                                                                                                                                                CardView cardView4 = (CardView) ViewBindings.findChildViewById(view, R.id.outputVarsContainer);
                                                                                                                                                                if (cardView4 != null) {
                                                                                                                                                                    i4 = R.id.outputVarsContent;
                                                                                                                                                                    FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.outputVarsContent);
                                                                                                                                                                    if (frameLayout4 != null) {
                                                                                                                                                                        i4 = R.id.outputVarsList;
                                                                                                                                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, R.id.outputVarsList);
                                                                                                                                                                        if (recyclerView3 != null) {
                                                                                                                                                                            i4 = R.id.pasteActionButton;
                                                                                                                                                                            ImageButton imageButton9 = (ImageButton) ViewBindings.findChildViewById(view, R.id.pasteActionButton);
                                                                                                                                                                            if (imageButton9 != null) {
                                                                                                                                                                                i4 = R.id.reorderActionsButton;
                                                                                                                                                                                ImageButton imageButton10 = (ImageButton) ViewBindings.findChildViewById(view, R.id.reorderActionsButton);
                                                                                                                                                                                if (imageButton10 != null) {
                                                                                                                                                                                    i4 = R.id.scanningSpinner;
                                                                                                                                                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.scanningSpinner);
                                                                                                                                                                                    if (progressBar != null) {
                                                                                                                                                                                        i4 = R.id.scrollView;
                                                                                                                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.scrollView);
                                                                                                                                                                                        if (nestedScrollView != null) {
                                                                                                                                                                                            i4 = R.id.shareNearbyText;
                                                                                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, R.id.shareNearbyText);
                                                                                                                                                                                            if (textView8 != null) {
                                                                                                                                                                                                i4 = R.id.toolbar;
                                                                                                                                                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                                                                                                                                                if (toolbar != null) {
                                                                                                                                                                                                    i4 = R.id.topLayout;
                                                                                                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.topLayout);
                                                                                                                                                                                                    if (linearLayout5 != null) {
                                                                                                                                                                                                        i4 = R.id.topLevelLayout;
                                                                                                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.topLevelLayout);
                                                                                                                                                                                                        if (linearLayout6 != null) {
                                                                                                                                                                                                            return new ActivityActionBlockEditBinding(coordinatorLayout, floatingActionButton, imageButton, editText, linearLayout, cardView, selectableItemsRecyclerView, imageButton2, imageButton3, imageButton4, imageButton5, appBarLayout, frameLayout, coordinatorLayout, appCompatEditText, expandableLayout, button, imageView, constraintLayout, imageButton6, linearLayout2, textView, cardView2, frameLayout2, recyclerView, imageButton7, linearLayout3, textView2, cardView3, frameLayout3, recyclerView2, imageView2, expandableLayout2, textView3, textView4, textView5, textView6, imageButton8, linearLayout4, textView7, cardView4, frameLayout4, recyclerView3, imageButton9, imageButton10, progressBar, nestedScrollView, textView8, toolbar, linearLayout5, linearLayout6);
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
    public static ActivityActionBlockEditBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityActionBlockEditBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_action_block_edit, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f10931a;
    }
}
