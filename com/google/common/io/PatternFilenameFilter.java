package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class PatternFilenameFilter implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    private final Pattern f28034a;

    public PatternFilenameFilter(String str) {
        this(Pattern.compile(str));
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.f28034a.matcher(str).matches();
    }

    public PatternFilenameFilter(Pattern pattern) {
        this.f28034a = (Pattern) Preconditions.checkNotNull(pattern);
    }
}
