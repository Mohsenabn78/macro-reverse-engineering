package com.arlosoft.macrodroid.categories;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Category.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class Category {
    public static final int $stable = 0;
    @NotNull
    public static final String CATEGORIES_KEY = "CategoryList";
    @NotNull
    public static final String CATEGORY_CACHE = "Categories";
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int color;
    private final boolean isExpanded;
    private final boolean isLocked;
    @NotNull
    private final String name;

    /* compiled from: Category.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Category(@NotNull String name, int i4, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.color = i4;
        this.isExpanded = z3;
        this.isLocked = z4;
    }

    public static /* synthetic */ Category copy$default(Category category, String str, int i4, boolean z3, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = category.name;
        }
        if ((i5 & 2) != 0) {
            i4 = category.color;
        }
        if ((i5 & 4) != 0) {
            z3 = category.isExpanded;
        }
        if ((i5 & 8) != 0) {
            z4 = category.isLocked;
        }
        return category.copy(str, i4, z3, z4);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.color;
    }

    public final boolean component3() {
        return this.isExpanded;
    }

    public final boolean component4() {
        return this.isLocked;
    }

    @NotNull
    public final Category copy(@NotNull String name, int i4, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new Category(name, i4, z3, z4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        if (Intrinsics.areEqual(this.name, category.name) && this.color == category.color && this.isExpanded == category.isExpanded && this.isLocked == category.isLocked) {
            return true;
        }
        return false;
    }

    public final int getColor() {
        return this.color;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.color) * 31;
        boolean z3 = this.isExpanded;
        int i4 = 1;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (hashCode + i5) * 31;
        boolean z4 = this.isLocked;
        if (!z4) {
            i4 = z4 ? 1 : 0;
        }
        return i6 + i4;
    }

    public final boolean isExpanded() {
        return this.isExpanded;
    }

    public final boolean isLocked() {
        return this.isLocked;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        int i4 = this.color;
        boolean z3 = this.isExpanded;
        boolean z4 = this.isLocked;
        return "Category(name=" + str + ", color=" + i4 + ", isExpanded=" + z3 + ", isLocked=" + z4 + ")";
    }
}
