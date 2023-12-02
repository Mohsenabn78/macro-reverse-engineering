package com.arlosoft.macrodroid.app.di.modules;

import android.app.Application;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import dagger.Module;
import dagger.Provides;
import java.util.Collection;
import java.util.List;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: BillingModule.kt */
@Module
/* loaded from: classes3.dex */
public final class BillingModule {
    @NotNull
    public static final BillingModule INSTANCE = new BillingModule();

    private BillingModule() {
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final BillingDataSource provideBillingDataSource(@NotNull Application application, @NotNull PurchaseValidator purchaseValidator) {
        List listOf;
        List<String> listOf2;
        List<String> listOf3;
        List<String> plus;
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(purchaseValidator, "purchaseValidator");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{BillingModuleKt.SKU_PREMIUM_FLASH_SALE, BillingModuleKt.SKU_PREMIUM_FLASH_SALE_2, BillingModuleKt.SKU_PREMIUM_NEW, BillingModuleKt.SKU_PREMIUM_NEW_2, "com.arlosoft.macrodroid.pro"});
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{BillingModuleKt.SKU_DONATION_1, BillingModuleKt.SKU_DONATION_2, BillingModuleKt.SKU_DONATION_3});
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{BillingModuleKt.SKU_STOPCLUB_SUB, BillingModuleKt.SKU_STOPCLUB_SUB_NO_TRIAL, BillingModuleKt.SKU_STOPCLUB_SUB_MONTHLY, BillingModuleKt.SKU_STOPCLUB_SUB_MONTHLY_NO_TRIAL});
        BillingDataSource.Companion companion = BillingDataSource.Companion;
        GlobalScope globalScope = GlobalScope.INSTANCE;
        plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) listOf2);
        return companion.getInstance(application, globalScope, plus, listOf2, listOf3, purchaseValidator);
    }
}
