package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* compiled from: KeyframeParser.java */
/* loaded from: classes2.dex */
class h {

    /* renamed from: b  reason: collision with root package name */
    private static SparseArrayCompat<WeakReference<Interpolator>> f1816b;

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f1815a = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    static JsonReader.Options f1817c = JsonReader.Options.of("t", "s", "e", "o", "i", "h", TypedValues.TransitionType.S_TO, "ti");

    /* renamed from: d  reason: collision with root package name */
    static JsonReader.Options f1818d = JsonReader.Options.of("x", "y");

    h() {
    }

    @Nullable
    private static WeakReference<Interpolator> a(int i4) {
        WeakReference<Interpolator> weakReference;
        synchronized (h.class) {
            weakReference = g().get(i4);
        }
        return weakReference;
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolator;
        Interpolator linearInterpolator;
        pointF.x = MiscUtils.clamp(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.clamp(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils.clamp(pointF2.x, -1.0f, 1.0f);
        float clamp = MiscUtils.clamp(pointF2.y, -100.0f, 100.0f);
        pointF2.y = clamp;
        int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, clamp);
        WeakReference<Interpolator> a4 = a(hashFor);
        if (a4 != null) {
            interpolator = a4.get();
        } else {
            interpolator = null;
        }
        if (a4 == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e4) {
                if ("The Path cannot loop back on itself.".equals(e4.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                h(hashFor, new WeakReference(interpolator));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Keyframe<T> c(JsonReader jsonReader, LottieComposition lottieComposition, float f4, u<T> uVar, boolean z3, boolean z4) throws IOException {
        if (z3 && z4) {
            return e(lottieComposition, jsonReader, f4, uVar);
        }
        if (z3) {
            return d(lottieComposition, jsonReader, f4, uVar);
        }
        return f(jsonReader, f4, uVar);
    }

    private static <T> Keyframe<T> d(LottieComposition lottieComposition, JsonReader jsonReader, float f4, u<T> uVar) throws IOException {
        Interpolator interpolator;
        Interpolator interpolator2;
        T t3;
        jsonReader.beginObject();
        PointF pointF = null;
        PointF pointF2 = null;
        T t4 = null;
        T t5 = null;
        PointF pointF3 = null;
        PointF pointF4 = null;
        boolean z3 = false;
        float f5 = 0.0f;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(f1817c)) {
                case 0:
                    f5 = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t5 = uVar.parse(jsonReader, f4);
                    break;
                case 2:
                    t4 = uVar.parse(jsonReader, f4);
                    break;
                case 3:
                    pointF = g.e(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF2 = g.e(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.nextInt() == 1) {
                        z3 = true;
                        break;
                    } else {
                        z3 = false;
                        break;
                    }
                case 6:
                    pointF3 = g.e(jsonReader, f4);
                    break;
                case 7:
                    pointF4 = g.e(jsonReader, f4);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z3) {
            interpolator2 = f1815a;
            t3 = t5;
        } else {
            if (pointF != null && pointF2 != null) {
                interpolator = b(pointF, pointF2);
            } else {
                interpolator = f1815a;
            }
            interpolator2 = interpolator;
            t3 = t4;
        }
        Keyframe<T> keyframe = new Keyframe<>(lottieComposition, t5, t3, interpolator2, f5, null);
        keyframe.pathCp1 = pointF3;
        keyframe.pathCp2 = pointF4;
        return keyframe;
    }

    private static <T> Keyframe<T> e(LottieComposition lottieComposition, JsonReader jsonReader, float f4, u<T> uVar) throws IOException {
        Interpolator interpolator;
        Interpolator b4;
        Interpolator b5;
        T t3;
        PointF pointF;
        Keyframe<T> keyframe;
        PointF pointF2;
        float f5;
        PointF pointF3;
        float f6;
        jsonReader.beginObject();
        PointF pointF4 = null;
        boolean z3 = false;
        PointF pointF5 = null;
        PointF pointF6 = null;
        PointF pointF7 = null;
        T t4 = null;
        PointF pointF8 = null;
        PointF pointF9 = null;
        PointF pointF10 = null;
        float f7 = 0.0f;
        PointF pointF11 = null;
        T t5 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(f1817c)) {
                case 0:
                    pointF2 = pointF4;
                    f7 = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    pointF2 = pointF4;
                    t4 = uVar.parse(jsonReader, f4);
                    break;
                case 2:
                    pointF2 = pointF4;
                    t5 = uVar.parse(jsonReader, f4);
                    break;
                case 3:
                    pointF2 = pointF4;
                    f5 = f7;
                    PointF pointF12 = pointF11;
                    if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f8 = 0.0f;
                        float f9 = 0.0f;
                        float f10 = 0.0f;
                        float f11 = 0.0f;
                        while (jsonReader.hasNext()) {
                            int selectName = jsonReader.selectName(f1818d);
                            if (selectName != 0) {
                                if (selectName != 1) {
                                    jsonReader.skipValue();
                                } else {
                                    JsonReader.Token peek = jsonReader.peek();
                                    JsonReader.Token token = JsonReader.Token.NUMBER;
                                    if (peek == token) {
                                        f11 = (float) jsonReader.nextDouble();
                                        f9 = f11;
                                    } else {
                                        jsonReader.beginArray();
                                        f9 = (float) jsonReader.nextDouble();
                                        if (jsonReader.peek() == token) {
                                            f11 = (float) jsonReader.nextDouble();
                                        } else {
                                            f11 = f9;
                                        }
                                        jsonReader.endArray();
                                    }
                                }
                            } else {
                                JsonReader.Token peek2 = jsonReader.peek();
                                JsonReader.Token token2 = JsonReader.Token.NUMBER;
                                if (peek2 == token2) {
                                    f10 = (float) jsonReader.nextDouble();
                                    f8 = f10;
                                } else {
                                    jsonReader.beginArray();
                                    f8 = (float) jsonReader.nextDouble();
                                    if (jsonReader.peek() == token2) {
                                        f10 = (float) jsonReader.nextDouble();
                                    } else {
                                        f10 = f8;
                                    }
                                    jsonReader.endArray();
                                }
                            }
                        }
                        PointF pointF13 = new PointF(f8, f9);
                        PointF pointF14 = new PointF(f10, f11);
                        jsonReader.endObject();
                        pointF8 = pointF14;
                        pointF7 = pointF13;
                        pointF11 = pointF12;
                        f7 = f5;
                        break;
                    } else {
                        pointF5 = g.e(jsonReader, f4);
                        f7 = f5;
                        pointF11 = pointF12;
                        break;
                    }
                case 4:
                    if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        float f12 = 0.0f;
                        float f13 = 0.0f;
                        float f14 = 0.0f;
                        float f15 = 0.0f;
                        while (jsonReader.hasNext()) {
                            PointF pointF15 = pointF11;
                            int selectName2 = jsonReader.selectName(f1818d);
                            if (selectName2 != 0) {
                                pointF3 = pointF4;
                                if (selectName2 != 1) {
                                    jsonReader.skipValue();
                                } else {
                                    JsonReader.Token peek3 = jsonReader.peek();
                                    JsonReader.Token token3 = JsonReader.Token.NUMBER;
                                    if (peek3 == token3) {
                                        f15 = (float) jsonReader.nextDouble();
                                        f7 = f7;
                                        f13 = f15;
                                    } else {
                                        float f16 = f7;
                                        jsonReader.beginArray();
                                        float nextDouble = (float) jsonReader.nextDouble();
                                        if (jsonReader.peek() == token3) {
                                            f6 = (float) jsonReader.nextDouble();
                                        } else {
                                            f6 = nextDouble;
                                        }
                                        jsonReader.endArray();
                                        f7 = f16;
                                        pointF11 = pointF15;
                                        pointF4 = pointF3;
                                        f15 = f6;
                                        f13 = nextDouble;
                                    }
                                }
                            } else {
                                pointF3 = pointF4;
                                float f17 = f7;
                                JsonReader.Token peek4 = jsonReader.peek();
                                JsonReader.Token token4 = JsonReader.Token.NUMBER;
                                if (peek4 == token4) {
                                    f14 = (float) jsonReader.nextDouble();
                                    f7 = f17;
                                    f12 = f14;
                                } else {
                                    jsonReader.beginArray();
                                    f12 = (float) jsonReader.nextDouble();
                                    if (jsonReader.peek() == token4) {
                                        f14 = (float) jsonReader.nextDouble();
                                    } else {
                                        f14 = f12;
                                    }
                                    jsonReader.endArray();
                                    f7 = f17;
                                }
                            }
                            pointF11 = pointF15;
                            pointF4 = pointF3;
                        }
                        pointF2 = pointF4;
                        f5 = f7;
                        PointF pointF16 = new PointF(f12, f13);
                        PointF pointF17 = new PointF(f14, f15);
                        jsonReader.endObject();
                        pointF10 = pointF17;
                        pointF9 = pointF16;
                        f7 = f5;
                        break;
                    } else {
                        pointF2 = pointF4;
                        pointF6 = g.e(jsonReader, f4);
                        break;
                    }
                case 5:
                    if (jsonReader.nextInt() == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                        continue;
                    }
                case 6:
                    pointF11 = g.e(jsonReader, f4);
                    continue;
                case 7:
                    pointF4 = g.e(jsonReader, f4);
                    continue;
                default:
                    pointF2 = pointF4;
                    jsonReader.skipValue();
                    break;
            }
            pointF4 = pointF2;
        }
        PointF pointF18 = pointF4;
        float f18 = f7;
        PointF pointF19 = pointF11;
        jsonReader.endObject();
        if (z3) {
            interpolator = f1815a;
            t3 = t4;
        } else {
            if (pointF5 != null && pointF6 != null) {
                interpolator = b(pointF5, pointF6);
            } else if (pointF7 != null && pointF8 != null && pointF9 != null && pointF10 != null) {
                b4 = b(pointF7, pointF9);
                b5 = b(pointF8, pointF10);
                t3 = t5;
                interpolator = null;
                if (b4 == null && b5 != null) {
                    pointF = pointF19;
                    keyframe = new Keyframe<>(lottieComposition, t4, t3, b4, b5, f18, null);
                } else {
                    pointF = pointF19;
                    keyframe = new Keyframe<>(lottieComposition, t4, t3, interpolator, f18, null);
                }
                keyframe.pathCp1 = pointF;
                keyframe.pathCp2 = pointF18;
                return keyframe;
            } else {
                interpolator = f1815a;
            }
            t3 = t5;
        }
        b4 = null;
        b5 = null;
        if (b4 == null) {
        }
        pointF = pointF19;
        keyframe = new Keyframe<>(lottieComposition, t4, t3, interpolator, f18, null);
        keyframe.pathCp1 = pointF;
        keyframe.pathCp2 = pointF18;
        return keyframe;
    }

    private static <T> Keyframe<T> f(JsonReader jsonReader, float f4, u<T> uVar) throws IOException {
        return new Keyframe<>(uVar.parse(jsonReader, f4));
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> g() {
        if (f1816b == null) {
            f1816b = new SparseArrayCompat<>();
        }
        return f1816b;
    }

    private static void h(int i4, WeakReference<Interpolator> weakReference) {
        synchronized (h.class) {
            f1816b.put(i4, weakReference);
        }
    }
}
