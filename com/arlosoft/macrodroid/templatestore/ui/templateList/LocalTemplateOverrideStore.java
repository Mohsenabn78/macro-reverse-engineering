package com.arlosoft.macrodroid.templatestore.ui.templateList;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import java.util.HashMap;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LocalTemplateOverrideStore.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class LocalTemplateOverrideStore {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<Integer, MacroTemplate> f13943a = new HashMap<>();

    public final void addLocalOverride(int i4, @NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        this.f13943a.put(Integer.valueOf(i4), macroTemplate);
    }

    public final void clearAll() {
        this.f13943a.clear();
    }

    @Nullable
    public final MacroTemplate getLocalOverride(int i4) {
        return this.f13943a.get(Integer.valueOf(i4));
    }
}
