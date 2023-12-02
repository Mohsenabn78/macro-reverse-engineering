package com.google.firebase.firestore.core;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.util.Function;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class CompositeFilter extends Filter {

    /* renamed from: a  reason: collision with root package name */
    private final List<Filter> f30324a;

    /* renamed from: b  reason: collision with root package name */
    private final Operator f30325b;

    /* renamed from: c  reason: collision with root package name */
    private List<FieldFilter> f30326c;

    /* loaded from: classes5.dex */
    public enum Operator {
        AND("and"),
        OR("or");
        
        private final String text;

        Operator(String str) {
            this.text = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.text;
        }
    }

    public CompositeFilter(List<Filter> list, Operator operator) {
        this.f30324a = new ArrayList(list);
        this.f30325b = operator;
    }

    @Nullable
    private FieldFilter b(Function<FieldFilter, Boolean> function) {
        for (FieldFilter fieldFilter : getFlattenedFilters()) {
            if (function.apply(fieldFilter).booleanValue()) {
                return fieldFilter;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean c(FieldFilter fieldFilter) {
        return Boolean.valueOf(fieldFilter.isInequality());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CompositeFilter)) {
            return false;
        }
        CompositeFilter compositeFilter = (CompositeFilter) obj;
        if (this.f30325b != compositeFilter.f30325b || !this.f30324a.equals(compositeFilter.f30324a)) {
            return false;
        }
        return true;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public String getCanonicalId() {
        StringBuilder sb = new StringBuilder();
        if (isFlatConjunction()) {
            for (Filter filter : this.f30324a) {
                sb.append(filter.getCanonicalId());
            }
            return sb.toString();
        }
        sb.append(this.f30325b.toString() + "(");
        sb.append(TextUtils.join(",", this.f30324a));
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.firebase.firestore.core.Filter
    public List<Filter> getFilters() {
        return Collections.unmodifiableList(this.f30324a);
    }

    @Override // com.google.firebase.firestore.core.Filter
    public FieldPath getFirstInequalityField() {
        FieldFilter b4 = b(new Function() { // from class: com.google.firebase.firestore.core.e
            @Override // com.google.firebase.firestore.util.Function
            public final Object apply(Object obj) {
                Boolean c4;
                c4 = CompositeFilter.c((FieldFilter) obj);
                return c4;
            }
        });
        if (b4 != null) {
            return b4.getField();
        }
        return null;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public List<FieldFilter> getFlattenedFilters() {
        List<FieldFilter> list = this.f30326c;
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        this.f30326c = new ArrayList();
        for (Filter filter : this.f30324a) {
            this.f30326c.addAll(filter.getFlattenedFilters());
        }
        return Collections.unmodifiableList(this.f30326c);
    }

    public Operator getOperator() {
        return this.f30325b;
    }

    public int hashCode() {
        return ((1147 + this.f30325b.hashCode()) * 31) + this.f30324a.hashCode();
    }

    public boolean isConjunction() {
        if (this.f30325b == Operator.AND) {
            return true;
        }
        return false;
    }

    public boolean isDisjunction() {
        if (this.f30325b == Operator.OR) {
            return true;
        }
        return false;
    }

    public boolean isFlat() {
        for (Filter filter : this.f30324a) {
            if (filter instanceof CompositeFilter) {
                return false;
            }
        }
        return true;
    }

    public boolean isFlatConjunction() {
        if (isFlat() && isConjunction()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        if (isConjunction()) {
            for (Filter filter : this.f30324a) {
                if (!filter.matches(document)) {
                    return false;
                }
            }
            return true;
        }
        for (Filter filter2 : this.f30324a) {
            if (filter2.matches(document)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return getCanonicalId();
    }

    public CompositeFilter withAddedFilters(List<Filter> list) {
        ArrayList arrayList = new ArrayList(this.f30324a);
        arrayList.addAll(list);
        return new CompositeFilter(arrayList, this.f30325b);
    }
}
