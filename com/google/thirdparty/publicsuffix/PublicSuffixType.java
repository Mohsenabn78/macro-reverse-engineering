package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@Beta
@GwtCompatible
/* loaded from: classes6.dex */
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY('!', '?');
    
    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char c4, char c5) {
        this.innerNodeCode = c4;
        this.leafNodeCode = c5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PublicSuffixType b(char c4) {
        PublicSuffixType[] values;
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.c() == c4 || publicSuffixType.e() == c4) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c4);
    }

    char c() {
        return this.innerNodeCode;
    }

    char e() {
        return this.leafNodeCode;
    }
}
