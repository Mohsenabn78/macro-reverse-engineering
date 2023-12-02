package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public class IntegerParser implements u<Integer> {
    public static final IntegerParser INSTANCE = new IntegerParser();

    private IntegerParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.u
    public Integer parse(JsonReader jsonReader, float f4) throws IOException {
        return Integer.valueOf(Math.round(g.g(jsonReader) * f4));
    }
}
