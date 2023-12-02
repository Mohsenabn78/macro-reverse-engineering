package com.google.mlkit.common.sdkinternal.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.mlkit:common@@18.5.0 */
@KeepForSdk
@WorkerThread
/* loaded from: classes5.dex */
public class ModelLoader {

    /* renamed from: c  reason: collision with root package name */
    private static final GmsLogger f33003c = new GmsLogger("ModelLoader", "");
    @NonNull
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    protected ModelLoadingState f33004a = ModelLoadingState.NO_MODEL_LOADED;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final ModelLoadingLogger f33005b;
    @Nullable
    @KeepForSdk
    public final LocalModelLoader localModelLoader;
    @Nullable
    @KeepForSdk
    @VisibleForTesting
    public final RemoteModelLoader remoteModelLoader;

    /* compiled from: com.google.mlkit:common@@18.5.0 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    public interface ModelContentHandler {
        @KeepForSdk
        void constructModel(@NonNull MappedByteBuffer mappedByteBuffer) throws MlKitException;
    }

    /* compiled from: com.google.mlkit:common@@18.5.0 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    public interface ModelLoadingLogger {
        @KeepForSdk
        void logErrorCodes(@NonNull List<Integer> list);
    }

    /* compiled from: com.google.mlkit:common@@18.5.0 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    protected enum ModelLoadingState {
        NO_MODEL_LOADED,
        REMOTE_MODEL_LOADED,
        LOCAL_MODEL_LOADED
    }

    @KeepForSdk
    public ModelLoader(@Nullable RemoteModelLoader remoteModelLoader, @Nullable LocalModelLoader localModelLoader, @NonNull ModelLoadingLogger modelLoadingLogger) {
        boolean z3 = true;
        if (remoteModelLoader == null && localModelLoader == null) {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "At least one of RemoteModelLoader or LocalModelLoader must be non-null.");
        Preconditions.checkNotNull(modelLoadingLogger);
        this.remoteModelLoader = remoteModelLoader;
        this.localModelLoader = localModelLoader;
        this.f33005b = modelLoadingLogger;
    }

    private final String a() {
        String uniqueModelNameForPersist;
        LocalModelLoader localModelLoader = this.localModelLoader;
        String str = null;
        if (localModelLoader != null) {
            if (localModelLoader.getLocalModel().getAssetFilePath() != null) {
                str = this.localModelLoader.getLocalModel().getAssetFilePath();
            } else if (this.localModelLoader.getLocalModel().getAbsoluteFilePath() != null) {
                str = this.localModelLoader.getLocalModel().getAbsoluteFilePath();
            } else if (this.localModelLoader.getLocalModel().getUri() != null) {
                str = ((Uri) Preconditions.checkNotNull(this.localModelLoader.getLocalModel().getUri())).toString();
            }
        }
        RemoteModelLoader remoteModelLoader = this.remoteModelLoader;
        if (remoteModelLoader == null) {
            uniqueModelNameForPersist = "unspecified";
        } else {
            uniqueModelNameForPersist = remoteModelLoader.getRemoteModel().getUniqueModelNameForPersist();
        }
        return String.format("Local model path: %s. Remote model name: %s. ", str, uniqueModelNameForPersist);
    }

    private final synchronized boolean b(ModelContentHandler modelContentHandler, List list) throws MlKitException {
        MappedByteBuffer load;
        LocalModelLoader localModelLoader = this.localModelLoader;
        if (localModelLoader != null && (load = localModelLoader.load()) != null) {
            try {
                modelContentHandler.constructModel(load);
                f33003c.d("ModelLoader", "Local model source is loaded successfully");
                return true;
            } catch (RuntimeException e4) {
                list.add(18);
                throw e4;
            }
        }
        return false;
    }

    private final synchronized boolean c(ModelContentHandler modelContentHandler, List list) throws MlKitException {
        RemoteModelLoader remoteModelLoader = this.remoteModelLoader;
        if (remoteModelLoader != null) {
            try {
                MappedByteBuffer load = remoteModelLoader.load();
                if (load != null) {
                    try {
                        modelContentHandler.constructModel(load);
                        f33003c.d("ModelLoader", "Remote model source is loaded successfully");
                        return true;
                    } catch (RuntimeException e4) {
                        list.add(19);
                        throw e4;
                    }
                }
                f33003c.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(21);
            } catch (MlKitException e5) {
                f33003c.d("ModelLoader", "Remote model source can NOT be loaded, try local model.");
                list.add(20);
                throw e5;
            }
        }
        return false;
    }

    @KeepForSdk
    public synchronized boolean isRemoteModelLoaded() {
        if (this.f33004a == ModelLoadingState.REMOTE_MODEL_LOADED) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public synchronized void loadWithModelContentHandler(@NonNull ModelContentHandler modelContentHandler) throws MlKitException {
        Exception exc;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        Exception e4 = null;
        boolean z4 = false;
        try {
            z3 = c(modelContentHandler, arrayList);
            exc = null;
        } catch (Exception e5) {
            exc = e5;
            z3 = false;
        }
        if (z3) {
            this.f33005b.logErrorCodes(arrayList);
            this.f33004a = ModelLoadingState.REMOTE_MODEL_LOADED;
            return;
        }
        try {
            z4 = b(modelContentHandler, arrayList);
        } catch (Exception e6) {
            e4 = e6;
        }
        if (z4) {
            this.f33005b.logErrorCodes(arrayList);
            this.f33004a = ModelLoadingState.LOCAL_MODEL_LOADED;
            return;
        }
        arrayList.add(17);
        this.f33005b.logErrorCodes(arrayList);
        this.f33004a = ModelLoadingState.NO_MODEL_LOADED;
        if (exc == null) {
            if (e4 != null) {
                throw new MlKitException("Local model load failed with the model options: ".concat(String.valueOf(a())), 14, e4);
            }
            throw new MlKitException("Cannot load any model with the model options: ".concat(String.valueOf(a())), 14);
        }
        throw new MlKitException("Remote model load failed with the model options: ".concat(String.valueOf(a())), 14, exc);
    }
}
