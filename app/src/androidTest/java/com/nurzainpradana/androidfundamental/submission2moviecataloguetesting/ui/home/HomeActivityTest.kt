package com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.R
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData.generateDummyMovies
import com.nurzainpradana.androidfundamental.submission2moviecataloguetesting.util.DummyData.generateDummyTvShow
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = generateDummyMovies()
    private val dummyTvShow = generateDummyTvShow()

    @Rule
    var activityTestRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(ViewMatchers.withId(R.id.rv_movies)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(ViewMatchers.withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(ViewMatchers.withId(R.id.tv_detail_movie_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_detail_movie_description)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_detail_movie_genre)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_detail_movie_year)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.img_detail_movie_poster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.img_detail_movie_poster_blur)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_detail_movie_title)).check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].movieTitle)))
        onView(ViewMatchers.withId(R.id.tv_detail_movie_description)).check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].movieDescription)))
        onView(ViewMatchers.withId(R.id.tv_detail_movie_genre)).check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].movieGenre)))
        onView(ViewMatchers.withId(R.id.tv_detail_movie_year)).check(ViewAssertions.matches(ViewMatchers.withText(dummyMovie[0].movieYear)))
    }

    @Test
    fun loadTvShow() {
        onView(ViewMatchers.withId(R.id.navigation_tvshow)).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.rv_tvshow)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(ViewMatchers.withId(R.id.navigation_tvshow)).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(ViewMatchers.withId(R.id.tv_detail_tv_show_title)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_detail_tv_show_description)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_detail_tv_show_genre)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_detail_tv_show_year)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.img_detail_tv_show_poster)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.img_detail_tv_show_poster_blur)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(ViewMatchers.withId(R.id.tv_detail_tv_show_title)).check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow[0].tvShowTitle)))
        onView(ViewMatchers.withId(R.id.tv_detail_tv_show_description)).check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow[0].tvShowDescription)))
        onView(ViewMatchers.withId(R.id.tv_detail_tv_show_genre)).check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow[0].tvShowGenre)))
        onView(ViewMatchers.withId(R.id.tv_detail_tv_show_year)).check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow[0].tvShowYear)))
    }
}