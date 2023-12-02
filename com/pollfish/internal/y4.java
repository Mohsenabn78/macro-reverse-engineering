package com.pollfish.internal;

import com.pollfish.builder.Params;
import com.pollfish.builder.Platform;
import com.pollfish.builder.Position;
import com.pollfish.builder.RewardInfo;
import com.pollfish.builder.UserProperties;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class y4 {
    @NotNull
    public static final x4 a(@NotNull Params params, boolean z3) {
        boolean z4;
        String str;
        String str2;
        String str3;
        String str4;
        CharSequence trim;
        CharSequence trim2;
        CharSequence trim3;
        CharSequence trim4;
        String apiKey = params.getApiKey();
        Boolean releaseMode = params.getReleaseMode();
        if (releaseMode != null) {
            z4 = releaseMode.booleanValue();
        } else {
            z4 = z3;
        }
        int surveyFormat = params.getSurveyFormat();
        boolean rewardMode = params.getRewardMode();
        boolean offerwallMode = params.getOfferwallMode();
        String requestUUID = params.getRequestUUID();
        if (requestUUID != null) {
            trim4 = StringsKt__StringsKt.trim(requestUUID);
            str = trim4.toString();
        } else {
            str = null;
        }
        String clickId = params.getClickId();
        if (clickId != null) {
            trim3 = StringsKt__StringsKt.trim(clickId);
            str2 = trim3.toString();
        } else {
            str2 = null;
        }
        String userId = params.getUserId();
        if (userId != null) {
            trim2 = StringsKt__StringsKt.trim(userId);
            str3 = trim2.toString();
        } else {
            str3 = null;
        }
        int a4 = z1.a(params.getIndicatorPosition());
        RewardInfo rewardInfo = params.getRewardInfo();
        UserProperties userProperties = params.getUserProperties();
        int indicatorPadding = params.getIndicatorPadding();
        Position indicatorPosition = params.getIndicatorPosition();
        Platform platform = params.getPlatform();
        if (platform == null) {
            platform = Platform.NATIVE;
        }
        Platform platform2 = platform;
        boolean z5 = !s5.a(params.getUserLayout());
        String signature = params.getSignature();
        if (signature != null) {
            trim = StringsKt__StringsKt.trim(signature);
            str4 = trim.toString();
        } else {
            str4 = null;
        }
        return new x4(apiKey, z4, surveyFormat, rewardMode, offerwallMode, str, str2, str3, a4, indicatorPosition, indicatorPadding, z5, platform2, rewardInfo, userProperties, str4);
    }
}
