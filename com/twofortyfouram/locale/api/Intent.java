package com.twofortyfouram.locale.api;

import androidx.annotation.NonNull;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class Intent {
    @NonNull
    public static final String ACTION_EDIT_CONDITION = "com.twofortyfouram.locale.intent.action.EDIT_CONDITION";
    @NonNull
    public static final String ACTION_EDIT_SETTING = "com.twofortyfouram.locale.intent.action.EDIT_SETTING";
    @NonNull
    public static final String ACTION_FIRE_SETTING = "com.twofortyfouram.locale.intent.action.FIRE_SETTING";
    @NonNull
    public static final String ACTION_QUERY_CONDITION = "com.twofortyfouram.locale.intent.action.QUERY_CONDITION";
    @NonNull
    public static final String ACTION_REQUEST_QUERY = "com.twofortyfouram.locale.intent.action.REQUEST_QUERY";
    @NonNull
    public static final String EXTRA_BUNDLE = "com.twofortyfouram.locale.intent.extra.BUNDLE";
    @NonNull
    public static final String EXTRA_STRING_ACTIVITY_CLASS_NAME = "com.twofortyfouram.locale.intent.extra.ACTIVITY";
    @NonNull
    public static final String EXTRA_STRING_BLURB = "com.twofortyfouram.locale.intent.extra.BLURB";
    @NonNull
    public static final String EXTRA_STRING_BREADCRUMB = "com.twofortyfouram.locale.intent.extra.BREADCRUMB";
    public static final int RESULT_CONDITION_SATISFIED = 16;
    public static final int RESULT_CONDITION_UNKNOWN = 18;
    public static final int RESULT_CONDITION_UNSATISFIED = 17;

    private Intent() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }
}
