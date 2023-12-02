package com.android.dx.merge;

import com.android.dex.Annotation;
import com.android.dex.ClassData;
import com.android.dex.ClassDef;
import com.android.dex.Code;
import com.android.dex.Dex;
import com.android.dex.DexException;
import com.android.dex.DexIndexOverflowException;
import com.android.dex.FieldId;
import com.android.dex.MethodId;
import com.android.dex.ProtoId;
import com.android.dex.TableOfContents;
import com.android.dex.TypeList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class DexMerger {
    private static final byte DBG_ADVANCE_LINE = 2;
    private static final byte DBG_ADVANCE_PC = 1;
    private static final byte DBG_END_LOCAL = 5;
    private static final byte DBG_END_SEQUENCE = 0;
    private static final byte DBG_RESTART_LOCAL = 6;
    private static final byte DBG_SET_EPILOGUE_BEGIN = 8;
    private static final byte DBG_SET_FILE = 9;
    private static final byte DBG_SET_PROLOGUE_END = 7;
    private static final byte DBG_START_LOCAL = 3;
    private static final byte DBG_START_LOCAL_EXTENDED = 4;
    private final Dex.Section annotationOut;
    private final Dex.Section annotationSetOut;
    private final Dex.Section annotationSetRefListOut;
    private final Dex.Section annotationsDirectoryOut;
    private final Dex.Section classDataOut;
    private final Dex.Section codeOut;
    private final CollisionPolicy collisionPolicy;
    private int compactWasteThreshold;
    private final TableOfContents contentsOut;
    private final Dex.Section debugInfoOut;
    private final Dex dexOut;
    private final Dex[] dexes;
    private final Dex.Section encodedArrayOut;
    private final Dex.Section headerOut;
    private final Dex.Section idsDefsOut;
    private final IndexMap[] indexMaps;
    private final InstructionTransformer instructionTransformer;
    private final Dex.Section mapListOut;
    private final Dex.Section stringDataOut;
    private final Dex.Section typeListOut;
    private final WriterSizes writerSizes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public abstract class IdMerger<T extends Comparable<T>> {
        private final Dex.Section out;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class UnsortedValue implements Comparable<IdMerger<T>.UnsortedValue> {
            final int index;
            final IndexMap indexMap;
            final int offset;
            final Dex source;
            final T value;

            UnsortedValue(Dex dex, IndexMap indexMap, T t3, int i4, int i5) {
                this.source = dex;
                this.indexMap = indexMap;
                this.value = t3;
                this.index = i4;
                this.offset = i5;
            }

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(Object obj) {
                return compareTo((UnsortedValue) ((UnsortedValue) obj));
            }

            public int compareTo(IdMerger<T>.UnsortedValue unsortedValue) {
                return this.value.compareTo(unsortedValue.value);
            }
        }

        protected IdMerger(Dex.Section section) {
            this.out = section;
        }

        private int readIntoMap(Dex.Section section, TableOfContents.Section section2, IndexMap indexMap, int i4, TreeMap<T, List<Integer>> treeMap, int i5) {
            int i6;
            if (section != null) {
                i6 = section.getPosition();
            } else {
                i6 = -1;
            }
            if (i4 < section2.size) {
                T read = read(section, indexMap, i4);
                List<Integer> list = treeMap.get(read);
                if (list == null) {
                    list = new ArrayList<>();
                    treeMap.put(read, list);
                }
                list.add(new Integer(i5));
            }
            return i6;
        }

        private List<IdMerger<T>.UnsortedValue> readUnsortedValues(Dex dex, IndexMap indexMap) {
            TableOfContents.Section section = getSection(dex.getTableOfContents());
            if (!section.exists()) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Dex.Section open = dex.open(section.off);
            for (int i4 = 0; i4 < section.size; i4++) {
                arrayList.add(new UnsortedValue(dex, indexMap, read(open, indexMap, 0), i4, open.getPosition()));
            }
            return arrayList;
        }

        abstract TableOfContents.Section getSection(TableOfContents tableOfContents);

        /* JADX WARN: Multi-variable type inference failed */
        public final void mergeSorted() {
            Dex.Section section;
            TableOfContents.Section[] sectionArr = new TableOfContents.Section[DexMerger.this.dexes.length];
            Dex.Section[] sectionArr2 = new Dex.Section[DexMerger.this.dexes.length];
            int[] iArr = new int[DexMerger.this.dexes.length];
            int[] iArr2 = new int[DexMerger.this.dexes.length];
            TreeMap treeMap = new TreeMap();
            int i4 = 0;
            for (int i5 = 0; i5 < DexMerger.this.dexes.length; i5++) {
                TableOfContents.Section section2 = getSection(DexMerger.this.dexes[i5].getTableOfContents());
                sectionArr[i5] = section2;
                if (section2.exists()) {
                    section = DexMerger.this.dexes[i5].open(sectionArr[i5].off);
                } else {
                    section = null;
                }
                Dex.Section section3 = section;
                sectionArr2[i5] = section3;
                iArr[i5] = readIntoMap(section3, sectionArr[i5], DexMerger.this.indexMaps[i5], iArr2[i5], treeMap, i5);
            }
            getSection(DexMerger.this.contentsOut).off = this.out.getPosition();
            while (!treeMap.isEmpty()) {
                Map.Entry pollFirstEntry = treeMap.pollFirstEntry();
                for (Integer num : (List) pollFirstEntry.getValue()) {
                    int i6 = iArr[num.intValue()];
                    IndexMap indexMap = DexMerger.this.indexMaps[num.intValue()];
                    int intValue = num.intValue();
                    int i7 = iArr2[intValue];
                    iArr2[intValue] = i7 + 1;
                    updateIndex(i6, indexMap, i7, i4);
                    iArr[num.intValue()] = readIntoMap(sectionArr2[num.intValue()], sectionArr[num.intValue()], DexMerger.this.indexMaps[num.intValue()], iArr2[num.intValue()], treeMap, num.intValue());
                }
                write((Comparable) pollFirstEntry.getKey());
                i4++;
            }
            getSection(DexMerger.this.contentsOut).size = i4;
        }

        public final void mergeUnsorted() {
            int i4;
            getSection(DexMerger.this.contentsOut).off = this.out.getPosition();
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < DexMerger.this.dexes.length; i5++) {
                arrayList.addAll(readUnsortedValues(DexMerger.this.dexes[i5], DexMerger.this.indexMaps[i5]));
            }
            Collections.sort(arrayList);
            int i6 = 0;
            for (int i7 = 0; i7 < arrayList.size(); i7 = i4) {
                i4 = i7 + 1;
                UnsortedValue unsortedValue = (UnsortedValue) arrayList.get(i7);
                int i8 = i6 - 1;
                updateIndex(unsortedValue.offset, unsortedValue.indexMap, unsortedValue.index, i8);
                while (i4 < arrayList.size() && unsortedValue.compareTo((UnsortedValue) ((UnsortedValue) arrayList.get(i4))) == 0) {
                    int i9 = i4 + 1;
                    UnsortedValue unsortedValue2 = (UnsortedValue) arrayList.get(i4);
                    updateIndex(unsortedValue2.offset, unsortedValue2.indexMap, unsortedValue2.index, i8);
                    i4 = i9;
                }
                write(unsortedValue.value);
                i6++;
            }
            getSection(DexMerger.this.contentsOut).size = i6;
        }

        abstract T read(Dex.Section section, IndexMap indexMap, int i4);

        abstract void updateIndex(int i4, IndexMap indexMap, int i5, int i6);

        abstract void write(T t3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class WriterSizes {
        private int annotation;
        private int annotationsDirectory;
        private int annotationsSet;
        private int annotationsSetRefList;
        private int classData;
        private int code;
        private int debugInfo;
        private int encodedArray;
        private int header;
        private int idsDefs;
        private int mapList;
        private int stringData;
        private int typeList;

        public WriterSizes(Dex[] dexArr) {
            this.header = 112;
            for (Dex dex : dexArr) {
                plus(dex.getTableOfContents(), false);
            }
            fourByteAlign();
        }

        private static int fourByteAlign(int i4) {
            return (i4 + 3) & (-4);
        }

        private void plus(TableOfContents tableOfContents, boolean z3) {
            this.idsDefs += (tableOfContents.stringIds.size * 4) + (tableOfContents.typeIds.size * 4) + (tableOfContents.protoIds.size * 12) + (tableOfContents.fieldIds.size * 8) + (tableOfContents.methodIds.size * 8) + (tableOfContents.classDefs.size * 32);
            this.mapList = (tableOfContents.sections.length * 12) + 4;
            this.typeList += fourByteAlign(tableOfContents.typeLists.byteCount);
            this.stringData += tableOfContents.stringDatas.byteCount;
            this.annotationsDirectory += tableOfContents.annotationsDirectories.byteCount;
            this.annotationsSet += tableOfContents.annotationSets.byteCount;
            this.annotationsSetRefList += tableOfContents.annotationSetRefLists.byteCount;
            if (z3) {
                this.code += tableOfContents.codes.byteCount;
                this.classData += tableOfContents.classDatas.byteCount;
                this.encodedArray += tableOfContents.encodedArrays.byteCount;
                this.annotation += tableOfContents.annotations.byteCount;
                this.debugInfo += tableOfContents.debugInfos.byteCount;
                return;
            }
            this.code += (int) Math.ceil(tableOfContents.codes.byteCount * 1.25d);
            this.classData += (int) Math.ceil(tableOfContents.classDatas.byteCount * 1.67d);
            this.encodedArray += tableOfContents.encodedArrays.byteCount * 2;
            this.annotation += (int) Math.ceil(tableOfContents.annotations.byteCount * 2);
            this.debugInfo += tableOfContents.debugInfos.byteCount * 2;
        }

        public int size() {
            return this.header + this.idsDefs + this.mapList + this.typeList + this.classData + this.code + this.stringData + this.debugInfo + this.encodedArray + this.annotationsDirectory + this.annotationsSet + this.annotationsSetRefList + this.annotation;
        }

        private void fourByteAlign() {
            this.header = fourByteAlign(this.header);
            this.idsDefs = fourByteAlign(this.idsDefs);
            this.mapList = fourByteAlign(this.mapList);
            this.typeList = fourByteAlign(this.typeList);
            this.classData = fourByteAlign(this.classData);
            this.code = fourByteAlign(this.code);
            this.stringData = fourByteAlign(this.stringData);
            this.debugInfo = fourByteAlign(this.debugInfo);
            this.encodedArray = fourByteAlign(this.encodedArray);
            this.annotationsDirectory = fourByteAlign(this.annotationsDirectory);
            this.annotationsSet = fourByteAlign(this.annotationsSet);
            this.annotationsSetRefList = fourByteAlign(this.annotationsSetRefList);
            this.annotation = fourByteAlign(this.annotation);
        }

        public WriterSizes(DexMerger dexMerger) {
            this.header = 112;
            this.header = dexMerger.headerOut.used();
            this.idsDefs = dexMerger.idsDefsOut.used();
            this.mapList = dexMerger.mapListOut.used();
            this.typeList = dexMerger.typeListOut.used();
            this.classData = dexMerger.classDataOut.used();
            this.code = dexMerger.codeOut.used();
            this.stringData = dexMerger.stringDataOut.used();
            this.debugInfo = dexMerger.debugInfoOut.used();
            this.encodedArray = dexMerger.encodedArrayOut.used();
            this.annotationsDirectory = dexMerger.annotationsDirectoryOut.used();
            this.annotationsSet = dexMerger.annotationSetOut.used();
            this.annotationsSetRefList = dexMerger.annotationSetRefListOut.used();
            this.annotation = dexMerger.annotationOut.used();
            fourByteAlign();
        }
    }

    public DexMerger(Dex[] dexArr, CollisionPolicy collisionPolicy) throws IOException {
        this(dexArr, collisionPolicy, new WriterSizes(dexArr));
    }

    private SortableType[] getSortedTypes() {
        boolean z3;
        int i4 = this.contentsOut.typeIds.size;
        SortableType[] sortableTypeArr = new SortableType[i4];
        int i5 = 0;
        while (true) {
            Dex[] dexArr = this.dexes;
            if (i5 >= dexArr.length) {
                break;
            }
            readSortableTypes(sortableTypeArr, dexArr[i5], this.indexMaps[i5]);
            i5++;
        }
        do {
            z3 = true;
            for (int i6 = 0; i6 < i4; i6++) {
                SortableType sortableType = sortableTypeArr[i6];
                if (sortableType != null && !sortableType.isDepthAssigned()) {
                    z3 &= sortableType.tryAssignDepth(sortableTypeArr);
                }
            }
        } while (!z3);
        Arrays.sort(sortableTypeArr, SortableType.NULLS_LAST_ORDER);
        int indexOf = Arrays.asList(sortableTypeArr).indexOf(null);
        if (indexOf != -1) {
            return (SortableType[]) Arrays.copyOfRange(sortableTypeArr, 0, indexOf);
        }
        return sortableTypeArr;
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 2) {
            printUsage();
            return;
        }
        Dex[] dexArr = new Dex[strArr.length - 1];
        for (int i4 = 1; i4 < strArr.length; i4++) {
            dexArr[i4 - 1] = new Dex(new File(strArr[i4]));
        }
        new DexMerger(dexArr, CollisionPolicy.KEEP_FIRST).merge().writeTo(new File(strArr[0]));
    }

    private void mergeAnnotations() {
        new IdMerger<Annotation>(this.annotationOut) { // from class: com.android.dx.merge.DexMerger.7
            @Override // com.android.dx.merge.DexMerger.IdMerger
            TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.annotations;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            void updateIndex(int i4, IndexMap indexMap, int i5, int i6) {
                indexMap.putAnnotationOffset(i4, DexMerger.this.annotationOut.getPosition());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public Annotation read(Dex.Section section, IndexMap indexMap, int i4) {
                return indexMap.adjust(section.readAnnotation());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(Annotation annotation) {
                annotation.writeTo(DexMerger.this.annotationOut);
            }
        }.mergeUnsorted();
    }

    private int mergeApiLevels() {
        int i4 = -1;
        int i5 = 0;
        while (true) {
            Dex[] dexArr = this.dexes;
            if (i5 < dexArr.length) {
                int i6 = dexArr[i5].getTableOfContents().apiLevel;
                if (i4 < i6) {
                    i4 = i6;
                }
                i5++;
            } else {
                return i4;
            }
        }
    }

    private void mergeClassDefs() {
        SortableType[] sortedTypes = getSortedTypes();
        this.contentsOut.classDefs.off = this.idsDefsOut.getPosition();
        this.contentsOut.classDefs.size = sortedTypes.length;
        for (SortableType sortableType : sortedTypes) {
            transformClassDef(sortableType.getDex(), sortableType.getClassDef(), sortableType.getIndexMap());
        }
    }

    private Dex mergeDexes() throws IOException {
        mergeStringIds();
        mergeTypeIds();
        mergeTypeLists();
        mergeProtoIds();
        mergeFieldIds();
        mergeMethodIds();
        mergeAnnotations();
        unionAnnotationSetsAndDirectories();
        mergeClassDefs();
        TableOfContents tableOfContents = this.contentsOut;
        TableOfContents.Section section = tableOfContents.header;
        section.off = 0;
        section.size = 1;
        tableOfContents.fileSize = this.dexOut.getLength();
        this.contentsOut.computeSizesFromOffsets();
        this.contentsOut.writeHeader(this.headerOut, mergeApiLevels());
        this.contentsOut.writeMap(this.mapListOut);
        this.dexOut.writeHashes();
        return this.dexOut;
    }

    private void mergeFieldIds() {
        new IdMerger<FieldId>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.5
            @Override // com.android.dx.merge.DexMerger.IdMerger
            TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.fieldIds;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            void updateIndex(int i4, IndexMap indexMap, int i5, int i6) {
                if (i6 >= 0 && i6 <= 65535) {
                    indexMap.fieldIds[i5] = (short) i6;
                    return;
                }
                throw new DexIndexOverflowException("field ID not in [0, 0xffff]: " + i6);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public FieldId read(Dex.Section section, IndexMap indexMap, int i4) {
                return indexMap.adjust(section.readFieldId());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(FieldId fieldId) {
                fieldId.writeTo(DexMerger.this.idsDefsOut);
            }
        }.mergeSorted();
    }

    private void mergeMethodIds() {
        new IdMerger<MethodId>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.6
            @Override // com.android.dx.merge.DexMerger.IdMerger
            TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.methodIds;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            void updateIndex(int i4, IndexMap indexMap, int i5, int i6) {
                if (i6 >= 0 && i6 <= 65535) {
                    indexMap.methodIds[i5] = (short) i6;
                    return;
                }
                throw new DexIndexOverflowException("method ID not in [0, 0xffff]: " + i6);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public MethodId read(Dex.Section section, IndexMap indexMap, int i4) {
                return indexMap.adjust(section.readMethodId());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(MethodId methodId) {
                methodId.writeTo(DexMerger.this.idsDefsOut);
            }
        }.mergeSorted();
    }

    private void mergeProtoIds() {
        new IdMerger<ProtoId>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.4
            @Override // com.android.dx.merge.DexMerger.IdMerger
            TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.protoIds;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            void updateIndex(int i4, IndexMap indexMap, int i5, int i6) {
                if (i6 >= 0 && i6 <= 65535) {
                    indexMap.protoIds[i5] = (short) i6;
                    return;
                }
                throw new DexIndexOverflowException("proto ID not in [0, 0xffff]: " + i6);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public ProtoId read(Dex.Section section, IndexMap indexMap, int i4) {
                return indexMap.adjust(section.readProtoId());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(ProtoId protoId) {
                protoId.writeTo(DexMerger.this.idsDefsOut);
            }
        }.mergeSorted();
    }

    private void mergeStringIds() {
        new IdMerger<String>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.1
            @Override // com.android.dx.merge.DexMerger.IdMerger
            TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.stringIds;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            void updateIndex(int i4, IndexMap indexMap, int i5, int i6) {
                indexMap.stringIds[i5] = i6;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public String read(Dex.Section section, IndexMap indexMap, int i4) {
                return section.readString();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(String str) {
                DexMerger.this.contentsOut.stringDatas.size++;
                DexMerger.this.idsDefsOut.writeInt(DexMerger.this.stringDataOut.getPosition());
                DexMerger.this.stringDataOut.writeStringData(str);
            }
        }.mergeSorted();
    }

    private void mergeTypeIds() {
        new IdMerger<Integer>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.2
            @Override // com.android.dx.merge.DexMerger.IdMerger
            TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.typeIds;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            void updateIndex(int i4, IndexMap indexMap, int i5, int i6) {
                if (i6 >= 0 && i6 <= 65535) {
                    indexMap.typeIds[i5] = (short) i6;
                    return;
                }
                throw new DexIndexOverflowException("type ID not in [0, 0xffff]: " + i6);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public Integer read(Dex.Section section, IndexMap indexMap, int i4) {
                return Integer.valueOf(indexMap.adjustString(section.readInt()));
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(Integer num) {
                DexMerger.this.idsDefsOut.writeInt(num.intValue());
            }
        }.mergeSorted();
    }

    private void mergeTypeLists() {
        new IdMerger<TypeList>(this.typeListOut) { // from class: com.android.dx.merge.DexMerger.3
            @Override // com.android.dx.merge.DexMerger.IdMerger
            TableOfContents.Section getSection(TableOfContents tableOfContents) {
                return tableOfContents.typeLists;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            void updateIndex(int i4, IndexMap indexMap, int i5, int i6) {
                indexMap.putTypeListOffset(i4, DexMerger.this.typeListOut.getPosition());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public TypeList read(Dex.Section section, IndexMap indexMap, int i4) {
                return indexMap.adjustTypeList(section.readTypeList());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(TypeList typeList) {
                DexMerger.this.typeListOut.writeTypeList(typeList);
            }
        }.mergeUnsorted();
    }

    private static void printUsage() {
        System.out.println("Usage: DexMerger <out.dex> <a.dex> <b.dex> ...");
        System.out.println();
        System.out.println("If a class is defined in several dex, the class found in the first dex will be used.");
    }

    private void readSortableTypes(SortableType[] sortableTypeArr, Dex dex, IndexMap indexMap) {
        for (ClassDef classDef : dex.classDefs()) {
            SortableType adjust = indexMap.adjust(new SortableType(dex, indexMap, classDef));
            int typeIndex = adjust.getTypeIndex();
            if (sortableTypeArr[typeIndex] == null) {
                sortableTypeArr[typeIndex] = adjust;
            } else if (this.collisionPolicy != CollisionPolicy.KEEP_FIRST) {
                throw new DexException("Multiple dex files define " + dex.typeNames().get(classDef.getTypeIndex()));
            }
        }
    }

    private void transformAnnotationDirectories(Dex dex, IndexMap indexMap) {
        TableOfContents.Section section = dex.getTableOfContents().annotationsDirectories;
        if (section.exists()) {
            Dex.Section open = dex.open(section.off);
            for (int i4 = 0; i4 < section.size; i4++) {
                transformAnnotationDirectory(open, indexMap);
            }
        }
    }

    private void transformAnnotationDirectory(Dex.Section section, IndexMap indexMap) {
        this.contentsOut.annotationsDirectories.size++;
        this.annotationsDirectoryOut.assertFourByteAligned();
        indexMap.putAnnotationDirectoryOffset(section.getPosition(), this.annotationsDirectoryOut.getPosition());
        this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSet(section.readInt()));
        int readInt = section.readInt();
        this.annotationsDirectoryOut.writeInt(readInt);
        int readInt2 = section.readInt();
        this.annotationsDirectoryOut.writeInt(readInt2);
        int readInt3 = section.readInt();
        this.annotationsDirectoryOut.writeInt(readInt3);
        for (int i4 = 0; i4 < readInt; i4++) {
            this.annotationsDirectoryOut.writeInt(indexMap.adjustField(section.readInt()));
            this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSet(section.readInt()));
        }
        for (int i5 = 0; i5 < readInt2; i5++) {
            this.annotationsDirectoryOut.writeInt(indexMap.adjustMethod(section.readInt()));
            this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSet(section.readInt()));
        }
        for (int i6 = 0; i6 < readInt3; i6++) {
            this.annotationsDirectoryOut.writeInt(indexMap.adjustMethod(section.readInt()));
            this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSetRefList(section.readInt()));
        }
    }

    private void transformAnnotationSet(IndexMap indexMap, Dex.Section section) {
        this.contentsOut.annotationSets.size++;
        this.annotationSetOut.assertFourByteAligned();
        indexMap.putAnnotationSetOffset(section.getPosition(), this.annotationSetOut.getPosition());
        int readInt = section.readInt();
        this.annotationSetOut.writeInt(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            this.annotationSetOut.writeInt(indexMap.adjustAnnotation(section.readInt()));
        }
    }

    private void transformAnnotationSetRefList(IndexMap indexMap, Dex.Section section) {
        this.contentsOut.annotationSetRefLists.size++;
        this.annotationSetRefListOut.assertFourByteAligned();
        indexMap.putAnnotationSetRefListOffset(section.getPosition(), this.annotationSetRefListOut.getPosition());
        int readInt = section.readInt();
        this.annotationSetRefListOut.writeInt(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            this.annotationSetRefListOut.writeInt(indexMap.adjustAnnotationSet(section.readInt()));
        }
    }

    private void transformAnnotationSetRefLists(Dex dex, IndexMap indexMap) {
        TableOfContents.Section section = dex.getTableOfContents().annotationSetRefLists;
        if (section.exists()) {
            Dex.Section open = dex.open(section.off);
            for (int i4 = 0; i4 < section.size; i4++) {
                transformAnnotationSetRefList(indexMap, open);
            }
        }
    }

    private void transformAnnotationSets(Dex dex, IndexMap indexMap) {
        TableOfContents.Section section = dex.getTableOfContents().annotationSets;
        if (section.exists()) {
            Dex.Section open = dex.open(section.off);
            for (int i4 = 0; i4 < section.size; i4++) {
                transformAnnotationSet(indexMap, open);
            }
        }
    }

    private int[] transformCatchHandlers(IndexMap indexMap, Code.CatchHandler[] catchHandlerArr) {
        int position = this.codeOut.getPosition();
        this.codeOut.writeUleb128(catchHandlerArr.length);
        int[] iArr = new int[catchHandlerArr.length];
        for (int i4 = 0; i4 < catchHandlerArr.length; i4++) {
            iArr[i4] = this.codeOut.getPosition() - position;
            transformEncodedCatchHandler(catchHandlerArr[i4], indexMap);
        }
        return iArr;
    }

    private void transformClassData(Dex dex, ClassData classData, IndexMap indexMap) {
        this.contentsOut.classDatas.size++;
        ClassData.Field[] staticFields = classData.getStaticFields();
        ClassData.Field[] instanceFields = classData.getInstanceFields();
        ClassData.Method[] directMethods = classData.getDirectMethods();
        ClassData.Method[] virtualMethods = classData.getVirtualMethods();
        this.classDataOut.writeUleb128(staticFields.length);
        this.classDataOut.writeUleb128(instanceFields.length);
        this.classDataOut.writeUleb128(directMethods.length);
        this.classDataOut.writeUleb128(virtualMethods.length);
        transformFields(indexMap, staticFields);
        transformFields(indexMap, instanceFields);
        transformMethods(dex, indexMap, directMethods);
        transformMethods(dex, indexMap, virtualMethods);
    }

    private void transformClassDef(Dex dex, ClassDef classDef, IndexMap indexMap) {
        this.idsDefsOut.assertFourByteAligned();
        this.idsDefsOut.writeInt(classDef.getTypeIndex());
        this.idsDefsOut.writeInt(classDef.getAccessFlags());
        this.idsDefsOut.writeInt(classDef.getSupertypeIndex());
        this.idsDefsOut.writeInt(classDef.getInterfacesOffset());
        this.idsDefsOut.writeInt(indexMap.adjustString(classDef.getSourceFileIndex()));
        this.idsDefsOut.writeInt(indexMap.adjustAnnotationDirectory(classDef.getAnnotationsOffset()));
        if (classDef.getClassDataOffset() == 0) {
            this.idsDefsOut.writeInt(0);
        } else {
            this.idsDefsOut.writeInt(this.classDataOut.getPosition());
            transformClassData(dex, dex.readClassData(classDef), indexMap);
        }
        this.idsDefsOut.writeInt(indexMap.adjustStaticValues(classDef.getStaticValuesOffset()));
    }

    private void transformCode(Dex dex, Code code, IndexMap indexMap) {
        this.contentsOut.codes.size++;
        this.codeOut.assertFourByteAligned();
        this.codeOut.writeUnsignedShort(code.getRegistersSize());
        this.codeOut.writeUnsignedShort(code.getInsSize());
        this.codeOut.writeUnsignedShort(code.getOutsSize());
        Code.Try[] tries = code.getTries();
        Code.CatchHandler[] catchHandlers = code.getCatchHandlers();
        this.codeOut.writeUnsignedShort(tries.length);
        int debugInfoOffset = code.getDebugInfoOffset();
        if (debugInfoOffset != 0) {
            this.codeOut.writeInt(this.debugInfoOut.getPosition());
            transformDebugInfoItem(dex.open(debugInfoOffset), indexMap);
        } else {
            this.codeOut.writeInt(0);
        }
        short[] transform = this.instructionTransformer.transform(indexMap, code.getInstructions());
        this.codeOut.writeInt(transform.length);
        this.codeOut.write(transform);
        if (tries.length > 0) {
            if (transform.length % 2 == 1) {
                this.codeOut.writeShort((short) 0);
            }
            Dex.Section open = this.dexOut.open(this.codeOut.getPosition());
            this.codeOut.skip(tries.length * 8);
            transformTries(open, tries, transformCatchHandlers(indexMap, catchHandlers));
        }
    }

    private void transformDebugInfoItem(Dex.Section section, IndexMap indexMap) {
        this.contentsOut.debugInfos.size++;
        this.debugInfoOut.writeUleb128(section.readUleb128());
        int readUleb128 = section.readUleb128();
        this.debugInfoOut.writeUleb128(readUleb128);
        for (int i4 = 0; i4 < readUleb128; i4++) {
            this.debugInfoOut.writeUleb128p1(indexMap.adjustString(section.readUleb128p1()));
        }
        while (true) {
            byte readByte = section.readByte();
            this.debugInfoOut.writeByte(readByte);
            if (readByte != 9) {
                switch (readByte) {
                    case 0:
                        return;
                    case 1:
                        this.debugInfoOut.writeUleb128(section.readUleb128());
                        continue;
                    case 2:
                        this.debugInfoOut.writeSleb128(section.readSleb128());
                        continue;
                    case 3:
                    case 4:
                        this.debugInfoOut.writeUleb128(section.readUleb128());
                        this.debugInfoOut.writeUleb128p1(indexMap.adjustString(section.readUleb128p1()));
                        this.debugInfoOut.writeUleb128p1(indexMap.adjustType(section.readUleb128p1()));
                        if (readByte == 4) {
                            this.debugInfoOut.writeUleb128p1(indexMap.adjustString(section.readUleb128p1()));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                    case 6:
                        this.debugInfoOut.writeUleb128(section.readUleb128());
                        continue;
                }
            } else {
                this.debugInfoOut.writeUleb128p1(indexMap.adjustString(section.readUleb128p1()));
            }
        }
    }

    private void transformEncodedCatchHandler(Code.CatchHandler catchHandler, IndexMap indexMap) {
        int catchAllAddress = catchHandler.getCatchAllAddress();
        int[] typeIndexes = catchHandler.getTypeIndexes();
        int[] addresses = catchHandler.getAddresses();
        if (catchAllAddress != -1) {
            this.codeOut.writeSleb128(-typeIndexes.length);
        } else {
            this.codeOut.writeSleb128(typeIndexes.length);
        }
        for (int i4 = 0; i4 < typeIndexes.length; i4++) {
            this.codeOut.writeUleb128(indexMap.adjustType(typeIndexes[i4]));
            this.codeOut.writeUleb128(addresses[i4]);
        }
        if (catchAllAddress != -1) {
            this.codeOut.writeUleb128(catchAllAddress);
        }
    }

    private void transformFields(IndexMap indexMap, ClassData.Field[] fieldArr) {
        int length = fieldArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            ClassData.Field field = fieldArr[i4];
            int adjustField = indexMap.adjustField(field.getFieldIndex());
            this.classDataOut.writeUleb128(adjustField - i5);
            this.classDataOut.writeUleb128(field.getAccessFlags());
            i4++;
            i5 = adjustField;
        }
    }

    private void transformMethods(Dex dex, IndexMap indexMap, ClassData.Method[] methodArr) {
        int length = methodArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            ClassData.Method method = methodArr[i4];
            int adjustMethod = indexMap.adjustMethod(method.getMethodIndex());
            this.classDataOut.writeUleb128(adjustMethod - i5);
            this.classDataOut.writeUleb128(method.getAccessFlags());
            if (method.getCodeOffset() == 0) {
                this.classDataOut.writeUleb128(0);
            } else {
                this.codeOut.alignToFourBytesWithZeroFill();
                this.classDataOut.writeUleb128(this.codeOut.getPosition());
                transformCode(dex, dex.readCode(method), indexMap);
            }
            i4++;
            i5 = adjustMethod;
        }
    }

    private void transformStaticValues(Dex dex, IndexMap indexMap) {
        TableOfContents.Section section = dex.getTableOfContents().encodedArrays;
        if (section.exists()) {
            Dex.Section open = dex.open(section.off);
            for (int i4 = 0; i4 < section.size; i4++) {
                transformStaticValues(open, indexMap);
            }
        }
    }

    private void transformTries(Dex.Section section, Code.Try[] tryArr, int[] iArr) {
        for (Code.Try r22 : tryArr) {
            section.writeInt(r22.getStartAddress());
            section.writeUnsignedShort(r22.getInstructionCount());
            section.writeUnsignedShort(iArr[r22.getCatchHandlerIndex()]);
        }
    }

    private void unionAnnotationSetsAndDirectories() {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            Dex[] dexArr = this.dexes;
            if (i5 >= dexArr.length) {
                break;
            }
            transformAnnotationSets(dexArr[i5], this.indexMaps[i5]);
            i5++;
        }
        int i6 = 0;
        while (true) {
            Dex[] dexArr2 = this.dexes;
            if (i6 >= dexArr2.length) {
                break;
            }
            transformAnnotationSetRefLists(dexArr2[i6], this.indexMaps[i6]);
            i6++;
        }
        int i7 = 0;
        while (true) {
            Dex[] dexArr3 = this.dexes;
            if (i7 >= dexArr3.length) {
                break;
            }
            transformAnnotationDirectories(dexArr3[i7], this.indexMaps[i7]);
            i7++;
        }
        while (true) {
            Dex[] dexArr4 = this.dexes;
            if (i4 < dexArr4.length) {
                transformStaticValues(dexArr4[i4], this.indexMaps[i4]);
                i4++;
            } else {
                return;
            }
        }
    }

    public Dex merge() throws IOException {
        Dex[] dexArr = this.dexes;
        if (dexArr.length == 1) {
            return dexArr[0];
        }
        if (dexArr.length == 0) {
            return null;
        }
        long nanoTime = System.nanoTime();
        Dex mergeDexes = mergeDexes();
        WriterSizes writerSizes = new WriterSizes(this);
        int size = this.writerSizes.size() - writerSizes.size();
        if (size > this.compactWasteThreshold) {
            mergeDexes = new DexMerger(new Dex[]{this.dexOut, new Dex(0)}, CollisionPolicy.FAIL, writerSizes).mergeDexes();
            System.out.printf("Result compacted from %.1fKiB to %.1fKiB to save %.1fKiB%n", Float.valueOf(this.dexOut.getLength() / 1024.0f), Float.valueOf(mergeDexes.getLength() / 1024.0f), Float.valueOf(size / 1024.0f));
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        int i4 = 0;
        while (i4 < this.dexes.length) {
            int i5 = i4 + 1;
            System.out.printf("Merged dex #%d (%d defs/%.1fKiB)%n", Integer.valueOf(i5), Integer.valueOf(this.dexes[i4].getTableOfContents().classDefs.size), Float.valueOf(this.dexes[i4].getLength() / 1024.0f));
            i4 = i5;
        }
        System.out.printf("Result is %d defs/%.1fKiB. Took %.1fs%n", Integer.valueOf(mergeDexes.getTableOfContents().classDefs.size), Float.valueOf(mergeDexes.getLength() / 1024.0f), Float.valueOf(((float) nanoTime2) / 1.0E9f));
        return mergeDexes;
    }

    public void setCompactWasteThreshold(int i4) {
        this.compactWasteThreshold = i4;
    }

    private DexMerger(Dex[] dexArr, CollisionPolicy collisionPolicy, WriterSizes writerSizes) throws IOException {
        this.compactWasteThreshold = 1048576;
        this.dexes = dexArr;
        this.collisionPolicy = collisionPolicy;
        this.writerSizes = writerSizes;
        this.dexOut = new Dex(writerSizes.size());
        this.indexMaps = new IndexMap[dexArr.length];
        for (int i4 = 0; i4 < dexArr.length; i4++) {
            this.indexMaps[i4] = new IndexMap(this.dexOut, dexArr[i4].getTableOfContents());
        }
        this.instructionTransformer = new InstructionTransformer();
        this.headerOut = this.dexOut.appendSection(writerSizes.header, "header");
        this.idsDefsOut = this.dexOut.appendSection(writerSizes.idsDefs, "ids defs");
        TableOfContents tableOfContents = this.dexOut.getTableOfContents();
        this.contentsOut = tableOfContents;
        tableOfContents.dataOff = this.dexOut.getNextSectionStart();
        tableOfContents.mapList.off = this.dexOut.getNextSectionStart();
        tableOfContents.mapList.size = 1;
        this.mapListOut = this.dexOut.appendSection(writerSizes.mapList, "map list");
        tableOfContents.typeLists.off = this.dexOut.getNextSectionStart();
        this.typeListOut = this.dexOut.appendSection(writerSizes.typeList, "type list");
        tableOfContents.annotationSetRefLists.off = this.dexOut.getNextSectionStart();
        this.annotationSetRefListOut = this.dexOut.appendSection(writerSizes.annotationsSetRefList, "annotation set ref list");
        tableOfContents.annotationSets.off = this.dexOut.getNextSectionStart();
        this.annotationSetOut = this.dexOut.appendSection(writerSizes.annotationsSet, "annotation sets");
        tableOfContents.classDatas.off = this.dexOut.getNextSectionStart();
        this.classDataOut = this.dexOut.appendSection(writerSizes.classData, "class data");
        tableOfContents.codes.off = this.dexOut.getNextSectionStart();
        this.codeOut = this.dexOut.appendSection(writerSizes.code, "code");
        tableOfContents.stringDatas.off = this.dexOut.getNextSectionStart();
        this.stringDataOut = this.dexOut.appendSection(writerSizes.stringData, "string data");
        tableOfContents.debugInfos.off = this.dexOut.getNextSectionStart();
        this.debugInfoOut = this.dexOut.appendSection(writerSizes.debugInfo, "debug info");
        tableOfContents.annotations.off = this.dexOut.getNextSectionStart();
        this.annotationOut = this.dexOut.appendSection(writerSizes.annotation, "annotation");
        tableOfContents.encodedArrays.off = this.dexOut.getNextSectionStart();
        this.encodedArrayOut = this.dexOut.appendSection(writerSizes.encodedArray, "encoded array");
        tableOfContents.annotationsDirectories.off = this.dexOut.getNextSectionStart();
        this.annotationsDirectoryOut = this.dexOut.appendSection(writerSizes.annotationsDirectory, "annotations directory");
        tableOfContents.dataSize = this.dexOut.getNextSectionStart() - tableOfContents.dataOff;
    }

    private void transformStaticValues(Dex.Section section, IndexMap indexMap) {
        this.contentsOut.encodedArrays.size++;
        indexMap.putStaticValuesOffset(section.getPosition(), this.encodedArrayOut.getPosition());
        indexMap.adjustEncodedArray(section.readEncodedArray()).writeTo(this.encodedArrayOut);
    }
}
