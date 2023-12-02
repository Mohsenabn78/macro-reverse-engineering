package com.android.dx.command.dump;

import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.util.ByteArray;
import java.io.PrintStream;

/* loaded from: classes2.dex */
public final class ClassDumper extends BaseDumper {
    private ClassDumper(byte[] bArr, PrintStream printStream, String str, Args args) {
        super(bArr, printStream, str, args);
    }

    public static void dump(byte[] bArr, PrintStream printStream, String str, Args args) {
        new ClassDumper(bArr, printStream, str, args).dump();
    }

    public void dump() {
        byte[] bytes = getBytes();
        ByteArray byteArray = new ByteArray(bytes);
        DirectClassFile directClassFile = new DirectClassFile(byteArray, getFilePath(), getStrictParse());
        directClassFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
        directClassFile.setObserver(this);
        directClassFile.getMagic();
        int at = getAt();
        if (at != bytes.length) {
            parsed(byteArray, at, bytes.length - at, "<extra data at end of file>");
        }
    }
}
