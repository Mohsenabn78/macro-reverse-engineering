package com.android.dx.command.grep;

import com.android.dex.Dex;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class Main {
    public static void main(String[] strArr) throws IOException {
        int i4 = 0;
        if (new Grep(new Dex(new File(strArr[0])), Pattern.compile(strArr[1]), new PrintWriter(System.out)).grep() <= 0) {
            i4 = 1;
        }
        System.exit(i4);
    }
}
