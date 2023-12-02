package com.arlosoft.macrodroid.templatestore.model;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.f;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateCategory.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class TemplateCategory {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int id;
    @NotNull
    private final String name;

    /* compiled from: TemplateCategory.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ List getAllCategories$default(Companion companion, Context context, boolean z3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                z3 = true;
            }
            return companion.getAllCategories(context, z3);
        }

        @JvmStatic
        @NotNull
        public final List<TemplateCategory> getAllCategories(@NotNull Context context, boolean z3) {
            List listOf;
            List<TemplateCategory> sortedWith;
            Intrinsics.checkNotNullParameter(context, "context");
            String string = context.getString(R.string.all_categories);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.all_categories)");
            String string2 = context.getString(R.string.categories_auto_and_vehicles);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…gories_auto_and_vehicles)");
            String string3 = context.getString(R.string.categories_battery_saving);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…ategories_battery_saving)");
            String string4 = context.getString(R.string.categories_call_handling);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…categories_call_handling)");
            String string5 = context.getString(R.string.categories_communication);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri…categories_communication)");
            String string6 = context.getString(R.string.categories_device_config);
            Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri…categories_device_config)");
            String string7 = context.getString(R.string.categories_entertainment);
            Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.stri…categories_entertainment)");
            String string8 = context.getString(R.string.categories_games);
            Intrinsics.checkNotNullExpressionValue(string8, "context.getString(R.string.categories_games)");
            String string9 = context.getString(R.string.categories_health_and_fitness);
            Intrinsics.checkNotNullExpressionValue(string9, "context.getString(R.stri…ories_health_and_fitness)");
            String string10 = context.getString(R.string.categories_house_and_home);
            Intrinsics.checkNotNullExpressionValue(string10, "context.getString(R.stri…ategories_house_and_home)");
            String string11 = context.getString(R.string.categories_location_based);
            Intrinsics.checkNotNullExpressionValue(string11, "context.getString(R.stri…ategories_location_based)");
            String string12 = context.getString(R.string.categories_maps_and_navigation);
            Intrinsics.checkNotNullExpressionValue(string12, "context.getString(R.stri…ries_maps_and_navigation)");
            String string13 = context.getString(R.string.categories_music_and_audio);
            Intrinsics.checkNotNullExpressionValue(string13, "context.getString(R.stri…tegories_music_and_audio)");
            String string14 = context.getString(R.string.categories_news);
            Intrinsics.checkNotNullExpressionValue(string14, "context.getString(R.string.categories_news)");
            String string15 = context.getString(R.string.categories_notifications);
            Intrinsics.checkNotNullExpressionValue(string15, "context.getString(R.stri…categories_notifications)");
            String string16 = context.getString(R.string.categories_personalisation);
            Intrinsics.checkNotNullExpressionValue(string16, "context.getString(R.stri…tegories_personalisation)");
            String string17 = context.getString(R.string.categories_photography);
            Intrinsics.checkNotNullExpressionValue(string17, "context.getString(R.string.categories_photography)");
            String string18 = context.getString(R.string.categories_productivity);
            Intrinsics.checkNotNullExpressionValue(string18, "context.getString(R.stri….categories_productivity)");
            String string19 = context.getString(R.string.categories_security);
            Intrinsics.checkNotNullExpressionValue(string19, "context.getString(R.string.categories_security)");
            String string20 = context.getString(R.string.categories_shopping);
            Intrinsics.checkNotNullExpressionValue(string20, "context.getString(R.string.categories_shopping)");
            String string21 = context.getString(R.string.categories_social);
            Intrinsics.checkNotNullExpressionValue(string21, "context.getString(R.string.categories_social)");
            String string22 = context.getString(R.string.categories_sport);
            Intrinsics.checkNotNullExpressionValue(string22, "context.getString(R.string.categories_sport)");
            String string23 = context.getString(R.string.categories_utilities);
            Intrinsics.checkNotNullExpressionValue(string23, "context.getString(R.string.categories_utilities)");
            String string24 = context.getString(R.string.categories_video);
            Intrinsics.checkNotNullExpressionValue(string24, "context.getString(R.string.categories_video)");
            String string25 = context.getString(R.string.categories_weather);
            Intrinsics.checkNotNullExpressionValue(string25, "context.getString(R.string.categories_weather)");
            String string26 = context.getString(R.string.categories_miscellaneous);
            Intrinsics.checkNotNullExpressionValue(string26, "context.getString(R.stri…categories_miscellaneous)");
            String string27 = context.getString(R.string.categories_quick_setting_tiles);
            Intrinsics.checkNotNullExpressionValue(string27, "context.getString(R.stri…ries_quick_setting_tiles)");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new TemplateCategory[]{new TemplateCategory(string, 0), new TemplateCategory(string2, 1), new TemplateCategory(string3, 2), new TemplateCategory(string4, 3), new TemplateCategory(string5, 4), new TemplateCategory(string6, 5), new TemplateCategory(string7, 6), new TemplateCategory(string8, 7), new TemplateCategory(string9, 8), new TemplateCategory(string10, 9), new TemplateCategory(string11, 10), new TemplateCategory(string12, 11), new TemplateCategory(string13, 12), new TemplateCategory(string14, 13), new TemplateCategory(string15, 14), new TemplateCategory(string16, 15), new TemplateCategory(string17, 16), new TemplateCategory(string18, 17), new TemplateCategory(string19, 18), new TemplateCategory(string20, 19), new TemplateCategory(string21, 20), new TemplateCategory(string22, 21), new TemplateCategory(string23, 22), new TemplateCategory(string24, 23), new TemplateCategory(string25, 24), new TemplateCategory(string26, 25), new TemplateCategory(string27, 26)});
            if (!z3) {
                listOf = listOf.subList(1, listOf.size());
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(listOf, new Comparator() { // from class: com.arlosoft.macrodroid.templatestore.model.TemplateCategory$Companion$getAllCategories$$inlined$compareBy$1
                @Override // java.util.Comparator
                public final int compare(T t3, T t4) {
                    int compareValues;
                    compareValues = f.compareValues(((TemplateCategory) t3).getName(), ((TemplateCategory) t4).getName());
                    return compareValues;
                }
            });
            return sortedWith;
        }
    }

    public TemplateCategory(@NotNull String name, int i4) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.id = i4;
    }

    public static /* synthetic */ TemplateCategory copy$default(TemplateCategory templateCategory, String str, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = templateCategory.name;
        }
        if ((i5 & 2) != 0) {
            i4 = templateCategory.id;
        }
        return templateCategory.copy(str, i4);
    }

    @JvmStatic
    @NotNull
    public static final List<TemplateCategory> getAllCategories(@NotNull Context context, boolean z3) {
        return Companion.getAllCategories(context, z3);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.id;
    }

    @NotNull
    public final TemplateCategory copy(@NotNull String name, int i4) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new TemplateCategory(name, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TemplateCategory)) {
            return false;
        }
        TemplateCategory templateCategory = (TemplateCategory) obj;
        if (Intrinsics.areEqual(this.name, templateCategory.name) && this.id == templateCategory.id) {
            return true;
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.id;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        int i4 = this.id;
        return "TemplateCategory(name=" + str + ", id=" + i4 + ")";
    }
}
