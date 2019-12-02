import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Movie from '../views/movie/Movie.vue'
import NewMovie from '../views/movie/NewMovie.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/filmes',
    name: 'movies',
    component: () => import(/* webpackChunkName: "about" */ '../views/movie/Movies.vue')
  },
  {
    path: '/filme/:movie_id',
    name: 'movieShow',
    component: Movie
  },
  {
    path: '/filmes/novo',
    name: 'newMovie',
    component: NewMovie
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
