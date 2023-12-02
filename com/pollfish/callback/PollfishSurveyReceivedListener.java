package com.pollfish.callback;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/pollfish/callback/PollfishSurveyReceivedListener;", "", "onPollfishSurveyReceived", "", "surveyInfo", "Lcom/pollfish/callback/SurveyInfo;", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface PollfishSurveyReceivedListener {
    void onPollfishSurveyReceived(@Nullable SurveyInfo surveyInfo);
}