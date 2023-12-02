package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LottieComposition {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<Layer>> f1255c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, LottieImageAsset> f1256d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, Font> f1257e;

    /* renamed from: f  reason: collision with root package name */
    private List<Marker> f1258f;

    /* renamed from: g  reason: collision with root package name */
    private SparseArrayCompat<FontCharacter> f1259g;

    /* renamed from: h  reason: collision with root package name */
    private LongSparseArray<Layer> f1260h;

    /* renamed from: i  reason: collision with root package name */
    private List<Layer> f1261i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f1262j;

    /* renamed from: k  reason: collision with root package name */
    private float f1263k;

    /* renamed from: l  reason: collision with root package name */
    private float f1264l;

    /* renamed from: m  reason: collision with root package name */
    private float f1265m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1266n;

    /* renamed from: a  reason: collision with root package name */
    private final PerformanceTracker f1253a = new PerformanceTracker();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f1254b = new HashSet<>();

    /* renamed from: o  reason: collision with root package name */
    private int f1267o = 0;

    @Deprecated
    /* loaded from: classes2.dex */
    public static class Factory {

        /* loaded from: classes2.dex */
        private static final class a implements LottieListener<LottieComposition>, Cancellable {

            /* renamed from: a  reason: collision with root package name */
            private final OnCompositionLoadedListener f1268a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f1269b;

            @Override // com.airbnb.lottie.LottieListener
            /* renamed from: a */
            public void onResult(LottieComposition lottieComposition) {
                if (this.f1269b) {
                    return;
                }
                this.f1268a.onCompositionLoaded(lottieComposition);
            }

            @Override // com.airbnb.lottie.Cancellable
            public void cancel() {
                this.f1269b = true;
            }

            private a(OnCompositionLoadedListener onCompositionLoadedListener) {
                this.f1269b = false;
                this.f1268a = onCompositionLoadedListener;
            }
        }

        private Factory() {
        }

        @Deprecated
        public static Cancellable fromAssetFileName(Context context, String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            a aVar = new a(onCompositionLoadedListener);
            LottieCompositionFactory.fromAsset(context, str).addListener(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromFileSync(Context context, String str) {
            return LottieCompositionFactory.fromAssetSync(context, str).getValue();
        }

        @Deprecated
        public static Cancellable fromInputStream(InputStream inputStream, OnCompositionLoadedListener onCompositionLoadedListener) {
            a aVar = new a(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonInputStream(inputStream, null).addListener(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream) {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
        }

        @Deprecated
        public static Cancellable fromJsonReader(JsonReader jsonReader, OnCompositionLoadedListener onCompositionLoadedListener) {
            a aVar = new a(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonReader(jsonReader, null).addListener(aVar);
            return aVar;
        }

        @Deprecated
        public static Cancellable fromJsonString(String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            a aVar = new a(onCompositionLoadedListener);
            LottieCompositionFactory.fromJsonString(str, null).addListener(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromJsonSync(Resources resources, JSONObject jSONObject) {
            return LottieCompositionFactory.fromJsonSync(jSONObject, null).getValue();
        }

        @Deprecated
        public static Cancellable fromRawFile(Context context, @RawRes int i4, OnCompositionLoadedListener onCompositionLoadedListener) {
            a aVar = new a(onCompositionLoadedListener);
            LottieCompositionFactory.fromRawRes(context, i4).addListener(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromInputStreamSync(InputStream inputStream, boolean z3) {
            if (z3) {
                Logger.warning("Lottie now auto-closes input stream!");
            }
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, null).getValue();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromJsonSync(String str) {
            return LottieCompositionFactory.fromJsonStringSync(str, null).getValue();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static LottieComposition fromJsonSync(JsonReader jsonReader) {
            return LottieCompositionFactory.fromJsonReaderSync(jsonReader, null).getValue();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void addWarning(String str) {
        Logger.warning(str);
        this.f1254b.add(str);
    }

    public Rect getBounds() {
        return this.f1262j;
    }

    public SparseArrayCompat<FontCharacter> getCharacters() {
        return this.f1259g;
    }

    public float getDuration() {
        return (getDurationFrames() / this.f1265m) * 1000.0f;
    }

    public float getDurationFrames() {
        return this.f1264l - this.f1263k;
    }

    public float getEndFrame() {
        return this.f1264l;
    }

    public Map<String, Font> getFonts() {
        return this.f1257e;
    }

    public float getFrameRate() {
        return this.f1265m;
    }

    public Map<String, LottieImageAsset> getImages() {
        return this.f1256d;
    }

    public List<Layer> getLayers() {
        return this.f1261i;
    }

    @Nullable
    public Marker getMarker(String str) {
        int size = this.f1258f.size();
        for (int i4 = 0; i4 < size; i4++) {
            Marker marker = this.f1258f.get(i4);
            if (marker.matchesName(str)) {
                return marker;
            }
        }
        return null;
    }

    public List<Marker> getMarkers() {
        return this.f1258f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getMaskAndMatteCount() {
        return this.f1267o;
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.f1253a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> getPrecomps(String str) {
        return this.f1255c.get(str);
    }

    public float getStartFrame() {
        return this.f1263k;
    }

    public ArrayList<String> getWarnings() {
        HashSet<String> hashSet = this.f1254b;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDashPattern() {
        return this.f1266n;
    }

    public boolean hasImages() {
        return !this.f1256d.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void incrementMatteOrMaskCount(int i4) {
        this.f1267o += i4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void init(Rect rect, float f4, float f5, float f6, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2, SparseArrayCompat<FontCharacter> sparseArrayCompat, Map<String, Font> map3, List<Marker> list2) {
        this.f1262j = rect;
        this.f1263k = f4;
        this.f1264l = f5;
        this.f1265m = f6;
        this.f1261i = list;
        this.f1260h = longSparseArray;
        this.f1255c = map;
        this.f1256d = map2;
        this.f1259g = sparseArrayCompat;
        this.f1257e = map3;
        this.f1258f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer layerModelForId(long j4) {
        return this.f1260h.get(j4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setHasDashPattern(boolean z3) {
        this.f1266n = z3;
    }

    public void setPerformanceTrackingEnabled(boolean z3) {
        this.f1253a.a(z3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.f1261i) {
            sb.append(layer.toString("\t"));
        }
        return sb.toString();
    }
}
