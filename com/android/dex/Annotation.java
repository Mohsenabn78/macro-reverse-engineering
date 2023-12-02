package com.android.dex;

import com.android.dex.Dex;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public final class Annotation implements Comparable<Annotation> {
    private final Dex dex;
    private final EncodedValue encodedAnnotation;
    private final byte visibility;

    public Annotation(Dex dex, byte b4, EncodedValue encodedValue) {
        this.dex = dex;
        this.visibility = b4;
        this.encodedAnnotation = encodedValue;
    }

    public EncodedValueReader getReader() {
        return new EncodedValueReader(this.encodedAnnotation, 29);
    }

    public int getTypeIndex() {
        EncodedValueReader reader = getReader();
        reader.readAnnotation();
        return reader.getAnnotationType();
    }

    public byte getVisibility() {
        return this.visibility;
    }

    public String toString() {
        if (this.dex == null) {
            return ((int) this.visibility) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getTypeIndex();
        }
        return ((int) this.visibility) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.dex.typeNames().get(getTypeIndex());
    }

    public void writeTo(Dex.Section section) {
        section.writeByte(this.visibility);
        this.encodedAnnotation.writeTo(section);
    }

    @Override // java.lang.Comparable
    public int compareTo(Annotation annotation) {
        return this.encodedAnnotation.compareTo(annotation.encodedAnnotation);
    }
}
