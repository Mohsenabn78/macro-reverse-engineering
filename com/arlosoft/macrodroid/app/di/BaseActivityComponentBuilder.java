package com.arlosoft.macrodroid.app.di;

import android.app.Activity;
import android.app.Application;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.di.modules.ActivityModule;
import dagger.android.AndroidInjector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: BaseActivityComponentBuilder.kt */
/* loaded from: classes3.dex */
public abstract class BaseActivityComponentBuilder<T extends Activity> extends AndroidInjector.Builder<T> {
    @NotNull
    public abstract BaseActivityComponentBuilder<T> activityModule(@NotNull ActivityModule activityModule);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dagger.android.AndroidInjector.Builder
    public /* bridge */ /* synthetic */ void seedInstance(Object obj) {
        seedInstance((BaseActivityComponentBuilder<T>) ((Activity) obj));
    }

    public void seedInstance(@NotNull T instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        Application application = instance.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.arlosoft.macrodroid.app.MacroDroidApplication");
        activityModule(((MacroDroidApplication) application).createActivityModule(instance));
    }
}
