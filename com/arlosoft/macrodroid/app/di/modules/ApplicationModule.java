package com.arlosoft.macrodroid.app.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.MacroStore;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ApplicationModule.kt */
@StabilityInferred(parameters = 0)
@Module
/* loaded from: classes3.dex */
public final class ApplicationModule {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MacroDroidApplication f9285a;

    public ApplicationModule(@NotNull MacroDroidApplication application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.f9285a = application;
    }

    @Provides
    @Singleton
    @NotNull
    public final ActionBlockStore provideActionBlockStore() {
        MacroStore macroStore = MacroStore.getInstance();
        Intrinsics.checkNotNullExpressionValue(macroStore, "getInstance()");
        return macroStore;
    }

    @Provides
    @Singleton
    @NotNull
    public final MacroDroidRoomDatabase provideRoomDatabase() {
        return MacroDroidApplication.Companion.getInstance().getRoomDatabase();
    }

    @Provides
    @Singleton
    @NotNull
    public final Application providesApplication() {
        return this.f9285a;
    }

    @Provides
    @NotNull
    @Singleton
    @ApplicationContext
    public final Context providesContext() {
        return this.f9285a;
    }

    @Provides
    @NotNull
    @Singleton
    @ApplicationContext
    public final Resources providesResources() {
        Resources resources = this.f9285a.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "application.resources");
        return resources;
    }
}
