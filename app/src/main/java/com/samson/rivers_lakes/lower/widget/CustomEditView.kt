package com.samson.rivers_lakes.lower.widget

import android.content.Context
import android.content.IntentFilter
import android.text.InputFilter
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.samson.rivers_lakes.R
import com.samson.rivers_lakes.lower.utils.LogUtil
import kotlinx.android.synthetic.main.layout_widget_edit_view.view.*

/**
 * Created by sam on 2017/7/11.
 */
class CustomEditView : LinearLayout {
    var selectImg: Int? = null
    var unSelectImg: Int? = null
    var selectDrawable: Int? = null
    var unSelectDrawable: Int? = null

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(context, attrs, defStyleAttr);
    }

    fun initView(context: Context, attrs: AttributeSet, defStyleAttr: Int) {
        LayoutInflater.from(context).inflate(R.layout.layout_widget_edit_view, this)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditView)
        for (i in 0..typedArray.indexCount) {
            var attr = typedArray.getIndex(i);
            when (attr) {
                R.styleable.CustomEditView_selectImg -> {
                    selectImg = typedArray.getResourceId(R.styleable.CustomEditView_selectImg, 0);
                }
                R.styleable.CustomEditView_unSelectImg -> {
                    unSelectImg = typedArray.getResourceId(R.styleable.CustomEditView_unSelectImg, 0);
                }
                R.styleable.CustomEditView_selectDrawable -> {
                    selectDrawable = typedArray.getResourceId(R.styleable.CustomEditView_selectDrawable, 0);
                }
                R.styleable.CustomEditView_unSelectDrawable -> {
                    unSelectDrawable = typedArray.getResourceId(R.styleable.CustomEditView_unSelectDrawable, 0);
                }
                R.styleable.CustomEditView_textHint -> {
                    val textHint = typedArray.getString(R.styleable.CustomEditView_textHint)
                    edit_phone.setHint(textHint)
                }
                R.styleable.CustomEditView_inputType -> {
                    val inputType = typedArray.getInt(R.styleable.CustomEditView_inputType, 1);
                    LogUtil.e("--" + inputType)
                    when (inputType) {
                        1 -> edit_phone.inputType = InputType.TYPE_CLASS_TEXT
                        2 -> edit_phone.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                        3 -> edit_phone.inputType = InputType.TYPE_CLASS_NUMBER
                    }
                }
                R.styleable.CustomEditView_maxLength -> {
                    val maxLength = typedArray.getInt(R.styleable.CustomEditView_maxLength, 20);
                    edit_phone.filters = arrayOf(InputFilter.LengthFilter(maxLength))
                }
            }
        }
//        LogUtil.e("--" + selectImg + "---" + unSelectImg + "--" + selectDrawable + "------" + unSelectDrawable + "------")
        setBackgroundResource(unSelectDrawable!!)
        show_img.setImageResource(unSelectImg!!)
        edit_phone.setOnFocusChangeListener { view, b ->
            if (b) {
                setBackgroundResource(selectDrawable!!)
                show_img.setImageResource(selectImg!!)
            } else {
                setBackgroundResource(unSelectDrawable!!)
                show_img.setImageResource(unSelectImg!!)
            }
        }
    }

    fun getText(): String {
        return edit_phone.text.toString();
    }


}