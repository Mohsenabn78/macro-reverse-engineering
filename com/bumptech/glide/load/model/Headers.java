package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public interface Headers {
    @Deprecated
    public static final Headers NONE = new a();
    public static final Headers DEFAULT = new LazyHeaders.Builder().build();

    /* loaded from: classes3.dex */
    class a implements Headers {
        a() {
        }

        @Override // com.bumptech.glide.load.model.Headers
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> getHeaders();
}
