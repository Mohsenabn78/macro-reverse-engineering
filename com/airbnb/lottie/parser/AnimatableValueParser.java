package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    private static <T> List<Keyframe<T>> a(JsonReader jsonReader, float f4, LottieComposition lottieComposition, u<T> uVar) throws IOException {
        return i.a(jsonReader, lottieComposition, f4, uVar, false);
    }

    private static <T> List<Keyframe<T>> b(JsonReader jsonReader, LottieComposition lottieComposition, u<T> uVar) throws IOException {
        return i.a(jsonReader, lottieComposition, 1.0f, uVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableColorValue c(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(b(jsonReader, lottieComposition, ColorParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableTextFrame d(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableTextFrame(b(jsonReader, lottieComposition, DocumentDataParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableGradientColorValue e(JsonReader jsonReader, LottieComposition lottieComposition, int i4) throws IOException {
        return new AnimatableGradientColorValue(b(jsonReader, lottieComposition, new GradientColorParser(i4)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableIntegerValue f(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(b(jsonReader, lottieComposition, IntegerParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatablePointValue g(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(i.a(jsonReader, lottieComposition, Utils.dpScale(), PointFParser.INSTANCE, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableScaleValue h(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableScaleValue(b(jsonReader, lottieComposition, ScaleXYParser.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimatableShapeValue i(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableShapeValue(a(jsonReader, Utils.dpScale(), lottieComposition, ShapeDataParser.INSTANCE));
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return parseFloat(jsonReader, lottieComposition, true);
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition, boolean z3) throws IOException {
        return new AnimatableFloatValue(a(jsonReader, z3 ? Utils.dpScale() : 1.0f, lottieComposition, FloatParser.INSTANCE));
    }
}
