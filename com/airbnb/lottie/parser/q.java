package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeGroupParser.java */
/* loaded from: classes2.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f1846a = JsonReader.Options.of("nm", "hd", TranslateLanguage.ITALIAN);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeGroup a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z3 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(f1846a);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        jsonReader.skipValue();
                    } else {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            ContentModel a4 = b.a(jsonReader, lottieComposition);
                            if (a4 != null) {
                                arrayList.add(a4);
                            }
                        }
                        jsonReader.endArray();
                    }
                } else {
                    z3 = jsonReader.nextBoolean();
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        return new ShapeGroup(str, arrayList, z3);
    }
}
