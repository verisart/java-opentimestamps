package com.eternitywall;

import com.eternitywall.ots.StreamDeserializationContext;
import com.eternitywall.ots.StreamSerializationContext;
import com.eternitywall.ots.Timestamp;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.List;

public class TestLongReceipt {
    @Test
    public void testException() throws Exception {
        String digest = "c858838f62f908c922f9cd734e49c8fa6ee9a3b8a77093ac0969cba429249412";
        byte[] digestByte = DatatypeConverter.parseHexBinary(digest);
        Timestamp root= new Timestamp(digestByte);

        String cata = "8BCFyeyt8QrzbwD7hc19Q6qyCPEguegXhF+Mvxbp/oHWCvX0gzpesI04rfV/cjXbvxDva2oI8SCO80/pScKWh2fGvNW5Gbjuf5j+Wa17AOoSrfZ7jCOFCwjxBFq5QzrwCCmEIs1jUPlD/wCD3+MNLvkMjiMiaHR0cHM6Ly9idGMuY2FsZW5kYXIuY2F0YWxsYXh5LmNvbQjxIN2HOOPNo6ibx5pEUshCgNQO+2WQ+3uy8HCcjJV8WmPoCPAgQ9TGTeAfsKVS5+bqQ1C9772QT9t0N4EWDXj1IAWlq74I8SCp20ylUoZafC03vehOB8YYj6nF9suGxisoP8a84npxQQjxIObarGShfxGy1oeDgER/1eRn+Nw5ChqX4fCZ8qbM9ZN3CPEgNkzIG/vskOaMl+6dxbCtl3/BDgjKB0kA+5xH1452lJwI8SDVRsFsHsMfnO7izZqDXV++swAxwqc+tx5Vsq4p7o0sSAjxIKnihRE3c3THLZCuA+rXal1NWISs0dA21hR9JF2IWSktCPAg0aDyCEb2yNHaAlkjqUQ5IjEWCNglmCFp1/Yxiyw2GfEI8CAIo0GR1CesJ42uD+x0pfGDvNAlg3Bq2oBjhP68oFGFnAjxIGofEmB9xJ6UzP+gm+Kn7svCR0yK9A4pwDzT6bwzJXkOCPFxAQAAAAGhLAL67vrH6gPmi5x2RyB4yNSNDsVp4idtjo3B0CtjFQAAAAAXFgAU2/eQXpzeNyVZM1G8bOo/Kvc7P979////AuOKNgAAAAAAF6kU3q3QUnuMcjeBLfe/5Hikx8emEbuHAAAAAAAAAAAiaiDwBM3cBwAICPAglhD1rl3w7azjl2YZS9engYJHAxaqvJDU0stt5E/B6PcICPAgvjGPIm/JhaBxfSPO0RlQpHuBNOuDK8Au60/EBLz2cOsICPEgYdyzNkx1MMh+HN+I15lITQ6I1rRLQh0lzuAWNM3qqGQICPAgkNA6xWB1GaZZmL/9c1Uds79y2C6iXaviXqfVo7N38r0ICPEgKn2pbzH9TiJiCxh87LSyQCGyrP0sJqHO4FindJcvZUgICPAgcsxyBcmPEtgzb6nf7feCY6xHBlereqIl36dD17HTOSUICPAg2UIid6/9tZiYfvJG0dDAwaXbB9lfTskuBpJOKQME6WIICPAguSAqpoXbxD6uQHNgruuuMWcfr8VVMr6IwkivxeJTcoQICPAgErpqzF/IelKM7cjl1mVAKXVgSGsGKBq87EXijcdriJIICPAgfbNlDGH4bJI6mNUdd27esu5XRTkkHwEx50ceG/E2haEICPEga9kHnRt06DmjNg3/ITURDxNx8IAFwT00Ak9RsdBDPq8ICPAg0DrrFt/cXFe4D5DHThyptc7ErMQK6uLZmA6utsVpHNYICAAFiJYNc9cZAQPOuR8=";
        String alice = "8BBczPrj2jYA+Qn0AvCDSQy8CPAgK/3GNIn81ORiI2xEosWE8aiMriD5lH3/Dzwg1XPcrTYI8CATjioVm1sq29q7/ZirwONKLQxf09Abt6VX039NWWmISAjwIKRGGK7ETpNlKWFBLqVJ+OfBnzQFqaey8aeHsM6hRwjuCPEEWrlDOvAI0JRMb64hdMj/AIPf4w0u+QyOLi1odHRwczovL2FsaWNlLmJ0Yy5jYWxlbmRhci5vcGVudGltZXN0YW1wcy5vcmcI8CBWBHyiGMUk78Zbk+kJxjja4WVMBMLRLx+zWxoOpBhWfAjxIFBH/lIh5oIGnCgDdTQf9xiAfRyQ6Giz7lCwR2VvmE37CPEgp0dgw4XQzlqaN0t76z2VJVJKOhRm8HkE9WI6aAXj/zUI8CBYwAfaWIjyV77RnWB1MfSfbu6/SNEK7x48lz0QrqDJpgjxIKkFvRLpe5T/n6JPCI4L7VzbzS/Xp9MaonfY8OOyStWZCPEgZ64asWA2pJXuYj+bVZog1gYp/vjJr0oAlowzRR7zzmgI8SAYJhuY0PZws3zlc+XmVVeR4n4hK6lBUuqUlXuCjeZFbwjxIB0TFFFLYP+fa/YoLZ57DtKm9D4EQ+dUfH5AN1zY9cDpCPAgl6HUR4KZ8s21108iFguIznKiNPUJ7ES0Rk4ycV0r7/kI8SCM9yWIzcsuzJhKrchiGqAycKcNG0NsfNar9bFzCj4OygjxIP4nJDRel8gHeahyO5cf+9WHx47va+CkdOp+LTGGJuBzCPFxAQAAAAFu1Kb1OPdZTBSsXgzs8Tp18Wpblm1WkHvf/SBp6d1IgAAAAAAXFgAUslWGeF7P6wUjQLIFPK/EQ/I1RU79////AjgyZQAAAAAAF6kUzLsfa89CgbzKwpSNlYPbGCE66WWHAAAAAAAAAAAiaiDwBMzcBwAICPAgWomEKT/NAbr554SbVy5U90C/b3vY1LaGrnYWX2gj9CIICPAg5ey7k590AuWthx5TBFHBG8UjeEXhiKYrHMfny5H8bDcICPAgsLJ/+vK9GjkA81Ju8Bk6N4hP5v30Rl2B27wTG0XSWL4ICPAgklfG6Boz5MPPtnwrmgmlNgcvTkH3aHSfdXJS2agHB1IICPAg38OKTU9JqJ/tc8YtYI2ylyYDs1CIz+fXzR68NEMkCsMICPEg4cIThkqyMGejkdB1ORVkEA2/2vzYdJ9/QYWaOzLelPkICPAgtqzm4JJ2BQ9nitNQCzdauG0tZ98wBRFB9Kaq8EJ9R7YICPAgf5luShZ1D9DnZs5NleEYNzuZSRFvsr9+2eGBF5PqGqEICPEgIAylN+xp1POS8abkwRAavm2Y4E5enSiqt/ZSJ9Pt4XYICPEgPO5oz9/CGhj01cmK4C1HCW9c0hBWNJGMcvJza7QUcykICPAg1X880qiy/qT5kK73Hbdkd9VVCuSW4HpW56kiHqrko78ICPAgcvEDsq5sk/z8drJUu2Mwgf42leo0/937YHtiS4sfoBgICAAFiJYNc9cZAQPNuR8=";
        String bob = "8BDwT6khsZrtv1BAULQSWYq4CPAgMt+TgQkEzLPogxtjMSlYsOfKr8EN0TyMc61N2dFNnK4I8CBoTlCeteZ7nMtN3fVbFuUksi5phQj8ryKS4v2xmCxcbgjxBFq5QzrwCE8Bj+rhL1Vv/wCD3+MNLvkMjiwraHR0cHM6Ly9ib2IuYnRjLmNhbGVuZGFyLm9wZW50aW1lc3RhbXBzLm9yZwjxIEb4yUZCFUFW74EhzhUGW4BiU7ulcp0Qk0N3Q7/L6Si1CPEg66TbJUViy1WntuQ/WOVRdPQQagy+S6ce4urTzfq3718I8SA/ggTUy3tlfB1bj7sVV9/xSyzZz4NjWZU5rhT4yllcvQjxIKbo/3jrimpFl4lmOCi5csr6CScXp0NJfZ95tFopR3vjCPEgk68/PQT1dIjZqBnpx06r6PHGADfL+iYUX4KX0pQc2ZQI8CBgiFzPYrFZEPXdiewi1Zun2sw2OWojuYfUgOcgzSlSJgjxIAS5mL/miIoUAHFU63aB4BaYeGNoEwpClnxUHfireSsyCPAgukSIEKll/0Bup9f1mP15NybSZmJbiujgJ9Kooi98P/8I8SDXxUxbSqT1OyL/pImNNaFe8ozDOw4+l+hw0pbFfnEX7QjxINI6E8haP+pKCNOAnacB5q2fp/Xnc31aKH+zXjF8DweuCPEgbB8Q5z/7swD/7mQElrhdaqFNIfgCfMQa15WLNyC/DlUI8CDN5862xCwHuuWtcPVu4wyhAz3r03Pvd++Gw2C56zF79QjxWQEAAAAB8U0E26g2KhA0luvvNogANWaC0JKf/9HHqwL3m7FxrQAAAAAAAP3///8CDUwzAAAAAAAWABQNuE08uA4/5oWDRYPWIW0HNrwSZgAAAAAAAAAAImog8ATM3AcACAjwIFPFQswDxLLV3n0nlvgNYGx9EBftsciWh6RiOq38Ls6gCAjwIKhliqZ1LZU8Pj6BHv6hDg/+Izs45W1OBxlVv0Ee3qB9CAjxICM8br4k7yxjpdu/2D0/cPyHv+BVXek9jv7JIDOj4nu7CAjwIFDU4U7azSrBcU8WnMSWfS548+WzAtOVEdo1Jj1o/7vqCAjxIMVmKnQSccupOdbdrx9TqIl6ipQTVcbeJmCcGmV1CNLLCAjxIPiyB2GYbN4nhR+Mmlxs8K/duwYcsrTN9BcvlSKrYyh6CAjxIMNwTm4Fl/t8mZZq/+BSbyFBMlmbE4XI7y7VY7pOeoo8CAjwIHvFUVHClQ4Ib4vSjndwspyWCstPFT0Ea5NxIf2rwAKICAjwIOXXYnsl4/cqlhCejZMPsgjrXUpr1AgqdATMN2mzNKZNCAjwIK6ZnepQvoFd10wFLot4JhDbuIIIUWi5LV0ypSVUudoVCAjwINV/PNKosv6k+ZCu9x23ZHfVVQrkluB6VuepIh6q5KO/CAjwIHLxA7KubJP8/HayVLtjMIH+NpXqNP/d+2B7YkuLH6AYCAgABYiWDXPXGQEDzbkf";
        String finney = "8BAqDeHtoPbxGQqr3cKPElH+CPEgK+N+N51Jo5plrOgUfaialm8g7RIl0i/CElYhyNQvwzQI8CC8PPLUsPh21UQqi+AqkUloB4Bmyf3TsdkpFkWOik0gCAjxIFbG9VpzqCgGrLNRa+C3R8Y1pEBEkkvL43OP/cXKZ9HjCPEEWrlDOfAImYOSAi3UKVj/AIPf4w0u+QyOKShodHRwczovL2Zpbm5leS5jYWxlbmRhci5ldGVybml0eXdhbGwuY29tCPAgaF8YYd74tCvipT4Vj0TpOY0F6hFumGuvG7Gt76QQho4I8CAHY3Ifn+Dwy4e06CRYKOfKqBt/Z2PfkDN3iJxeFa2ltgjwIMEa+29UJje8uLMuOUSo6cSRPpSc5xfNZ0vQzhDxjea2CPAgG3zfM489Lnk2KZ7ZDthrU3Kol6AwiYU/dL+ajjb5C/AI8SAQOT4E640EqeT/lQLilgRbBGWkxjSAKOPBes/vF07u+wjwILGODOZj7XUYq8H9OQq3PhVcVUWk+qTcOWwoycIS3h4rCPEgfWXAjbOvccrCVRgudC3LsS9g+UaxznYaaoZwoQcLy9wI8SBq/JQlR9apV48ILFcxgKGI+5G0HiWGP5VQeRQAmh5abgjwIAhddljFcmCMcmE/RAKyNMJFPrUH1Fa/vj6glSklJyrtCPEgcVjAhQyT+DpVBXBpzn+1MqjJwoLseYu7tfMGzJs4O4YI8CCv329jnbLYRQuDGmYYsD4kscCFzaqZb2o7kxQz7LD29QjwIMQKClKrl+ZXl43WkN0DnEicE/dFk//1W+haNUJH9gEpCPAg155mOD+GlyOD4Aej2r+BqofR1eTkTwTAlR5EoIyVPaQI8XEBAAAAAVaj5T2j5SkGUlgoVBsk6LjSTAiBab+9tHC8kDNEGUxZAAAAABcWABSMvUQJ6B5hj5+HlvUIYKCQVHXtHf3///8CZJEpAAAAAAAXqRSxSn76ORPndk+exI7QKqRy6jgEB4cAAAAAAAAAACJqIPAE3dwHAAgI8SB/296kvU7oSYjGH9CKTV+/H+azFxE0l1HtUf7rtYZVFAgI8SBAo5Ww0LeZSPnbeY699dL4kaK9mFhVJ8SV+foKdm3CPQgI8CDYYtN0BknZXwtUCqKd5+aEGmr9YOCfSnchSjOXSHpxUQgI8CDEa3gUw136BoZjmiMSEnFS2lL/3wZtR+qEYY8Kj7cPMwgI8CDGv7F1jEqaOBRqloiT7On2w2b2OCrayR9xlTPdC4RBfQgI8SCe64fFfJxRGFcqzgWsi/MKXoTPFChF0Pq6n/jYOJwE7AgI8CDKwiCAyWgcNxoWBqkJP7Ok8XwsNX03IVXNEck1GoFrjAgI8CCvAJbgAaUlE/Hqd2vjHHEnonwHP6rFSSTHLvq0pgpOIwgI8CAyZqK/QPV/okyeinJVpckubwDf8glUkDULEjVAKyBKsQgI8SDBkxwrApSs5WfUSkOAcSqk4a1bgTx0VNiodt0nmsZV/QgIAAWIlg1z1xkBA965Hw==";
        //String eth = "8BD0dgjKdcGJJrOqterOHLYpCPEEWrlDOfAIBW5AgpyIBub/AIPf4w0u+QyOISBodHRwczovL2V0aC5vdHMuZXRlcm5pdHl3YWxsLmNvbQjxIBtBcmlDWEsIUSSYcJ2j2wGkhh2M/O43MLeMoB25zpb3CPAg8kqaIIYwmbSTHkcDFqnmA/geUKP/e6hoesKIfJKUayoI8SX4hoG3hQEqBfIAgwHhKJTlegWdQVBgNLKbTVZ1jtwdty09eICg8EMloD6/GtZLoo0zsjloobJvXD4XUaM4HXqx2fGTzirZ75rWoGthQk2h4asIjIwYk4aU8jzjJpfpIFBkmr6Jvqp0qEh08QX4iyC4iGfxiAH5AhGghcGAtx7CHlq5Jf/A7dp4XR4lsxPjB4VGSSJcjdXzS3ig1fDc3sXKmehii1GxxpNtoY6DIJK68w3R+Mq74G0yBoSgjCuq7UoC+AX7rF3gvbn8GByT5Zb5g3Je6QLtiteaucigrqhfNjwNt0BGd5LoOaTAGDI1GzcMqUzQZ04lMCAckJSg8OwCoOov3y9zuodccRe9iedZMgSu4Itv7qecHkrYrdyGJcXdoECW0TlWbUQbolDBnz6bkP7uJEYgzKFGCmfGGsJvCr3/oAqoegOE/pO8x3kvVANjnJgeVgZD/GZOxyaJit5nqaBIoDDs3MCj/rUjgR2KFwZvyA4Bg0iZQkS09TNQOkWUHIhDoHyZYMLeQR1Z1QtkSlXwLjEPwLb869xDkjn+/SnxJR9poE84qjjg1/6BrZIfK4Xn2n47tuz/80F21UVPdH7+OtuvoLc7iOV9WO45kbzsEPNbk2G0MyyrTdpntXnKrHhyneI3oAvCVrOIrJb5FlLnnucdB2G2a3aZu8zcf9SWHea/xDpwoE/It1w2HDd8rEPhFmkZp/PqQbC5m7U5MaHGypBUkMoxoNru9gQEh2Wl8pkG7nRvn6B4kfMkBtp/42wtE04AycJfoGBF0MRyu+XR0tOwr2f3b5jJuNtMnIvAT1Gxp2jvZ65cgGfxLPiRgICAgICAgICgJ+ElPvTnM5vhnvS4miHY6+myiPxlnqfyIXhSODujyQ6g8EegSYnWBTdpC/pyLPhE6qvdC+lPmmbk9lWYOr1cvokcWbCgJ5UdnbHkjKcr46gnlITcwk9e7wvxVlxThZNCGeSHay2AgICAgGfxJPhRoCZAVq8i8S94JTgipchI7lqGXQIsr50XMBt8HXOCEI6xoPAPgICAgICAgICAgICAgICAZ/GMAvkBMaD5+3z5jUPlDB4VFwv7xbIgZHXPwxkV7zL7kno6loAK/aDmmgfl49oMw7DAIyOqPstTyBmj+dGzoC576zf1Ik44+aBRlpTbcSa9Mx34BrBILGFKxvf8pINx/j05lOjcinMUy6CCjG5H5jFfVYUZNwhTozrESw/QuTY7oCn63tz0b+XPJaD1KAkmSduV9XrRLt/WBIYQbiJwn3LNhPudPwsNpCaPfqAlvGpZHqxFD3/k7wfaGiMZVt6EQQ/1MA6newGOn7P7B6A21s3wCxj4VUAHjIjdIJDvr0UlibWU+JUxrf16yTjsX6BZVVegOKPLC/6+Mp+j/XCnpzKaJD/UIbi4t9I4AXzPmaDwCICAgICAgICAZwAw/oCHtcfq1wTAk8UC";
        List<String> list = new ArrayList<>();
        list.add(cata);
        list.add(alice);
        list.add(bob);
        list.add(finney);

        for (String el : list) {
            final byte[] bytes = DatatypeConverter.parseBase64Binary(el);
            StreamDeserializationContext ctx = new StreamDeserializationContext(bytes);
            Timestamp timestamp = Timestamp.deserialize(ctx, digestByte);
            try {
                root.merge(timestamp);
            } catch (Exception e) {
                assertTrue(false);
            }
        }
        StreamSerializationContext streamSerializationContext = new StreamSerializationContext();
        root.serialize(streamSerializationContext);
        assertTrue(true);

        StreamDeserializationContext ctx2 = new StreamDeserializationContext(streamSerializationContext.getOutput());
        Timestamp timestamp = Timestamp.deserialize(ctx2, digestByte);
        assertNotNull(timestamp);
        //System.out.println(timestamp.strTree(2));

    }
}