package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircleShapeParser.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.Options f1803a = JsonReader.Options.of("nm", "p", "s", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CircleShape a(JsonReader jsonReader, LottieComposition lottieComposition, int i4) throws IOException {
        boolean z3;
        if (i4 == 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z4 = z3;
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(f1803a);
            if (selectName != 0) {
                if (selectName != 1) {
                    if (selectName != 2) {
                        if (selectName != 3) {
                            if (selectName != 4) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else if (jsonReader.nextInt() == 3) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                        } else {
                            z5 = jsonReader.nextBoolean();
                        }
                    } else {
                        animatablePointValue = AnimatableValueParser.g(jsonReader, lottieComposition);
                    }
                } else {
                    animatableValue = AnimatablePathValueParser.a(jsonReader, lottieComposition);
                }
            } else {
                str = jsonReader.nextString();
            }
        }
        return new CircleShape(str, animatableValue, animatablePointValue, z4, z5);
    }
}
