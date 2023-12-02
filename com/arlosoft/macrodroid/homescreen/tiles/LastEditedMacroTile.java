package com.arlosoft.macrodroid.homescreen.tiles;

import android.app.Activity;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.categories.Category;
import com.arlosoft.macrodroid.categories.CategoryList;
import com.arlosoft.macrodroid.homescreen.HomeScreenNavigator;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.CategoryPasswordHelper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;

/* compiled from: LastEditedMacroTile.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LastEditedMacroTile extends HomeScreenTile {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f12483c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final HomeScreenNavigator f12484d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final String f12485e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12486f;

    /* renamed from: g  reason: collision with root package name */
    private final long f12487g;

    /* renamed from: h  reason: collision with root package name */
    private final int f12488h;

    public LastEditedMacroTile(@NotNull Activity activity, @NotNull HomeScreenNavigator homeScreenNavigator) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(homeScreenNavigator, "homeScreenNavigator");
        this.f12483c = activity;
        this.f12484d = homeScreenNavigator;
        String string = activity.getString(R.string.home_screen_tile_last_edited_macro);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str…n_tile_last_edited_macro)");
        this.f12485e = string;
        this.f12486f = R.drawable.ic_share_white_24dp;
        this.f12487g = 21L;
        this.f12488h = ContextCompat.getColor(activity, R.color.home_screen_tile_last_edited_macro);
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getBackgroundColor() {
        return this.f12488h;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public int getIconRes() {
        return this.f12486f;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public long getId() {
        return this.f12487g;
    }

    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    @NotNull
    public String getTitle() {
        return this.f12485e;
    }

    /* JADX WARN: Type inference failed for: r9v2, types: [com.arlosoft.macrodroid.macro.Macro, T] */
    /* JADX WARN: Type inference failed for: r9v4, types: [com.arlosoft.macrodroid.macro.Macro, T] */
    @Override // com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile
    public void onClick(@NotNull View view, @NotNull View iconView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(iconView, "iconView");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? macroByGUID = MacroStore.getInstance().getMacroByGUID(Settings.getLastOpenedMacroGuid(this.f12483c));
        objectRef.element = macroByGUID;
        if (macroByGUID == 0 || !macroByGUID.isCompleted()) {
            objectRef.element = MacroStore.getInstance().getMacroByGUID(Settings.getLastEditedMacroGuid(this.f12483c));
        }
        T t3 = objectRef.element;
        if (t3 != 0) {
            String categoryName = ((Macro) t3).getCategory();
            Cache cache = MacroDroidApplication.Companion.getInstance().getCache(Category.CATEGORY_CACHE);
            CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
            if (categoryList != null) {
                Intrinsics.checkNotNullExpressionValue(categoryName, "categoryName");
                Category categoryByName = categoryList.getCategoryByName(categoryName);
                if (categoryByName != null && categoryByName.isLocked()) {
                    CategoryPasswordHelper categoryPasswordHelper = new CategoryPasswordHelper(cache, null);
                    Activity activity = this.f12483c;
                    categoryPasswordHelper.promptForCategoryPassword(activity, activity.getString(R.string.enter_category_lock_password), categoryName, Settings.getLockedCategoryPassword(this.f12483c), 0, new CategoryPasswordHelper.PasswordListener() { // from class: com.arlosoft.macrodroid.homescreen.tiles.LastEditedMacroTile$onClick$1
                        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
                        public void passwordCorrect() {
                            HomeScreenNavigator homeScreenNavigator;
                            homeScreenNavigator = LastEditedMacroTile.this.f12484d;
                            homeScreenNavigator.showEditMacroScreen(objectRef.element.getId());
                        }

                        @Override // com.arlosoft.macrodroid.utils.CategoryPasswordHelper.PasswordListener
                        public void passwordCancelled() {
                        }
                    });
                    return;
                }
                this.f12484d.showEditMacroScreen(((Macro) objectRef.element).getId());
                return;
            }
            this.f12484d.showEditMacroScreen(((Macro) objectRef.element).getId());
            return;
        }
        ToastCompat.makeText(this.f12483c.getApplicationContext(), (int) R.string.last_edited_macro_unavailable, 1).show();
    }
}
