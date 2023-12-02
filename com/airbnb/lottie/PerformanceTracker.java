package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class PerformanceTracker {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1380a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<FrameListener> f1381b = new ArraySet();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, MeanCalculator> f1382c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<Pair<String, Float>> f1383d = new a();

    /* loaded from: classes2.dex */
    public interface FrameListener {
        void onFrameRendered(float f4);
    }

    /* loaded from: classes2.dex */
    class a implements Comparator<Pair<String, Float>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = pair.second.floatValue();
            float floatValue2 = pair2.second.floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z3) {
        this.f1380a = z3;
    }

    public void addFrameListener(FrameListener frameListener) {
        this.f1381b.add(frameListener);
    }

    public void clearRenderTimes() {
        this.f1382c.clear();
    }

    public List<Pair<String, Float>> getSortedRenderTimes() {
        if (!this.f1380a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f1382c.size());
        for (Map.Entry<String, MeanCalculator> entry : this.f1382c.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Float.valueOf(entry.getValue().getMean())));
        }
        Collections.sort(arrayList, this.f1383d);
        return arrayList;
    }

    public void logRenderTimes() {
        if (!this.f1380a) {
            return;
        }
        List<Pair<String, Float>> sortedRenderTimes = getSortedRenderTimes();
        for (int i4 = 0; i4 < sortedRenderTimes.size(); i4++) {
            Pair<String, Float> pair = sortedRenderTimes.get(i4);
            String.format("\t\t%30s:%.2f", pair.first, pair.second);
        }
    }

    public void recordRenderTime(String str, float f4) {
        if (!this.f1380a) {
            return;
        }
        MeanCalculator meanCalculator = this.f1382c.get(str);
        if (meanCalculator == null) {
            meanCalculator = new MeanCalculator();
            this.f1382c.put(str, meanCalculator);
        }
        meanCalculator.add(f4);
        if (str.equals("__container")) {
            for (FrameListener frameListener : this.f1381b) {
                frameListener.onFrameRendered(f4);
            }
        }
    }

    public void removeFrameListener(FrameListener frameListener) {
        this.f1381b.remove(frameListener);
    }
}
