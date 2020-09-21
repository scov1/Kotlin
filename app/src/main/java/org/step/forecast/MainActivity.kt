package org.step.forecast

//import android.widget.Toolbar
//import androidx.appcompat.app.AppCompatActivity;

import android.Manifest
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.location.*
import com.google.android.material.tabs.TabLayout
import org.step.forecast.data.api.Api
import org.step.forecast.presentation.adapter.ViewPagerAdapter
import org.step.forecast.presentation.fragment.TodayFragment


class MainActivity : AppCompatActivity() {

    private var toolbar: Toolbar? = null
    private var tabLayout : TabLayout? = null
    private var viewPager : ViewPager? = null
    private var coordinator : CoordinatorLayout? =null
    private var fusedLocationProviderClient : FusedLocationProviderClient? = null
    private var locationCallBack : LocationCallback? = null
    private var locationRequest : LocationRequest? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coordinator = findViewById(R.id.root_view)
        toolbar = findViewById(R.id.toolBar_activity_main_menu)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )){
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
                );
            }else{
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
                );
            }
        }
        buildLocationCallBack()
        buildLocationRequest()
//        Dexter.withActivity(this)
//            .withPermission(ACCESS_COARSE_LOCATION)
//            .withListener(object : PermissionListener {
//                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
//                    if (report.areAllPermissionsGranted()) {
//                        buildLocationRequest()
//                        buildLocationCallBack()
//
//                        if (ActivityCompat.checkSelfPermission(
//                                this@MainActivity,
//                                ACCESS_FINE_LOCATION
//                            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                                this@MainActivity,
//                                ACCESS_COARSE_LOCATION
//                            ) != PackageManager.PERMISSION_GRANTED
//                        ) {
//                            Log.d("adapter", "get locattt")
//                            return
//                        }
                        fusedLocationProviderClient =
                            LocationServices.getFusedLocationProviderClient(
                               this@MainActivity
                            )
                        fusedLocationProviderClient?.requestLocationUpdates(
                            locationRequest, locationCallBack,
                            Looper.myLooper()
                        )
//                    }
//                }
//
//                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
//                    Toast.makeText(this@MainActivity,"Permission granted",Toast.LENGTH_LONG).show()
//                }
//
//                override fun onPermissionDenied(response: PermissionDeniedResponse?) {
//                    Toast.makeText(this@MainActivity,"Perm deni",Toast.LENGTH_LONG).show()
//                }
//
//                override fun onPermissionRationaleShouldBeShown(
//                    permission: PermissionRequest?,
//                    token: PermissionToken?
//                ) {
//                    Snackbar.make(coordinator!!, "Permission Denied", Snackbar.LENGTH_LONG).show()
//
//                }
//            }).check()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        when (requestCode) {
            1 -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(
                            this@MainActivity,
                            ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    private fun buildLocationCallBack() {
        locationCallBack = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                Log.d("LocationCallBack", "ENTERED LocationCallback::onLocationResult")
                super.onLocationResult(locationResult)
                if (locationResult != null) {
                    Api.current_location = locationResult.lastLocation
                    viewPager = findViewById(R.id.viewPager_activity_main_menu)
                    setupViewPager(viewPager)
                    tabLayout = findViewById(R.id.tabLayout_activity_main_menu)
                    tabLayout!!.setupWithViewPager(viewPager)

                    Log.d("LocationCallBack", "/" + locationResult.lastLocation.latitude + locationResult.lastLocation.longitude)
                }
            }
        }
    }

    private fun setupViewPager(viewPager: ViewPager?) {
        var adapter  = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TodayFragment.getInstance(), "Today")
        viewPager?.adapter = adapter
    }

    private fun buildLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest!!.interval = 5000
        locationRequest!!.fastestInterval = 3000
        locationRequest!!.smallestDisplacement = 10.0f
    }
}