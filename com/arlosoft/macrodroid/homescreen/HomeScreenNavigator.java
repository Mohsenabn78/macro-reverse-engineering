package com.arlosoft.macrodroid.homescreen;

import android.view.View;
import org.jetbrains.annotations.NotNull;

/* compiled from: HomeScreenNavigator.kt */
/* loaded from: classes3.dex */
public interface HomeScreenNavigator {
    void showCategories();

    void showCellTowers();

    void showDrawerSettings();

    void showEditMacroScreen(int i4);

    void showFavouritesDialog(@NotNull View view, @NotNull View view2);

    void showGeofences();

    void showHome();

    void showMacroDroidModes();

    void showMacros();

    void showNotificationBarOptions();

    void showPlugins();

    void showQuickRunMacroDialog(@NotNull View view, @NotNull View view2);

    void showQuickSettingsConfig();

    void showSettings();

    void showTemplates();
}
