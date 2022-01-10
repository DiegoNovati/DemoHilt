package uk.co.itmms.demohilt.services

interface INavigationService {

    enum class NextActivity {
        Main, Home,
    }

    fun openActivity(nextActivity: NextActivity)
}

class NavigationService: INavigationService {

    override fun openActivity(nextActivity: INavigationService.NextActivity) {
        TODO("Not yet implemented")
    }
}