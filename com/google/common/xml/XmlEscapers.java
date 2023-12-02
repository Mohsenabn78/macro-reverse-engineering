package com.google.common.xml;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.Typography;
import okio.Utf8;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public class XmlEscapers {

    /* renamed from: a  reason: collision with root package name */
    private static final Escaper f28688a;

    /* renamed from: b  reason: collision with root package name */
    private static final Escaper f28689b;

    /* renamed from: c  reason: collision with root package name */
    private static final Escaper f28690c;

    static {
        Escapers.Builder builder = Escapers.builder();
        builder.setSafeRange((char) 0, Utf8.REPLACEMENT_CHARACTER);
        builder.setUnsafeReplacement("�");
        for (char c4 = 0; c4 <= 31; c4 = (char) (c4 + 1)) {
            if (c4 != '\t' && c4 != '\n' && c4 != '\r') {
                builder.addEscape(c4, "�");
            }
        }
        builder.addEscape(Typography.amp, "&amp;");
        builder.addEscape(Typography.less, "&lt;");
        builder.addEscape(Typography.greater, "&gt;");
        f28689b = builder.build();
        builder.addEscape('\'', "&apos;");
        builder.addEscape(Typography.quote, "&quot;");
        f28688a = builder.build();
        builder.addEscape('\t', "&#x9;");
        builder.addEscape('\n', "&#xA;");
        builder.addEscape('\r', "&#xD;");
        f28690c = builder.build();
    }

    private XmlEscapers() {
    }

    public static Escaper xmlAttributeEscaper() {
        return f28690c;
    }

    public static Escaper xmlContentEscaper() {
        return f28689b;
    }
}
