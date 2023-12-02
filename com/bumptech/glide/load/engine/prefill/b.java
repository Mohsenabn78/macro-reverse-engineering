package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: PreFillQueue.java */
/* loaded from: classes3.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<PreFillType, Integer> f17103a;

    /* renamed from: b  reason: collision with root package name */
    private final List<PreFillType> f17104b;

    /* renamed from: c  reason: collision with root package name */
    private int f17105c;

    /* renamed from: d  reason: collision with root package name */
    private int f17106d;

    public b(Map<PreFillType, Integer> map) {
        this.f17103a = map;
        this.f17104b = new ArrayList(map.keySet());
        for (Integer num : map.values()) {
            this.f17105c += num.intValue();
        }
    }

    public boolean a() {
        if (this.f17105c == 0) {
            return true;
        }
        return false;
    }

    public PreFillType b() {
        int size;
        PreFillType preFillType = this.f17104b.get(this.f17106d);
        Integer num = this.f17103a.get(preFillType);
        if (num.intValue() == 1) {
            this.f17103a.remove(preFillType);
            this.f17104b.remove(this.f17106d);
        } else {
            this.f17103a.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.f17105c--;
        if (this.f17104b.isEmpty()) {
            size = 0;
        } else {
            size = (this.f17106d + 1) % this.f17104b.size();
        }
        this.f17106d = size;
        return preFillType;
    }
}
