package com.arlosoft.macrodroid.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppPreferences.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class AppPreferences {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f13391a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f13392b;

    @Inject
    public AppPreferences(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f13391a = context;
        this.f13392b = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public final boolean getAutoTranslateTemplates() {
        return this.f13392b.getBoolean(AppPreferencesKt.PREF_AUTO_TRANSLATE_TEMPLATES, true);
    }

    @NotNull
    public final Context getContext() {
        return this.f13391a;
    }

    public final void setAutoTranslateTemplates(boolean z3) {
        this.f13392b.edit().putBoolean(AppPreferencesKt.PREF_AUTO_TRANSLATE_TEMPLATES, z3).apply();
    }
}
