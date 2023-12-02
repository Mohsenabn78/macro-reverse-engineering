package com.arlosoft.macrodroid.action.services;

import com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendEmailService_MembersInjector implements MembersInjector<SendEmailService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<SystemLogHelper> f4904a;

    public SendEmailService_MembersInjector(Provider<SystemLogHelper> provider) {
        this.f4904a = provider;
    }

    public static MembersInjector<SendEmailService> create(Provider<SystemLogHelper> provider) {
        return new SendEmailService_MembersInjector(provider);
    }

    public static void injectSystemLogHelper(SendEmailService sendEmailService, SystemLogHelper systemLogHelper) {
        sendEmailService.systemLogHelper = systemLogHelper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SendEmailService sendEmailService) {
        injectSystemLogHelper(sendEmailService, this.f4904a.get());
    }
}
