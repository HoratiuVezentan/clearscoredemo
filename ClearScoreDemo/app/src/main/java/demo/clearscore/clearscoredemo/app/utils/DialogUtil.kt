package demo.clearscore.clearscoredemo.app.utils

import android.content.Context
import android.support.v7.app.AlertDialog
import demo.clearscore.clearscoredemo.R


/**
 * Created by Horatiu on 5/16/2018.
 */
class DialogUtil(private val context: Context) {

    /**
     * Method used to show dialogs with error or informative message
     * @param message The message itself
     */
    fun showDialog(message: String){
        val builder = AlertDialog.Builder(context)
        builder.setMessage(message)
                .setPositiveButton(R.string.dialog_ok, { dialog, _ -> dialog.dismiss() })

        val alertDialog = builder.create()
        alertDialog.show()
    }
}