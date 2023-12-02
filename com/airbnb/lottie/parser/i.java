package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser.java */
/* loaded from: classes2.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    static JsonReader.Options f1819a = JsonReader.Options.of("k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<Keyframe<T>> a(JsonReader jsonReader, LottieComposition lottieComposition, float f4, u<T> uVar, boolean z3) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonReader.Token.STRING) {
            lottieComposition.addWarning("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(f1819a) != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonReader.Token.NUMBER) {
                    arrayList.add(h.c(jsonReader, lottieComposition, f4, uVar, false, z3));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(h.c(jsonReader, lottieComposition, f4, uVar, true, z3));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(h.c(jsonReader, lottieComposition, f4, uVar, false, z3));
            }
        }
        jsonReader.endObject();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends Keyframe<T>> list) {
        int i4;
        T t3;
        int size = list.size();
        int i5 = 0;
        while (true) {
            i4 = size - 1;
            if (i5 >= i4) {
                break;
            }
            Keyframe<T> keyframe = list.get(i5);
            i5++;
            Keyframe<T> keyframe2 = list.get(i5);
            keyframe.endFrame = Float.valueOf(keyframe2.startFrame);
            if (keyframe.endValue == null && (t3 = keyframe2.startValue) != null) {
                keyframe.endValue = t3;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).createPath();
                }
            }
        }
        Keyframe<T> keyframe3 = list.get(i4);
        if ((keyframe3.startValue == null || keyframe3.endValue == null) && list.size() > 1) {
            list.remove(keyframe3);
        }
    }
}
