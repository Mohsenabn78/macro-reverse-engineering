package com.stericson.RootTools.containers;

import java.io.File;

/* loaded from: classes6.dex */
public class Symlink {

    /* renamed from: a  reason: collision with root package name */
    protected final File f37511a;

    /* renamed from: b  reason: collision with root package name */
    protected final File f37512b;

    public Symlink(File file, File file2) {
        this.f37511a = file;
        this.f37512b = file2;
    }

    public File getFile() {
        return this.f37511a;
    }

    public File getSymlinkPath() {
        return this.f37512b;
    }
}
