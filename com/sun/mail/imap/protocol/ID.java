package com.sun.mail.imap.protocol;

import com.sun.mail.iap.Argument;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class ID {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f37847a;

    public ID(Response response) throws ProtocolException {
        this.f37847a = null;
        response.skipSpaces();
        byte peekByte = response.peekByte();
        if (peekByte != 78 && peekByte != 110) {
            if (peekByte == 40) {
                this.f37847a = new HashMap();
                String[] readStringList = response.readStringList();
                if (readStringList != null) {
                    for (int i4 = 0; i4 < readStringList.length; i4 += 2) {
                        String str = readStringList[i4];
                        if (str != null) {
                            int i5 = i4 + 1;
                            if (i5 < readStringList.length) {
                                this.f37847a.put(str, readStringList[i5]);
                            } else {
                                throw new ProtocolException("ID field without value: " + str);
                            }
                        } else {
                            throw new ProtocolException("ID field name null");
                        }
                    }
                }
                this.f37847a = Collections.unmodifiableMap(this.f37847a);
                return;
            }
            throw new ProtocolException("Missing '(' at start of ID");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Argument a(Map<String, String> map) {
        Argument argument = new Argument();
        if (map == null) {
            argument.writeAtom("NIL");
            return argument;
        }
        Argument argument2 = new Argument();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            argument2.writeNString(entry.getKey());
            argument2.writeNString(entry.getValue());
        }
        argument.writeArgument(argument2);
        return argument;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> b() {
        return this.f37847a;
    }
}
