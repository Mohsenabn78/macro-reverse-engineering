package com.google.mlkit.nl.translate.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileMover;
import java.io.File;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzag implements RemoteModelFileMover {

    /* renamed from: c  reason: collision with root package name */
    private static final GmsLogger f33098c = new GmsLogger("TranslateModelMover", "");

    /* renamed from: a  reason: collision with root package name */
    private final MlKitContext f33099a;

    /* renamed from: b  reason: collision with root package name */
    private final String f33100b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(@NonNull MlKitContext mlKitContext, @NonNull String str) {
        this.f33099a = mlKitContext;
        this.f33100b = str;
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelFileMover
    public final File getModelFileDestination() throws MlKitException {
        ModelFileHelper modelFileHelper = new ModelFileHelper(this.f33099a);
        File modelDir = modelFileHelper.getModelDir(this.f33100b, ModelType.TRANSLATE);
        return new File(modelDir, String.valueOf(modelFileHelper.getLatestCachedModelVersion(modelDir) + 1));
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelFileMover
    @Nullable
    public final File moveAllFilesFromPrivateTempToPrivateDestination(File file) throws MlKitException {
        File modelFileDestination = getModelFileDestination();
        if (file.renameTo(modelFileDestination)) {
            f33098c.d("TranslateModelMover", "Rename to serving model successfully");
            modelFileDestination.setExecutable(false);
            modelFileDestination.setWritable(false);
            return modelFileDestination;
        }
        GmsLogger gmsLogger = f33098c;
        gmsLogger.d("TranslateModelMover", "Rename to serving model failed, remove the temp file.");
        if (!file.delete()) {
            gmsLogger.d("TranslateModelMover", "Failed to delete the temp file: ".concat(String.valueOf(file.getAbsolutePath())));
            return null;
        }
        return null;
    }
}
