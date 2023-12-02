package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class Argument {

    /* renamed from: a  reason: collision with root package name */
    protected List<Object> f37593a = new ArrayList(1);

    private void a(byte[] bArr, Protocol protocol) throws IOException, ProtocolException {
        e(bArr, protocol, false);
    }

    private void b(Literal literal, Protocol protocol) throws IOException, ProtocolException {
        literal.writeTo(g(protocol, literal.size()));
    }

    private void c(ByteArrayOutputStream byteArrayOutputStream, Protocol protocol) throws IOException, ProtocolException {
        byteArrayOutputStream.writeTo(g(protocol, byteArrayOutputStream.size()));
    }

    private void d(byte[] bArr, Protocol protocol) throws IOException, ProtocolException {
        g(protocol, bArr.length).write(bArr);
    }

    private void e(byte[] bArr, Protocol protocol, boolean z3) throws IOException, ProtocolException {
        boolean z4;
        byte b4;
        byte b5;
        byte b6;
        int i4;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.g();
        int length = bArr.length;
        if (length > 1024) {
            d(bArr, protocol);
            return;
        }
        boolean z5 = true;
        if (length == 0) {
            z4 = true;
        } else {
            z4 = z3;
        }
        boolean supportsUtf8 = protocol.supportsUtf8();
        boolean z6 = false;
        for (byte b7 : bArr) {
            if (b7 != 0 && b7 != 13 && b7 != 10 && (supportsUtf8 || (b7 & 255) <= 127)) {
                if (b7 == 42 || b7 == 37 || b7 == 40 || b7 == 41 || b7 == 123 || b7 == 34 || b7 == 92 || (i4 = b7 & 255) <= 32 || i4 > 127) {
                    if (b7 != 34 && b7 != 92) {
                        z4 = true;
                    } else {
                        z4 = true;
                        z6 = true;
                    }
                }
            } else {
                d(bArr, protocol);
                return;
            }
        }
        if (z4 || bArr.length != 3 || (((b4 = bArr[0]) != 78 && b4 != 110) || (((b5 = bArr[1]) != 73 && b5 != 105) || ((b6 = bArr[2]) != 76 && b6 != 108)))) {
            z5 = z4;
        }
        if (z5) {
            dataOutputStream.write(34);
        }
        if (z6) {
            for (byte b8 : bArr) {
                if (b8 == 34 || b8 == 92) {
                    dataOutputStream.write(92);
                }
                dataOutputStream.write(b8);
            }
        } else {
            dataOutputStream.write(bArr);
        }
        if (z5) {
            dataOutputStream.write(34);
        }
    }

    private void f(byte[] bArr, Protocol protocol) throws IOException, ProtocolException {
        if (bArr == null) {
            ((DataOutputStream) protocol.g()).writeBytes("NIL");
        } else {
            e(bArr, protocol, true);
        }
    }

    private OutputStream g(Protocol protocol, int i4) throws IOException, ProtocolException {
        Response readResponse;
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.g();
        boolean m4 = protocol.m();
        dataOutputStream.write(123);
        dataOutputStream.writeBytes(Integer.toString(i4));
        if (m4) {
            dataOutputStream.writeBytes("+}\r\n");
        } else {
            dataOutputStream.writeBytes("}\r\n");
        }
        dataOutputStream.flush();
        if (!m4) {
            do {
                readResponse = protocol.readResponse();
                if (readResponse.isContinuation()) {
                }
            } while (!readResponse.isTagged());
            throw new LiteralException(readResponse);
        }
        return dataOutputStream;
    }

    public Argument append(Argument argument) {
        this.f37593a.addAll(argument.f37593a);
        return this;
    }

    public void write(Protocol protocol) throws IOException, ProtocolException {
        int i4;
        List<Object> list = this.f37593a;
        if (list != null) {
            i4 = list.size();
        } else {
            i4 = 0;
        }
        DataOutputStream dataOutputStream = (DataOutputStream) protocol.g();
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 > 0) {
                dataOutputStream.write(32);
            }
            Object obj = this.f37593a.get(i5);
            if (obj instanceof b) {
                dataOutputStream.writeBytes(((b) obj).f37629a);
            } else if (obj instanceof Number) {
                dataOutputStream.writeBytes(((Number) obj).toString());
            } else if (obj instanceof a) {
                a(((a) obj).f37628a, protocol);
            } else if (obj instanceof c) {
                f(((c) obj).f37630a, protocol);
            } else if (obj instanceof byte[]) {
                d((byte[]) obj, protocol);
            } else if (obj instanceof ByteArrayOutputStream) {
                c((ByteArrayOutputStream) obj, protocol);
            } else if (obj instanceof Literal) {
                b((Literal) obj, protocol);
            } else if (obj instanceof Argument) {
                dataOutputStream.write(40);
                ((Argument) obj).write(protocol);
                dataOutputStream.write(41);
            }
        }
    }

    public Argument writeArgument(Argument argument) {
        this.f37593a.add(argument);
        return this;
    }

    public Argument writeAtom(String str) {
        this.f37593a.add(new b(str));
        return this;
    }

    public Argument writeBytes(byte[] bArr) {
        this.f37593a.add(bArr);
        return this;
    }

    public Argument writeNString(String str) {
        if (str == null) {
            this.f37593a.add(new c(null));
        } else {
            this.f37593a.add(new c(ASCIIUtility.getBytes(str)));
        }
        return this;
    }

    public Argument writeNumber(int i4) {
        this.f37593a.add(Integer.valueOf(i4));
        return this;
    }

    public Argument writeString(String str) {
        this.f37593a.add(new a(ASCIIUtility.getBytes(str)));
        return this;
    }

    public Argument writeBytes(ByteArrayOutputStream byteArrayOutputStream) {
        this.f37593a.add(byteArrayOutputStream);
        return this;
    }

    public Argument writeNumber(long j4) {
        this.f37593a.add(Long.valueOf(j4));
        return this;
    }

    public Argument writeString(String str, String str2) throws UnsupportedEncodingException {
        if (str2 == null) {
            writeString(str);
        } else {
            this.f37593a.add(new a(str.getBytes(str2)));
        }
        return this;
    }

    public Argument writeBytes(Literal literal) {
        this.f37593a.add(literal);
        return this;
    }

    public Argument writeNString(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            this.f37593a.add(new c(null));
        } else if (str2 == null) {
            writeString(str);
        } else {
            this.f37593a.add(new c(str.getBytes(str2)));
        }
        return this;
    }

    public Argument writeString(String str, Charset charset) {
        if (charset == null) {
            writeString(str);
        } else {
            this.f37593a.add(new a(str.getBytes(charset)));
        }
        return this;
    }

    public Argument writeNString(String str, Charset charset) {
        if (str == null) {
            this.f37593a.add(new c(null));
        } else if (charset == null) {
            writeString(str);
        } else {
            this.f37593a.add(new c(str.getBytes(charset)));
        }
        return this;
    }
}
