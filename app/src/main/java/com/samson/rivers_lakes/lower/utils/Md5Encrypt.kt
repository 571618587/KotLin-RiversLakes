package com.samson.rivers_lakes.lower.utils

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * MD5加密算法
 */
object Md5Encrypt {
    /**
     * Used building output as Hex
     */
    private val DIGITS = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

    /**
     * 对字符串进行MD5加密

     * @param text
     * *            明文
     * *
     * *
     * @return 密文
     */
    fun md5(text: String, charset: String): String {
        var msgDigest: MessageDigest? = null

        try {
            msgDigest = MessageDigest.getInstance("MD5")
        } catch (e: NoSuchAlgorithmException) {
            throw IllegalStateException("System doesn't support MD5 algorithm.")
        }

        try {
            msgDigest!!.update(text.toByteArray(charset(charset)))

        } catch (e: UnsupportedEncodingException) {

            throw IllegalStateException("System doesn't support your  EncodingException.")

        }

        val bytes = msgDigest.digest()

        val md5Str = String(encodeHex(bytes))

        return md5Str
    }

    fun encodeHex(data: ByteArray): CharArray {

        val l = data.size

        val out = CharArray(l shl 1)

        // two characters form the hex value.
        var i = 0
        var j = 0
        while (i < l) {
            out[j++] = DIGITS[(0xF0 and data[i].toInt()).ushr(4)]
            out[j++] = DIGITS[0x0F and data[i].toInt()]
            i++
        }

        return out
    }

    @JvmStatic fun main(args: Array<String>) {
        // System.out.println(md5(md5("123456","utf-8"),"utf-8"));
    }
}
