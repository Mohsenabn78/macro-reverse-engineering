package com.obsez.android.lib.filechooser.internals;

import java.io.File;
import java.io.FileFilter;

/* loaded from: classes6.dex */
public class ExtFileFilter implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    boolean f36553a;

    /* renamed from: b  reason: collision with root package name */
    boolean f36554b;

    /* renamed from: c  reason: collision with root package name */
    String[] f36555c;

    public ExtFileFilter() {
        this(false, false, new String[0]);
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        if (!this.f36553a && file.isHidden()) {
            return false;
        }
        if (this.f36554b && !file.isDirectory()) {
            return false;
        }
        if (this.f36555c == null || file.isDirectory()) {
            return true;
        }
        String extensionWithoutDot = FileUtil.getExtensionWithoutDot(file);
        for (String str : this.f36555c) {
            if (extensionWithoutDot.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public ExtFileFilter(String... strArr) {
        this(false, false, strArr);
    }

    public ExtFileFilter(boolean z3, boolean z4, String... strArr) {
        this.f36553a = z4;
        this.f36554b = z3;
        this.f36555c = strArr;
    }
}
