package com.h6ah4i.android.widget.advrecyclerview.composedadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.adapter.BridgeAdapterDataObserver;
import java.util.ArrayList;
import java.util.List;
import javax.mail.UIDFolder;

/* compiled from: AdaptersSet.java */
/* loaded from: classes6.dex */
class a {

    /* renamed from: f  reason: collision with root package name */
    public static long f33706f = -1;

    /* renamed from: a  reason: collision with root package name */
    private BridgeAdapterDataObserver.Subscriber f33707a;

    /* renamed from: b  reason: collision with root package name */
    private List<ComposedChildAdapterTag> f33708b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<RecyclerView.Adapter> f33709c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<RecyclerView.Adapter> f33710d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<b> f33711e = new ArrayList();

    public a(@NonNull BridgeAdapterDataObserver.Subscriber subscriber) {
        this.f33707a = subscriber;
    }

    public static long b(int i4, int i5) {
        return (i5 & UIDFolder.MAXUID) | (i4 << 32);
    }

    public static int c(long j4) {
        return (int) (j4 >>> 32);
    }

    public static int d(long j4) {
        return (int) (j4 & UIDFolder.MAXUID);
    }

    @NonNull
    public ComposedChildAdapterTag a(@NonNull RecyclerView.Adapter adapter, int i4) {
        b bVar;
        ComposedChildAdapterTag composedChildAdapterTag = new ComposedChildAdapterTag();
        this.f33708b.add(i4, composedChildAdapterTag);
        this.f33709c.add(i4, adapter);
        int indexOf = this.f33710d.indexOf(adapter);
        if (indexOf >= 0) {
            bVar = this.f33711e.get(indexOf);
        } else {
            b bVar2 = new b(this.f33707a, adapter);
            this.f33711e.add(bVar2);
            this.f33710d.add(adapter);
            adapter.registerAdapterDataObserver(bVar2);
            bVar = bVar2;
        }
        bVar.c(composedChildAdapterTag);
        return composedChildAdapterTag;
    }

    @NonNull
    public RecyclerView.Adapter e(int i4) {
        return this.f33709c.get(i4);
    }

    public int f(@NonNull ComposedChildAdapterTag composedChildAdapterTag) {
        return this.f33708b.indexOf(composedChildAdapterTag);
    }

    public int g() {
        return this.f33709c.size();
    }

    @NonNull
    public ComposedChildAdapterTag h(int i4) {
        return this.f33708b.get(i4);
    }

    @NonNull
    public List<RecyclerView.Adapter> i() {
        return this.f33710d;
    }

    public void j() {
        this.f33708b.clear();
        this.f33709c.clear();
        int size = this.f33710d.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = this.f33711e.get(i4);
            this.f33710d.get(i4).unregisterAdapterDataObserver(bVar);
            bVar.d();
        }
        this.f33710d.clear();
        this.f33711e.clear();
    }

    @Nullable
    public RecyclerView.Adapter k(@NonNull ComposedChildAdapterTag composedChildAdapterTag) {
        int f4 = f(composedChildAdapterTag);
        if (f4 < 0) {
            return null;
        }
        RecyclerView.Adapter remove = this.f33709c.remove(f4);
        this.f33708b.remove(f4);
        int indexOf = this.f33710d.indexOf(remove);
        if (indexOf >= 0) {
            b bVar = this.f33711e.get(indexOf);
            bVar.e(composedChildAdapterTag);
            if (!bVar.b()) {
                remove.unregisterAdapterDataObserver(bVar);
            }
            return remove;
        }
        throw new IllegalStateException("Something wrong. Inconsistency detected.");
    }
}
