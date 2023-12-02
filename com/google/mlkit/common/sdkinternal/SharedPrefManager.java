package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.mlkit.common.model.RemoteModel;
import java.util.UUID;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
/* loaded from: classes5.dex */
public class SharedPrefManager {
    @NonNull
    @KeepForSdk
    public static final Component<?> COMPONENT = Component.builder(SharedPrefManager.class).add(Dependency.required(MlKitContext.class)).add(Dependency.required(Context.class)).factory(new ComponentFactory() { // from class: com.google.mlkit.common.sdkinternal.zzs
        @Override // com.google.firebase.components.ComponentFactory
        public final Object create(ComponentContainer componentContainer) {
            return new SharedPrefManager((Context) componentContainer.get(Context.class));
        }
    }).build();
    @NonNull
    @KeepForSdk
    @VisibleForTesting
    public static final String PREF_FILE = "com.google.mlkit.internal";

    /* renamed from: a  reason: collision with root package name */
    private final Context f32978a;

    public SharedPrefManager(@NonNull Context context) {
        this.f32978a = context;
    }

    private final SharedPreferences a() {
        return this.f32978a.getSharedPreferences(PREF_FILE, 0);
    }

    @NonNull
    @KeepForSdk
    public static SharedPrefManager getInstance(@NonNull MlKitContext mlKitContext) {
        return (SharedPrefManager) mlKitContext.get(SharedPrefManager.class);
    }

    @KeepForSdk
    public synchronized void clearDownloadingModelInfo(@NonNull RemoteModel remoteModel) {
        a().edit().remove(String.format("downloading_model_id_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("downloading_model_hash_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("downloading_model_type_%s", getDownloadingModelHash(remoteModel))).remove(String.format("downloading_begin_time_%s", remoteModel.getUniqueModelNameForPersist())).remove(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist())).apply();
    }

    @KeepForSdk
    public synchronized void clearIncompatibleModelInfo(@NonNull RemoteModel remoteModel) {
        a().edit().remove(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist())).remove("app_version").apply();
    }

    @KeepForSdk
    @WorkerThread
    public synchronized void clearLatestModelHash(@NonNull RemoteModel remoteModel) {
        a().edit().remove(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist())).commit();
    }

    @Nullable
    @KeepForSdk
    public synchronized String getDownloadingModelHash(@NonNull RemoteModel remoteModel) {
        return a().getString(String.format("downloading_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
    }

    @Nullable
    @KeepForSdk
    public synchronized Long getDownloadingModelId(@NonNull RemoteModel remoteModel) {
        long j4 = a().getLong(String.format("downloading_model_id_%s", remoteModel.getUniqueModelNameForPersist()), -1L);
        if (j4 < 0) {
            return null;
        }
        return Long.valueOf(j4);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getIncompatibleModelHash(@NonNull RemoteModel remoteModel) {
        return a().getString(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getLatestModelHash(@NonNull RemoteModel remoteModel) {
        return a().getString(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), null);
    }

    @NonNull
    @KeepForSdk
    public synchronized String getMlSdkInstanceId() {
        String string = a().getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        a().edit().putString("ml_sdk_instance_id", uuid).apply();
        return uuid;
    }

    @KeepForSdk
    public synchronized long getModelDownloadBeginTimeMs(@NonNull RemoteModel remoteModel) {
        return a().getLong(String.format("downloading_begin_time_%s", remoteModel.getUniqueModelNameForPersist()), 0L);
    }

    @KeepForSdk
    public synchronized long getModelFirstUseTimeMs(@NonNull RemoteModel remoteModel) {
        return a().getLong(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist()), 0L);
    }

    @Nullable
    @KeepForSdk
    public synchronized String getPreviousAppVersion() {
        return a().getString("app_version", null);
    }

    @KeepForSdk
    public synchronized void setDownloadingModelInfo(long j4, @NonNull ModelInfo modelInfo) {
        String modelNameForPersist = modelInfo.getModelNameForPersist();
        a().edit().putString(String.format("downloading_model_hash_%s", modelNameForPersist), modelInfo.getModelHash()).putLong(String.format("downloading_model_id_%s", modelNameForPersist), j4).putLong(String.format("downloading_begin_time_%s", modelNameForPersist), SystemClock.elapsedRealtime()).apply();
    }

    @KeepForSdk
    public synchronized void setIncompatibleModelInfo(@NonNull RemoteModel remoteModel, @NonNull String str, @NonNull String str2) {
        a().edit().putString(String.format("bad_hash_%s", remoteModel.getUniqueModelNameForPersist()), str).putString("app_version", str2).apply();
    }

    @KeepForSdk
    public synchronized void setLatestModelHash(@NonNull RemoteModel remoteModel, @NonNull String str) {
        a().edit().putString(String.format("current_model_hash_%s", remoteModel.getUniqueModelNameForPersist()), str).apply();
    }

    @KeepForSdk
    public synchronized void setModelFirstUseTimeMs(@NonNull RemoteModel remoteModel, long j4) {
        a().edit().putLong(String.format("model_first_use_time_%s", remoteModel.getUniqueModelNameForPersist()), j4).apply();
    }

    @Nullable
    public final synchronized String zza(@NonNull String str, long j4) {
        return a().getString(String.format("cached_local_model_hash_%1s_%2s", Preconditions.checkNotNull(str), Long.valueOf(j4)), null);
    }

    public final synchronized void zzb(@NonNull String str, long j4, @NonNull String str2) {
        a().edit().putString(String.format("cached_local_model_hash_%1s_%2s", Preconditions.checkNotNull(str), Long.valueOf(j4)), str2).apply();
    }
}
