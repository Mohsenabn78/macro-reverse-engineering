package com.obsez.android.lib.filechooser.internals;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class RegexFileFilter implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    boolean f36558a;

    /* renamed from: b  reason: collision with root package name */
    boolean f36559b;

    /* renamed from: c  reason: collision with root package name */
    Pattern f36560c;

    public RegexFileFilter() {
        this(null);
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        if (!this.f36558a && file.isHidden()) {
            return false;
        }
        if (this.f36559b && !file.isDirectory()) {
            return false;
        }
        if (this.f36560c == null || file.isDirectory()) {
            return true;
        }
        if (!this.f36560c.matcher(file.getName()).matches()) {
            return false;
        }
        return true;
    }

    public RegexFileFilter(Pattern pattern) {
        this(false, false, pattern);
    }

    public RegexFileFilter(boolean z3, boolean z4, String str) {
        this.f36558a = z4;
        this.f36559b = z3;
        this.f36560c = Pattern.compile(str, 2);
    }

    public RegexFileFilter(boolean z3, boolean z4, String str, int i4) {
        this.f36558a = z4;
        this.f36559b = z3;
        this.f36560c = Pattern.compile(str, i4);
    }

    public RegexFileFilter(boolean z3, boolean z4, Pattern pattern) {
        this.f36558a = z4;
        this.f36559b = z3;
        this.f36560c = pattern;
    }
}
