package com.android.billingclient.api;

import androidx.annotation.RecentlyNonNull;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: com.android.billingclient:billing-ktx@@5.2.0 */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001d\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a\u001d\u0010\u0015\u001a\u00020\u0016*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u001d\u0010\u0019\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u001bH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"acknowledgePurchase", "Lcom/android/billingclient/api/BillingResult;", "Lcom/android/billingclient/api/BillingClient;", "params", "Lcom/android/billingclient/api/AcknowledgePurchaseParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/AcknowledgePurchaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumePurchase", "Lcom/android/billingclient/api/ConsumeResult;", "Lcom/android/billingclient/api/ConsumeParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/ConsumeParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryProductDetails", "Lcom/android/billingclient/api/ProductDetailsResult;", "Lcom/android/billingclient/api/QueryProductDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryProductDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchaseHistory", "Lcom/android/billingclient/api/PurchaseHistoryResult;", "Lcom/android/billingclient/api/QueryPurchaseHistoryParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchaseHistoryParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "skuType", "", "(Lcom/android/billingclient/api/BillingClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryPurchasesAsync", "Lcom/android/billingclient/api/PurchasesResult;", "Lcom/android/billingclient/api/QueryPurchasesParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/QueryPurchasesParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySkuDetails", "Lcom/android/billingclient/api/SkuDetailsResult;", "Lcom/android/billingclient/api/SkuDetailsParams;", "(Lcom/android/billingclient/api/BillingClient;Lcom/android/billingclient/api/SkuDetailsParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BillingClientKotlinKt {
    @RecentlyNonNull
    @Nullable
    public static final Object acknowledgePurchase(@RecentlyNonNull BillingClient billingClient, @RecentlyNonNull AcknowledgePurchaseParams acknowledgePurchaseParams, @RecentlyNonNull Continuation<? super BillingResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.acknowledgePurchase(acknowledgePurchaseParams, new AcknowledgePurchaseResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$acknowledgePurchase$2
            @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
            public final void onAcknowledgePurchaseResponse(BillingResult it) {
                CompletableDeferred<BillingResult> completableDeferred = CompletableDeferred$default;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                completableDeferred.complete(it);
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNonNull
    @Nullable
    public static final Object consumePurchase(@RecentlyNonNull BillingClient billingClient, @RecentlyNonNull ConsumeParams consumeParams, @RecentlyNonNull Continuation<? super ConsumeResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.consumeAsync(consumeParams, new ConsumeResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$consumePurchase$2
            @Override // com.android.billingclient.api.ConsumeResponseListener
            public final void onConsumeResponse(BillingResult billingResult, String str) {
                Intrinsics.checkNotNullExpressionValue(billingResult, "billingResult");
                CompletableDeferred$default.complete(new ConsumeResult(billingResult, str));
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNonNull
    @Nullable
    public static final Object queryProductDetails(@RecentlyNonNull BillingClient billingClient, @RecentlyNonNull QueryProductDetailsParams queryProductDetailsParams, @RecentlyNonNull Continuation<? super ProductDetailsResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryProductDetailsAsync(queryProductDetailsParams, new ProductDetailsResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$queryProductDetails$2
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void onProductDetailsResponse(BillingResult billingResult, List<ProductDetails> list) {
                Intrinsics.checkNotNullExpressionValue(billingResult, "billingResult");
                CompletableDeferred$default.complete(new ProductDetailsResult(billingResult, list));
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNonNull
    @Nullable
    public static final Object queryPurchaseHistory(@RecentlyNonNull BillingClient billingClient, @RecentlyNonNull QueryPurchaseHistoryParams queryPurchaseHistoryParams, @RecentlyNonNull Continuation<? super PurchaseHistoryResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchaseHistoryAsync(queryPurchaseHistoryParams, new PurchaseHistoryResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$queryPurchaseHistory$4
            @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
            public final void onPurchaseHistoryResponse(BillingResult billingResult, @Nullable List<PurchaseHistoryRecord> list) {
                Intrinsics.checkNotNullExpressionValue(billingResult, "billingResult");
                CompletableDeferred$default.complete(new PurchaseHistoryResult(billingResult, list));
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNonNull
    @Nullable
    public static final Object queryPurchasesAsync(@RecentlyNonNull BillingClient billingClient, @RecentlyNonNull QueryPurchasesParams queryPurchasesParams, @RecentlyNonNull Continuation<? super PurchasesResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchasesAsync(queryPurchasesParams, new PurchasesResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$queryPurchasesAsync$4
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> purchases) {
                Intrinsics.checkNotNullExpressionValue(billingResult, "billingResult");
                Intrinsics.checkNotNullExpressionValue(purchases, "purchases");
                CompletableDeferred$default.complete(new PurchasesResult(billingResult, purchases));
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNonNull
    @Deprecated(message = "Use [BillingClient.queryProductDetails] instead")
    @Nullable
    public static final Object querySkuDetails(@RecentlyNonNull BillingClient billingClient, @RecentlyNonNull SkuDetailsParams skuDetailsParams, @RecentlyNonNull Continuation<? super SkuDetailsResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.querySkuDetailsAsync(skuDetailsParams, new SkuDetailsResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$querySkuDetails$2
            @Override // com.android.billingclient.api.SkuDetailsResponseListener
            public final void onSkuDetailsResponse(BillingResult billingResult, @Nullable List<SkuDetails> list) {
                Intrinsics.checkNotNullExpressionValue(billingResult, "billingResult");
                CompletableDeferred$default.complete(new SkuDetailsResult(billingResult, list));
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNonNull
    @Deprecated(message = "Use [BillingClient.queryPurchaseHistory(QueryPurchaseHistoryParams)] instead")
    @Nullable
    public static final Object queryPurchaseHistory(@RecentlyNonNull BillingClient billingClient, @RecentlyNonNull String str, @RecentlyNonNull Continuation<? super PurchaseHistoryResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchaseHistoryAsync(str, new PurchaseHistoryResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$queryPurchaseHistory$2
            @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
            public final void onPurchaseHistoryResponse(BillingResult billingResult, @Nullable List<PurchaseHistoryRecord> list) {
                Intrinsics.checkNotNullExpressionValue(billingResult, "billingResult");
                CompletableDeferred$default.complete(new PurchaseHistoryResult(billingResult, list));
            }
        });
        return CompletableDeferred$default.await(continuation);
    }

    @RecentlyNonNull
    @Deprecated(message = "Use [BillingClient.queryPurchasesAsync(QueryPurchasesParams)] instead")
    @Nullable
    public static final Object queryPurchasesAsync(@RecentlyNonNull BillingClient billingClient, @RecentlyNonNull String str, @RecentlyNonNull Continuation<? super PurchasesResult> continuation) {
        final CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        billingClient.queryPurchasesAsync(str, new PurchasesResponseListener() { // from class: com.android.billingclient.api.BillingClientKotlinKt$queryPurchasesAsync$2
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> purchases) {
                Intrinsics.checkNotNullExpressionValue(billingResult, "billingResult");
                Intrinsics.checkNotNullExpressionValue(purchases, "purchases");
                CompletableDeferred$default.complete(new PurchasesResult(billingResult, purchases));
            }
        });
        return CompletableDeferred$default.await(continuation);
    }
}
