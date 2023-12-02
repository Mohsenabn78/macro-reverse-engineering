package com.google.common.net;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class UrlEscapers {

    /* renamed from: a  reason: collision with root package name */
    private static final Escaper f28137a = new PercentEscaper("-_.*", true);

    /* renamed from: b  reason: collision with root package name */
    private static final Escaper f28138b = new PercentEscaper("-._~!$'()*,;&=@:+", false);

    /* renamed from: c  reason: collision with root package name */
    private static final Escaper f28139c = new PercentEscaper("-._~!$'()*,;&=@:+/?", false);

    private UrlEscapers() {
    }

    public static Escaper urlFormParameterEscaper() {
        return f28137a;
    }

    public static Escaper urlFragmentEscaper() {
        return f28139c;
    }

    public static Escaper urlPathSegmentEscaper() {
        return f28138b;
    }
}
