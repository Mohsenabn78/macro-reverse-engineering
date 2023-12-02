package com.pollfish.builder;

import android.view.ViewGroup;
import com.android.dx.rop.code.RegisterSpec;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pollfish.callback.PollfishClosedListener;
import com.pollfish.callback.PollfishOpenedListener;
import com.pollfish.callback.PollfishSurveyCompletedListener;
import com.pollfish.callback.PollfishSurveyNotAvailableListener;
import com.pollfish.callback.PollfishSurveyReceivedListener;
import com.pollfish.callback.PollfishUserNotEligibleListener;
import com.pollfish.callback.PollfishUserRejectedSurveyListener;
import com.pollfish.internal.f0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.m;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001uBÙ\u0001\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010(\u001a\u0004\u0018\u00010#\u0012\b\u0010.\u001a\u0004\u0018\u00010)\u0012\u0006\u00101\u001a\u00020\u000e\u0012\u0006\u00106\u001a\u00020#\u0012\u0006\u00109\u001a\u00020#\u0012\b\u0010?\u001a\u0004\u0018\u00010:\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010H\u001a\u0004\u0018\u00010C\u0012\b\u0010N\u001a\u0004\u0018\u00010I\u0012\b\u0010T\u001a\u0004\u0018\u00010O\u0012\b\u0010Z\u001a\u0004\u0018\u00010U\u0012\b\u0010`\u001a\u0004\u0018\u00010[\u0012\b\u0010f\u001a\u0004\u0018\u00010a\u0012\b\u0010l\u001a\u0004\u0018\u00010g\u0012\b\u0010r\u001a\u0004\u0018\u00010m¢\u0006\u0004\bs\u0010tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010(\u001a\u0004\u0018\u00010#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010.\u001a\u0004\u0018\u00010)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u00101\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b/\u0010\u0010\u001a\u0004\b0\u0010\u0012R\u0017\u00106\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u00109\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u00105R\u0019\u0010?\u001a\u0004\u0018\u00010:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010B\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0006R\u0019\u0010H\u001a\u0004\u0018\u00010C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0019\u0010N\u001a\u0004\u0018\u00010I8\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0019\u0010T\u001a\u0004\u0018\u00010O8\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR\u0019\u0010Z\u001a\u0004\u0018\u00010U8\u0006¢\u0006\f\n\u0004\bV\u0010W\u001a\u0004\bX\u0010YR\u0019\u0010`\u001a\u0004\u0018\u00010[8\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0019\u0010f\u001a\u0004\u0018\u00010a8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0019\u0010l\u001a\u0004\u0018\u00010g8\u0006¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0019\u0010r\u001a\u0004\u0018\u00010m8\u0006¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q¨\u0006v"}, d2 = {"Lcom/pollfish/builder/Params;", "", "", "a", "Ljava/lang/String;", "getApiKey", "()Ljava/lang/String;", "apiKey", "Lcom/pollfish/builder/Position;", "b", "Lcom/pollfish/builder/Position;", "getIndicatorPosition", "()Lcom/pollfish/builder/Position;", "indicatorPosition", "", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "I", "getIndicatorPadding", "()I", "indicatorPadding", "d", "getRequestUUID", "requestUUID", "e", "getClickId", "clickId", "f", "getUserId", "userId", "Landroid/view/ViewGroup;", "g", "Landroid/view/ViewGroup;", "getUserLayout", "()Landroid/view/ViewGroup;", "userLayout", "", "h", "Ljava/lang/Boolean;", "getReleaseMode", "()Ljava/lang/Boolean;", "releaseMode", "Lcom/pollfish/builder/UserProperties;", "i", "Lcom/pollfish/builder/UserProperties;", "getUserProperties", "()Lcom/pollfish/builder/UserProperties;", "userProperties", "j", "getSurveyFormat", "surveyFormat", "k", "Z", "getRewardMode", "()Z", "rewardMode", "l", "getOfferwallMode", "offerwallMode", "Lcom/pollfish/builder/RewardInfo;", "m", "Lcom/pollfish/builder/RewardInfo;", "getRewardInfo", "()Lcom/pollfish/builder/RewardInfo;", "rewardInfo", "n", "getSignature", "signature", "Lcom/pollfish/builder/Platform;", "o", "Lcom/pollfish/builder/Platform;", "getPlatform", "()Lcom/pollfish/builder/Platform;", "platform", "Lcom/pollfish/callback/PollfishSurveyNotAvailableListener;", "p", "Lcom/pollfish/callback/PollfishSurveyNotAvailableListener;", "getPollfishSurveyNotAvailableListener", "()Lcom/pollfish/callback/PollfishSurveyNotAvailableListener;", "pollfishSurveyNotAvailableListener", "Lcom/pollfish/callback/PollfishUserNotEligibleListener;", "q", "Lcom/pollfish/callback/PollfishUserNotEligibleListener;", "getPollfishUserNotEligibleListener", "()Lcom/pollfish/callback/PollfishUserNotEligibleListener;", "pollfishUserNotEligibleListener", "Lcom/pollfish/callback/PollfishOpenedListener;", "r", "Lcom/pollfish/callback/PollfishOpenedListener;", "getPollfishOpenedListener", "()Lcom/pollfish/callback/PollfishOpenedListener;", "pollfishOpenedListener", "Lcom/pollfish/callback/PollfishClosedListener;", "s", "Lcom/pollfish/callback/PollfishClosedListener;", "getPollfishClosedListener", "()Lcom/pollfish/callback/PollfishClosedListener;", "pollfishClosedListener", "Lcom/pollfish/callback/PollfishSurveyReceivedListener;", "t", "Lcom/pollfish/callback/PollfishSurveyReceivedListener;", "getPollfishSurveyReceivedListener", "()Lcom/pollfish/callback/PollfishSurveyReceivedListener;", "pollfishSurveyReceivedListener", "Lcom/pollfish/callback/PollfishSurveyCompletedListener;", "u", "Lcom/pollfish/callback/PollfishSurveyCompletedListener;", "getPollfishSurveyCompletedListener", "()Lcom/pollfish/callback/PollfishSurveyCompletedListener;", "pollfishSurveyCompletedListener", "Lcom/pollfish/callback/PollfishUserRejectedSurveyListener;", RegisterSpec.PREFIX, "Lcom/pollfish/callback/PollfishUserRejectedSurveyListener;", "getPollfishUserRejectedSurveyListener", "()Lcom/pollfish/callback/PollfishUserRejectedSurveyListener;", "pollfishUserRejectedSurveyListener", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;Lcom/pollfish/builder/Position;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/ViewGroup;Ljava/lang/Boolean;Lcom/pollfish/builder/UserProperties;IZZLcom/pollfish/builder/RewardInfo;Ljava/lang/String;Lcom/pollfish/builder/Platform;Lcom/pollfish/callback/PollfishSurveyNotAvailableListener;Lcom/pollfish/callback/PollfishUserNotEligibleListener;Lcom/pollfish/callback/PollfishOpenedListener;Lcom/pollfish/callback/PollfishClosedListener;Lcom/pollfish/callback/PollfishSurveyReceivedListener;Lcom/pollfish/callback/PollfishSurveyCompletedListener;Lcom/pollfish/callback/PollfishUserRejectedSurveyListener;)V", "Builder", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class Params {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f36585a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Position f36586b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36587c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f36588d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f36589e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f36590f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final ViewGroup f36591g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Boolean f36592h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final UserProperties f36593i;

    /* renamed from: j  reason: collision with root package name */
    private final int f36594j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f36595k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f36596l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private final RewardInfo f36597m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private final String f36598n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    private final Platform f36599o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private final PollfishSurveyNotAvailableListener f36600p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private final PollfishUserNotEligibleListener f36601q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private final PollfishOpenedListener f36602r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private final PollfishClosedListener f36603s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private final PollfishSurveyReceivedListener f36604t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private final PollfishSurveyCompletedListener f36605u;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    private final PollfishUserRejectedSurveyListener f36606v;

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020\u0006¢\u0006\u0004\bS\u0010TJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(J\u0006\u0010+\u001a\u00020*R\u0014\u0010.\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010-R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010-R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010-R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00102R\u0016\u0010\u0012\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010>R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010-R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010R¨\u0006U"}, d2 = {"Lcom/pollfish/builder/Params$Builder;", "", "Lcom/pollfish/builder/Position;", "indicatorPosition", "", "indicatorPadding", "", "requestUUID", "clickId", "userId", "Landroid/view/ViewGroup;", "userLayout", "", "releaseMode", "Lcom/pollfish/builder/UserProperties;", "userProperties", "Lcom/pollfish/builder/SurveyFormat;", "surveyFormat", "rewardMode", "isOfferWall", "offerwallMode", "Lcom/pollfish/builder/RewardInfo;", "info", "rewardInfo", "signature", "Lcom/pollfish/builder/Platform;", "platform", "Lcom/pollfish/callback/PollfishSurveyNotAvailableListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "pollfishSurveyNotAvailableListener", "Lcom/pollfish/callback/PollfishUserNotEligibleListener;", "pollfishUserNotEligibleListener", "Lcom/pollfish/callback/PollfishOpenedListener;", "pollfishOpenedListener", "Lcom/pollfish/callback/PollfishClosedListener;", "pollfishClosedListener", "Lcom/pollfish/callback/PollfishSurveyReceivedListener;", "pollfishSurveyReceivedListener", "Lcom/pollfish/callback/PollfishSurveyCompletedListener;", "pollfishSurveyCompletedListener", "Lcom/pollfish/callback/PollfishUserRejectedSurveyListener;", "pollfishUserRejectedSurveyListener", "Lcom/pollfish/builder/Params;", "build", "a", "Ljava/lang/String;", "apiKey", "b", "Lcom/pollfish/builder/Position;", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "I", "d", "e", "f", "g", "Landroid/view/ViewGroup;", "h", "Ljava/lang/Boolean;", "i", "Lcom/pollfish/builder/UserProperties;", "j", "k", "Z", "l", "m", "Lcom/pollfish/builder/RewardInfo;", "n", "o", "Lcom/pollfish/builder/Platform;", "p", "Lcom/pollfish/callback/PollfishSurveyNotAvailableListener;", "q", "Lcom/pollfish/callback/PollfishUserNotEligibleListener;", "r", "Lcom/pollfish/callback/PollfishOpenedListener;", "s", "Lcom/pollfish/callback/PollfishClosedListener;", "t", "Lcom/pollfish/callback/PollfishSurveyReceivedListener;", "u", "Lcom/pollfish/callback/PollfishSurveyCompletedListener;", RegisterSpec.PREFIX, "Lcom/pollfish/callback/PollfishUserRejectedSurveyListener;", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;)V", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class Builder {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f36607a;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private String f36610d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private String f36611e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private String f36612f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private ViewGroup f36613g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private Boolean f36614h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private UserProperties f36615i;

        /* renamed from: k  reason: collision with root package name */
        private boolean f36617k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f36618l;
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        private RewardInfo f36619m;
        @Nullable

        /* renamed from: n  reason: collision with root package name */
        private String f36620n;
        @Nullable

        /* renamed from: o  reason: collision with root package name */
        private Platform f36621o;
        @Nullable

        /* renamed from: p  reason: collision with root package name */
        private PollfishSurveyNotAvailableListener f36622p;
        @Nullable

        /* renamed from: q  reason: collision with root package name */
        private PollfishUserNotEligibleListener f36623q;
        @Nullable

        /* renamed from: r  reason: collision with root package name */
        private PollfishOpenedListener f36624r;
        @Nullable

        /* renamed from: s  reason: collision with root package name */
        private PollfishClosedListener f36625s;
        @Nullable

        /* renamed from: t  reason: collision with root package name */
        private PollfishSurveyReceivedListener f36626t;
        @Nullable

        /* renamed from: u  reason: collision with root package name */
        private PollfishSurveyCompletedListener f36627u;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        private PollfishUserRejectedSurveyListener f36628v;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private Position f36608b = f0.a();

        /* renamed from: c  reason: collision with root package name */
        private int f36609c = 8;

        /* renamed from: j  reason: collision with root package name */
        private int f36616j = -1;

        public Builder(@NotNull String str) {
            this.f36607a = str;
        }

        @NotNull
        public final Params build() {
            boolean z3;
            String str = this.f36607a;
            if (str != null && str.length() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3) {
                String str2 = this.f36607a;
                Position position = this.f36608b;
                int i4 = this.f36609c;
                String str3 = this.f36610d;
                String str4 = this.f36611e;
                String str5 = this.f36612f;
                Boolean bool = this.f36614h;
                ViewGroup viewGroup = this.f36613g;
                UserProperties userProperties = this.f36615i;
                int i5 = this.f36616j;
                boolean z4 = this.f36617k;
                boolean z5 = this.f36618l;
                RewardInfo rewardInfo = this.f36619m;
                String str6 = this.f36620n;
                Platform platform = this.f36621o;
                PollfishSurveyNotAvailableListener pollfishSurveyNotAvailableListener = this.f36622p;
                PollfishSurveyCompletedListener pollfishSurveyCompletedListener = this.f36627u;
                PollfishSurveyReceivedListener pollfishSurveyReceivedListener = this.f36626t;
                return new Params(str2, position, i4, str3, str4, str5, viewGroup, bool, userProperties, i5, z4, z5, rewardInfo, str6, platform, pollfishSurveyNotAvailableListener, this.f36623q, this.f36624r, this.f36625s, pollfishSurveyReceivedListener, pollfishSurveyCompletedListener, this.f36628v, null);
            }
            throw new IllegalArgumentException("`API KEY should not be empty`");
        }

        @NotNull
        public final Builder clickId(@NotNull String str) {
            boolean isBlank;
            isBlank = m.isBlank(str);
            if (!isBlank) {
                this.f36611e = str;
            }
            return this;
        }

        @NotNull
        public final Builder indicatorPadding(int i4) {
            this.f36609c = i4;
            return this;
        }

        @NotNull
        public final Builder indicatorPosition(@NotNull Position position) {
            this.f36608b = position;
            return this;
        }

        @NotNull
        public final Builder offerwallMode(boolean z3) {
            this.f36618l = z3;
            return this;
        }

        @NotNull
        public final Builder platform(@NotNull Platform platform) {
            this.f36621o = platform;
            return this;
        }

        @NotNull
        public final Builder pollfishClosedListener(@NotNull PollfishClosedListener pollfishClosedListener) {
            this.f36625s = pollfishClosedListener;
            return this;
        }

        @NotNull
        public final Builder pollfishOpenedListener(@NotNull PollfishOpenedListener pollfishOpenedListener) {
            this.f36624r = pollfishOpenedListener;
            return this;
        }

        @NotNull
        public final Builder pollfishSurveyCompletedListener(@NotNull PollfishSurveyCompletedListener pollfishSurveyCompletedListener) {
            this.f36627u = pollfishSurveyCompletedListener;
            return this;
        }

        @NotNull
        public final Builder pollfishSurveyNotAvailableListener(@NotNull PollfishSurveyNotAvailableListener pollfishSurveyNotAvailableListener) {
            this.f36622p = pollfishSurveyNotAvailableListener;
            return this;
        }

        @NotNull
        public final Builder pollfishSurveyReceivedListener(@NotNull PollfishSurveyReceivedListener pollfishSurveyReceivedListener) {
            this.f36626t = pollfishSurveyReceivedListener;
            return this;
        }

        @NotNull
        public final Builder pollfishUserNotEligibleListener(@NotNull PollfishUserNotEligibleListener pollfishUserNotEligibleListener) {
            this.f36623q = pollfishUserNotEligibleListener;
            return this;
        }

        @NotNull
        public final Builder pollfishUserRejectedSurveyListener(@NotNull PollfishUserRejectedSurveyListener pollfishUserRejectedSurveyListener) {
            this.f36628v = pollfishUserRejectedSurveyListener;
            return this;
        }

        @NotNull
        public final Builder releaseMode(boolean z3) {
            this.f36614h = Boolean.valueOf(z3);
            return this;
        }

        @NotNull
        public final Builder requestUUID(@NotNull String str) {
            boolean isBlank;
            isBlank = m.isBlank(str);
            if (!isBlank) {
                this.f36610d = str;
            }
            return this;
        }

        @NotNull
        public final Builder rewardInfo(@NotNull RewardInfo rewardInfo) {
            this.f36619m = rewardInfo;
            return this;
        }

        @NotNull
        public final Builder rewardMode(boolean z3) {
            this.f36617k = z3;
            return this;
        }

        @NotNull
        public final Builder signature(@NotNull String str) {
            boolean isBlank;
            isBlank = m.isBlank(str);
            if (!isBlank) {
                this.f36620n = str;
            }
            return this;
        }

        @NotNull
        public final Builder surveyFormat(@NotNull SurveyFormat surveyFormat) {
            this.f36616j = surveyFormat.getValue();
            return this;
        }

        @NotNull
        public final Builder userId(@NotNull String str) {
            boolean isBlank;
            isBlank = m.isBlank(str);
            if (!isBlank) {
                this.f36612f = str;
            }
            return this;
        }

        @NotNull
        public final Builder userLayout(@NotNull ViewGroup viewGroup) {
            this.f36613g = viewGroup;
            return this;
        }

        @NotNull
        public final Builder userProperties(@NotNull UserProperties userProperties) {
            this.f36615i = userProperties;
            return this;
        }
    }

    public /* synthetic */ Params(String str, Position position, int i4, String str2, String str3, String str4, ViewGroup viewGroup, Boolean bool, UserProperties userProperties, int i5, boolean z3, boolean z4, RewardInfo rewardInfo, String str5, Platform platform, PollfishSurveyNotAvailableListener pollfishSurveyNotAvailableListener, PollfishUserNotEligibleListener pollfishUserNotEligibleListener, PollfishOpenedListener pollfishOpenedListener, PollfishClosedListener pollfishClosedListener, PollfishSurveyReceivedListener pollfishSurveyReceivedListener, PollfishSurveyCompletedListener pollfishSurveyCompletedListener, PollfishUserRejectedSurveyListener pollfishUserRejectedSurveyListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, position, i4, str2, str3, str4, viewGroup, bool, userProperties, i5, z3, z4, rewardInfo, str5, platform, pollfishSurveyNotAvailableListener, pollfishUserNotEligibleListener, pollfishOpenedListener, pollfishClosedListener, pollfishSurveyReceivedListener, pollfishSurveyCompletedListener, pollfishUserRejectedSurveyListener);
    }

    @NotNull
    public final String getApiKey() {
        return this.f36585a;
    }

    @Nullable
    public final String getClickId() {
        return this.f36589e;
    }

    public final int getIndicatorPadding() {
        return this.f36587c;
    }

    @NotNull
    public final Position getIndicatorPosition() {
        return this.f36586b;
    }

    public final boolean getOfferwallMode() {
        return this.f36596l;
    }

    @Nullable
    public final Platform getPlatform() {
        return this.f36599o;
    }

    @Nullable
    public final PollfishClosedListener getPollfishClosedListener() {
        return this.f36603s;
    }

    @Nullable
    public final PollfishOpenedListener getPollfishOpenedListener() {
        return this.f36602r;
    }

    @Nullable
    public final PollfishSurveyCompletedListener getPollfishSurveyCompletedListener() {
        return this.f36605u;
    }

    @Nullable
    public final PollfishSurveyNotAvailableListener getPollfishSurveyNotAvailableListener() {
        return this.f36600p;
    }

    @Nullable
    public final PollfishSurveyReceivedListener getPollfishSurveyReceivedListener() {
        return this.f36604t;
    }

    @Nullable
    public final PollfishUserNotEligibleListener getPollfishUserNotEligibleListener() {
        return this.f36601q;
    }

    @Nullable
    public final PollfishUserRejectedSurveyListener getPollfishUserRejectedSurveyListener() {
        return this.f36606v;
    }

    @Nullable
    public final Boolean getReleaseMode() {
        return this.f36592h;
    }

    @Nullable
    public final String getRequestUUID() {
        return this.f36588d;
    }

    @Nullable
    public final RewardInfo getRewardInfo() {
        return this.f36597m;
    }

    public final boolean getRewardMode() {
        return this.f36595k;
    }

    @Nullable
    public final String getSignature() {
        return this.f36598n;
    }

    public final int getSurveyFormat() {
        return this.f36594j;
    }

    @Nullable
    public final String getUserId() {
        return this.f36590f;
    }

    @Nullable
    public final ViewGroup getUserLayout() {
        return this.f36591g;
    }

    @Nullable
    public final UserProperties getUserProperties() {
        return this.f36593i;
    }

    private Params(String str, Position position, int i4, String str2, String str3, String str4, ViewGroup viewGroup, Boolean bool, UserProperties userProperties, int i5, boolean z3, boolean z4, RewardInfo rewardInfo, String str5, Platform platform, PollfishSurveyNotAvailableListener pollfishSurveyNotAvailableListener, PollfishUserNotEligibleListener pollfishUserNotEligibleListener, PollfishOpenedListener pollfishOpenedListener, PollfishClosedListener pollfishClosedListener, PollfishSurveyReceivedListener pollfishSurveyReceivedListener, PollfishSurveyCompletedListener pollfishSurveyCompletedListener, PollfishUserRejectedSurveyListener pollfishUserRejectedSurveyListener) {
        this.f36585a = str;
        this.f36586b = position;
        this.f36587c = i4;
        this.f36588d = str2;
        this.f36589e = str3;
        this.f36590f = str4;
        this.f36591g = viewGroup;
        this.f36592h = bool;
        this.f36593i = userProperties;
        this.f36594j = i5;
        this.f36595k = z3;
        this.f36596l = z4;
        this.f36597m = rewardInfo;
        this.f36598n = str5;
        this.f36599o = platform;
        this.f36600p = pollfishSurveyNotAvailableListener;
        this.f36601q = pollfishUserNotEligibleListener;
        this.f36602r = pollfishOpenedListener;
        this.f36603s = pollfishClosedListener;
        this.f36604t = pollfishSurveyReceivedListener;
        this.f36605u = pollfishSurveyCompletedListener;
        this.f36606v = pollfishUserRejectedSurveyListener;
    }
}
