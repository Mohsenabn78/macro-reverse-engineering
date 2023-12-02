package com.arlosoft.macrodroid.categories;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.constraint.LogicConstraint;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.uchuhimo.collections.BiMap;
import com.uchuhimo.collections.BiMapsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CategoriesHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CategoriesHelper {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f9604a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final BiMap<String, Integer> f9605b;

    @Inject
    public CategoriesHelper(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9604a = context;
        this.f9605b = BiMapsKt.biMapOf(TuplesKt.to(context.getString(R.string.categories_auto_and_vehicles), 1), TuplesKt.to(context.getString(R.string.categories_battery_saving), 2), TuplesKt.to(context.getString(R.string.categories_call_handling), 3), TuplesKt.to(context.getString(R.string.categories_communication), 4), TuplesKt.to(context.getString(R.string.categories_device_config), 5), TuplesKt.to(context.getString(R.string.categories_entertainment), 6), TuplesKt.to(context.getString(R.string.categories_games), 7), TuplesKt.to(context.getString(R.string.categories_health_and_fitness), 8), TuplesKt.to(context.getString(R.string.categories_house_and_home), 9), TuplesKt.to(context.getString(R.string.categories_location_based), 10), TuplesKt.to(context.getString(R.string.categories_maps_and_navigation), 11), TuplesKt.to(context.getString(R.string.categories_music_and_audio), 12), TuplesKt.to(context.getString(R.string.categories_news), 13), TuplesKt.to(context.getString(R.string.categories_notifications), 14), TuplesKt.to(context.getString(R.string.categories_personalisation), 15), TuplesKt.to(context.getString(R.string.categories_photography), 16), TuplesKt.to(context.getString(R.string.categories_productivity), 17), TuplesKt.to(context.getString(R.string.categories_security), 18), TuplesKt.to(context.getString(R.string.categories_shopping), 19), TuplesKt.to(context.getString(R.string.categories_social), 20), TuplesKt.to(context.getString(R.string.categories_sport), 21), TuplesKt.to(context.getString(R.string.categories_utilities), 22), TuplesKt.to(context.getString(R.string.categories_video), 23), TuplesKt.to(context.getString(R.string.categories_weather), 24), TuplesKt.to(context.getString(R.string.categories_miscellaneous), 25), TuplesKt.to(context.getString(R.string.categories_quick_setting_tiles), 26));
    }

    private final void a(Constraint constraint, String str, String str2) {
        b(constraint, str, str2);
        if (constraint instanceof LogicConstraint) {
            for (Constraint lc : ((LogicConstraint) constraint).getConstraints()) {
                Intrinsics.checkNotNullExpressionValue(lc, "lc");
                a(lc, str, str2);
            }
        }
    }

    private final void b(SelectableItem selectableItem, String str, String str2) {
        if (selectableItem instanceof HasCategoryName) {
            HasCategoryName hasCategoryName = (HasCategoryName) selectableItem;
            if (Intrinsics.areEqual(str, hasCategoryName.getCategory())) {
                hasCategoryName.setCategory(str2);
            }
        }
    }

    public final int categoryIdFromName(@NotNull String categoryName) {
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        Integer num = this.f9605b.get(categoryName);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @NotNull
    public final String getCategoryNameFromId(int i4) {
        String str = this.f9605b.getInverse().get(Integer.valueOf(i4));
        if (str == null) {
            str = this.f9604a.getString(R.string.uncategorized);
        }
        Intrinsics.checkNotNullExpressionValue(str, "bimap.inverse[id] ?: con…g(R.string.uncategorized)");
        return str;
    }

    @NotNull
    public final Context getContext() {
        return this.f9604a;
    }

    public final void renameCategory(@NotNull Context context, @NotNull String oldCategoryName, @NotNull String newCategoryName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(oldCategoryName, "oldCategoryName");
        Intrinsics.checkNotNullParameter(newCategoryName, "newCategoryName");
        Util.getCategories(context).indexOf(oldCategoryName);
        boolean z3 = false;
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacrosWithActionBlocks(false)) {
            if (Intrinsics.areEqual(macro.getCategory(), oldCategoryName)) {
                macro.setCategory(newCategoryName);
                z3 = true;
            }
            Iterator<Action> it = macro.getActions().iterator();
            while (it.hasNext()) {
                Action action = it.next();
                Intrinsics.checkNotNullExpressionValue(action, "action");
                b(action, oldCategoryName, newCategoryName);
                for (Constraint constraint : action.getConstraints()) {
                    Intrinsics.checkNotNullExpressionValue(constraint, "constraint");
                    a(constraint, oldCategoryName, newCategoryName);
                }
            }
            for (Constraint constraint2 : macro.getConstraints()) {
                Intrinsics.checkNotNullExpressionValue(constraint2, "constraint");
                a(constraint2, oldCategoryName, newCategoryName);
            }
        }
        Cache cache = MacroDroidApplication.Companion.getInstance().getCache(Category.CATEGORY_CACHE);
        CategoryList categoryList = (CategoryList) cache.get(Category.CATEGORIES_KEY, CategoryList.class);
        if (categoryList != null) {
            categoryList.renameCategory(oldCategoryName, newCategoryName);
        } else {
            categoryList = new CategoryList(new ArrayList());
            categoryList.setCategory(new Category(newCategoryName, ContextCompat.getColor(context, R.color.default_macro_tile_color), true, false));
        }
        cache.put(Category.CATEGORIES_KEY, categoryList);
        List<String> categories = Util.getCategories(context);
        if (categories != null) {
            categories.remove(oldCategoryName);
            categories.add(newCategoryName);
            Settings.setCategories(context, categories);
        }
        if (z3) {
            MacroStore.getInstance().writeToJSON();
        }
    }
}
