package com.example.homestay_uz.models

import java.util.LinkedList

class BaseScreenViews {

    //var mainAdds: LinkedList<MainAdds>? = null
    var screenView: ArrayList<ScreenView>? = ArrayList()
    var screenAddsView:ScreenAddsView? = null



   /* constructor(mainAdds: LinkedList<MainAdds>?) {
        this.mainAdds = mainAdds
    }
*/
    constructor(screenView: ArrayList<ScreenView>?) {
        this.screenView = screenView
    }

    constructor(screenAddsView: ScreenAddsView?) {
        this.screenAddsView = screenAddsView
    }
}