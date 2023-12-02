package com.sun.mail.imap;

import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import java.util.ArrayList;
import java.util.List;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.MultipartDataSource;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimePartDataSource;

/* loaded from: classes6.dex */
public class IMAPMultipartDataSource extends MimePartDataSource implements MultipartDataSource {

    /* renamed from: a  reason: collision with root package name */
    private List<IMAPBodyPart> f37748a;

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPMultipartDataSource(MimePart mimePart, BODYSTRUCTURE[] bodystructureArr, String str, IMAPMessage iMAPMessage) {
        super(mimePart);
        String str2;
        this.f37748a = new ArrayList(bodystructureArr.length);
        for (int i4 = 0; i4 < bodystructureArr.length; i4++) {
            List<IMAPBodyPart> list = this.f37748a;
            BODYSTRUCTURE bodystructure = bodystructureArr[i4];
            if (str == null) {
                str2 = Integer.toString(i4 + 1);
            } else {
                str2 = str + "." + Integer.toString(i4 + 1);
            }
            list.add(new IMAPBodyPart(bodystructure, str2, iMAPMessage));
        }
    }

    @Override // javax.mail.MultipartDataSource
    public BodyPart getBodyPart(int i4) throws MessagingException {
        return this.f37748a.get(i4);
    }

    @Override // javax.mail.MultipartDataSource
    public int getCount() {
        return this.f37748a.size();
    }
}
