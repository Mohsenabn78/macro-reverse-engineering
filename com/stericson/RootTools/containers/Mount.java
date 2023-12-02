package com.stericson.RootTools.containers;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class Mount {

    /* renamed from: a  reason: collision with root package name */
    final File f37501a;

    /* renamed from: b  reason: collision with root package name */
    final File f37502b;

    /* renamed from: c  reason: collision with root package name */
    final String f37503c;

    /* renamed from: d  reason: collision with root package name */
    final Set<String> f37504d;

    public Mount(File file, File file2, String str, String str2) {
        this.f37501a = file;
        this.f37502b = file2;
        this.f37503c = str;
        this.f37504d = new LinkedHashSet(Arrays.asList(str2.split(",")));
    }

    public File getDevice() {
        return this.f37501a;
    }

    public Set<String> getFlags() {
        return this.f37504d;
    }

    public File getMountPoint() {
        return this.f37502b;
    }

    public String getType() {
        return this.f37503c;
    }

    public String toString() {
        return String.format("%s on %s type %s %s", this.f37501a, this.f37502b, this.f37503c, this.f37504d);
    }
}
