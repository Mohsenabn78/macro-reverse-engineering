package com.arlosoft.macrodroid.app.di.modules;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.arlosoft.macrodroid.app.di.AppFragmentModule;
import com.arlosoft.macrodroid.app.di.annotations.ActivityContext;
import com.arlosoft.macrodroid.app.di.annotations.ActivityScope;
import com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider;
import dagger.Module;
import dagger.Provides;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityModule.kt */
@StabilityInferred(parameters = 0)
@Module(includes = {AppFragmentModule.class})
/* loaded from: classes3.dex */
public class ActivityModule {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f9277a;

    public ActivityModule(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f9277a = activity;
    }

    @ActivityScope
    @Provides
    @Nullable
    public final SearchTermProvider provideSearchTermProvider() {
        Activity activity = this.f9277a;
        if (activity instanceof SearchTermProvider) {
            return (SearchTermProvider) activity;
        }
        return null;
    }

    @ActivityScope
    @Provides
    @NotNull
    public final Activity providesActivity() {
        return this.f9277a;
    }

    @Provides
    @ActivityContext
    @NotNull
    @ActivityScope
    public final Context providesContext(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return activity;
    }

    @ActivityScope
    @Provides
    @NotNull
    public final FragmentManager providesFragmentManager() {
        Activity activity = this.f9277a;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity as FragmentActi…y).supportFragmentManager");
        return supportFragmentManager;
    }

    @ActivityScope
    @Provides
    @NotNull
    public final LayoutInflater providesLayoutInflater() {
        LayoutInflater layoutInflater = this.f9277a.getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "activity.layoutInflater");
        return layoutInflater;
    }

    @ActivityScope
    @Provides
    @NotNull
    public final Resources providesResources() {
        Resources resources = this.f9277a.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        return resources;
    }
}
