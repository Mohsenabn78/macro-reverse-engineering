package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.action.email.api.EmailApi;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendEmailAction_MembersInjector implements MembersInjector<SendEmailAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<EmailApi> f2476a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SystemLogHelper> f2477b;

    public SendEmailAction_MembersInjector(Provider<EmailApi> provider, Provider<SystemLogHelper> provider2) {
        this.f2476a = provider;
        this.f2477b = provider2;
    }

    public static MembersInjector<SendEmailAction> create(Provider<EmailApi> provider, Provider<SystemLogHelper> provider2) {
        return new SendEmailAction_MembersInjector(provider, provider2);
    }

    public static void injectEmailApi(SendEmailAction sendEmailAction, EmailApi emailApi) {
        sendEmailAction.emailApi = emailApi;
    }

    public static void injectSystemLogHelper(SendEmailAction sendEmailAction, SystemLogHelper systemLogHelper) {
        sendEmailAction.systemLogHelper = systemLogHelper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SendEmailAction sendEmailAction) {
        injectEmailApi(sendEmailAction, this.f2476a.get());
        injectSystemLogHelper(sendEmailAction, this.f2477b.get());
    }
}
