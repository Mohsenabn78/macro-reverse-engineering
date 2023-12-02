package com.google.mlkit.nl.translate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_translate.zznv;
import com.google.android.gms.internal.mlkit_translate.zznx;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.concurrent.Executor;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public class TranslatorOptions {
    @TranslateLanguage.Language

    /* renamed from: a  reason: collision with root package name */
    private final String f33055a;
    @TranslateLanguage.Language

    /* renamed from: b  reason: collision with root package name */
    private final String f33056b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Executor f33057c;

    /* compiled from: com.google.mlkit:translate@@17.0.1 */
    /* loaded from: classes5.dex */
    public static class Builder {
        @Nullable
        @TranslateLanguage.Language

        /* renamed from: a  reason: collision with root package name */
        private String f33058a;
        @Nullable
        @TranslateLanguage.Language

        /* renamed from: b  reason: collision with root package name */
        private String f33059b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Executor f33060c;

        @NonNull
        public TranslatorOptions build() {
            return new TranslatorOptions((String) Preconditions.checkNotNull(this.f33058a), (String) Preconditions.checkNotNull(this.f33059b), this.f33060c, null);
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            this.f33060c = executor;
            return this;
        }

        @NonNull
        public Builder setSourceLanguage(@NonNull @TranslateLanguage.Language String str) {
            this.f33058a = str;
            return this;
        }

        @NonNull
        public Builder setTargetLanguage(@NonNull @TranslateLanguage.Language String str) {
            this.f33059b = str;
            return this;
        }
    }

    /* synthetic */ TranslatorOptions(String str, String str2, Executor executor, zzl zzlVar) {
        this.f33055a = str;
        this.f33056b = str2;
        this.f33057c = executor;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranslatorOptions)) {
            return false;
        }
        TranslatorOptions translatorOptions = (TranslatorOptions) obj;
        if (Objects.equal(translatorOptions.f33055a, this.f33055a) && Objects.equal(translatorOptions.f33056b, this.f33056b) && Objects.equal(translatorOptions.f33057c, this.f33057c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f33055a, this.f33056b, this.f33057c);
    }

    public final zznx zza() {
        zznv zznvVar = new zznv();
        zznvVar.zza(this.f33055a);
        zznvVar.zzb(this.f33056b);
        return zznvVar.zzc();
    }

    @NonNull
    public final String zzb() {
        return TranslateLanguage.zza(this.f33055a);
    }

    @NonNull
    public final String zzc() {
        return TranslateLanguage.zza(this.f33056b);
    }

    @NonNull
    @TranslateLanguage.Language
    public final String zzd() {
        return this.f33055a;
    }

    @NonNull
    @TranslateLanguage.Language
    public final String zze() {
        return this.f33056b;
    }

    @Nullable
    public final Executor zzf() {
        return this.f33057c;
    }
}
