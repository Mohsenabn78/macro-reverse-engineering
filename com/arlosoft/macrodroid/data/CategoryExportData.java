package com.arlosoft.macrodroid.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CategoryExportData.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class CategoryExportData {
    public static final int $stable = 8;
    private final int categoryExportVersion;
    @NotNull
    private final List<Macro> macros;
    @Nullable
    private final List<UserIconData> userIcons;

    /* JADX WARN: Multi-variable type inference failed */
    public CategoryExportData(int i4, @NotNull List<? extends Macro> macros, @Nullable List<? extends UserIconData> list) {
        Intrinsics.checkNotNullParameter(macros, "macros");
        this.categoryExportVersion = i4;
        this.macros = macros;
        this.userIcons = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryExportData copy$default(CategoryExportData categoryExportData, int i4, List list, List list2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = categoryExportData.categoryExportVersion;
        }
        if ((i5 & 2) != 0) {
            list = categoryExportData.macros;
        }
        if ((i5 & 4) != 0) {
            list2 = categoryExportData.userIcons;
        }
        return categoryExportData.copy(i4, list, list2);
    }

    public final int component1() {
        return this.categoryExportVersion;
    }

    @NotNull
    public final List<Macro> component2() {
        return this.macros;
    }

    @Nullable
    public final List<UserIconData> component3() {
        return this.userIcons;
    }

    @NotNull
    public final CategoryExportData copy(int i4, @NotNull List<? extends Macro> macros, @Nullable List<? extends UserIconData> list) {
        Intrinsics.checkNotNullParameter(macros, "macros");
        return new CategoryExportData(i4, macros, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryExportData)) {
            return false;
        }
        CategoryExportData categoryExportData = (CategoryExportData) obj;
        if (this.categoryExportVersion == categoryExportData.categoryExportVersion && Intrinsics.areEqual(this.macros, categoryExportData.macros) && Intrinsics.areEqual(this.userIcons, categoryExportData.userIcons)) {
            return true;
        }
        return false;
    }

    public final int getCategoryExportVersion() {
        return this.categoryExportVersion;
    }

    @NotNull
    public final List<Macro> getMacros() {
        return this.macros;
    }

    @Nullable
    public final List<UserIconData> getUserIcons() {
        return this.userIcons;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.categoryExportVersion * 31) + this.macros.hashCode()) * 31;
        List<UserIconData> list = this.userIcons;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        int i4 = this.categoryExportVersion;
        List<Macro> list = this.macros;
        List<UserIconData> list2 = this.userIcons;
        return "CategoryExportData(categoryExportVersion=" + i4 + ", macros=" + list + ", userIcons=" + list2 + ")";
    }

    public /* synthetic */ CategoryExportData(int i4, List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, list, (i5 & 4) != 0 ? null : list2);
    }
}
