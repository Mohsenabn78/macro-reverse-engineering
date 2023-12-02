package com.google.mlkit.nl.translate.internal;

import android.content.Context;
import android.util.Log;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.LegacyModelMigrator;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import java.io.File;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public final class zzq extends LegacyModelMigrator {
    public zzq(Context context, ModelFileHelper modelFileHelper) {
        super(context, modelFileHelper);
    }

    private final void f(File file) {
        String name = file.getName();
        try {
            if (zzad.a(name).length != 2 || !file.isDirectory()) {
                return;
            }
            try {
                File modelDir = this.f32993a.getModelDir(name, ModelType.TRANSLATE);
                com.google.android.gms.internal.mlkit_translate.zzv zza = zzad.zza(name);
                int size = zza.size();
                for (int i4 = 0; i4 < size; i4++) {
                    String str = (String) zza.get(i4);
                    LegacyModelMigrator.migrateFile(new File(file, str), new File(modelDir, str));
                }
                LegacyModelMigrator.a(file);
            } catch (MlKitException e4) {
                Log.e("TranslateMigrator", "Error creating model directory for ".concat(String.valueOf(name)), e4);
            }
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // com.google.mlkit.common.sdkinternal.model.LegacyModelMigrator
    protected final String b() {
        return "com.google.firebase.ml.translate.models";
    }

    @Override // com.google.mlkit.common.sdkinternal.model.LegacyModelMigrator
    protected final void d(File file) {
        File[] listFiles;
        if (!LegacyModelMigrator.c(file.getName()) || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            f(file2);
        }
        LegacyModelMigrator.a(file);
    }
}
