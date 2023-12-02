package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepeaterParser.java */
/* loaded from: classes2.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f1844a = JsonReader.Options.of("nm", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", TranslateLanguage.TURKISH, "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Repeater a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableTransform animatableTransform = null;
        boolean z3 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(f1844a);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            if (selectName != 4) {
                                jsonReader.skipValue();
                            } else {
                                z3 = jsonReader.nextBoolean();
                            }
                        } else {
                            animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                        }
                    } else {
                        animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    }
                } else {
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        return new Repeater(str, animatableFloatValue, animatableFloatValue2, animatableTransform, z3);
    }
}
