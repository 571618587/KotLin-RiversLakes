package com.samson.rivers_lakes.lower.utils

/**
 * 颜色工具类 包括常用的色值
 */
class Colors
/**
 * Don't let anyone instantiate this class.
 */
private constructor() {

    init {
        throw Error("Do not need instantiate!")
    }

    companion object {

        /**
         * 白色
         */
        val WHITE = 0xffffffff.toInt()

        /**
         * 白色 - 半透明
         */
        val WHITE_TRANSLUCENT = 0x80ffffff.toInt()

        /**
         * 黑色
         */
        val BLACK = 0xff000000.toInt()

        /**
         * 黑色 - 半透明
         */
        val BLACK_TRANSLUCENT = 0x80000000.toInt()

        /**
         * 透明
         */
        val TRANSPARENT = 0x00000000

        /**
         * 红色
         */
        val RED = 0xffff0000.toInt()

        /**
         * 红色 - 半透明
         */
        val RED_TRANSLUCENT = 0x80ff0000.toInt()

        /**
         * 红色 - 深的
         */
        val RED_DARK = 0xff8b0000.toInt()

        /**
         * 红色 - 深的 - 半透明
         */
        val RED_DARK_TRANSLUCENT = 0x808b0000.toInt()

        /**
         * 绿色
         */
        val GREEN = 0xff00ff00.toInt()

        /**
         * 绿色 - 半透明
         */
        val GREEN_TRANSLUCENT = 0x8000ff00.toInt()

        /**
         * 绿色 - 深的
         */
        val GREEN_DARK = 0xff003300.toInt()

        /**
         * 绿色 - 深的 - 半透明
         */
        val GREEN_DARK_TRANSLUCENT = 0x80003300.toInt()

        /**
         * 绿色 - 浅的
         */
        val GREEN_LIGHT = 0xffccffcc.toInt()

        /**
         * 绿色 - 浅的 - 半透明
         */
        val GREEN_LIGHT_TRANSLUCENT = 0x80ccffcc.toInt()

        /**
         * 蓝色
         */
        val BLUE = 0xff0000ff.toInt()

        /**
         * 蓝色 - 半透明
         */
        val BLUE_TRANSLUCENT = 0x800000ff.toInt()

        /**
         * 蓝色 - 深的
         */
        val BLUE_DARK = 0xff00008b.toInt()

        /**
         * 蓝色 - 深的 - 半透明
         */
        val BLUE_DARK_TRANSLUCENT = 0x8000008b.toInt()

        /**
         * 蓝色 - 浅的
         */
        val BLUE_LIGHT = 0xff36a5E3.toInt()

        /**
         * 蓝色 - 浅的 - 半透明
         */
        val BLUE_LIGHT_TRANSLUCENT = 0x8036a5E3.toInt()

        /**
         * 天蓝
         */
        val SKYBLUE = 0xff87ceeb.toInt()

        /**
         * 天蓝 - 半透明
         */
        val SKYBLUE_TRANSLUCENT = 0x8087ceeb.toInt()

        /**
         * 天蓝 - 深的
         */
        val SKYBLUE_DARK = 0xff00bfff.toInt()

        /**
         * 天蓝 - 深的 - 半透明
         */
        val SKYBLUE_DARK_TRANSLUCENT = 0x8000bfff.toInt()

        /**
         * 天蓝 - 浅的
         */
        val SKYBLUE_LIGHT = 0xff87cefa.toInt()

        /**
         * 天蓝 - 浅的 - 半透明
         */
        val SKYBLUE_LIGHT_TRANSLUCENT = 0x8087cefa.toInt()

        /**
         * 灰色
         */
        val GRAY = 0xff969696.toInt()

        /**
         * 灰色 - 半透明
         */
        val GRAY_TRANSLUCENT = 0x80969696.toInt()

        /**
         * 灰色 - 深的
         */
        val GRAY_DARK = 0xffa9a9a9.toInt()

        /**
         * 灰色 - 深的 - 半透明
         */
        val GRAY_DARK_TRANSLUCENT = 0x80a9a9a9.toInt()

        /**
         * 灰色 - 暗的
         */
        val GRAY_DIM = 0xff696969.toInt()

        /**
         * 灰色 - 暗的 - 半透明
         */
        val GRAY_DIM_TRANSLUCENT = 0x80696969.toInt()

        /**
         * 灰色 - 浅的
         */
        val GRAY_LIGHT = 0xffd3d3d3.toInt()

        /**
         * 灰色 - 浅的 - 半透明
         */
        val GRAY_LIGHT_TRANSLUCENT = 0x80d3d3d3.toInt()

        /**
         * 橙色
         */
        val ORANGE = 0xffffa500.toInt()

        /**
         * 橙色 - 半透明
         */
        val ORANGE_TRANSLUCENT = 0x80ffa500.toInt()

        /**
         * 橙色 - 深的
         */
        val ORANGE_DARK = 0xffff8800.toInt()

        /**
         * 橙色 - 深的 - 半透明
         */
        val ORANGE_DARK_TRANSLUCENT = 0x80ff8800.toInt()

        /**
         * 橙色 - 浅的
         */
        val ORANGE_LIGHT = 0xffffbb33.toInt()

        /**
         * 橙色 - 浅的 - 半透明
         */
        val ORANGE_LIGHT_TRANSLUCENT = 0x80ffbb33.toInt()

        /**
         * 金色
         */
        val GOLD = 0xffffd700.toInt()

        /**
         * 金色 - 半透明
         */
        val GOLD_TRANSLUCENT = 0x80ffd700.toInt()

        /**
         * 粉色
         */
        val PINK = 0xffffc0cb.toInt()

        /**
         * 粉色 - 半透明
         */
        val PINK_TRANSLUCENT = 0x80ffc0cb.toInt()

        /**
         * 紫红色
         */
        val FUCHSIA = 0xffff00ff.toInt()

        /**
         * 紫红色 - 半透明
         */
        val FUCHSIA_TRANSLUCENT = 0x80ff00ff.toInt()

        /**
         * 灰白色
         */
        val GRAYWHITE = 0xfff2f2f2.toInt()

        /**
         * 灰白色 - 半透明
         */
        val GRAYWHITE_TRANSLUCENT = 0x80f2f2f2.toInt()

        /**
         * 紫色
         */
        val PURPLE = 0xff800080.toInt()

        /**
         * 紫色 - 半透明
         */
        val PURPLE_TRANSLUCENT = 0x80800080.toInt()

        /**
         * 青色
         */
        val CYAN = 0xff00ffff.toInt()

        /**
         * 青色 - 半透明
         */
        val CYAN_TRANSLUCENT = 0x8000ffff.toInt()

        /**
         * 青色 - 深的
         */
        val CYAN_DARK = 0xff008b8b.toInt()

        /**
         * 青色 - 深的 - 半透明
         */
        val CYAN_DARK_TRANSLUCENT = 0x80008b8b.toInt()

        /**
         * 黄色
         */
        val YELLOW = 0xffffff00.toInt()

        /**
         * 黄色 - 半透明
         */
        val YELLOW_TRANSLUCENT = 0x80ffff00.toInt()

        /**
         * 黄色 - 浅的
         */
        val YELLOW_LIGHT = 0xffffffe0.toInt()

        /**
         * 黄色 - 浅的 - 半透明
         */
        val YELLOW_LIGHT_TRANSLUCENT = 0x80ffffe0.toInt()

        /**
         * 巧克力色
         */
        val CHOCOLATE = 0xffd2691e.toInt()

        /**
         * 巧克力色 - 半透明
         */
        val CHOCOLATE_TRANSLUCENT = 0x80d2691e.toInt()

        /**
         * 番茄色
         */
        val TOMATO = 0xffff6347.toInt()

        /**
         * 番茄色 - 半透明
         */
        val TOMATO_TRANSLUCENT = 0x80ff6347.toInt()

        /**
         * 橙红色
         */
        val ORANGERED = 0xffff4500.toInt()

        /**
         * 橙红色 - 半透明
         */
        val ORANGERED_TRANSLUCENT = 0x80ff4500.toInt()

        /**
         * 银白色
         */
        val SILVER = 0xffc0c0c0.toInt()

        /**
         * 银白色 - 半透明
         */
        val SILVER_TRANSLUCENT = 0x80c0c0c0.toInt()

        /**
         * 高光
         */
        val HIGHLIGHT = 0x33ffffff

        /**
         * 低光
         */
        val LOWLIGHT = 0x33000000
    }

}