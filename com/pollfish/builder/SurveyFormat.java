package com.pollfish.builder;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/pollfish/builder/SurveyFormat;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "BASIC", "PLAYFUL", "RANDOM", "MEDIATION", "INTERNAL", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public enum SurveyFormat {
    BASIC(0),
    PLAYFUL(1),
    RANDOM(2),
    MEDIATION(3),
    INTERNAL(4);
    
    private final int value;

    SurveyFormat(int i4) {
        this.value = i4;
    }

    public final int getValue() {
        return this.value;
    }
}
