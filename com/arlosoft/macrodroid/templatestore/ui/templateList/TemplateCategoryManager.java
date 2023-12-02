package com.arlosoft.macrodroid.templatestore.ui.templateList;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.annotations.ActivityScope;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateCategoryManager.kt */
@StabilityInferred(parameters = 0)
@ActivityScope
/* loaded from: classes3.dex */
public final class TemplateCategoryManager {
    public static final int $stable = 8;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Integer f13945a;

    /* renamed from: b  reason: collision with root package name */
    private int f13946b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<CategoryUpdatedListener> f13947c = new ArrayList<>();

    /* compiled from: TemplateCategoryManager.kt */
    /* loaded from: classes3.dex */
    public interface CategoryUpdatedListener {
        void categoryUpdated(int i4);
    }

    public final void addCategoryUpdatedListener(@NotNull CategoryUpdatedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f13947c.add(listener);
    }

    public final int getCategoryId() {
        return this.f13946b;
    }

    @Nullable
    public final Integer getLastChosenCategoryId() {
        return this.f13945a;
    }

    public final void removeCategoryUpdatedListener(@NotNull CategoryUpdatedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f13947c.remove(listener);
    }

    public final void setCategory(int i4) {
        this.f13946b = i4;
        Iterator<CategoryUpdatedListener> it = this.f13947c.iterator();
        while (it.hasNext()) {
            it.next().categoryUpdated(i4);
        }
    }

    public final void setLastChosenCategoryId(@Nullable Integer num) {
        this.f13945a = num;
    }
}
