package ninja.saad.wizardoflocale

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ninja.saad.wizardoflocale.util.LocaleHelper
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_change_language_en.onClick {
            LocaleHelper().setLocale(this@MainActivity, "en")
            recreate()
        }

        btn_change_language_bn.onClick {
            LocaleHelper().setLocale(this@MainActivity, "bn")
            recreate()
        }

    }

    override fun attachBaseContext(base: Context) {
        LocaleHelper().setLocale(base, LocaleHelper().getLanguage(base))
        super.attachBaseContext(LocaleHelper().onAttach(base))
    }

}
