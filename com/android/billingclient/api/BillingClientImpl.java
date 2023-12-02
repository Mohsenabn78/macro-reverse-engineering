package com.android.billingclient.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.core.app.BundleCompat;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.ktx.BuildConfig;
import com.google.android.gms.internal.play_billing.zzfl;
import com.google.android.gms.internal.play_billing.zzfm;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes2.dex */
public class BillingClientImpl extends BillingClient {
    private volatile int zza;
    private final String zzb;
    private final Handler zzc;
    private volatile zzo zzd;
    private Context zze;
    private volatile com.google.android.gms.internal.play_billing.zze zzf;
    private volatile zzap zzg;
    private boolean zzh;
    private boolean zzi;
    private int zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private ExecutorService zzy;
    private zzbh zzz;

    private BillingClientImpl(Activity activity, boolean z3, boolean z4, String str) {
        this(activity.getApplicationContext(), z3, z4, new zzat(), str, null, null);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, boolean z3, boolean z4, @Nullable AlternativeBillingListener alternativeBillingListener, String str) {
        boolean z5;
        this.zze = context.getApplicationContext();
        zzfl zzu = zzfm.zzu();
        zzu.zzj(str);
        zzu.zzi(this.zze.getPackageName());
        zzfm zzfmVar = (zzfm) zzu.zzc();
        this.zzz = new zzbh();
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzo(this.zze, purchasesUpdatedListener, alternativeBillingListener, this.zzz);
        this.zzv = z3;
        this.zzw = z4;
        if (alternativeBillingListener != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        this.zzx = z5;
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    @zzi
    private void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, long j4) {
        launchPriceChangeConfirmationFlow(activity, priceChangeFlowParams, new zzat(j4));
    }

    private void startConnection(long j4) {
        ServiceInfo serviceInfo;
        zzat zzatVar = new zzat(j4);
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Service connection is valid. No need to re-initialize.");
            zzatVar.onBillingSetupFinished(zzbc.zzl);
        } else if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Client is already in the process of connecting to billing service.");
            zzatVar.onBillingSetupFinished(zzbc.zzd);
        } else if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            zzatVar.onBillingSetupFinished(zzbc.zzm);
        } else {
            this.zza = 1;
            this.zzd.zze();
            com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Starting in-app billing setup.");
            this.zzg = new zzap(this, zzatVar, null);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if ("com.android.vending".equals(str) && str2 != null) {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzg, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Service was bonded successfully.");
                        return;
                    }
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Connection to Billing service is blocked.");
                } else {
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "The device doesn't have valid Play Store.");
                }
            }
            this.zza = 0;
            com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Billing service unavailable on device.");
            zzatVar.onBillingSetupFinished(zzbc.zzc);
        }
    }

    public final Handler zzH() {
        if (Looper.myLooper() == null) {
            return this.zzc;
        }
        return new Handler(Looper.myLooper());
    }

    private final BillingResult zzI(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzc.post(new Runnable() { // from class: com.android.billingclient.api.zzag
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.this.zzG(billingResult);
            }
        });
        return billingResult;
    }

    public final BillingResult zzJ() {
        if (this.zza != 0 && this.zza != 3) {
            return zzbc.zzj;
        }
        return zzbc.zzm;
    }

    @SuppressLint({"PrivateApi"})
    private static String zzK() {
        try {
            return (String) BuildConfig.class.getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return com.android.billingclient.BuildConfig.VERSION_NAME;
        }
    }

    @Nullable
    public final Future zzL(Callable callable, long j4, @Nullable final Runnable runnable, Handler handler) {
        if (this.zzy == null) {
            this.zzy = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzb.zza, new zzal(this));
        }
        try {
            final Future submit = this.zzy.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaf
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = submit;
                    Runnable runnable2 = runnable;
                    if (!future.isDone() && !future.isCancelled()) {
                        future.cancel(true);
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Async task is taking too long, cancel it!");
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                    }
                }
            }, (long) (j4 * 0.95d));
            return submit;
        } catch (Exception e4) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Async task throws exception!", e4);
            return null;
        }
    }

    private final void zzM(final BillingResult billingResult, final PriceChangeConfirmationListener priceChangeConfirmationListener) {
        if (Thread.interrupted()) {
            return;
        }
        this.zzc.post(new Runnable() { // from class: com.android.billingclient.api.zzx
            @Override // java.lang.Runnable
            public final void run() {
                PriceChangeConfirmationListener.this.onPriceChangeConfirmationResult(billingResult);
            }
        });
    }

    private final void zzN(String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzbc.zzm, null);
        } else if (zzL(new zzaj(this, str, purchaseHistoryResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzw
            @Override // java.lang.Runnable
            public final void run() {
                PurchaseHistoryResponseListener.this.onPurchaseHistoryResponse(zzbc.zzn, null);
            }
        }, zzH()) == null) {
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzJ(), null);
        }
    }

    private final void zzO(String str, final PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            purchasesResponseListener.onQueryPurchasesResponse(zzbc.zzm, com.google.android.gms.internal.play_billing.zzu.zzk());
        } else if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Please provide a valid product type.");
            purchasesResponseListener.onQueryPurchasesResponse(zzbc.zzg, com.google.android.gms.internal.play_billing.zzu.zzk());
        } else if (zzL(new zzai(this, str, purchasesResponseListener), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzad
            @Override // java.lang.Runnable
            public final void run() {
                PurchasesResponseListener.this.onQueryPurchasesResponse(zzbc.zzn, com.google.android.gms.internal.play_billing.zzu.zzk());
            }
        }, zzH()) == null) {
            purchasesResponseListener.onQueryPurchasesResponse(zzJ(), com.google.android.gms.internal.play_billing.zzu.zzk());
        }
    }

    private final boolean zzP() {
        if (this.zzu && this.zzw) {
            return true;
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ zzas zzg(BillingClientImpl billingClientImpl, String str) {
        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzc = com.google.android.gms.internal.play_billing.zzb.zzc(billingClientImpl.zzm, billingClientImpl.zzu, billingClientImpl.zzv, billingClientImpl.zzw, billingClientImpl.zzb);
        String str2 = null;
        while (billingClientImpl.zzk) {
            try {
                Bundle zzh = billingClientImpl.zzf.zzh(6, billingClientImpl.zze.getPackageName(), str, str2, zzc);
                BillingResult zza = zzbl.zza(zzh, "BillingClient", "getPurchaseHistory()");
                if (zza != zzbc.zzl) {
                    return new zzas(zza, null);
                }
                ArrayList<String> stringArrayList = zzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i4 = 0; i4 < stringArrayList2.size(); i4++) {
                    String str3 = stringArrayList2.get(i4);
                    String str4 = stringArrayList3.get(i4);
                    com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i4))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str3, str4);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchaseHistoryRecord);
                    } catch (JSONException e4) {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got an exception trying to decode the purchase!", e4);
                        return new zzas(zzbc.zzj, null);
                    }
                }
                str2 = zzh.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    return new zzas(zzbc.zzl, arrayList);
                }
            } catch (RemoteException e5) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got exception trying to get purchase history, try to reconnect", e5);
                return new zzas(zzbc.zzm, null);
            }
        }
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzas(zzbc.zzq, null);
    }

    public static /* bridge */ /* synthetic */ zzbk zzi(BillingClientImpl billingClientImpl, String str) {
        Bundle zzi;
        int i4;
        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Bundle zzc = com.google.android.gms.internal.play_billing.zzb.zzc(billingClientImpl.zzm, billingClientImpl.zzu, billingClientImpl.zzv, billingClientImpl.zzw, billingClientImpl.zzb);
        String str2 = null;
        do {
            try {
                if (billingClientImpl.zzm) {
                    com.google.android.gms.internal.play_billing.zze zzeVar = billingClientImpl.zzf;
                    if (true != billingClientImpl.zzu) {
                        i4 = 9;
                    } else {
                        i4 = 19;
                    }
                    zzi = zzeVar.zzj(i4, billingClientImpl.zze.getPackageName(), str, str2, zzc);
                } else {
                    zzi = billingClientImpl.zzf.zzi(3, billingClientImpl.zze.getPackageName(), str, str2);
                }
                BillingResult zza = zzbl.zza(zzi, "BillingClient", "getPurchase()");
                if (zza != zzbc.zzl) {
                    return new zzbk(zza, null);
                }
                ArrayList<String> stringArrayList = zzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                for (int i5 = 0; i5 < stringArrayList2.size(); i5++) {
                    String str3 = stringArrayList2.get(i5);
                    String str4 = stringArrayList3.get(i5);
                    com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i5))));
                    try {
                        Purchase purchase = new Purchase(str3, str4);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "BUG: empty/null token!");
                        }
                        arrayList.add(purchase);
                    } catch (JSONException e4) {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got an exception trying to decode the purchase!", e4);
                        return new zzbk(zzbc.zzj, null);
                    }
                }
                str2 = zzi.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
            } catch (Exception e5) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got exception trying to get purchasesm try to reconnect", e5);
                return new zzbk(zzbc.zzm, null);
            }
        } while (!TextUtils.isEmpty(str2));
        return new zzbk(zzbc.zzl, arrayList);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbc.zzm);
        } else if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Please provide a valid purchase token.");
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbc.zzi);
        } else if (!this.zzm) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbc.zzb);
        } else if (zzL(new Callable() { // from class: com.android.billingclient.api.zzz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzk(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzaa
            @Override // java.lang.Runnable
            public final void run() {
                AcknowledgePurchaseResponseListener.this.onAcknowledgePurchaseResponse(zzbc.zzn);
            }
        }, zzH()) == null) {
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzJ());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            consumeResponseListener.onConsumeResponse(zzbc.zzm, consumeParams.getPurchaseToken());
        } else if (zzL(new Callable() { // from class: com.android.billingclient.api.zzu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzl(consumeParams, consumeResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzv
            @Override // java.lang.Runnable
            public final void run() {
                ConsumeResponseListener.this.onConsumeResponse(zzbc.zzn, consumeParams.getPurchaseToken());
            }
        }, zzH()) == null) {
            consumeResponseListener.onConsumeResponse(zzJ(), consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void endConnection() {
        try {
            this.zzd.zzd();
            if (this.zzg != null) {
                this.zzg.zzc();
            }
            if (this.zzg != null && this.zzf != null) {
                com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Unbinding from service.");
                this.zze.unbindService(this.zzg);
                this.zzg = null;
            }
            this.zzf = null;
            ExecutorService executorService = this.zzy;
            if (executorService != null) {
                executorService.shutdownNow();
                this.zzy = null;
            }
        } catch (Exception e4) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "There was an exception while ending connection!", e4);
        } finally {
            this.zza = 3;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        return this.zza;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        char c4;
        if (!isReady()) {
            return zzbc.zzm;
        }
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 96321:
                if (str.equals("aaa")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 97314:
                if (str.equals(BillingClient.FeatureType.IN_APP_MESSAGING)) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case 98307:
                if (str.equals("ccc")) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case 99300:
                if (str.equals("ddd")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case 100293:
                if (str.equals("eee")) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case 101286:
                if (str.equals(BillingClient.FeatureType.PRODUCT_DETAILS)) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            case 102279:
                if (str.equals("ggg")) {
                    c4 = '\t';
                    break;
                }
                c4 = 65535;
                break;
            case 103272:
                if (str.equals("hhh")) {
                    c4 = '\n';
                    break;
                }
                c4 = 65535;
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
                if (this.zzh) {
                    return zzbc.zzl;
                }
                return zzbc.zzo;
            case 1:
                if (this.zzi) {
                    return zzbc.zzl;
                }
                return zzbc.zzp;
            case 2:
                if (this.zzl) {
                    return zzbc.zzl;
                }
                return zzbc.zzr;
            case 3:
                if (this.zzo) {
                    return zzbc.zzl;
                }
                return zzbc.zzw;
            case 4:
                if (this.zzq) {
                    return zzbc.zzl;
                }
                return zzbc.zzs;
            case 5:
                if (this.zzp) {
                    return zzbc.zzl;
                }
                return zzbc.zzu;
            case 6:
            case 7:
                if (this.zzr) {
                    return zzbc.zzl;
                }
                return zzbc.zzt;
            case '\b':
                if (this.zzs) {
                    return zzbc.zzl;
                }
                return zzbc.zzv;
            case '\t':
                if (this.zzt) {
                    return zzbc.zzl;
                }
                return zzbc.zzz;
            case '\n':
                if (this.zzt) {
                    return zzbc.zzl;
                }
                return zzbc.zzA;
            default:
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Unsupported feature: ".concat(str));
                return zzbc.zzy;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        if (this.zza == 2 && this.zzf != null && this.zzg != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:364:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0400 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0457 A[Catch: Exception -> 0x04a0, CancellationException | TimeoutException -> 0x04b1, TimeoutException -> 0x04b3, TRY_LEAVE, TryCatch #0 {Exception -> 0x04a0, blocks: (B:392:0x0443, B:394:0x0457, B:396:0x047b, B:397:0x047e, B:403:0x0486), top: B:416:0x0443 }] */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0486 A[Catch: Exception -> 0x04a0, CancellationException | TimeoutException -> 0x04b1, TimeoutException -> 0x04b3, TRY_LEAVE, TryCatch #0 {Exception -> 0x04a0, blocks: (B:392:0x0443, B:394:0x0457, B:396:0x047b, B:397:0x047e, B:403:0x0486), top: B:416:0x0443 }] */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.android.billingclient.api.BillingResult launchBillingFlow(android.app.Activity r33, final com.android.billingclient.api.BillingFlowParams r34) {
        /*
            Method dump skipped, instructions count: 1220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.launchBillingFlow(android.app.Activity, com.android.billingclient.api.BillingFlowParams):com.android.billingclient.api.BillingResult");
    }

    @Override // com.android.billingclient.api.BillingClient
    @zzj
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (!isReady()) {
            productDetailsResponseListener.onProductDetailsResponse(zzbc.zzm, new ArrayList());
        } else if (!this.zzs) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Querying product details is not supported.");
            productDetailsResponseListener.onProductDetailsResponse(zzbc.zzv, new ArrayList());
        } else if (zzL(new Callable() { // from class: com.android.billingclient.api.zzs
            @Override // java.util.concurrent.Callable
            public final Object call() {
                BillingClientImpl.this.zzm(queryProductDetailsParams, productDetailsResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzt
            @Override // java.lang.Runnable
            public final void run() {
                ProductDetailsResponseListener.this.onProductDetailsResponse(zzbc.zzn, new ArrayList());
            }
        }, zzH()) == null) {
            productDetailsResponseListener.onProductDetailsResponse(zzJ(), new ArrayList());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    @zzj
    public void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzN(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    @zzj
    public void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzO(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            skuDetailsResponseListener.onSkuDetailsResponse(zzbc.zzm, null);
            return;
        }
        String skuType = skuDetailsParams.getSkuType();
        List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Please fix the input params. SKU type can't be empty.");
            skuDetailsResponseListener.onSkuDetailsResponse(zzbc.zzf, null);
        } else if (skusList != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : skusList) {
                zzbw zzbwVar = new zzbw(null);
                zzbwVar.zza(str);
                arrayList.add(zzbwVar.zzb());
            }
            if (zzL(new Callable(skuType, arrayList, null, skuDetailsResponseListener) { // from class: com.android.billingclient.api.zzq
                public final /* synthetic */ String zzb;
                public final /* synthetic */ List zzc;
                public final /* synthetic */ SkuDetailsResponseListener zzd;

                {
                    this.zzd = skuDetailsResponseListener;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.this.zzn(this.zzb, this.zzc, null, this.zzd);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzy
                @Override // java.lang.Runnable
                public final void run() {
                    SkuDetailsResponseListener.this.onSkuDetailsResponse(zzbc.zzn, null);
                }
            }, zzH()) == null) {
                skuDetailsResponseListener.onSkuDetailsResponse(zzJ(), null);
            }
        } else {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Please fix the input params. The list of SKUs can't be empty - set SKU list or SkuWithOffer list.");
            skuDetailsResponseListener.onSkuDetailsResponse(zzbc.zze, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    @zzf
    public BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service disconnected.");
            return zzbc.zzm;
        } else if (!this.zzo) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzbc.zzw;
        } else {
            View findViewById = activity.findViewById(16908290);
            IBinder windowToken = findViewById.getWindowToken();
            Rect rect = new Rect();
            findViewById.getGlobalVisibleRect(rect);
            final Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
            bundle.putInt("KEY_DIMEN_LEFT", rect.left);
            bundle.putInt("KEY_DIMEN_TOP", rect.top);
            bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
            bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.getInAppMessageCategoriesToShow());
            final zzak zzakVar = new zzak(this, this.zzc, inAppMessageResponseListener);
            zzL(new Callable() { // from class: com.android.billingclient.api.zzae
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    BillingClientImpl.this.zzo(bundle, activity, zzakVar);
                    return null;
                }
            }, 5000L, null, this.zzc);
            return zzbc.zzl;
        }
    }

    public final /* synthetic */ void zzG(BillingResult billingResult) {
        if (this.zzd.zzc() != null) {
            this.zzd.zzc().onPurchasesUpdated(billingResult, null);
            return;
        }
        this.zzd.zzb();
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "No valid listener is set in BroadcastManager");
    }

    public final /* synthetic */ Bundle zzc(int i4, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        return this.zzf.zzg(i4, this.zze.getPackageName(), str, str2, null, bundle);
    }

    public final /* synthetic */ Bundle zzd(String str, String str2) throws Exception {
        return this.zzf.zzf(3, this.zze.getPackageName(), str, str2, null);
    }

    public final /* synthetic */ Bundle zze(String str, Bundle bundle) throws Exception {
        return this.zzf.zzm(8, this.zze.getPackageName(), str, "subs", bundle);
    }

    public final /* synthetic */ Object zzk(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) throws Exception {
        try {
            com.google.android.gms.internal.play_billing.zze zzeVar = this.zzf;
            String packageName = this.zze.getPackageName();
            String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
            String str = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            Bundle zzd = zzeVar.zzd(9, packageName, purchaseToken, bundle);
            int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(zzd, "BillingClient");
            String zzf = com.google.android.gms.internal.play_billing.zzb.zzf(zzd, "BillingClient");
            BillingResult.Builder newBuilder = BillingResult.newBuilder();
            newBuilder.setResponseCode(zzb);
            newBuilder.setDebugMessage(zzf);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(newBuilder.build());
            return null;
        } catch (Exception e4) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Error acknowledge purchase!", e4);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzbc.zzm);
            return null;
        }
    }

    public final /* synthetic */ Object zzl(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Exception {
        int zza;
        String str;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Consuming purchase with token: " + purchaseToken);
            if (this.zzm) {
                com.google.android.gms.internal.play_billing.zze zzeVar = this.zzf;
                String packageName = this.zze.getPackageName();
                boolean z3 = this.zzm;
                String str2 = this.zzb;
                Bundle bundle = new Bundle();
                if (z3) {
                    bundle.putString("playBillingLibraryVersion", str2);
                }
                Bundle zze = zzeVar.zze(9, packageName, purchaseToken, bundle);
                zza = zze.getInt("RESPONSE_CODE");
                str = com.google.android.gms.internal.play_billing.zzb.zzf(zze, "BillingClient");
            } else {
                zza = this.zzf.zza(3, this.zze.getPackageName(), purchaseToken);
                str = "";
            }
            BillingResult.Builder newBuilder = BillingResult.newBuilder();
            newBuilder.setResponseCode(zza);
            newBuilder.setDebugMessage(str);
            BillingResult build = newBuilder.build();
            if (zza == 0) {
                com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.onConsumeResponse(build, purchaseToken);
                return null;
            }
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Error consuming purchase with token. Response code: " + zza);
            consumeResponseListener.onConsumeResponse(build, purchaseToken);
            return null;
        } catch (Exception e4) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Error consuming purchase!", e4);
            consumeResponseListener.onConsumeResponse(zzbc.zzm, purchaseToken);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x00e8, code lost:
        r12 = 4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ java.lang.Object zzm(com.android.billingclient.api.QueryProductDetailsParams r21, com.android.billingclient.api.ProductDetailsResponseListener r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.zzm(com.android.billingclient.api.QueryProductDetailsParams, com.android.billingclient.api.ProductDetailsResponseListener):java.lang.Object");
    }

    public final /* synthetic */ Object zzn(String str, List list, String str2, SkuDetailsResponseListener skuDetailsResponseListener) throws Exception {
        int i4;
        String str3;
        int i5;
        int i6;
        int i7;
        Bundle zzk;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i8 = 0;
        while (true) {
            if (i8 < size) {
                int i9 = i8 + 20;
                if (i9 > size) {
                    i5 = size;
                } else {
                    i5 = i9;
                }
                ArrayList arrayList2 = new ArrayList(list.subList(i8, i5));
                ArrayList<String> arrayList3 = new ArrayList<>();
                int size2 = arrayList2.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    arrayList3.add(((zzby) arrayList2.get(i10)).zza());
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
                bundle.putString("playBillingLibraryVersion", this.zzb);
                try {
                    if (this.zzn) {
                        com.google.android.gms.internal.play_billing.zze zzeVar = this.zzf;
                        String packageName = this.zze.getPackageName();
                        int i11 = this.zzj;
                        boolean z3 = this.zzv;
                        boolean zzP = zzP();
                        String str4 = this.zzb;
                        Bundle bundle2 = new Bundle();
                        i6 = size;
                        if (i11 >= 9) {
                            bundle2.putString("playBillingLibraryVersion", str4);
                        }
                        if (i11 >= 9 && z3) {
                            bundle2.putBoolean("enablePendingPurchases", true);
                        }
                        if (zzP) {
                            bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                        }
                        if (i11 >= 14) {
                            ArrayList<String> arrayList4 = new ArrayList<>();
                            ArrayList<String> arrayList5 = new ArrayList<>();
                            ArrayList arrayList6 = new ArrayList();
                            int size3 = arrayList2.size();
                            int i12 = 0;
                            boolean z4 = false;
                            boolean z5 = false;
                            while (i12 < size3) {
                                zzby zzbyVar = (zzby) arrayList2.get(i12);
                                arrayList4.add(null);
                                z4 |= !TextUtils.isEmpty(null);
                                arrayList5.add(null);
                                z5 |= !TextUtils.isEmpty(null);
                                arrayList6.add(0);
                                i12++;
                                i9 = i9;
                            }
                            i7 = i9;
                            if (z4) {
                                bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                            }
                            if (z5) {
                                bundle2.putStringArrayList("SKU_OFFER_ID_LIST", arrayList5);
                            }
                        } else {
                            i7 = i9;
                        }
                        zzk = zzeVar.zzl(10, packageName, str, bundle, bundle2);
                    } else {
                        i6 = size;
                        i7 = i9;
                        zzk = this.zzf.zzk(3, this.zze.getPackageName(), str, bundle);
                    }
                    str3 = "Item is unavailable for purchase.";
                    if (zzk == null) {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "querySkuDetailsAsync got null sku details list");
                        break;
                    } else if (!zzk.containsKey("DETAILS_LIST")) {
                        i4 = com.google.android.gms.internal.play_billing.zzb.zzb(zzk, "BillingClient");
                        str3 = com.google.android.gms.internal.play_billing.zzb.zzf(zzk, "BillingClient");
                        if (i4 != 0) {
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "getSkuDetails() failed. Response code: " + i4);
                        } else {
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                        }
                    } else {
                        ArrayList<String> stringArrayList = zzk.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList == null) {
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "querySkuDetailsAsync got null response list");
                            break;
                        }
                        for (int i13 = 0; i13 < stringArrayList.size(); i13++) {
                            try {
                                SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i13));
                                com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                                arrayList.add(skuDetails);
                            } catch (JSONException e4) {
                                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got a JSON exception trying to decode SkuDetails.", e4);
                                str3 = "Error trying to decode SkuDetails.";
                                arrayList = null;
                                i4 = 6;
                                BillingResult.Builder newBuilder = BillingResult.newBuilder();
                                newBuilder.setResponseCode(i4);
                                newBuilder.setDebugMessage(str3);
                                skuDetailsResponseListener.onSkuDetailsResponse(newBuilder.build(), arrayList);
                                return null;
                            }
                        }
                        i8 = i7;
                        size = i6;
                    }
                } catch (Exception e5) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", e5);
                    str3 = "Service connection is disconnected.";
                    i4 = -1;
                    arrayList = null;
                }
            } else {
                i4 = 0;
                str3 = "";
                break;
            }
        }
        arrayList = null;
        i4 = 4;
        BillingResult.Builder newBuilder2 = BillingResult.newBuilder();
        newBuilder2.setResponseCode(i4);
        newBuilder2.setDebugMessage(str3);
        skuDetailsResponseListener.onSkuDetailsResponse(newBuilder2.build(), arrayList);
        return null;
    }

    public final /* synthetic */ Object zzo(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        this.zzf.zzn(12, this.zze.getPackageName(), bundle, new zzar(new WeakReference(activity), resultReceiver, null));
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    @zzi
    public void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, PriceChangeConfirmationListener priceChangeConfirmationListener) {
        if (!isReady()) {
            zzM(zzbc.zzm, priceChangeConfirmationListener);
        } else if (priceChangeFlowParams != null && priceChangeFlowParams.getSkuDetails() != null) {
            final String sku = priceChangeFlowParams.getSkuDetails().getSku();
            if (sku == null) {
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Please fix the input params. priceChangeFlowParams must contain valid sku.");
                zzM(zzbc.zzk, priceChangeConfirmationListener);
            } else if (!this.zzl) {
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Current client doesn't support price change confirmation flow.");
                zzM(zzbc.zzr, priceChangeConfirmationListener);
            } else {
                final Bundle bundle = new Bundle();
                bundle.putString("playBillingLibraryVersion", this.zzb);
                bundle.putBoolean("subs_price_change", true);
                try {
                    Bundle bundle2 = (Bundle) zzL(new Callable() { // from class: com.android.billingclient.api.zzr
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return BillingClientImpl.this.zze(sku, bundle);
                        }
                    }, 5000L, null, this.zzc).get(5000L, TimeUnit.MILLISECONDS);
                    int zzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle2, "BillingClient");
                    String zzf = com.google.android.gms.internal.play_billing.zzb.zzf(bundle2, "BillingClient");
                    BillingResult.Builder newBuilder = BillingResult.newBuilder();
                    newBuilder.setResponseCode(zzb);
                    newBuilder.setDebugMessage(zzf);
                    BillingResult build = newBuilder.build();
                    if (zzb != 0) {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Unable to launch price change flow, error response code: " + zzb);
                        zzM(build, priceChangeConfirmationListener);
                        return;
                    }
                    zzah zzahVar = new zzah(this, this.zzc, priceChangeConfirmationListener);
                    Intent intent = new Intent(activity, ProxyBillingActivity.class);
                    intent.putExtra("SUBS_MANAGEMENT_INTENT", (PendingIntent) bundle2.getParcelable("SUBS_MANAGEMENT_INTENT"));
                    intent.putExtra("result_receiver", zzahVar);
                    activity.startActivity(intent);
                } catch (CancellationException e4) {
                    e = e4;
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Time out while launching Price Change Flow for sku: " + sku + "; try to reconnect", e);
                    zzM(zzbc.zzn, priceChangeConfirmationListener);
                } catch (TimeoutException e5) {
                    e = e5;
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Time out while launching Price Change Flow for sku: " + sku + "; try to reconnect", e);
                    zzM(zzbc.zzn, priceChangeConfirmationListener);
                } catch (Exception e6) {
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Exception caught while launching Price Change Flow for sku: " + sku + "; try to reconnect", e6);
                    zzM(zzbc.zzm, priceChangeConfirmationListener);
                }
            }
        } else {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Please fix the input params. priceChangeFlowParams must contain valid sku.");
            zzM(zzbc.zzk, priceChangeConfirmationListener);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzN(str, purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    @zzk
    public void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) {
        zzO(str, purchasesResponseListener);
    }

    @AnyThread
    private BillingClientImpl(Context context, boolean z3, boolean z4, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, @Nullable AlternativeBillingListener alternativeBillingListener) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzj = 0;
        this.zzb = str;
        initialize(context, purchasesUpdatedListener, z3, z4, alternativeBillingListener, str);
    }

    private BillingClientImpl(String str) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzj = 0;
        this.zzb = str;
    }

    @AnyThread
    public BillingClientImpl(@Nullable String str, boolean z3, Context context, zzbf zzbfVar) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzj = 0;
        this.zzb = zzK();
        this.zze = context.getApplicationContext();
        zzfl zzu = zzfm.zzu();
        zzu.zzj(zzK());
        zzu.zzi(this.zze.getPackageName());
        zzfm zzfmVar = (zzfm) zzu.zzc();
        this.zzz = new zzbh();
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzd = new zzo(this.zze, null, this.zzz);
        this.zzv = z3;
    }

    @AnyThread
    public BillingClientImpl(@Nullable String str, boolean z3, boolean z4, Context context, PurchasesUpdatedListener purchasesUpdatedListener, @Nullable AlternativeBillingListener alternativeBillingListener) {
        this(context, z3, false, purchasesUpdatedListener, zzK(), null, alternativeBillingListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void startConnection(BillingClientStateListener billingClientStateListener) {
        ServiceInfo serviceInfo;
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Service connection is valid. No need to re-initialize.");
            billingClientStateListener.onBillingSetupFinished(zzbc.zzl);
        } else if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Client is already in the process of connecting to billing service.");
            billingClientStateListener.onBillingSetupFinished(zzbc.zzd);
        } else if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            billingClientStateListener.onBillingSetupFinished(zzbc.zzm);
        } else {
            this.zza = 1;
            this.zzd.zze();
            com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Starting in-app billing setup.");
            this.zzg = new zzap(this, billingClientStateListener, null);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if ("com.android.vending".equals(str) && str2 != null) {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzg, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Service was bonded successfully.");
                        return;
                    }
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Connection to Billing service is blocked.");
                } else {
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "The device doesn't have valid Play Store.");
                }
            }
            this.zza = 0;
            com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Billing service unavailable on device.");
            billingClientStateListener.onBillingSetupFinished(zzbc.zzc);
        }
    }
}
