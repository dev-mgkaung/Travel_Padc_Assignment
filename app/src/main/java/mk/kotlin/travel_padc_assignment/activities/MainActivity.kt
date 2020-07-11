package mk.kotlin.travel_padc_assignment.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import mk.kotlin.travel_padc_assignment.R
import mk.kotlin.travel_padc_assignment.fragments.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navChange(HomeFragment())
        init()
    }

    fun init()
    {
        //bottom Navigation View setup
        bottomnavigationview.setOnNavigationItemSelectedListener (object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.action_home -> navChange(HomeFragment())
                    R.id.action_search -> navChange(SearchFragment())
                    R.id.action_favourite -> navChange(FavouriteFragment())
                    R.id.action_price -> navChange(PriceFragment())
                    R.id.action_detail -> navChange(DetailFragment())
                }
                return true
            }
        })
    }

    fun navChange(fragment: Fragment) : Boolean
    {
        supportFragmentManager.beginTransaction().replace(R.id.ftcontainer, fragment).commit()
        return true
    }
}
