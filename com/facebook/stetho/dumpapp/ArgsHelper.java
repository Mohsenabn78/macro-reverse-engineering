package com.facebook.stetho.dumpapp;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ArgsHelper {
    public static String[] drainToArray(Iterator<String> it) {
        ArrayList arrayList = new ArrayList();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String nextArg(Iterator<String> it, String str) throws DumpUsageException {
        if (it.hasNext()) {
            return it.next();
        }
        throw new DumpUsageException(str);
    }

    public static String nextOptionalArg(Iterator<String> it, String str) {
        if (it.hasNext()) {
            return it.next();
        }
        return str;
    }
}
