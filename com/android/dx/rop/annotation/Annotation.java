package com.android.dx.rop.annotation;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.MutabilityControl;
import com.android.dx.util.ToHuman;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class Annotation extends MutabilityControl implements Comparable<Annotation>, ToHuman {
    private final TreeMap<CstString, NameValuePair> elements;
    private final CstType type;
    private final AnnotationVisibility visibility;

    public Annotation(CstType cstType, AnnotationVisibility annotationVisibility) {
        if (cstType != null) {
            if (annotationVisibility != null) {
                this.type = cstType;
                this.visibility = annotationVisibility;
                this.elements = new TreeMap<>();
                return;
            }
            throw new NullPointerException("visibility == null");
        }
        throw new NullPointerException("type == null");
    }

    public void add(NameValuePair nameValuePair) {
        throwIfImmutable();
        if (nameValuePair != null) {
            CstString name = nameValuePair.getName();
            if (this.elements.get(name) == null) {
                this.elements.put(name, nameValuePair);
                return;
            }
            throw new IllegalArgumentException("name already added: " + name);
        }
        throw new NullPointerException("pair == null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Annotation)) {
            return false;
        }
        Annotation annotation = (Annotation) obj;
        if (!this.type.equals(annotation.type) || this.visibility != annotation.visibility) {
            return false;
        }
        return this.elements.equals(annotation.elements);
    }

    public Collection<NameValuePair> getNameValuePairs() {
        return Collections.unmodifiableCollection(this.elements.values());
    }

    public CstType getType() {
        return this.type;
    }

    public AnnotationVisibility getVisibility() {
        return this.visibility;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.elements.hashCode()) * 31) + this.visibility.hashCode();
    }

    public void put(NameValuePair nameValuePair) {
        throwIfImmutable();
        if (nameValuePair != null) {
            this.elements.put(nameValuePair.getName(), nameValuePair);
            return;
        }
        throw new NullPointerException("pair == null");
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.visibility.toHuman());
        sb.append("-annotation ");
        sb.append(this.type.toHuman());
        sb.append(" {");
        boolean z3 = true;
        for (NameValuePair nameValuePair : this.elements.values()) {
            if (z3) {
                z3 = false;
            } else {
                sb.append(", ");
            }
            sb.append(nameValuePair.getName().toHuman());
            sb.append(": ");
            sb.append(nameValuePair.getValue().toHuman());
        }
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        return toHuman();
    }

    @Override // java.lang.Comparable
    public int compareTo(Annotation annotation) {
        int compareTo = this.type.compareTo((Constant) annotation.type);
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = this.visibility.compareTo(annotation.visibility);
        if (compareTo2 != 0) {
            return compareTo2;
        }
        Iterator<NameValuePair> it = this.elements.values().iterator();
        Iterator<NameValuePair> it2 = annotation.elements.values().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo3 = it.next().compareTo(it2.next());
            if (compareTo3 != 0) {
                return compareTo3;
            }
        }
        if (it.hasNext()) {
            return 1;
        }
        return it2.hasNext() ? -1 : 0;
    }
}
