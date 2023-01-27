package tour.management.system;

import java.util.Base64;

public class PasswdEncryptionAndDecryption {
    public String encode(String passwd) {
        Base64.Encoder encoder = Base64.getEncoder();
        String originalString = passwd;
        String encodedString = encoder.encodeToString(originalString.getBytes());
        return encodedString;
    }

    public String decode(String encodePasswd) {
        Base64.Decoder decoder = Base64.getDecoder();
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = decoder.decode(encodePasswd);
        String decodedString = new String(bytes);
        return decodedString;
    }

//    public static void main(String[] args) {
//        PasswdEncryptionAndDecryption p = new PasswdEncryptionAndDecryption();
//        System.out.println(p.encode("arawat"));
//        String s = p.encode("arawat");
//        System.out.println(p.decode(s));
//
//
//    }
}