package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: classes5.dex */
public interface ValueEncoderContext {
    @NonNull
    ValueEncoderContext add(double d4) throws IOException;

    @NonNull
    ValueEncoderContext add(float f4) throws IOException;

    @NonNull
    ValueEncoderContext add(int i4) throws IOException;

    @NonNull
    ValueEncoderContext add(long j4) throws IOException;

    @NonNull
    ValueEncoderContext add(@Nullable String str) throws IOException;

    @NonNull
    ValueEncoderContext add(boolean z3) throws IOException;

    @NonNull
    ValueEncoderContext add(@NonNull byte[] bArr) throws IOException;
}
