package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: ValueParser.java */
/* loaded from: classes2.dex */
interface u<V> {
    V parse(JsonReader jsonReader, float f4) throws IOException;
}
