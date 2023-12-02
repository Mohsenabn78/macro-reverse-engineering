package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class Filter {
    public abstract String getCanonicalId();

    public abstract List<Filter> getFilters();

    @Nullable
    public abstract FieldPath getFirstInequalityField();

    public abstract List<FieldFilter> getFlattenedFilters();

    public abstract boolean matches(Document document);
}
