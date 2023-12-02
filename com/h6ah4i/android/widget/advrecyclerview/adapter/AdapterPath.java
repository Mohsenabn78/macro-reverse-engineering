package com.h6ah4i.android.widget.advrecyclerview.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class AdapterPath {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final List<AdapterPathSegment> f33678a = new ArrayList();

    @NonNull
    public AdapterPath append(@NonNull UnwrapPositionResult unwrapPositionResult) {
        return append(unwrapPositionResult.adapter, unwrapPositionResult.tag);
    }

    @NonNull
    public AdapterPath clear() {
        this.f33678a.clear();
        return this;
    }

    @Nullable
    public AdapterPathSegment firstSegment() {
        if (!this.f33678a.isEmpty()) {
            return this.f33678a.get(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return this.f33678a.isEmpty();
    }

    @Nullable
    public AdapterPathSegment lastSegment() {
        if (!this.f33678a.isEmpty()) {
            List<AdapterPathSegment> list = this.f33678a;
            return list.get(list.size() - 1);
        }
        return null;
    }

    @NonNull
    public List<AdapterPathSegment> segments() {
        return this.f33678a;
    }

    @NonNull
    public AdapterPath append(@NonNull RecyclerView.Adapter adapter, @Nullable Object obj) {
        return append(new AdapterPathSegment(adapter, obj));
    }

    @NonNull
    public AdapterPath append(@NonNull AdapterPathSegment adapterPathSegment) {
        this.f33678a.add(adapterPathSegment);
        return this;
    }
}
