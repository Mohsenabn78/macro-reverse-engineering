package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import io.github.rosemoe.sora.widget.CodeEditor;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public final class ActivityJavascriptActionConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f10947a;
    @NonNull
    public final Button addConsoleVariableButton;
    @NonNull
    public final Button addStringVariableButton;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final ImageButton backButton;
    @NonNull
    public final CodeEditor codeEditor;
    @NonNull
    public final LinearLayout consoleVariableLayout;
    @NonNull
    public final NDSpinner consoleVariableSpinner;
    @NonNull
    public final LinearLayout consoleVariableTopLevelLayout;
    @NonNull
    public final CoordinatorLayout editMacroContainer;
    @NonNull
    public final Spinner engineSpinner;
    @NonNull
    public final LinearLayout mainContent;
    @NonNull
    public final LinearLayout responseVariableLayout;
    @NonNull
    public final FloatingActionButton saveButton;
    @NonNull
    public final NDSpinner stringVariableSpinner;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final ExpandableLayout variablesExpandable;
    @NonNull
    public final LinearLayout variablesLayout;

    private ActivityJavascriptActionConfigureBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Button button, @NonNull Button button2, @NonNull AppBarLayout appBarLayout, @NonNull ImageButton imageButton, @NonNull CodeEditor codeEditor, @NonNull LinearLayout linearLayout, @NonNull NDSpinner nDSpinner, @NonNull LinearLayout linearLayout2, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull Spinner spinner, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull FloatingActionButton floatingActionButton, @NonNull NDSpinner nDSpinner2, @NonNull Toolbar toolbar, @NonNull ExpandableLayout expandableLayout, @NonNull LinearLayout linearLayout5) {
        this.f10947a = coordinatorLayout;
        this.addConsoleVariableButton = button;
        this.addStringVariableButton = button2;
        this.appBarLayout = appBarLayout;
        this.backButton = imageButton;
        this.codeEditor = codeEditor;
        this.consoleVariableLayout = linearLayout;
        this.consoleVariableSpinner = nDSpinner;
        this.consoleVariableTopLevelLayout = linearLayout2;
        this.editMacroContainer = coordinatorLayout2;
        this.engineSpinner = spinner;
        this.mainContent = linearLayout3;
        this.responseVariableLayout = linearLayout4;
        this.saveButton = floatingActionButton;
        this.stringVariableSpinner = nDSpinner2;
        this.toolbar = toolbar;
        this.variablesExpandable = expandableLayout;
        this.variablesLayout = linearLayout5;
    }

    @NonNull
    public static ActivityJavascriptActionConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.addConsoleVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addConsoleVariableButton);
        if (button != null) {
            i4 = R.id.addStringVariableButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.addStringVariableButton);
            if (button2 != null) {
                i4 = R.id.appBarLayout;
                AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
                if (appBarLayout != null) {
                    i4 = R.id.backButton;
                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.backButton);
                    if (imageButton != null) {
                        i4 = R.id.codeEditor;
                        CodeEditor codeEditor = (CodeEditor) ViewBindings.findChildViewById(view, R.id.codeEditor);
                        if (codeEditor != null) {
                            i4 = R.id.consoleVariableLayout;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.consoleVariableLayout);
                            if (linearLayout != null) {
                                i4 = R.id.consoleVariableSpinner;
                                NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.consoleVariableSpinner);
                                if (nDSpinner != null) {
                                    i4 = R.id.consoleVariableTopLevelLayout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.consoleVariableTopLevelLayout);
                                    if (linearLayout2 != null) {
                                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                                        i4 = R.id.engineSpinner;
                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.engineSpinner);
                                        if (spinner != null) {
                                            i4 = R.id.main_content;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.main_content);
                                            if (linearLayout3 != null) {
                                                i4 = R.id.responseVariableLayout;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.responseVariableLayout);
                                                if (linearLayout4 != null) {
                                                    i4 = R.id.save_button;
                                                    FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.save_button);
                                                    if (floatingActionButton != null) {
                                                        i4 = R.id.stringVariableSpinner;
                                                        NDSpinner nDSpinner2 = (NDSpinner) ViewBindings.findChildViewById(view, R.id.stringVariableSpinner);
                                                        if (nDSpinner2 != null) {
                                                            i4 = R.id.toolbar;
                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                            if (toolbar != null) {
                                                                i4 = R.id.variablesExpandable;
                                                                ExpandableLayout expandableLayout = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.variablesExpandable);
                                                                if (expandableLayout != null) {
                                                                    i4 = R.id.variablesLayout;
                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.variablesLayout);
                                                                    if (linearLayout5 != null) {
                                                                        return new ActivityJavascriptActionConfigureBinding(coordinatorLayout, button, button2, appBarLayout, imageButton, codeEditor, linearLayout, nDSpinner, linearLayout2, coordinatorLayout, spinner, linearLayout3, linearLayout4, floatingActionButton, nDSpinner2, toolbar, expandableLayout, linearLayout5);
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
    public static ActivityJavascriptActionConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityJavascriptActionConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_javascript_action_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f10947a;
    }
}
