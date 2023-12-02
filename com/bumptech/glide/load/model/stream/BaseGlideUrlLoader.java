package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<GlideUrl, InputStream> f17204a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final ModelCache<Model, GlideUrl> f17205b;

    private static List<Key> a(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String str : collection) {
            arrayList.add(new GlideUrl(str));
        }
        return arrayList;
    }

    protected List<String> b(Model model2, int i4, int i5, Options options) {
        return Collections.emptyList();
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    @Nullable
    public ModelLoader.LoadData<InputStream> buildLoadData(@NonNull Model model2, int i4, int i5, @NonNull Options options) {
        GlideUrl glideUrl;
        ModelCache<Model, GlideUrl> modelCache = this.f17205b;
        if (modelCache != null) {
            glideUrl = modelCache.get(model2, i4, i5);
        } else {
            glideUrl = null;
        }
        if (glideUrl == null) {
            String d4 = d(model2, i4, i5, options);
            if (TextUtils.isEmpty(d4)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(d4, c(model2, i4, i5, options));
            ModelCache<Model, GlideUrl> modelCache2 = this.f17205b;
            if (modelCache2 != null) {
                modelCache2.put(model2, i4, i5, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        List<String> b4 = b(model2, i4, i5, options);
        ModelLoader.LoadData<InputStream> buildLoadData = this.f17204a.buildLoadData(glideUrl, i4, i5, options);
        if (buildLoadData != null && !b4.isEmpty()) {
            return new ModelLoader.LoadData<>(buildLoadData.sourceKey, a(b4), buildLoadData.fetcher);
        }
        return buildLoadData;
    }

    @Nullable
    protected Headers c(Model model2, int i4, int i5, Options options) {
        return Headers.DEFAULT;
    }

    protected abstract String d(Model model2, int i4, int i5, Options options);
}
