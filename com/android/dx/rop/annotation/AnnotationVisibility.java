package com.android.dx.rop.annotation;

import com.android.dx.util.ToHuman;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;

/* loaded from: classes2.dex */
public enum AnnotationVisibility implements ToHuman {
    RUNTIME("runtime"),
    BUILD("build"),
    SYSTEM(HelperCommandsKt.HELPER_SETTING_TYPE_SYSTEM),
    EMBEDDED("embedded");
    
    private final String human;

    AnnotationVisibility(String str) {
        this.human = str;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return this.human;
    }
}
