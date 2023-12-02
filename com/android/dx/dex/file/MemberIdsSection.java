package com.android.dx.dex.file;

import com.android.dex.DexIndexOverflowException;
import com.android.dx.command.dexer.Main;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class MemberIdsSection extends UniformItemSection {
    public MemberIdsSection(String str, DexFile dexFile) {
        super(str, dexFile, 4);
    }

    private String getTooManyMembersMessage() {
        String str;
        TreeMap treeMap = new TreeMap();
        Iterator<? extends Item> it = items().iterator();
        while (it.hasNext()) {
            String packageName = ((MemberIdItem) it.next()).getDefiningClass().getPackageName();
            AtomicInteger atomicInteger = (AtomicInteger) treeMap.get(packageName);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                treeMap.put(packageName, atomicInteger);
            }
            atomicInteger.incrementAndGet();
        }
        Formatter formatter = new Formatter();
        try {
            if (this instanceof MethodIdsSection) {
                str = FirebaseAnalytics.Param.METHOD;
            } else {
                str = "field";
            }
            formatter.format("Too many %s references: %d; max is %d.%n" + Main.getTooManyIdsErrorMessage() + "%nReferences by package:", str, Integer.valueOf(items().size()), 65536);
            for (Map.Entry entry : treeMap.entrySet()) {
                formatter.format("%n%6d %s", Integer.valueOf(((AtomicInteger) entry.getValue()).get()), entry.getKey());
            }
            return formatter.toString();
        } finally {
            formatter.close();
        }
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    protected void orderItems() {
        if (items().size() <= 65536) {
            Iterator<? extends Item> it = items().iterator();
            int i4 = 0;
            while (it.hasNext()) {
                ((MemberIdItem) it.next()).setIndex(i4);
                i4++;
            }
            return;
        }
        throw new DexIndexOverflowException(getTooManyMembersMessage());
    }
}
