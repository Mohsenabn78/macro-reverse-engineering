package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes5.dex */
public interface ValueEncoder<T> extends Encoder<T, ValueEncoderContext> {
    /* synthetic */ void encode(@NonNull Object obj, @NonNull Object obj2) throws IOException;
}
