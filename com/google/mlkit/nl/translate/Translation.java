package com.google.mlkit.nl.translate;

import androidx.annotation.NonNull;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.nl.translate.internal.TranslatorImpl;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes5.dex */
public class Translation {
    private Translation() {
    }

    @NonNull
    public static Translator getClient(@NonNull TranslatorOptions translatorOptions) {
        return ((TranslatorImpl.Factory) MlKitContext.getInstance().get(TranslatorImpl.Factory.class)).zza(translatorOptions);
    }
}
