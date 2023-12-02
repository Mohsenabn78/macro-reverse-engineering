package com.airbnb.lottie.parser;

import android.graphics.Color;
import androidx.annotation.IntRange;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class GradientColorParser implements u<GradientColor> {

    /* renamed from: a  reason: collision with root package name */
    private int f1792a;

    public GradientColorParser(int i4) {
        this.f1792a = i4;
    }

    private void a(GradientColor gradientColor, List<Float> list) {
        int i4 = this.f1792a * 4;
        if (list.size() <= i4) {
            return;
        }
        int size = (list.size() - i4) / 2;
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        int i5 = 0;
        while (i4 < list.size()) {
            if (i4 % 2 == 0) {
                dArr[i5] = list.get(i4).floatValue();
            } else {
                dArr2[i5] = list.get(i4).floatValue();
                i5++;
            }
            i4++;
        }
        for (int i6 = 0; i6 < gradientColor.getSize(); i6++) {
            int i7 = gradientColor.getColors()[i6];
            gradientColor.getColors()[i6] = Color.argb(b(gradientColor.getPositions()[i6], dArr, dArr2), Color.red(i7), Color.green(i7), Color.blue(i7));
        }
    }

    @IntRange(from = 0, to = 255)
    private int b(double d4, double[] dArr, double[] dArr2) {
        double d5;
        int i4 = 1;
        while (true) {
            if (i4 < dArr.length) {
                int i5 = i4 - 1;
                double d6 = dArr[i5];
                double d7 = dArr[i4];
                if (d7 >= d4) {
                    d5 = MiscUtils.lerp(dArr2[i5], dArr2[i4], MiscUtils.clamp((d4 - d6) / (d7 - d6), (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d));
                    break;
                }
                i4++;
            } else {
                d5 = dArr2[dArr2.length - 1];
                break;
            }
        }
        return (int) (d5 * 255.0d);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.u
    public GradientColor parse(JsonReader jsonReader, float f4) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z3 = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z3) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z3) {
            jsonReader.endArray();
        }
        if (this.f1792a == -1) {
            this.f1792a = arrayList.size() / 4;
        }
        int i4 = this.f1792a;
        float[] fArr = new float[i4];
        int[] iArr = new int[i4];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < this.f1792a * 4; i7++) {
            int i8 = i7 / 4;
            double floatValue = arrayList.get(i7).floatValue();
            int i9 = i7 % 4;
            if (i9 == 0) {
                if (i8 > 0) {
                    float f5 = (float) floatValue;
                    if (fArr[i8 - 1] >= f5) {
                        fArr[i8] = f5 + 0.01f;
                    }
                }
                fArr[i8] = (float) floatValue;
            } else if (i9 == 1) {
                i5 = (int) (floatValue * 255.0d);
            } else if (i9 == 2) {
                i6 = (int) (floatValue * 255.0d);
            } else if (i9 == 3) {
                iArr[i8] = Color.argb(255, i5, i6, (int) (floatValue * 255.0d));
            }
        }
        GradientColor gradientColor = new GradientColor(fArr, iArr);
        a(gradientColor, arrayList);
        return gradientColor;
    }
}
