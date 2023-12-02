package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

/* compiled from: PathKeyframeParser.java */
/* loaded from: classes2.dex */
class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static PathKeyframe a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z3;
        if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
            z3 = true;
        } else {
            z3 = false;
        }
        return new PathKeyframe(lottieComposition, h.c(jsonReader, lottieComposition, Utils.dpScale(), PathParser.INSTANCE, z3, false));
    }
}
