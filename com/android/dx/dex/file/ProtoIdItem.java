package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;

/* loaded from: classes2.dex */
public final class ProtoIdItem extends IndexedItem {
    private TypeListItem parameterTypes;
    private final Prototype prototype;
    private final CstString shortForm;

    public ProtoIdItem(Prototype prototype) {
        TypeListItem typeListItem;
        if (prototype != null) {
            this.prototype = prototype;
            this.shortForm = makeShortForm(prototype);
            StdTypeList parameterTypes = prototype.getParameterTypes();
            if (parameterTypes.size() == 0) {
                typeListItem = null;
            } else {
                typeListItem = new TypeListItem(parameterTypes);
            }
            this.parameterTypes = typeListItem;
            return;
        }
        throw new NullPointerException("prototype == null");
    }

    private static CstString makeShortForm(Prototype prototype) {
        StdTypeList parameterTypes = prototype.getParameterTypes();
        int size = parameterTypes.size();
        StringBuilder sb = new StringBuilder(size + 1);
        sb.append(shortFormCharFor(prototype.getReturnType()));
        for (int i4 = 0; i4 < size; i4++) {
            sb.append(shortFormCharFor(parameterTypes.getType(i4)));
        }
        return new CstString(sb.toString());
    }

    private static char shortFormCharFor(Type type) {
        char charAt = type.getDescriptor().charAt(0);
        if (charAt == '[') {
            return 'L';
        }
        return charAt;
    }

    @Override // com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
        StringIdsSection stringIds = dexFile.getStringIds();
        TypeIdsSection typeIds = dexFile.getTypeIds();
        MixedItemSection typeLists = dexFile.getTypeLists();
        typeIds.intern(this.prototype.getReturnType());
        stringIds.intern(this.shortForm);
        TypeListItem typeListItem = this.parameterTypes;
        if (typeListItem != null) {
            this.parameterTypes = (TypeListItem) typeLists.intern(typeListItem);
        }
    }

    @Override // com.android.dx.dex.file.Item
    public ItemType itemType() {
        return ItemType.TYPE_PROTO_ID_ITEM;
    }

    @Override // com.android.dx.dex.file.Item
    public int writeSize() {
        return 12;
    }

    @Override // com.android.dx.dex.file.Item
    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        int indexOf = dexFile.getStringIds().indexOf(this.shortForm);
        int indexOf2 = dexFile.getTypeIds().indexOf(this.prototype.getReturnType());
        int absoluteOffsetOr0 = OffsettedItem.getAbsoluteOffsetOr0(this.parameterTypes);
        if (annotatedOutput.annotates()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.prototype.getReturnType().toHuman());
            sb.append(" proto(");
            StdTypeList parameterTypes = this.prototype.getParameterTypes();
            int size = parameterTypes.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(parameterTypes.getType(i4).toHuman());
            }
            sb.append(")");
            annotatedOutput.annotate(0, indexString() + ' ' + sb.toString());
            annotatedOutput.annotate(4, "  shorty_idx:      " + Hex.u4(indexOf) + " // " + this.shortForm.toQuoted());
            annotatedOutput.annotate(4, "  return_type_idx: " + Hex.u4(indexOf2) + " // " + this.prototype.getReturnType().toHuman());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  parameters_off:  ");
            sb2.append(Hex.u4(absoluteOffsetOr0));
            annotatedOutput.annotate(4, sb2.toString());
        }
        annotatedOutput.writeInt(indexOf);
        annotatedOutput.writeInt(indexOf2);
        annotatedOutput.writeInt(absoluteOffsetOr0);
    }
}
