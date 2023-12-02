package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.io.IOException;

/* loaded from: classes2.dex */
public class AnimatableTextPropertiesParser {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f1787a = JsonReader.Options.of("a");

    /* renamed from: b  reason: collision with root package name */
    private static JsonReader.Options f1788b = JsonReader.Options.of("fc", "sc", TranslateLanguage.SWAHILI, "t");

    private AnimatableTextPropertiesParser() {
    }

    private static AnimatableTextProperties a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableColorValue animatableColorValue = null;
        AnimatableColorValue animatableColorValue2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(f1788b);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                        }
                    } else {
                        animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    }
                } else {
                    animatableColorValue2 = AnimatableValueParser.c(jsonReader, lottieComposition);
                }
            } else {
                animatableColorValue = AnimatableValueParser.c(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        return new AnimatableTextProperties(animatableColorValue, animatableColorValue2, animatableFloatValue, animatableFloatValue2);
    }

    public static AnimatableTextProperties parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        AnimatableTextProperties animatableTextProperties = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(f1787a) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                animatableTextProperties = a(jsonReader, lottieComposition);
            }
        }
        jsonReader.endObject();
        if (animatableTextProperties == null) {
            return new AnimatableTextProperties(null, null, null, null);
        }
        return animatableTextProperties;
    }
}
