package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import java.util.ArrayList;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import net.bytebuddy.pool.TypePool;

/* compiled from: ENVELOPE.java */
/* loaded from: classes6.dex */
class a extends InternetAddress {
    private static final long serialVersionUID = -3835822029483122232L;
    private boolean group;
    private InternetAddress[] grouplist;
    private String groupname;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Response response) throws ParsingException {
        this.group = false;
        response.skipSpaces();
        if (response.readByte() == 40) {
            this.encodedPersonal = response.readString();
            response.readString();
            String readString = response.readString();
            String readString2 = response.readString();
            response.skipSpaces();
            if (response.isNextNonSpace(')')) {
                if (readString2 == null) {
                    this.group = true;
                    this.groupname = readString;
                    if (readString == null) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.groupname);
                    sb.append(':');
                    ArrayList arrayList = new ArrayList();
                    while (response.peekByte() != 41) {
                        a aVar = new a(response);
                        if (aVar.a()) {
                            break;
                        }
                        if (arrayList.size() != 0) {
                            sb.append(',');
                        }
                        sb.append(aVar.toString());
                        arrayList.add(aVar);
                    }
                    sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
                    this.address = sb.toString();
                    this.grouplist = (InternetAddress[]) arrayList.toArray(new a[arrayList.size()]);
                    return;
                } else if (readString != null && readString.length() != 0) {
                    if (readString2.length() == 0) {
                        this.address = readString;
                        return;
                    }
                    this.address = readString + "@" + readString2;
                    return;
                } else {
                    this.address = readString2;
                    return;
                }
            }
            throw new ParsingException("ADDRESS parse error");
        }
        throw new ParsingException("ADDRESS parse error");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.group && this.groupname == null) {
            return true;
        }
        return false;
    }

    @Override // javax.mail.internet.InternetAddress
    public InternetAddress[] getGroup(boolean z3) throws AddressException {
        InternetAddress[] internetAddressArr = this.grouplist;
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    @Override // javax.mail.internet.InternetAddress
    public boolean isGroup() {
        return this.group;
    }
}
