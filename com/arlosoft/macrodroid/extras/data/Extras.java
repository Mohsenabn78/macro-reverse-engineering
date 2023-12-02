package com.arlosoft.macrodroid.extras.data;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.modules.BillingModuleKt;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Extras.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class Extras {
    public static final int $stable;
    @NotNull
    public static final Extras INSTANCE = new Extras();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f12009a;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{BillingModuleKt.SKU_STOPCLUB_SUB, BillingModuleKt.SKU_STOPCLUB_SUB_NO_TRIAL, BillingModuleKt.SKU_STOPCLUB_SUB_MONTHLY, BillingModuleKt.SKU_STOPCLUB_SUB_MONTHLY_NO_TRIAL});
        f12009a = listOf;
        $stable = 8;
    }

    private Extras() {
    }

    @NotNull
    public final List<String> getAllExtras() {
        return f12009a;
    }
}
