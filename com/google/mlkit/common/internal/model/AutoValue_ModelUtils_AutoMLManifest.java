package com.google.mlkit.common.internal.model;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.internal.model.ModelUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes5.dex */
public final class AutoValue_ModelUtils_AutoMLManifest extends ModelUtils.AutoMLManifest {

    /* renamed from: a  reason: collision with root package name */
    private final String f32917a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32918b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32919c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ModelUtils_AutoMLManifest(String str, String str2, String str3) {
        if (str != null) {
            this.f32917a = str;
            if (str2 != null) {
                this.f32918b = str2;
                if (str3 != null) {
                    this.f32919c = str3;
                    return;
                }
                throw new NullPointerException("Null labelsFile");
            }
            throw new NullPointerException("Null modelFile");
        }
        throw new NullPointerException("Null modelType");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ModelUtils.AutoMLManifest) {
            ModelUtils.AutoMLManifest autoMLManifest = (ModelUtils.AutoMLManifest) obj;
            if (this.f32917a.equals(autoMLManifest.getModelType()) && this.f32918b.equals(autoMLManifest.getModelFile()) && this.f32919c.equals(autoMLManifest.getLabelsFile())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    @KeepForSdk
    public String getLabelsFile() {
        return this.f32919c;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    @KeepForSdk
    public String getModelFile() {
        return this.f32918b;
    }

    @Override // com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest
    @KeepForSdk
    public String getModelType() {
        return this.f32917a;
    }

    public final int hashCode() {
        return ((((this.f32917a.hashCode() ^ 1000003) * 1000003) ^ this.f32918b.hashCode()) * 1000003) ^ this.f32919c.hashCode();
    }

    public final String toString() {
        String str = this.f32917a;
        String str2 = this.f32918b;
        String str3 = this.f32919c;
        return "AutoMLManifest{modelType=" + str + ", modelFile=" + str2 + ", labelsFile=" + str3 + "}";
    }
}
