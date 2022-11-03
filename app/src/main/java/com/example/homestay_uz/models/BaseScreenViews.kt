package com.example.homestay_uz.models


class BaseScreenViews {

    var screenView: ArrayList<ScreenView>? = ArrayList()
    var screenAddsView: ScreenAddsView? = null
    var mainAdds: MainAdds? = null
    var isHeader: Boolean = false


    constructor(screenView: ArrayList<ScreenView>?) {
        this.screenView = screenView
        this.isHeader = false
    }

    constructor(screenAddsView: ScreenAddsView?) {
        this.screenAddsView = screenAddsView
        this.isHeader = false
    }

    constructor(isHeaders: Boolean) {
        this.isHeader = true
    }

    constructor(mainAdds: MainAdds?) {
        this.mainAdds = mainAdds
    }

}