package com.android.dx;

import com.android.dx.rop.type.StdTypeList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class TypeList {
    final StdTypeList ropTypes;
    final TypeId<?>[] types;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeList(TypeId<?>[] typeIdArr) {
        this.types = (TypeId[]) typeIdArr.clone();
        this.ropTypes = new StdTypeList(typeIdArr.length);
        for (int i4 = 0; i4 < typeIdArr.length; i4++) {
            this.ropTypes.set(i4, typeIdArr[i4].ropType);
        }
    }

    public List<TypeId<?>> asList() {
        return Collections.unmodifiableList(Arrays.asList(this.types));
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TypeList) && Arrays.equals(((TypeList) obj).types, this.types)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.types);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < this.types.length; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            sb.append(this.types[i4]);
        }
        return sb.toString();
    }
}
