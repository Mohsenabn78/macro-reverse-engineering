package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import com.google.mlkit.nl.translate.TranslateLanguage;

/* loaded from: classes2.dex */
public class AnimatableTransformParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f1789a = JsonReader.Options.of("a", "p", "s", "rz", "r", "o", "so", TranslateLanguage.ESPERANTO, TranslateLanguage.SLOVAK, "sa");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.Options f1790b = JsonReader.Options.of("k");

    private AnimatableTransformParser() {
    }

    private static boolean a(AnimatablePathValue animatablePathValue) {
        if (animatablePathValue != null && (!animatablePathValue.isStatic() || !animatablePathValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f))) {
            return false;
        }
        return true;
    }

    private static boolean b(AnimatableValue<PointF, PointF> animatableValue) {
        if (animatableValue != null && ((animatableValue instanceof AnimatableSplitDimensionPathValue) || !animatableValue.isStatic() || !animatableValue.getKeyframes().get(0).startValue.equals(0.0f, 0.0f))) {
            return false;
        }
        return true;
    }

    private static boolean c(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null && (!animatableFloatValue.isStatic() || ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    private static boolean d(AnimatableScaleValue animatableScaleValue) {
        if (animatableScaleValue != null && (!animatableScaleValue.isStatic() || !((ScaleXY) ((Keyframe) animatableScaleValue.getKeyframes().get(0)).startValue).equals(1.0f, 1.0f))) {
            return false;
        }
        return true;
    }

    private static boolean e(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null && (!animatableFloatValue.isStatic() || ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    private static boolean f(AnimatableFloatValue animatableFloatValue) {
        if (animatableFloatValue != null && (!animatableFloatValue.isStatic() || ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() != 0.0f)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.airbnb.lottie.model.animatable.AnimatableTransform parse(com.airbnb.lottie.parser.moshi.JsonReader r27, com.airbnb.lottie.LottieComposition r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.AnimatableTransformParser.parse(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.animatable.AnimatableTransform");
    }
}
