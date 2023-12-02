package com.google.firebase.encoders;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public final class EncodingException extends RuntimeException {
    public EncodingException(@NonNull String str) {
        super(str);
    }

    public EncodingException(@NonNull String str, @NonNull Exception exc) {
        super(str, exc);
    }
}
