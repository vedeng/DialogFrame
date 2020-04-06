package com.dialog

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.base_title_bar.*

/**
 * 基类Activity 处理公共布局
 * @author Fires
 */
abstract class BaseActivity() : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLayout()
        initView()
        doExecute()
    }

    protected fun initTitle(title: String, showRight: Boolean) {
        base_back?.setOnClickListener(this)
        base_right?.setOnClickListener(this)
        base_title?.text = "$title"
        base_right?.visibility = if (showRight) View.VISIBLE else View.GONE
    }

    protected abstract fun loadLayout()
    protected abstract fun initView()
    protected abstract fun doExecute()

    override fun onClick(v: View) {
        when(v.id) {
            base_back?.id -> clickLeft()
            base_right?.id -> clickRight()
        }
    }

    protected open fun clickLeft() { finish() }

    protected open fun clickRight() {}

}
