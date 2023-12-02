package com.android.dx.io;

import com.android.dex.ClassDef;
import com.android.dex.Dex;
import com.android.dex.FieldId;
import com.android.dex.MethodId;
import com.android.dex.ProtoId;
import com.android.dex.TableOfContents;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class DexIndexPrinter {
    private final Dex dex;
    private final TableOfContents tableOfContents;

    public DexIndexPrinter(File file) throws IOException {
        Dex dex = new Dex(file);
        this.dex = dex;
        this.tableOfContents = dex.getTableOfContents();
    }

    public static void main(String[] strArr) throws IOException {
        DexIndexPrinter dexIndexPrinter = new DexIndexPrinter(new File(strArr[0]));
        dexIndexPrinter.printMap();
        dexIndexPrinter.printStrings();
        dexIndexPrinter.printTypeIds();
        dexIndexPrinter.printProtoIds();
        dexIndexPrinter.printFieldIds();
        dexIndexPrinter.printMethodIds();
        dexIndexPrinter.printTypeLists();
        dexIndexPrinter.printClassDefs();
    }

    private void printClassDefs() {
        Iterator<ClassDef> it = this.dex.classDefs().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            PrintStream printStream = System.out;
            printStream.println("class def " + i4 + ": " + it.next());
            i4++;
        }
    }

    private void printFieldIds() throws IOException {
        Iterator<FieldId> it = this.dex.fieldIds().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            PrintStream printStream = System.out;
            printStream.println("field " + i4 + ": " + it.next());
            i4++;
        }
    }

    private void printMap() {
        TableOfContents.Section[] sectionArr;
        for (TableOfContents.Section section : this.tableOfContents.sections) {
            if (section.off != -1) {
                System.out.println("section " + Integer.toHexString(section.type) + " off=" + Integer.toHexString(section.off) + " size=" + Integer.toHexString(section.size) + " byteCount=" + Integer.toHexString(section.byteCount));
            }
        }
    }

    private void printMethodIds() throws IOException {
        Iterator<MethodId> it = this.dex.methodIds().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            PrintStream printStream = System.out;
            printStream.println("methodId " + i4 + ": " + it.next());
            i4++;
        }
    }

    private void printProtoIds() throws IOException {
        Iterator<ProtoId> it = this.dex.protoIds().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            PrintStream printStream = System.out;
            printStream.println("proto " + i4 + ": " + it.next());
            i4++;
        }
    }

    private void printStrings() throws IOException {
        Iterator<String> it = this.dex.strings().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            PrintStream printStream = System.out;
            printStream.println("string " + i4 + ": " + it.next());
            i4++;
        }
    }

    private void printTypeIds() throws IOException {
        Iterator<Integer> it = this.dex.typeIds().iterator();
        int i4 = 0;
        while (it.hasNext()) {
            PrintStream printStream = System.out;
            printStream.println("type " + i4 + ": " + this.dex.strings().get(it.next().intValue()));
            i4++;
        }
    }

    private void printTypeLists() throws IOException {
        int i4 = this.tableOfContents.typeLists.off;
        if (i4 == -1) {
            System.out.println("No type lists");
            return;
        }
        Dex.Section open = this.dex.open(i4);
        for (int i5 = 0; i5 < this.tableOfContents.typeLists.size; i5++) {
            int readInt = open.readInt();
            PrintStream printStream = System.out;
            printStream.print("Type list i=" + i5 + ", size=" + readInt + ", elements=");
            for (int i6 = 0; i6 < readInt; i6++) {
                PrintStream printStream2 = System.out;
                printStream2.print(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.dex.typeNames().get(open.readShort()));
            }
            if (readInt % 2 == 1) {
                open.readShort();
            }
            System.out.println();
        }
    }
}
