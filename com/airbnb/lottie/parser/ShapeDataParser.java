package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.android.dx.rop.code.RegisterSpec;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class ShapeDataParser implements u<ShapeData> {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f1802a = JsonReader.Options.of(CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, RegisterSpec.PREFIX, "i", "o");

    private ShapeDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.u
    public ShapeData parse(JsonReader jsonReader, float f4) throws IOException {
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z3 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(f1802a);
            if (selectName == 0) {
                z3 = jsonReader.nextBoolean();
            } else if (selectName == 1) {
                list = g.f(jsonReader, f4);
            } else if (selectName == 2) {
                list2 = g.f(jsonReader, f4);
            } else if (selectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                list3 = g.f(jsonReader, f4);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonReader.Token.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new ShapeData(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i4 = 1; i4 < size; i4++) {
                PointF pointF2 = list.get(i4);
                int i5 = i4 - 1;
                arrayList.add(new CubicCurveData(MiscUtils.addPoints(list.get(i5), list3.get(i5)), MiscUtils.addPoints(pointF2, list2.get(i4)), pointF2));
            }
            if (z3) {
                PointF pointF3 = list.get(0);
                int i6 = size - 1;
                arrayList.add(new CubicCurveData(MiscUtils.addPoints(list.get(i6), list3.get(i6)), MiscUtils.addPoints(pointF3, list2.get(0)), pointF3));
            }
            return new ShapeData(pointF, z3, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
