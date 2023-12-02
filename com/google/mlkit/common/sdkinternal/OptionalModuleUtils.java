package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstall;
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.mlkit_common.zzao;
import com.google.android.gms.internal.mlkit_common.zzaq;
import com.google.android.gms.internal.mlkit_common.zzar;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Tasks;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class OptionalModuleUtils {
    @NonNull
    @KeepForSdk
    public static final String BARCODE = "barcode";
    @NonNull
    @KeepForSdk
    public static final String BARCODE_MODULE_ID = "com.google.android.gms.vision.barcode";
    @NonNull
    @KeepForSdk
    public static final String CUSTOM_ICA = "custom_ica";
    @NonNull
    @KeepForSdk
    public static final String CUSTOM_ICA_MODULE_ID = "com.google.android.gms.vision.custom.ica";
    @NonNull
    @KeepForSdk
    public static final String DEPRECATED_DYNAMITE_MODULE_ID = "com.google.android.gms.vision.dynamite";
    @NonNull
    @KeepForSdk
    public static final Feature[] EMPTY_FEATURES = new Feature[0];
    @NonNull
    @KeepForSdk
    public static final String FACE = "face";
    @NonNull
    @KeepForSdk
    public static final String FACE_MODULE_ID = "com.google.android.gms.vision.face";
    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_BARCODE;
    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_CUSTOM_ICA;
    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_FACE;
    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_ICA;
    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_LANGID;
    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_MLKIT_BARCODE_UI;
    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_NLCLASSIFIER;
    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_OCR;
    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_SMART_REPLY;
    @NonNull
    @KeepForSdk
    public static final Feature FEATURE_TFLITE_DYNAMITE;
    @NonNull
    @KeepForSdk
    public static final String ICA = "ica";
    @NonNull
    @KeepForSdk
    public static final String ICA_MODULE_ID = "com.google.android.gms.vision.ica";
    @NonNull
    @KeepForSdk
    public static final String LANGID = "langid";
    @NonNull
    @KeepForSdk
    public static final String LANGID_MODULE_ID = "com.google.android.gms.mlkit.langid";
    @NonNull
    @KeepForSdk
    public static final String MLKIT_BARCODE_UI = "barcode_ui";
    @NonNull
    @KeepForSdk
    public static final String NLCLASSIFIER = "nlclassifier";
    @NonNull
    @KeepForSdk
    public static final String NLCLASSIFIER_MODULE_ID = "com.google.android.gms.mlkit.nlclassifier";
    @NonNull
    @KeepForSdk
    public static final String OCR = "ocr";
    @NonNull
    @KeepForSdk
    public static final String OCR_MODULE_ID = "com.google.android.gms.vision.ocr";
    @NonNull
    @KeepForSdk
    public static final String SMART_REPLY = "smart_reply";
    @NonNull
    @KeepForSdk
    public static final String SMART_REPLY_MODULE_ID = "com.google.android.gms.mlkit_smartreply";
    @NonNull
    @KeepForSdk
    public static final String TFLITE_DYNAMITE = "tflite_dynamite";
    @NonNull
    @KeepForSdk
    public static final String TFLITE_DYNAMITE_MODULE_ID = "com.google.android.gms.tflite_dynamite";

    /* renamed from: a  reason: collision with root package name */
    private static final zzar f32976a;

    /* renamed from: b  reason: collision with root package name */
    private static final zzar f32977b;

    static {
        Feature feature = new Feature("vision.barcode", 1L);
        FEATURE_BARCODE = feature;
        Feature feature2 = new Feature("vision.custom.ica", 1L);
        FEATURE_CUSTOM_ICA = feature2;
        Feature feature3 = new Feature("vision.face", 1L);
        FEATURE_FACE = feature3;
        Feature feature4 = new Feature("vision.ica", 1L);
        FEATURE_ICA = feature4;
        Feature feature5 = new Feature("vision.ocr", 1L);
        FEATURE_OCR = feature5;
        Feature feature6 = new Feature("mlkit.langid", 1L);
        FEATURE_LANGID = feature6;
        Feature feature7 = new Feature("mlkit.nlclassifier", 1L);
        FEATURE_NLCLASSIFIER = feature7;
        Feature feature8 = new Feature(TFLITE_DYNAMITE, 1L);
        FEATURE_TFLITE_DYNAMITE = feature8;
        Feature feature9 = new Feature("mlkit.barcode.ui", 1L);
        FEATURE_MLKIT_BARCODE_UI = feature9;
        Feature feature10 = new Feature("mlkit.smartreply", 1L);
        FEATURE_SMART_REPLY = feature10;
        zzaq zzaqVar = new zzaq();
        zzaqVar.zza(BARCODE, feature);
        zzaqVar.zza(CUSTOM_ICA, feature2);
        zzaqVar.zza(FACE, feature3);
        zzaqVar.zza(ICA, feature4);
        zzaqVar.zza(OCR, feature5);
        zzaqVar.zza(LANGID, feature6);
        zzaqVar.zza(NLCLASSIFIER, feature7);
        zzaqVar.zza(TFLITE_DYNAMITE, feature8);
        zzaqVar.zza(MLKIT_BARCODE_UI, feature9);
        zzaqVar.zza(SMART_REPLY, feature10);
        f32976a = zzaqVar.zzb();
        zzaq zzaqVar2 = new zzaq();
        zzaqVar2.zza(BARCODE_MODULE_ID, feature);
        zzaqVar2.zza(CUSTOM_ICA_MODULE_ID, feature2);
        zzaqVar2.zza(FACE_MODULE_ID, feature3);
        zzaqVar2.zza(ICA_MODULE_ID, feature4);
        zzaqVar2.zza(OCR_MODULE_ID, feature5);
        zzaqVar2.zza(LANGID_MODULE_ID, feature6);
        zzaqVar2.zza(NLCLASSIFIER_MODULE_ID, feature7);
        zzaqVar2.zza(TFLITE_DYNAMITE_MODULE_ID, feature8);
        zzaqVar2.zza(SMART_REPLY_MODULE_ID, feature10);
        f32977b = zzaqVar2.zzb();
    }

    private OptionalModuleUtils() {
    }

    @KeepForSdk
    @WorkerThread
    private static boolean a(Context context, final Feature[] featureArr) {
        try {
            return ((ModuleAvailabilityResponse) Tasks.await(ModuleInstall.getClient(context).areModulesAvailable(new OptionalModuleApi() { // from class: com.google.mlkit.common.sdkinternal.zzo
                @Override // com.google.android.gms.common.api.OptionalModuleApi
                public final Feature[] getOptionalFeatures() {
                    Feature[] featureArr2 = featureArr;
                    Feature[] featureArr3 = OptionalModuleUtils.EMPTY_FEATURES;
                    return featureArr2;
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.google.mlkit.common.sdkinternal.zzp
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Log.e("OptionalModuleUtils", "Failed to check feature availability", exc);
                }
            }))).areModulesAvailable();
        } catch (InterruptedException | ExecutionException e4) {
            Log.e("OptionalModuleUtils", "Failed to complete the task of features availability check", e4);
            return false;
        }
    }

    @KeepForSdk
    @WorkerThread
    public static boolean areAllRequiredModulesAvailable(@NonNull Context context, @NonNull List<String> list) {
        if (GoogleApiAvailabilityLight.getInstance().getApkVersion(context) >= 221500000) {
            return a(context, b(f32977b, list));
        }
        try {
            for (String str : list) {
                DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, str);
            }
            return true;
        } catch (DynamiteModule.LoadingException unused) {
            return false;
        }
    }

    private static Feature[] b(Map map, List list) {
        Feature[] featureArr = new Feature[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            featureArr[i4] = (Feature) Preconditions.checkNotNull((Feature) map.get(list.get(i4)));
        }
        return featureArr;
    }

    @KeepForSdk
    public static void requestDownload(@NonNull Context context, @NonNull String str) {
        requestDownload(context, zzao.zzj(str));
    }

    @KeepForSdk
    public static void requestDownload(@NonNull Context context, @NonNull List<String> list) {
        if (GoogleApiAvailabilityLight.getInstance().getApkVersion(context) >= 221500000) {
            final Feature[] b4 = b(f32976a, list);
            ModuleInstall.getClient(context).installModules(ModuleInstallRequest.newBuilder().addApi(new OptionalModuleApi() { // from class: com.google.mlkit.common.sdkinternal.zzq
                @Override // com.google.android.gms.common.api.OptionalModuleApi
                public final Feature[] getOptionalFeatures() {
                    Feature[] featureArr = b4;
                    Feature[] featureArr2 = OptionalModuleUtils.EMPTY_FEATURES;
                    return featureArr;
                }
            }).build()).addOnFailureListener(new OnFailureListener() { // from class: com.google.mlkit.common.sdkinternal.zzr
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    Log.e("OptionalModuleUtils", "Failed to request modules install request", exc);
                }
            });
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        intent.setAction("com.google.android.gms.vision.DEPENDENCY");
        intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(",", list));
        intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
        context.sendBroadcast(intent);
    }
}
