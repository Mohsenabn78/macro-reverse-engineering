package com.arlosoft.macrodroid.templatestore.reportmacro;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import javax.inject.Singleton;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReportMacroRepository.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class ReportMacroRepository {
    public static final int $stable = 8;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private MacroTemplate f13668a;

    @Nullable
    public final MacroTemplate getMacroTemplate() {
        return this.f13668a;
    }

    public final void setMacroTemplate(@Nullable MacroTemplate macroTemplate) {
        this.f13668a = macroTemplate;
    }
}
