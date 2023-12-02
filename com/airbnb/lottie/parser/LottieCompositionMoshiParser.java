package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.android.dx.rop.code.RegisterSpec;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class LottieCompositionMoshiParser {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.Options f1797a = JsonReader.Options.of("w", "h", "ip", "op", TranslateLanguage.FRENCH, RegisterSpec.PREFIX, "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b  reason: collision with root package name */
    static JsonReader.Options f1798b = JsonReader.Options.of("id", "layers", "w", "h", "p", "u");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.Options f1799c = JsonReader.Options.of("list");

    /* renamed from: d  reason: collision with root package name */
    private static final JsonReader.Options f1800d = JsonReader.Options.of("cm", "tm", "dr");

    private static void a(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i4 = 0;
            int i5 = 0;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(f1798b);
                if (selectName != 0) {
                    if (selectName != 1) {
                        if (selectName != 2) {
                            if (selectName != 3) {
                                if (selectName != 4) {
                                    if (selectName != 5) {
                                        jsonReader.skipName();
                                        jsonReader.skipValue();
                                    } else {
                                        str3 = jsonReader.nextString();
                                    }
                                } else {
                                    str2 = jsonReader.nextString();
                                }
                            } else {
                                i5 = jsonReader.nextInt();
                            }
                        } else {
                            i4 = jsonReader.nextInt();
                        }
                    } else {
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            Layer parse = LayerParser.parse(jsonReader, lottieComposition);
                            longSparseArray.put(parse.getId(), parse);
                            arrayList.add(parse);
                        }
                        jsonReader.endArray();
                    }
                } else {
                    str = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(i4, i5, str, str2, str3);
                map2.put(lottieImageAsset.getId(), lottieImageAsset);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void b(JsonReader jsonReader, LottieComposition lottieComposition, SparseArrayCompat<FontCharacter> sparseArrayCompat) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            FontCharacter a4 = c.a(jsonReader, lottieComposition);
            sparseArrayCompat.put(a4.hashCode(), a4);
        }
        jsonReader.endArray();
    }

    private static void c(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(f1799c) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Font a4 = d.a(jsonReader);
                    map.put(a4.getName(), a4);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    private static void d(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i4 = 0;
        while (jsonReader.hasNext()) {
            Layer parse = LayerParser.parse(jsonReader, lottieComposition);
            if (parse.getLayerType() == Layer.LayerType.IMAGE) {
                i4++;
            }
            list.add(parse);
            longSparseArray.put(parse.getId(), parse);
            if (i4 > 4) {
                Logger.warning("You have " + i4 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void e(JsonReader jsonReader, LottieComposition lottieComposition, List<Marker> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float f4 = 0.0f;
            String str = null;
            float f5 = 0.0f;
            while (jsonReader.hasNext()) {
                int selectName = jsonReader.selectName(f1800d);
                if (selectName != 0) {
                    if (selectName != 1) {
                        if (selectName != 2) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            f5 = (float) jsonReader.nextDouble();
                        }
                    } else {
                        f4 = (float) jsonReader.nextDouble();
                    }
                } else {
                    str = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            list.add(new Marker(str, f4, f5));
        }
        jsonReader.endArray();
    }

    public static LottieComposition parse(JsonReader jsonReader) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float dpScale = Utils.dpScale();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<FontCharacter> sparseArrayCompat = new SparseArrayCompat<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.beginObject();
        int i4 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        int i5 = 0;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(f1797a)) {
                case 0:
                    i4 = jsonReader.nextInt();
                    continue;
                    jsonReader2 = jsonReader;
                case 1:
                    i5 = jsonReader.nextInt();
                    continue;
                    jsonReader2 = jsonReader;
                case 2:
                    f4 = (float) jsonReader.nextDouble();
                    continue;
                    jsonReader2 = jsonReader;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f5 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f6 = (float) jsonReader.nextDouble();
                    break;
                case 5:
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!Utils.isAtLeastVersion(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 6:
                    d(jsonReader2, lottieComposition, arrayList2, longSparseArray);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 7:
                    a(jsonReader2, lottieComposition, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 8:
                    c(jsonReader2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 9:
                    b(jsonReader2, lottieComposition, sparseArrayCompat);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 10:
                    e(jsonReader2, lottieComposition, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        lottieComposition.init(new Rect(0, 0, (int) (i4 * dpScale), (int) (i5 * dpScale)), f4, f5, f6, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return lottieComposition;
    }
}
