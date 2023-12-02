package com.google.mlkit.nl.translate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.BaseModel;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.internal.zzad;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public class TranslateRemoteModel extends RemoteModel {
    @TranslateLanguage.Language

    /* renamed from: f  reason: collision with root package name */
    private final String f33053f;

    /* compiled from: com.google.mlkit:translate@@17.0.1 */
    /* loaded from: classes5.dex */
    public static class Builder {
        @TranslateLanguage.Language

        /* renamed from: a  reason: collision with root package name */
        private final String f33054a;

        public Builder(@NonNull @TranslateLanguage.Language String str) {
            this.f33054a = str;
        }

        @NonNull
        public TranslateRemoteModel build() {
            return new TranslateRemoteModel(this.f33054a, null);
        }
    }

    /* synthetic */ TranslateRemoteModel(String str, zzk zzkVar) {
        super(null, BaseModel.TRANSLATE, ModelType.TRANSLATE);
        this.f33053f = str;
    }

    @NonNull
    public static String zza(@NonNull String str) {
        return "COM.GOOGLE.BASE_TRANSLATE:".concat(String.valueOf(str));
    }

    @Override // com.google.mlkit.common.model.RemoteModel
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof TranslateRemoteModel) && super.equals(obj) && getLanguage() == ((TranslateRemoteModel) obj).getLanguage()) {
            return true;
        }
        return false;
    }

    @NonNull
    @TranslateLanguage.Language
    public String getLanguage() {
        return this.f33053f;
    }

    @Override // com.google.mlkit.common.model.RemoteModel
    @NonNull
    public final String getModelNameForBackend() {
        return zzad.zze(getLanguage());
    }

    @Override // com.google.mlkit.common.model.RemoteModel
    @NonNull
    public final String getUniqueModelNameForPersist() {
        return zza(zzad.zze(getLanguage()));
    }

    @Override // com.google.mlkit.common.model.RemoteModel
    public int hashCode() {
        return (super.hashCode() * 31) + getLanguage().hashCode();
    }
}
