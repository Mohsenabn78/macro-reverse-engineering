package com.bumptech.glide.load.engine;

import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.UnitTransformation;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DecodeHelper.java */
/* loaded from: classes3.dex */
public final class f<Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ModelLoader.LoadData<?>> f16940a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<Key> f16941b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private GlideContext f16942c;

    /* renamed from: d  reason: collision with root package name */
    private Object f16943d;

    /* renamed from: e  reason: collision with root package name */
    private int f16944e;

    /* renamed from: f  reason: collision with root package name */
    private int f16945f;

    /* renamed from: g  reason: collision with root package name */
    private Class<?> f16946g;

    /* renamed from: h  reason: collision with root package name */
    private g.e f16947h;

    /* renamed from: i  reason: collision with root package name */
    private Options f16948i;

    /* renamed from: j  reason: collision with root package name */
    private Map<Class<?>, Transformation<?>> f16949j;

    /* renamed from: k  reason: collision with root package name */
    private Class<Transcode> f16950k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16951l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f16952m;

    /* renamed from: n  reason: collision with root package name */
    private Key f16953n;

    /* renamed from: o  reason: collision with root package name */
    private Priority f16954o;

    /* renamed from: p  reason: collision with root package name */
    private DiskCacheStrategy f16955p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f16956q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f16957r;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f16942c = null;
        this.f16943d = null;
        this.f16953n = null;
        this.f16946g = null;
        this.f16950k = null;
        this.f16948i = null;
        this.f16954o = null;
        this.f16949j = null;
        this.f16955p = null;
        this.f16940a.clear();
        this.f16951l = false;
        this.f16941b.clear();
        this.f16952m = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayPool b() {
        return this.f16942c.getArrayPool();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Key> c() {
        if (!this.f16952m) {
            this.f16952m = true;
            this.f16941b.clear();
            List<ModelLoader.LoadData<?>> g4 = g();
            int size = g4.size();
            for (int i4 = 0; i4 < size; i4++) {
                ModelLoader.LoadData<?> loadData = g4.get(i4);
                if (!this.f16941b.contains(loadData.sourceKey)) {
                    this.f16941b.add(loadData.sourceKey);
                }
                for (int i5 = 0; i5 < loadData.alternateKeys.size(); i5++) {
                    if (!this.f16941b.contains(loadData.alternateKeys.get(i5))) {
                        this.f16941b.add(loadData.alternateKeys.get(i5));
                    }
                }
            }
        }
        return this.f16941b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskCache d() {
        return this.f16947h.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DiskCacheStrategy e() {
        return this.f16955p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f16945f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ModelLoader.LoadData<?>> g() {
        if (!this.f16951l) {
            this.f16951l = true;
            this.f16940a.clear();
            List modelLoaders = this.f16942c.getRegistry().getModelLoaders(this.f16943d);
            int size = modelLoaders.size();
            for (int i4 = 0; i4 < size; i4++) {
                ModelLoader.LoadData<?> buildLoadData = ((ModelLoader) modelLoaders.get(i4)).buildLoadData(this.f16943d, this.f16944e, this.f16945f, this.f16948i);
                if (buildLoadData != null) {
                    this.f16940a.add(buildLoadData);
                }
            }
        }
        return this.f16940a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Data> LoadPath<Data, ?, Transcode> h(Class<Data> cls) {
        return this.f16942c.getRegistry().getLoadPath(cls, this.f16946g, this.f16950k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> i() {
        return this.f16943d.getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ModelLoader<File, ?>> j(File file) throws Registry.NoModelLoaderAvailableException {
        return this.f16942c.getRegistry().getModelLoaders(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Options k() {
        return this.f16948i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Priority l() {
        return this.f16954o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Class<?>> m() {
        return this.f16942c.getRegistry().getRegisteredResourceClasses(this.f16943d.getClass(), this.f16946g, this.f16950k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> ResourceEncoder<Z> n(Resource<Z> resource) {
        return this.f16942c.getRegistry().getResultEncoder(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Key o() {
        return this.f16953n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <X> Encoder<X> p(X x3) throws Registry.NoSourceEncoderAvailableException {
        return this.f16942c.getRegistry().getSourceEncoder(x3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> q() {
        return (Class<Transcode>) this.f16950k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <Z> Transformation<Z> r(Class<Z> cls) {
        Transformation<Z> transformation = (Transformation<Z>) this.f16949j.get(cls);
        if (transformation == null) {
            Iterator<Map.Entry<Class<?>, Transformation<?>>> it = this.f16949j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, Transformation<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    transformation = (Transformation<Z>) next.getValue();
                    break;
                }
            }
        }
        if (transformation == null) {
            if (this.f16949j.isEmpty() && this.f16956q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return UnitTransformation.get();
        }
        return transformation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s() {
        return this.f16944e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean t(Class<?> cls) {
        if (h(cls) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <R> void u(GlideContext glideContext, Object obj, Key key, int i4, int i5, DiskCacheStrategy diskCacheStrategy, Class<?> cls, Class<R> cls2, Priority priority, Options options, Map<Class<?>, Transformation<?>> map, boolean z3, boolean z4, g.e eVar) {
        this.f16942c = glideContext;
        this.f16943d = obj;
        this.f16953n = key;
        this.f16944e = i4;
        this.f16945f = i5;
        this.f16955p = diskCacheStrategy;
        this.f16946g = cls;
        this.f16947h = eVar;
        this.f16950k = cls2;
        this.f16954o = priority;
        this.f16948i = options;
        this.f16949j = map;
        this.f16956q = z3;
        this.f16957r = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v(Resource<?> resource) {
        return this.f16942c.getRegistry().isResourceEncoderAvailable(resource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.f16957r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(Key key) {
        List<ModelLoader.LoadData<?>> g4 = g();
        int size = g4.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (g4.get(i4).sourceKey.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
