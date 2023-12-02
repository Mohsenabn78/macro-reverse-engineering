package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: FontParser.java */
/* loaded from: classes2.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f1807a = JsonReader.Options.of("fFamily", "fName", "fStyle", "ascent");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Font a(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f4 = 0.0f;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(f1807a);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            f4 = (float) jsonReader.nextDouble();
                        }
                    } else {
                        str3 = jsonReader.nextString();
                    }
                } else {
                    str2 = jsonReader.nextString();
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        jsonReader.endObject();
        return new Font(str, str2, str3, f4);
    }
}
