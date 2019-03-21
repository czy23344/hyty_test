package com.hysy.data_collection.backstage.util;

/**
 * 密码校验与密文密码生成.
 * @author czy
 * @version 2019-03-12
 */
public class PassWordUtil {
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;
    /**
     * 验证密码
     *
     * @param plainPassword
     *            明文密码
     * @param password
     *            密文密码
     * @return 验证成功返回true
     */
    public static boolean validatePassword(String plainPassword, String password) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Encodes.decodeHex(password.substring(0, 16));
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
    }

    /**
     * 生成密码，随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
    }
}
