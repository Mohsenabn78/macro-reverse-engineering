package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.navigation.NavigationView;

/* loaded from: classes3.dex */
public final class ActivityHomeScreenBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final DrawerLayout f10943a;
    @NonNull
    public final DrawerLayout drawerLayout;
    @NonNull
    public final FrameLayout forumButton;
    @NonNull
    public final FrameLayout importExportButton;
    @NonNull
    public final FrameLayout macroAddButton;
    @NonNull
    public final FrameLayout macroExamplesButton;
    @NonNull
    public final FrameLayout macroListButton;
    @NonNull
    public final TextView mainMacroListTitle;
    @NonNull
    public final Button mainUpgradeButton;
    @NonNull
    public final LinearLayout mainUpgradeContainer;
    @NonNull
    public final NavigationView navigationView;
    @NonNull
    public final FrameLayout settingsButton;
    @Nullable
    public final TableRow tableRow2;
    @NonNull
    public final Toolbar toolbar;

    private ActivityHomeScreenBinding(@NonNull DrawerLayout drawerLayout, @NonNull DrawerLayout drawerLayout2, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FrameLayout frameLayout4, @NonNull FrameLayout frameLayout5, @NonNull TextView textView, @NonNull Button button, @NonNull LinearLayout linearLayout, @NonNull NavigationView navigationView, @NonNull FrameLayout frameLayout6, @Nullable TableRow tableRow, @NonNull Toolbar toolbar) {
        this.f10943a = drawerLayout;
        this.drawerLayout = drawerLayout2;
        this.forumButton = frameLayout;
        this.importExportButton = frameLayout2;
        this.macroAddButton = frameLayout3;
        this.macroExamplesButton = frameLayout4;
        this.macroListButton = frameLayout5;
        this.mainMacroListTitle = textView;
        this.mainUpgradeButton = button;
        this.mainUpgradeContainer = linearLayout;
        this.navigationView = navigationView;
        this.settingsButton = frameLayout6;
        this.tableRow2 = tableRow;
        this.toolbar = toolbar;
    }

    @NonNull
    public static ActivityHomeScreenBinding bind(@NonNull View view) {
        DrawerLayout drawerLayout = (DrawerLayout) view;
        int i4 = R.id.forumButton;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.forumButton);
        if (frameLayout != null) {
            i4 = R.id.importExportButton;
            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.importExportButton);
            if (frameLayout2 != null) {
                i4 = R.id.macroAddButton;
                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.macroAddButton);
                if (frameLayout3 != null) {
                    i4 = R.id.macroExamplesButton;
                    FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.macroExamplesButton);
                    if (frameLayout4 != null) {
                        i4 = R.id.macroListButton;
                        FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.macroListButton);
                        if (frameLayout5 != null) {
                            i4 = R.id.main_macro_list_title;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.main_macro_list_title);
                            if (textView != null) {
                                i4 = R.id.main_upgrade_button;
                                Button button = (Button) ViewBindings.findChildViewById(view, R.id.main_upgrade_button);
                                if (button != null) {
                                    i4 = R.id.main_upgrade_container;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.main_upgrade_container);
                                    if (linearLayout != null) {
                                        i4 = R.id.navigation_view;
                                        NavigationView navigationView = (NavigationView) ViewBindings.findChildViewById(view, R.id.navigation_view);
                                        if (navigationView != null) {
                                            i4 = R.id.settingsButton;
                                            FrameLayout frameLayout6 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.settingsButton);
                                            if (frameLayout6 != null) {
                                                TableRow tableRow = (TableRow) ViewBindings.findChildViewById(view, R.id.tableRow2);
                                                i4 = R.id.toolbar;
                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                if (toolbar != null) {
                                                    return new ActivityHomeScreenBinding(drawerLayout, drawerLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4, frameLayout5, textView, button, linearLayout, navigationView, frameLayout6, tableRow, toolbar);
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
    public static ActivityHomeScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityHomeScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_home_screen, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public DrawerLayout getRoot() {
        return this.f10943a;
    }
}
