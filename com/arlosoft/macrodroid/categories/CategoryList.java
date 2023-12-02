package com.arlosoft.macrodroid.categories;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.DontObfuscate;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CategoryList.kt */
@StabilityInferred(parameters = 0)
@DontObfuscate
/* loaded from: classes3.dex */
public final class CategoryList {
    public static final int $stable = 8;
    @Nullable
    private final List<Category> categories;

    public CategoryList(@Nullable List<Category> list) {
        this.categories = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryList copy$default(CategoryList categoryList, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = categoryList.categories;
        }
        return categoryList.copy(list);
    }

    @Nullable
    public final List<Category> component1() {
        return this.categories;
    }

    @NotNull
    public final CategoryList copy(@Nullable List<Category> list) {
        return new CategoryList(list);
    }

    public final void deleteCategory(@NotNull String name) {
        List<Category> list;
        Intrinsics.checkNotNullParameter(name, "name");
        Category categoryByName = getCategoryByName(name);
        if (categoryByName != null && (list = this.categories) != null) {
            list.remove(categoryByName);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof CategoryList) && Intrinsics.areEqual(this.categories, ((CategoryList) obj).categories)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<Category> getCategories() {
        return this.categories;
    }

    @Nullable
    public final Category getCategoryByName(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<Category> list = this.categories;
        if (list == null) {
            return null;
        }
        for (Category category : list) {
            if (Intrinsics.areEqual(category.getName(), name)) {
                return category;
            }
        }
        return null;
    }

    public int hashCode() {
        List<Category> list = this.categories;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void renameCategory(@NotNull String oldName, @NotNull String newName) {
        Intrinsics.checkNotNullParameter(oldName, "oldName");
        Intrinsics.checkNotNullParameter(newName, "newName");
        Category categoryByName = getCategoryByName(oldName);
        if (categoryByName != null) {
            Category category = new Category(newName, categoryByName.getColor(), categoryByName.isExpanded(), categoryByName.isLocked());
            List<Category> list = this.categories;
            if (list != null) {
                list.remove(categoryByName);
            }
            List<Category> list2 = this.categories;
            if (list2 != null) {
                list2.add(category);
            }
        }
    }

    public final void setCategory(@NotNull Category category) {
        Intrinsics.checkNotNullParameter(category, "category");
        List<Category> list = this.categories;
        if (list != null) {
            Iterator<Category> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Category next = it.next();
                if (Intrinsics.areEqual(category.getName(), next.getName())) {
                    this.categories.remove(next);
                    break;
                }
            }
        }
        List<Category> list2 = this.categories;
        if (list2 != null) {
            list2.add(category);
        }
    }

    @NotNull
    public String toString() {
        List<Category> list = this.categories;
        return "CategoryList(categories=" + list + ")";
    }
}
