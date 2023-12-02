package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

/* loaded from: classes2.dex */
public class ScaleXYParser implements u<ScaleXY> {
    public static final ScaleXYParser INSTANCE = new ScaleXYParser();

    private ScaleXYParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.u
    public ScaleXY parse(JsonReader jsonReader, float f4) throws IOException {
        boolean z3 = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z3) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z3) {
            jsonReader.endArray();
        }
        return new ScaleXY((nextDouble / 100.0f) * f4, (nextDouble2 / 100.0f) * f4);
    }
}
