package com.obsez.android.lib.filechooser.tool;

import java.io.File;

/* loaded from: classes6.dex */
public final class RootFile extends File {
    private String name;

    public RootFile(String str, String str2) {
        super(str);
        this.name = str2;
    }

    @Override // java.io.File
    public String getName() {
        return this.name;
    }

    @Override // java.io.File
    public boolean isDirectory() {
        return true;
    }

    @Override // java.io.File
    public boolean isHidden() {
        return false;
    }

    @Override // java.io.File
    public long lastModified() {
        return 0L;
    }
}
