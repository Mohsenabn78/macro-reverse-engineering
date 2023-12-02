package com.arlosoft.macrodroid.templatestore.ui.comments;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TemplateCommentsDataRepository.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class TemplateCommentsDataRepository {
    public static final int $stable = 8;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private MacroTemplate f13749a;

    @Nullable
    public final MacroTemplate getMacroTemplate() {
        return this.f13749a;
    }

    public final void setMacroTemplate(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        this.f13749a = macroTemplate;
    }
}
