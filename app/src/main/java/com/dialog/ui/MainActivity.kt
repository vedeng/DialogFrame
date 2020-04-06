package com.dialog.ui

import android.app.Dialog
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.ToastUtils
import com.dialog.R
import com.dialog.BaseActivity
import com.xdialog.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun loadLayout() {
        setContentView(R.layout.activity_main)
    }


    override fun initView() {
        initTitle("XDialog使用展示", true)

        tv_center_dialog?.setOnClickListener {
            XDialog(this)
                .setTitle("弹窗标题")
                .setMessage("消息content")
                .build()
        }
        tv_center_dialog2?.setOnClickListener {
            XDialog(this)
                .setTitle("弹窗标题，默认粗体")
                .setEnterText("好的")
                .setEnterTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                .setCancelText("不好")
                .setCancelTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
                .setListener(object : DialogListener {
                    override fun doEnter(view: Dialog?) {
                        ToastUtils.showShort("点击-好的~")
                    }
                })
                .build()
        }
        tv_top_dialog?.setOnClickListener {
            val view = LinearLayout(this)
            view.addView(LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
            })
            EdgeDialog()
                .setEdgeTop(true)
                .setEdgeView(view)
                .show(supportFragmentManager, "Top1")
        }
        tv_top_dialog2?.setOnClickListener {
            val view = LinearLayout(this)
            view.addView(LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
            })
            EdgeDialog()
                .setEdgeTop(true)
                .setEdgeView(view)
                .show(supportFragmentManager, "Top2")
        }
        tv_bottom_dialog?.setOnClickListener {
            val view = LinearLayout(this)
            view.addView(LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
            })
            EdgeDialog()
                .setEdgeTop(false)
                .setEdgeView(view)
                .show(supportFragmentManager, "Bottom1")
        }
        tv_bottom_dialog2?.setOnClickListener {
            val view = LinearLayout(this)
            view.addView(LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
                addView(ImageView(this@MainActivity).apply { setImageResource(R.mipmap.icon_download); setPadding(50, 50, 50, 50) })
            })
            EdgeDialog()
                .setEdgeTop(false)
                .setEdgeView(view)
                .show(supportFragmentManager, "Bottom2")
        }
        tv_toast?.setOnClickListener {
            XToast(this)
                .setView(R.layout.toast_hint_noicon)
                .setDuration(3000)
                .setText("仿系统吐司样式")
                .show()
        }
        tv_toast2?.setOnClickListener {
            XToast(this)
                .setView(R.layout.toast_hint_noicon)
                .setAnimStyle(R.style.toast_animation)
                .setText("带动画吐司样式")
                .show()
        }
        tv_rich_toast?.setOnClickListener {
            XToast(this)
                .setView(R.layout.toast_hint)
                .setImageDrawable(R.drawable.svg_success)
                .setText("带图标吐司")
                .show()
        }
        tv_select_pic?.setOnClickListener {
            PicPickerDialog(this, View.OnClickListener {
                ToastUtils.showShort("打开拍照~")
            }, View.OnClickListener {
                ToastUtils.showShort("~打开图库")
            }).show(supportFragmentManager, "PicPicker")
        }
    }

    override fun doExecute() {

    }

    override fun clickRight() {
        XToast(this).setText("你以为有菜单？\n 这只是个彩蛋！").setDuration(6000).show()
    }

}
